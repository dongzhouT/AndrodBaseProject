package com.haierac.biz.airkeeper.persistence;

import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by Administrator on 2018/8/7.
 */
@SharedPref(SharedPref.Scope.UNIQUE)
public interface SDKPref {
    String accessToken();

    String userId();

    String phoneNum();

    String password();

    String realName();
}
