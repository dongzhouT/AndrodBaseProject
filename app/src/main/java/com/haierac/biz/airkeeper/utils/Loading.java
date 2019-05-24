package com.haierac.biz.airkeeper.utils;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.haierac.biz.airkeeper.R;

/**
 * Loading框 显示/关闭， 半透明
 *
 * @author Eric
 */
public class Loading {

    private static Dialog dlgLoading;

    public static Dialog show(Context context, String msg) {
        close();
        View view = LayoutInflater.from(context).inflate(R.layout.loading, null);
        TextView textView = (TextView) view.findViewById(R.id.id_text);
        if (TextUtils.isEmpty(msg)) {
            textView.setVisibility(View.GONE);
        } else {
            textView.setVisibility(View.VISIBLE);
            textView.setText(msg);
        }

        dlgLoading = new Dialog(context, R.style.dialog);
        synchronized (dlgLoading) {
            dlgLoading.setContentView(view);
            dlgLoading.setCancelable(true);
            dlgLoading.setCanceledOnTouchOutside(false);
            dlgLoading.show();
        }

        return dlgLoading;
    }

    public static Dialog show(Context context, int txtID) {
        return show(context, context.getString(txtID));
    }

    public static Dialog show(Context context) {
        return show(context, null);
    }

    public static Dialog showLoading(Context context, String msg, boolean isOk) {
        close();
        View view;
        if (isOk) {
            view = LayoutInflater.from(context).inflate(R.layout.loading_success, null);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.loading_fail, null);
        }

        TextView textView = (TextView) view.findViewById(R.id.id_text);
        if (TextUtils.isEmpty(msg)) {
//            textView.setText(R.string.string_loading_msg);
            textView.setVisibility(View.GONE);
        } else {
            textView.setVisibility(View.VISIBLE);
            textView.setText(msg);
        }
        dlgLoading = new Dialog(context, R.style.dialog);
        dlgLoading.setContentView(view);
        dlgLoading.setCancelable(true);
        dlgLoading.setCanceledOnTouchOutside(false);
        dlgLoading.show();
        return dlgLoading;
    }

    public static Dialog showOk(Context context, String msg) {
        return showLoading(context, msg, true);
    }

    public static Dialog showFail(Context context, String msg) {
        return showLoading(context, msg, false);
    }

    public static void close() {
        if (dlgLoading != null) {
            try {
                dlgLoading.dismiss();
            } catch (Exception e) {
            }
            dlgLoading = null;
        }
    }

    public static boolean isShowing() {
        return dlgLoading != null && dlgLoading.isShowing();
    }
}
