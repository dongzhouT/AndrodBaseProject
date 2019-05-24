package com.haierac.biz.airkeeper.constant;

import android.os.Build;


/**
 * Created by lw on 2018/1/19.
 */

public class Constant {
    //    public static final String BASE_HOST = "http://vrf.api.eplusplatform.com";
    //http://vrf.api.eplusplatform.com  正式环境
    //http:/59.110.166.227:8888 测试环境
    public static final boolean isTestEnv = false;
    //设置baseUrl,注意，baseUrl必须后缀"/"
    public static final String BASE_HOST = isTestEnv ? "http://rest.apizza.net/mock/6169e615726ee2474b18666fa0fecc7c/" :
            "http://vrf.api.eplusplatform.com";// 正式环境
//    public static final String BASE_HOST = "http:/59.110.166.227:8888";// 内网测试

    public static final String BASE_URL = BASE_HOST;
    public static final String HEAD_URL = BASE_HOST;
    public static final String NET_LOG = "net_log";
    public static final String PREF_TOKEN = "accessToken";

    public static final String BLE_TAG = "BleDeviceTag";

    public static final String LEHUOTONG_LOG = "LeHuoTongTag";
    public static final String DB_LOG = "db_log";
    /**
     * 每页数量
     */
    public static final int PAGE_SIZE = 20;
    /**
     * 每页数量
     */
    public static final int PAGE_SIZE_MIDDLE = 10;


    /**
     * url key
     */
    public static final String CONTENT_URL_KEY = "url";
    /**
     * title key
     */
    public static final String CONTENT_TITLE_KEY = "title";
    /**
     * id key
     */
    public static final String CONTENT_ID_KEY = "id";
    /**
     * cid key
     */
    public static final String CONTENT_CID_KEY = "cid";
    public static final String CONTENT_AUTHOR_KEY = "author";
    /**
     * childrenData key
     */
    public static final String CONTENT_CHILDREN_DATA_KEY = "childrenData";
    /**
     * hotFriend key
     */
    public static final String CONTENT_HOT_FRIEND_KEY = "hotFriend";
    /**
     * hot key
     */
    public static final String CONTENT_HOT_KEY = "hotKey";
    /**
     * hot key
     */
    public static final String CONTENT_HOT_NAME_KEY = "hotNameKey";

    public static final String SAVE_USER_LOGIN_KEY = "user/login";
    public static final String SAVE_USER_REGISTER_KEY = "user/register";
    public static final String SET_COOKIE_KEY = "set-cookie";

    public static final String SHARED_NAME = "_preferences";
    public static final String USERNAME_KEY = "username";
    public static final String PASSWORD_KEY = "password";
    public static final String LOGIN_KEY = "login";
    public static final String USER_KEY = "user";
    public static final String BANNER_KEY = "banner";
    public static final String ARTICLE_KEY = "article";

    public static final String UMENG_APP_KEY = "5a8120838f4a9d484e0002e2";
    public static final String UMENG_CHANNEL = "WanAndroid";
    /**
     * 话题正则表达式
     */
    //public static final String HT_REGEX = "\\[hq:ht[\\s]+(id='[0-9]+')?[\\s]*nr='#[^#]+#'\\]";
    public static final String HT_REGEX = "#[^#]+#";

    /**
     * at我的正则表达式
     */
    //public static final String AT_REGEX = "\\[hq:at[\\s]+(id='[0-9]+')*[\\s]*nr='@[^\\s@']+[\\s]?'\\]";
    public static final String AT_REGEX = "@(\\S)+(\\u0020){1}";

    /**
     * 图片正则表达式
     */
    public static final String PICTURE_REGEX = "(\\u0020){1}(\\w){32}(\\u0020){1}";
    /**
     * 微博内容最大字数
     */
    public static final int BLOG_CONTENT_MAX_LENGTH = 160;

    public static final String BLOG_CONTENT_TIP = "最多只能发" + BLOG_CONTENT_MAX_LENGTH + "个字符";

    public static final String DEVICE = Build.MODEL;


}
