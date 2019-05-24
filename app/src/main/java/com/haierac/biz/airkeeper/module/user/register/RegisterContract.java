package com.haierac.biz.airkeeper.module.user.register;

import com.haierac.biz.airkeeper.base.IBaseView;

/**
 * @author taodzh
 * create at 2019/5/24
 */
public class RegisterContract {
    interface IView extends IBaseView {
        String getPhoneNum();

        String getVerifyCode();

        String getPassword();

        String getVerifyPass();

        void sendSuccess();

        void sendFail(String msg);

        void registerSuccess();

        void registerFail(String msg);
    }

    interface IPresenter {
        void register();

        void sendVerifyCode();
    }
}
