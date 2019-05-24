package com.haierac.biz.airkeeper.net;


import com.haierac.biz.airkeeper.base.IBaseView;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 通用的Rx线程转换类
 * 参考:http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0819/3327.html
 */
public class RxSchedulers {


    static final ObservableTransformer schedulersTransformer = new ObservableTransformer() {
        @Override
        public ObservableSource apply(Observable upstream) {
            return (upstream).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };


    public static <T> ObservableTransformer<T, T> applySchedulers() {
        return (ObservableTransformer<T, T>) schedulersTransformer;
    }

    public static <T> ObservableTransformer<T, T> applySchedulers(IBaseView view) {
        new ObservableTransformer<T, T>() {

            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return null;
            }
        };
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(view.bindLifeCycle());
//        return (ObservableTransformer<T, T>) schedulersTransformer;
    }
}
