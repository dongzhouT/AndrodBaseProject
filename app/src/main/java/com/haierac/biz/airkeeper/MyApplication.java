package com.haierac.biz.airkeeper;

import android.app.Application;
import android.content.Context;

import logger.LogLevel;
import logger.Logger;
import update.Constants;

/**
 * @author taodzh
 * create at 2019/5/23
 */
public class MyApplication extends Application {
    private final String LOG_TAG = "===nbiot====";
    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        if (BuildConfig.DEBUG) {
//            LeakCanary.install(this);
        }
        // 注册通知
        Constants.createNotificationChannel(this);
        Logger.init(LOG_TAG).setLogLevel(BuildConfig.DEBUG ? LogLevel.FULL : LogLevel.NONE);
        //正式服
//        if (Constant.isTestEnv) {
//            ESDKManager.getInstance().initSDKWithAppId(ESDKConnectPlatformType.eSDKConnectPlatformTypeDevelop);
//        } else {
//            ESDKManager.getInstance().initSDKWithAppId(ESDKConnectPlatformType.eSDKConnectPlatformTypeProduct);
//        }
//        ESDKManager.getInstance().setIsShowDebug(BuildConfig.DEBUG);
////        ESDKManager.getInstance().setIsShowDebug(true);
//        ZXingLibrary.initDisplayOpinion(this);
//        //初始化友盟统计
//        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, "");
//        //融云初始化
//        RongIM.init(this);
//        TwinklingRefreshLayout.setDefaultHeader(SinaRefreshView.class.getName());
//        TwinklingRefreshLayout.setDefaultFooter(LoadingView.class.getName());
    }

    public static Context getAppContext() {
        return mInstance.getApplicationContext();
    }

    public static MyApplication getApplication() {
        return mInstance;
    }
}
