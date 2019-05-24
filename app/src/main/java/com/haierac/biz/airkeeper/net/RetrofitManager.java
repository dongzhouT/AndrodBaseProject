package com.haierac.biz.airkeeper.net;

import android.text.TextUtils;
import android.util.Log;

import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.SPUtils;
import com.haierac.biz.airkeeper.MyApplication;
import com.haierac.biz.airkeeper.constant.Constant;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lw on 2017-04-01.
 */

public class RetrofitManager {
    private static long CONNECT_TIMEOUT = 60L;
    private static long READ_TIMEOUT = 10L;
    private static long WRITE_TIMEOUT = 10L;
    //设缓存有效期为1天
    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 1;
    //查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
    public static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;
    //查询网络的Cache-Control设置
    //(假如请求了服务器并在a时刻返回响应结果，则在max-age规定的秒数内，浏览器将不会发送对应的请求到服务器，数据由缓存直接返回)
    public static final String CACHE_CONTROL_NETWORK = "Cache-Control: public, max-age=10";
    // 避免出现 HTTP 403 Forbidden，参考：http://stackoverflow.com/questions/13670692/403-forbidden-with-java-but-not-web-browser
    private static final String AVOID_HTTP403_FORBIDDEN = "UserInfobean-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11";
    private static volatile OkHttpClient mOkHttpClient;

    private static ApiService mApiService;
    private static CommentService mCommService;

