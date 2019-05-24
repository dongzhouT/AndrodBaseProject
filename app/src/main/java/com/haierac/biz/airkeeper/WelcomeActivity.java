package com.haierac.biz.airkeeper;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.haierac.biz.airkeeper.module.user.login.LoginActivity_;
import com.haierac.biz.airkeeper.net.RetrofitManager;
import com.haierac.biz.airkeeper.net.RxSchedulers;
import com.haierac.biz.airkeeper.net.entity.OpenAdBean;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@EActivity(R.layout.activity_welcome)
public class WelcomeActivity extends RxAppCompatActivity {
    Observable mObs;
    @ViewById(R.id.tv_countdown)
    TextView tvCountdown;
    @ViewById(R.id.iv_webcome)
    ImageView ivWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        loadAd();
    }

    private void goToNext() {
        // TODO: 2019/5/24 判断token 进入登录页还是home页
        LoginActivity_.intent(this).start();
        finish();
    }

    private void loadAd() {
        RetrofitManager.getApiService().getAd()
                .delay(1000, TimeUnit.MILLISECONDS)
                .compose(RxSchedulers.<OpenAdBean>applySchedulers())
                .subscribe(new Consumer<OpenAdBean>() {
                    @Override
                    public void accept(OpenAdBean openAdBean) throws Exception {
                        if (openAdBean.ok()) {
                            OpenAdBean.DataBean.AdvertisementBean advertisement = openAdBean.getData().getAdvertisement();
                            if (advertisement != null) {
                                initAd(advertisement.getImgUrl());
                            }
                        }
                        startTimer();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        startTimer();
                    }
                });
    }

    private void initAd(String imgUrl) {
        if (!TextUtils.isEmpty(imgUrl)) {
            Glide.with(this).load(imgUrl).into(ivWelcome);
        }
    }

    /**
     * 开启倒计时
     */
    private void startTimer() {
        Observable.interval(1, TimeUnit.SECONDS).take(5)
                .compose(bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        showCountDown(aLong.intValue());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        goToNext();
                    }
                });
    }

    void showCountDown(int time) {
        tvCountdown.setText(time + "s");
    }
}
