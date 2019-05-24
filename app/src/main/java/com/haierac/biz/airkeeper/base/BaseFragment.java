package com.haierac.biz.airkeeper.base;

import com.blankj.utilcode.util.ToastUtils;
import com.haierac.biz.airkeeper.utils.Loading;
import com.trello.rxlifecycle2.components.RxFragment;

import org.androidannotations.annotations.EFragment;

import io.reactivex.ObservableTransformer;

/**
 * @author taodzh
 * create at 2019/5/24
 */
@EFragment
public class BaseFragment extends RxFragment implements IBaseView {
    @Override
    public <T> ObservableTransformer<T, T> bindLifeCycle() {
        return bindToLifecycle();
    }

    @Override
    public void showLoading() {
        Loading.show(getActivity());
    }

    @Override
    public void showLoading(String msg) {
        Loading.show(getActivity(), msg);
    }

    @Override
    public void hideLoading() {
        Loading.close();
    }

    @Override
    public void showWarnMsg(String msg) {
        ToastUtils.showShort(msg);
    }

    @Override
    public void showWarnMsg(int textResId) {
        ToastUtils.showShort(textResId);
    }

    @Override
    public void onTokenInvalid() {

    }

}
