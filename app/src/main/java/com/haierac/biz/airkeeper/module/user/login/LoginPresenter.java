package com.haierac.biz.airkeeper.module.user.login;

import com.haierac.biz.airkeeper.base.BaseObserver;
import com.haierac.biz.airkeeper.net.RetrofitManager;
import com.haierac.biz.airkeeper.net.RxSchedulers;
import com.haierac.biz.airkeeper.net.entity.HaierBaseResultBean;
import com.haierac.biz.airkeeper.utils.Md5Utils;

/**
 * @author taodzh
 * create at 2019/5/23
 */
public class LoginPresenter implements LoginContract.Presenter {
    LoginContract.View mView;

    public LoginPresenter(LoginContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void login() {
        String name = mView.getUserName();
        String pass = Md5Utils.encode(mView.getPassword());
        mView.showLoading();
        RetrofitManager.getApiService().login(name, pass)
                .compose(RxSchedulers.applySchedulers(mView))
                .subscribe(new BaseObserver<HaierBaseResultBean>() {
                    @Override
                    public void onSuccess(HaierBaseResultBean bean) {
                        mView.success(bean.retCode);
                    }

                    @Override
                    public void onFail(String code, String msg) {
                        mView.fail(code, msg);
                    }

                    @Override
                    public void onNetError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        mView.hideLoading();
                    }
                });

    }
}
