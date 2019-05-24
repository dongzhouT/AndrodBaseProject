package com.haierac.biz.airkeeper.module.protocol;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.haierac.biz.airkeeper.R;
import com.haierac.biz.airkeeper.base.BaseActivity;
import com.haierac.biz.airkeeper.utils.Loading;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_user_usage_protocol)
public class UserUsageProtocolActivity extends BaseActivity {
    @ViewById(R.id.wb_protocol)
    WebView wbProtocol;
    @Extra
    boolean isProtocol;

    @Override
    public String title() {
        return null;
    }

    @Override
    public void initUI() {
        tvRight.setVisibility(View.GONE);
        String assetFileUrl;
        if (isProtocol) {
            setTitle("用户服务协议");
            assetFileUrl = "file:///android_asset/protocol.htm";
            wbProtocol.loadUrl(assetFileUrl);
        } else {
            setTitle("隐私政策");
            assetFileUrl = "file:///android_asset/policy.htm";
        }

        wbProtocol.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Loading.show(UserUsageProtocolActivity.this);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Loading.close();
            }
        });
        wbProtocol.setWebChromeClient(new WebChromeClient());
        wbProtocol.loadUrl(assetFileUrl);
    }
}
