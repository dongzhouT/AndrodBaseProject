package com.haierac.biz.airkeeper.module.user.register;

import android.text.TextUtils;

import com.haierac.biz.airkeeper.R;
import com.haierac.biz.airkeeper.base.ObserverHandler;
import com.haierac.biz.airkeeper.net.RetrofitManager;
import com.haierac.biz.airkeeper.net.RxSchedulers;
import com.haierac.biz.airkeeper.net.entity.HaierBaseResultBean;
import com.haierac.biz.airkeeper.net.entity.LoginResultBean;
import com.haierac.biz.airkeeper.utils.CommonUtils;

/**
 * @author taodzh
 * create at 2019/5/24
 */
public class RegisterPresenter implements RegisterContract.IPresenter {
    RegisterContract.IView mView;

    public RegisterPresenter(RegisterContract.IView mView) {
        this.mView = mView;
    }

    @Override
    public void register() {
        if (TextUtils.isEmpty(mView.getPhoneNum())) {
            mView.showWarnMsg("手机号不能为空");
            return;
        }
        if (!CommonUtils.isValidMobile(mView.getPhoneNum())) {
            mView.showWarnMsg("请输入正确的手机号");
            return;
        }
        if (TextUtils.isEmpty(mView.getPassword())) {
            mView.showWarnMsg("请输入密码");
            return;
        }
        if (!CommonUtils.isValidPassword(mView.getPassword())) {
            mView.showWarnMsg(R.string.string_pass_invalid);
            return;
        }
        if (TextUtils.isEmpty(mView.getVerifyCode())) {
            mView.showWarnMsg("手机验证码不能为空！");
            return;
        }
        mView.showLoading();
        RetrofitManager.getCommService().register(mView.getPhoneNum(), mView.getPassword(), mView.getVerifyCode())
                .compose(RxSchedulers.applySchedulers(mView))
                .subscribe(new ObserverHandler<LoginResultBean>(mView) {
                    @Override
                    public void onSuccess(LoginResultBean bean) {
                        mView.hideLoading();
                        // TODO: 2019/5/24 保存用户信息
                        mView.registerSuccess();
                    }

                    @Override
                    public void onFail(String code, String msg) {
                        mView.registerFail(msg);
                    }
                });

    }

    @Override
    public void sendVerifyCode() {
        if (TextUtils.isEmpty(mView.getPhoneNum())) {
            mView.showWarnMsg("手机号不能为空");
            return;
        }
        if (!CommonUtils.isValidMobile(mView.getPhoneNum())) {
            mView.showWarnMsg("请输入正确的手机号");
            return;
        }
        RetrofitManager.getCommService().sendForRegister(mView.getPhoneNum())
                .compose(RxSchedulers.applySchedulers(mView))
                .subscribe(new ObserverHandler<HaierBaseResultBean>(mView) {
                    @Override
                    public void onSuccess(HaierBaseResultBean bean) {
                        mView.sendSuccess();
                    }

                    @Override
                    public void onFail(String code, String msg) {
                        mView.sendFail(msg);
                    }
                });
    }
}
