package update;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class Constants {
    /**
     * 在线更新包 部署流程
     * 1、MyApplication中调用{@link #createNotificationChannel(Application)}方法
     * 2、AndroidManifest中增加权限
     *    允许未知来源应用安装
     *     <uses-permission android:name="android.permission.REQUEST_INSTALL_PACKAGES" />
     *    在AndroidManifest.xml中注册FileProvider和DownloadService
     * 3、在欢迎页添加以下方法，重置更新标记
     *    PreferencesUtils.putBoolean(this, AppConstants.PREF_UPDATEHASCHECKED, false);
     * 4、在需要检查更新的地方调用
     *    if (!PreferencesUtils.getBoolean(this, AppConstants.PREF_UPDATEHASCHECKED)) {
     *             UpdateChecker.checkForDialog(this, null);
     *         }
     */

    /**
     * 服务端返回示例
     * {
     * "data": {
     * "newVersion": "2019010201",
     * "updateUrl": "/haierV3/app/v1/download",
     * "updateInfo": "1、增加会务应用\r\n2、增加抽奖小游戏，问卷调查功能\r\n3、集成了采购流程"
     * },
     * "retCode": "000000",
     * "retInfo": "发现新版本"
     * }
     */
    //我这里服务器返回的json数据是这样的，可以根据实际情况修改下面参数的名称
    public static final String APK_DATA = "data";
    public static final String APK_DOWNLOAD_URL = "updateUrl";
    public static final String APK_UPDATE_CONTENT = "updateInfo";
    public static final String APK_VERSION_CODE = "newVersion";
    public static final String APK_UPDATE_URL = "http://update.api.eplusplatform.com/app/package/query";
    public static final String CHANNEL_ID = "channelId";
    public static final String FILE_PROVIDER_SUF = ".fileprovider";
    public static final String PREF_FORCE_UPDATE_VERSION = "pref_forceUpdateVersion";//强制升级版本

    public static void createNotificationChannel(Application application) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "channel_name";
            String description = "channel_description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = application.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
//            notificationManager.crea
        }
    }
}
