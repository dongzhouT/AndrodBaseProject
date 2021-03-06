package com.haierac.biz.airkeeper.base;

import com.haierac.biz.airkeeper.net.entity.HaierBaseResultBean;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author taodzh
 * create at 2019/5/23
 */
public abstract class BaseObserver<T extends HaierBaseResultBean> implements Observer<T> {
    abstract public void onSuccess(T bean);

    abstract public void onFail(String code, String msg);

    abstract public void onNetError(Throwable e);

    abstract public void onTokenInvalid();

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        // TODO: 2019/5/24 token失效统一处理
        if (t.ok()) {
            onSuccess(t);
        } else if (t.tokenInvalid()) {
            onTokenInvalid();
        } else {
            onFail(t.retCode, t.retInfo);
        }

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        onNetError(e);
    }

    @Override
    public void onComplete() {

    }
}
