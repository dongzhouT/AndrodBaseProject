package update;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class UpdateChecker extends Fragment {

    //private static final String NOTIFICATION_ICON_RES_ID_KEY = "resId";
    private static final String NOTICE_TYPE_KEY = "type";
    private static final String APP_UPDATE_SERVER_URL = "app_update_server_url";
    //private static final String SUCCESSFUL_CHECKS_REQUIRED_KEY = "nChecks";
    private static final int NOTICE_NOTIFICATION = 2;
    private static final int NOTICE_DIALOG = 1;
    private static final String CODE_NEW_UPDATE = "10051";
    private static final String TAG = "UpdateChecker";

    private FragmentActivity mContext;
    private Thread mThread;
    private int mTypeOfNotice;
    Map<String, String> params = new HashMap<>();


    /**
     * Show a Dialog if an update is available for download. Callable in a
     * FragmentActivity. Number of checks after the dialog will be shown:
     * default, 5
     *
     * @param fragmentActivity Required.
     */
    public static void checkForDialog(FragmentActivity fragmentActivity, String url) {
        FragmentTransaction content = fragmentActivity.getSupportFragmentManager().beginTransaction();
        UpdateChecker updateChecker = new UpdateChecker();
        Bundle args = new Bundle();
        args.putInt(NOTICE_TYPE_KEY, NOTICE_DIALOG);
        args.putString(APP_UPDATE_SERVER_URL, url);
        //args.putInt(SUCCESSFUL_CHECKS_REQUIRED_KEY, 5);
        updateChecker.setArguments(args);
        content.add(updateChecker, null).commit();
    }


    /**
     * Show a Notification if an update is available for download. Callable in a
     * FragmentActivity Specify the number of checks after the notification will
     * be shown.
     *
     * @param fragmentActivity Required.
     */
    public static void checkForNotification(FragmentActivity fragmentActivity, String url) {
        FragmentTransaction content = fragmentActivity.getSupportFragmentManager().beginTransaction();
        UpdateChecker updateChecker = new UpdateChecker();
        Bundle args = new Bundle();
        args.putInt(NOTICE_TYPE_KEY, NOTICE_NOTIFICATION);
        args.putString(APP_UPDATE_SERVER_URL, url);
        //args.putInt(NOTIFICATION_ICON_RES_ID_KEY, notificationIconResId);
        //args.putInt(SUCCESSFUL_CHECKS_REQUIRED_KEY, 5);
        updateChecker.setArguments(args);
        content.add(updateChecker, null).commit();
    }


    /**
     * This class is a Fragment. Check for the method you have chosen.
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = (FragmentActivity) activity;
        params.put("appPlatform", "2"); // E+多联机为2; E+精装为3
        params.put("appVersion", "");
        params.put("systemType", "android"); // 系统类别
        Bundle args = getArguments();
        mTypeOfNotice = args.getInt(NOTICE_TYPE_KEY);
        String url = args.getString(APP_UPDATE_SERVER_URL);
        //mSuccessfulChecksRequired = args.getInt(SUCCESSFUL_CHECKS_REQUIRED_KEY);
        //mNotificationIconResId = args.getInt(NOTIFICATION_ICON_RES_ID_KEY);
        checkForUpdates(url);
    }

    /**
     * Heart of the library. Check if an update is available for download
     * parsing the desktop Play Store page of the app
     */
    private void checkForUpdates(final String url) {
        mThread = new Thread() {
            @Override
            public void run() {
                if (isNetworkAvailable(mContext)) {
//                    PreferencesUtils.putBoolean(mContext, AppConstants.PREF_UPDATEHASCHECKED, true);
                    String json = sendPost(Constants.APK_UPDATE_URL);
                    if (json != null) {
                        parseJson(json);
                    } else {
                        Log.e(TAG, "can't get app update json");
                    }
                }
            }

        };
        mThread.start();
    }

    private boolean isValidApkUrl(String path) {
        return path != null && path.endsWith(".apk");
    }

    protected String sendPost(String urlStr) {
        HttpURLConnection uRLConnection = null;
        InputStream is = null;
        BufferedReader buffer = null;
        String result = null;
        try {
            URL url = new URL(urlStr);
            uRLConnection = (HttpURLConnection) url.openConnection();
            uRLConnection.setDoInput(true);
            uRLConnection.setDoOutput(true);
            uRLConnection.setRequestMethod("POST");
            uRLConnection.setConnectTimeout(10 * 1000);
            uRLConnection.setReadTimeout(10 * 1000);
            uRLConnection.setRequestProperty("Charset", "UTF-8");
//            uRLConnection.setRequestProperty("Content-Type", "multipart/form-data");
            write2Conn(uRLConnection, params);
//            uRLConnection.setUseCaches(false);
//            uRLConnection.setInstanceFollowRedirects(false);
//            uRLConnection.setRequestProperty("Connection", "Keep-Alive");
//            uRLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
//            uRLConnection.setRequestProperty("Content-Type", "application/json");
//            uRLConnection.connect();
            is = uRLConnection.getInputStream();

            String content_encode = uRLConnection.getContentEncoding();

            if (null != content_encode && !"".equals(content_encode) && content_encode.equals("gzip")) {
                is = new GZIPInputStream(is);
            }

            buffer = new BufferedReader(new InputStreamReader(is));
            StringBuilder strBuilder = new StringBuilder();
            String line;
            while ((line = buffer.readLine()) != null) {
                strBuilder.append(line);
            }
            result = strBuilder.toString();
        } catch (Exception e) {
            Log.e(TAG, "http post error", e);
        } finally {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (uRLConnection != null) {
                uRLConnection.disconnect();
            }
        }
        return result;
    }


    private void parseJson(String json) {
        mThread.interrupt();
        Looper.prepare();
        try {
            JSONObject obj = new JSONObject(json);
            JSONObject data = obj.getJSONObject(Constants.APK_DATA);
            if (data == null) {
                return;
            }
            String updateMessage = data.getString(Constants.APK_UPDATE_CONTENT);
            String apkUrl = data.getString(Constants.APK_DOWNLOAD_URL);
            int apkCode = data.getInt(Constants.APK_VERSION_CODE);
            String forceVersion = data.getString("forceUpdateVersion");
//            PreferencesUtils.putString(mContext.getApplicationContext(), Constants.PREF_FORCE_UPDATE_VERSION, forceVersion);

            int versionCode = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionCode;

            if (apkCode > versionCode && isValidApkUrl(apkUrl)) {
                if (mTypeOfNotice == NOTICE_NOTIFICATION) {
                    showNotification(updateMessage, apkUrl);
                } else if (mTypeOfNotice == NOTICE_DIALOG) {
                    showDialog(updateMessage, apkUrl);
                }
            } else {
                //Toast.makeText(mContext, mContext.getString(R.string.app_no_new_update), Toast.LENGTH_SHORT).show();
            }

        } catch (PackageManager.NameNotFoundException ignored) {
        } catch (JSONException e) {
            Log.e(TAG, "parse json error", e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Show dialog
     */
    public void showDialog(String content, String apkUrl) {
        try {
            UpdateDialog d = new UpdateDialog();
            Bundle args = new Bundle();
            args.putString(Constants.APK_UPDATE_CONTENT, content);
            args.putString(Constants.APK_DOWNLOAD_URL, apkUrl);
            d.setArguments(args);
            d.show(mContext.getSupportFragmentManager(), null);
        } catch (RuntimeException e) {

        }
    }

    /**
     * Show Notification
     */
    public void showNotification(String content, String apkUrl) {
        Notification noti;
        Intent myIntent = new Intent(mContext, DownloadService.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        myIntent.putExtra(Constants.APK_DOWNLOAD_URL, apkUrl);
        PendingIntent pendingIntent = PendingIntent.getService(mContext, 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        int smallIcon = mContext.getApplicationInfo().icon;
        noti = new NotificationCompat.Builder(mContext).setTicker("发现新版本")
                .setContentTitle("发现新版本").setContentText(content).setSmallIcon(smallIcon)
                .setContentIntent(pendingIntent).build();

        noti.flags = Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, noti);
    }


    /**
     * Check if a network available
     */
    public static boolean isNetworkAvailable(Context context) {
        boolean connected = false;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo ni = cm.getActiveNetworkInfo();
            if (ni != null) {
                connected = ni.isConnected();
            }
        }
        return connected;
    }

    private void write2Conn(HttpURLConnection conn, Map<String, String> params) {
        try {
            PrintWriter pw = new PrintWriter(conn.getOutputStream());
            pw.write(getParamString(params));
            pw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String getParamString(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (sb.length() != 0) {
                sb.append("&");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
        return sb.toString();
    }

    /**
     * 是否强制更新
     *
     * @param context
     * @return
     */
    public static boolean isForceUpdate(Context context) {
        if (isNetworkAvailable(context)) {
            int forceUpdVersion = 0;
            try {
//                forceUpdVersion = Integer.valueOf(PreferencesUtils.getString(context, Constants.PREF_FORCE_UPDATE_VERSION, ""));
            } catch (Exception e) {
                e.printStackTrace();
            }
//            String currentVersion = NetUtils.getVersion();
            int currentVersion = getVersionCode(context);
            if (currentVersion < forceUpdVersion) {
                return true;
            }
        }
        return false;
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;

    }

}