    /**
     * 云端响应头拦截器，用来配置缓存策略
     * Dangerous interceptor that rewrites the server's cache-control header.
     */
    private static final Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            //addHeader(request)
            request = addHeader(request).build();
            logForRequest(request);
            if (!NetworkUtils.isConnected()) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }

            Response originalResponse = chain.proceed(request);
            logForResponse(originalResponse);
            if (NetworkUtils.isConnected()) {
                //有网的时候读接口上的@Headers里的配置，可以在这里进行统一的设置
                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();
            } else {
                Log.e(Constant.NET_LOG, originalResponse.message());
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_CONTROL_CACHE)
                        .removeHeader("Pragma")
                        .build();
            }
        }
    };
    private static final HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            Log.e("RetrofitUtil->", "请求->" + message);
        }
    });


    private static void logForRequest(Request request) {
        try {
            String url = request.url().toString();
            Headers headers = request.headers();

            Log.e(Constant.NET_LOG, "========request'log=======");
            Log.e(Constant.NET_LOG, "url : " + url);
            Log.e(Constant.NET_LOG, "method : " + request.method());
            if (headers != null && headers.size() > 0) {
                Log.e(Constant.NET_LOG, "headers : " + headers.toString());
            }
            RequestBody requestBody = request.body();
            if (requestBody != null) {
                MediaType mediaType = requestBody.contentType();
                if (mediaType != null) {
                    Log.e(Constant.NET_LOG, "requestBody's contentType : " + mediaType.toString());
                    if (isText(mediaType)) {
                        Log.e(Constant.NET_LOG, "requestBody's content : " + bodyToString(request));
                    } else {
                        Log.e(Constant.NET_LOG, "requestBody's content : " + " maybe [file part] , too large too print , ignored!");
                        Log.e(Constant.NET_LOG, "requestBody's content : " + bodyToString(request));
                    }
                }
            }
            Log.e(Constant.NET_LOG, "========request'log=======end");
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }


    private static String bodyToString(final Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            if (null == copy.body()) {
                return "";
            }
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "something error when show requestBody.";
        }
    }

    private static Response logForResponse(Response response) {
        Log.e(Constant.NET_LOG, "========response'log=======");
        Response.Builder builder = response.newBuilder();
        Response clone = builder.build();
        Log.e(Constant.NET_LOG, "url: " + clone.request().url());
        Log.e(Constant.NET_LOG, "code: " + clone.code());
        Log.e(Constant.NET_LOG, "protocol " + clone.protocol());
        if (!TextUtils.isEmpty(clone.message())) {
            Log.e(Constant.NET_LOG, "message : " + clone.message());
        }
        Headers headers = clone.headers();
        if (headers != null && headers.size() != 0) {
            Log.e(Constant.NET_LOG, "headers: " + headers.toString());
        }
        ResponseBody body = clone.body();
        if (body != null) {
            MediaType mediaType = body.contentType();
            if (mediaType != null) {
                Log.e(Constant.NET_LOG, "responseBody's contentType : " + mediaType.toString());
                if (isText(mediaType)) {
                    String resp = null;
                    try {
                        //这里不能直接使用response.body().string()的方式输出日志
                        //因为response.body().string()之后，response中的流会被关闭，程序会报错，我们需要创建出一
                        //个新的response给应用层处理
                        ResponseBody responseBody = response.peekBody(1024 * 1024);
                        resp = responseBody.string();
                        Log.e(Constant.NET_LOG, "responseBody's content : " + resp);
                        body = ResponseBody.create(mediaType, resp);
                        return response.newBuilder().body(body).build();
                    } catch (IOException e) {
                        Log.e(Constant.NET_LOG, "responseBody's content : "
                                + " maybe [file part] , too large too print , ignored!");
                    }

                }
            }
        }
        Log.e(Constant.NET_LOG, "========response'log=======end");
        return response;
    }

    private static boolean isText(MediaType mediaType) {
        if (null != mediaType.type() && mediaType.type().equals("text")) {
            return true;
        }
        if (null != mediaType.subtype()) {
            if (mediaType.subtype().equals("json")
                    || mediaType.subtype().equals("xml")
                    || mediaType.subtype().equals("html")
                    || mediaType.subtype().equals("webviewhtml")) {
                return true;
            }
        }
        return false;
    }

    private static Request.Builder addHeader(Request request) {
        Request.Builder requestBuilder = request.newBuilder();

        Map<String, String> headers = buildHeaders(bodyToString(request));
//        request.newBuilder().removeHeader("encryption");
        for (Map.Entry<String, String> header : headers.entrySet()) {
            String name = header.getKey().trim();
            String value = "";
            if (header.getValue() != null) {
                value = header.getValue().trim();
            }
            if (name.length() == 0 || name.indexOf('\0') != -1 || value.indexOf('\0') != -1) {
                throw new IllegalArgumentException("Unexpected header: " + name + ": " + value);
            }
            requestBuilder.addHeader(name, value);
        }

        return requestBuilder;
    }

    public static Map<String, String> buildHeaders(String needSignRequest) {
        Map<String, String> headers = new HashMap<String, String>();
        long timeStamp = getUnixTimeStamp();

        headers.put("accessToken", SPUtils.getInstance().getString(Constant.PREF_TOKEN));
//        headers.put("appKey", "");
//        headers.put("appVersion", "");
//        headers.put("clientId", HttpUtils.getClientId(HotWaterApp.getAppContext()));
//        headers.put("Content-Type",
//                "application/x-www-form-urlencoded;charset=utf-8 ");
//        headers.put("Content-Encoding", CHARSET);
//        if (!TextUtils.isEmpty(NetConfigConst.accessToken)) {
//            headers.put("accessToken", NetConfigConst.accessToken);
//        }
//        headers.put("accessToken", SharedPreferenceUtils.getInstance().getAccessToken());
//        headers.put("timestamp", String.valueOf(timeStamp));
//        headers.put("language", getLanguage());
//        headers.put("timezone", "+08:00");
//        headers.put("sequenceId", getSequenceId());

//        if(!("3").equals(type)){
//            headers.put("sign", generateSignSha(needSignRequest,timeStamp,ofurl));
//        }else{
//            headers.put("sign", generateSign(needSignRequest,timeStamp));
//        }
//        headers.put("sign", generateSign(needSignRequest,timeStamp));

        return headers;

    }

    /**
     * 时间戳 （Unix时间戳，精确到毫秒）
     */
    public static final long getUnixTimeStamp() {
        return System.currentTimeMillis();
    }


    /**
     * 获取OkHttpClient实例
     *
     * @return
     */
    private static OkHttpClient getOkHttpClient() {
        if (mOkHttpClient == null) {
            synchronized (RetrofitManager.class) {
                Cache cache = new Cache(new File(MyApplication.getAppContext().getCacheDir(), "HttpCache"), 1024 * 1024 * 100);
                if (mOkHttpClient == null) {
                    mOkHttpClient = new OkHttpClient.Builder().cache(cache)
                            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                            .addNetworkInterceptor(logInterceptor)
//                            .addInterceptor(new SimpleRequestInterceptor())
                            .addInterceptor(mRewriteCacheControlInterceptor)
                            .cookieJar(new CookiesManager())
                            .build();
                }
            }
        }
        return mOkHttpClient;
    }


    /**
     * 获取Service
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T create(Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        return retrofit.create(clazz);
    }


    public static ApiService getApiService() {
        if (mApiService == null) {
            mApiService = create(ApiService.class);
        }
        return mApiService;
    }

    /**
     * 登录注册类接口
     *
     * @return
     */
    public static CommentService getCommService() {
        if (mCommService == null) {
            mCommService = create(CommentService.class);
        }
        return mCommService;
    }
}
