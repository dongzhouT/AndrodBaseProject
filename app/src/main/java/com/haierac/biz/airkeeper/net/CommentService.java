package com.haierac.biz.airkeeper.net;

import com.haierac.biz.airkeeper.net.entity.HaierBaseResultBean;
import com.haierac.biz.airkeeper.net.entity.LoginResultBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CommentService {
    @FormUrlEncoded
    @POST("/manager/app/login")
    Observable<LoginResultBean> login(@Field("username") String username,
                                      @Field("password") String password);

    //注册 发送验证码
    @FormUrlEncoded
    @POST("/manager/app/sendCodeForReg")
    Observable<HaierBaseResultBean> sendForRegister(@Field("mobile") String mobile);

    //忘记密码 发送验证码
    @FormUrlEncoded
    @POST("/manager/app/sendCodeForUpdatePassword")
    Observable<HaierBaseResultBean> sendForUpdate(@Field("mobile") String mobile);

    //注册
    @FormUrlEncoded
    @POST("/manager/app/register")
    Observable<LoginResultBean> register(@Field("mobile") String mobile,
                                         @Field("password") String password,
                                         @Field("sms_code") String sms_code);
    //    @FormUrlEncoded
//    @POST("/manager/app/login")
//    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
//    Observable<UserData> login(@Field("username") String username, @Field("password") String password);
//
//    @GET("/app/innerMachine/projects")
//    Observable<ProjectData> getPragammDataList();
//
//    @GET("/app/innerMachine/innerMachines")
//    Observable<InnerMac> getInnerMac(@Query("projectId") String projectId);
//
//    @FormUrlEncoded
//    @POST("/uniqueCode/uniqueidentificationcode")
//    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
//    Observable<BaseResponse> postImuCode(@Field("uniqueIdentificationCode") String uniCode
//            , @Field("imuSerialCode") String imuCode, @Field("machineSn") String machineSn);

}
