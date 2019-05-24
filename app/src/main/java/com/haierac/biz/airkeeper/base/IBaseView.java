package com.haierac.biz.airkeeper.base;

import io.reactivex.ObservableTransformer;

/**
 * @author taodzh
 * create at 2019/5/23
 */
public interface IBaseView {
    public <T> ObservableTransformer<T, T> bindLifeCycle();

    void showLoading();

    void hideLoading();
}
