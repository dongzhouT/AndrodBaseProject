package com.haierac.biz.airkeeper.base;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.Utils;
import com.haierac.biz.airkeeper.R;
import com.haierac.biz.airkeeper.utils.Loading;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.reactivex.ObservableTransformer;

/**
 * @author taodzh
 * create at 2019/5/22
 */
@EActivity
public abstract class BaseActivity extends RxAppCompatActivity implements IBaseView {
    @ViewById(R.id.tv_title)
    public TextView tvTitle;
    @ViewById(R.id.iv_back)
    public ImageView ivBack;
    @ViewById(R.id.layout_header)
    public RelativeLayout layoutHeader;


    @Click(R.id.iv_back)
    public void onClickBack() {
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusColor(getResources().getColor(R.color.colorMain));
    }

    /**
     * 设置状态栏颜色
     *
     * @param color
     */
    public void setStatusColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(color);
        }
    }

    /**
     * 设置沉浸式状态栏
     *
     * @param view 标题栏
     */
    public void setImmerseLayout(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            int statusBarHeight = getStatusBarHeight(this.getBaseContext());
            view.setPadding(0, statusBarHeight, 0, 0);
        }
    }

    public int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @AfterViews
    public void init() {
        setTitle(title());
        initUI();
    }

    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        if (title != null) {
            tvTitle.setText(title);
        }
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifeCycle() {
        return bindToLifecycle();
    }

    @Override
    public void showLoading() {
        Loading.show(this);
    }

    @Override
    public void hideLoading() {
        Loading.close();
    }

    public void setHeaderVisiable(int visibility) {
        layoutHeader.setVisibility(visibility);
    }

    abstract public String title();

    abstract public void initUI();
}
