package com.haierac.biz.airkeeper.base;

import com.haierac.biz.airkeeper.net.entity.HaierBaseResultBean;

/**
 * @author taodzh
 * create at 2019/5/24
 * 网络请求公用逻辑处理
 */
public abstract class ObserverHandler<T extends HaierBaseResultBean> extends BaseObserver<T> {
    IBaseView mBaseView;

    public ObserverHandler(IBaseView mBaseView) {
        this.mBaseView = mBaseView;
    }

    @Override
    public void onNetError(Throwable e) {
        mBaseView.showWarnMsg("当前网络不可用，请检查网络设置。");
    }

    @Override
    public void onTokenInvalid() {
        mBaseView.onTokenInvalid();
    }
}
