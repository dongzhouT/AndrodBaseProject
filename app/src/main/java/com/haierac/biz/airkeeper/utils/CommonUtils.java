package com.haierac.biz.airkeeper.utils;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.blankj.utilcode.util.TimeUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/18.
 */

public class CommonUtils {
    public static void bindEdtClear(final EditText editText, final ImageView imageView) {
        if (editText == null || imageView == null) {
            return;
        }
        if (TextUtils.isEmpty(editText.getText().toString().trim())) {
            imageView.setVisibility(View.GONE);
        } else {
            imageView.setVisibility(View.VISIBLE);
        }
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (TextUtils.isEmpty(editText.getText().toString().trim())) {
                        imageView.setVisibility(View.GONE);
                    } else {
                        imageView.setVisibility(View.VISIBLE);
                    }
                } else {
                    imageView.setVisibility(View.GONE);
                }
            }
        });
        imageView.setVisibility(View.GONE);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                imageView.setVisibility(TextUtils.isEmpty(s) ? View.GONE : View.VISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                imageView.setVisibility(TextUtils.isEmpty(s) ? View.GONE : View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {
                imageView.setVisibility(TextUtils.isEmpty(s) ? View.GONE : View.VISIBLE);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });

    }

    /**
     * 校验手机号
     *
     * @param mobile
     * @return
     */
    public static boolean isValidMobile(String mobile) {
        if (TextUtils.isEmpty(mobile))
            return false;
        String regex = "^1\\d{10}";
        return mobile.matches(regex);
    }

    /**
     * 校验密码：仅含有数字、大小或下划线
     *
     * @param mobile
     * @return
     */
    public static boolean isValidPassword(String mobile) {
        if (TextUtils.isEmpty(mobile))
            return false;
        String regex = "^[\\w]{6,16}$"; //6-16位字符
        String regex2 = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9a-zA-Z]{6,20}$"; // 6-20位字母加数字
        return mobile.matches(regex2);
    }

    //drawable 着色
    public static void setImageViewColor(ImageView view, int colorResId) {
        //mutate()
        Drawable modeDrawable = view.getDrawable().mutate();
        Drawable temp = DrawableCompat.wrap(modeDrawable);
        ColorStateList colorStateList = ColorStateList.valueOf(view.getResources().getColor(colorResId));
        DrawableCompat.setTintList(temp, colorStateList);
        view.setImageDrawable(temp);
    }

    //获取设备唯一识别码
//    public static String getUniqueImei(Context context) {
//        String appid = PreferencesUtils.getString(context, AppConstants.PREF_APPID, "");
//        if (TextUtils.isEmpty(appid)) {
//            try {
//                //Android6.0 API23以上读取不到手机IMEI
//                TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
//                appid = tm.getDeviceId();
//                if (TextUtils.isEmpty(appid)) {
//                    //如果获取不到手机的IMEI
//                    appid = Md5Utils.encode(System.currentTimeMillis() + "" + Math.round(Math.random() * 1000));
//                    PreferencesUtils.putString(context, AppConstants.PREF_APPID, appid);
//                } else {
//                    PreferencesUtils.putString(context, AppConstants.PREF_APPID, appid);
//                }
//            } catch (Exception e) {
//                appid = Md5Utils.encode(System.currentTimeMillis() + "" + Math.round(Math.random() * 1000));
//                PreferencesUtils.putString(context, AppConstants.PREF_APPID, appid);
//            }
//        }
//        return appid;
//    }

    /**
     * 隐藏手机号中间四位
     *
     * @param mobile
     * @return
     */
    public static String HideMobile(String mobile) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(mobile) && mobile.length() > 6) {
            for (int i = 0; i < mobile.length(); i++) {
                char c = mobile.charAt(i);
                if (i >= 3 && i <= 6) {
                    sb.append('x');
                } else {
                    sb.append(c);
                }
            }

        }
        return sb.toString();
    }

    /**
     * 返回评论时间
     *
     * @param date
     * @return
     */
    public static String date2String(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        TimeUtils.date2String(date);
        return TimeUtils.date2String(date, sdf);
    }

}
