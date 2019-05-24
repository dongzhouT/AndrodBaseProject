package com.haierac.biz.airkeeper.module.user.login;

import com.haierac.biz.airkeeper.base.IBaseView;
import com.haierac.biz.airkeeper.net.entity.HaierBaseResultBean;

import io.reactivex.Observable;

/**
 * @author taodzh
 * create at 2019/5/22
 */
public class LoginContract {
    interface View extends IBaseView {
        String getUserName();

        String getPassword();

        void success(String token);

        void fail(String code, String msg);
    }

    interface Presenter {
        void login();
    }

    interface Model {
        Observable<HaierBaseResultBean> login(String name, String pass);
    }
}
