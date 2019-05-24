package com.haierac.biz.airkeeper.net;

import com.haierac.biz.airkeeper.net.entity.CommentListBean;
import com.haierac.biz.airkeeper.net.entity.CommentResultBean;
import com.haierac.biz.airkeeper.net.entity.GeneralBean;
import com.haierac.biz.airkeeper.net.entity.GetMessgaeBean;
import com.haierac.biz.airkeeper.net.entity.HaierBaseResultBean;
import com.haierac.biz.airkeeper.net.entity.InnerMacComtFlagBean;
import com.haierac.biz.airkeeper.net.entity.InnerMacScoreBean;
import com.haierac.biz.airkeeper.net.entity.InnerMacSmartCtrlBean;
import com.haierac.biz.airkeeper.net.entity.MessageContentBean;
import com.haierac.biz.airkeeper.net.entity.OpenAdBean;
import com.haierac.biz.airkeeper.net.entity.QueryHistoryBean;
import com.haierac.biz.airkeeper.net.entity.ReplyListBean;
import com.haierac.biz.airkeeper.net.entity.ReplyResultBean;
import com.haierac.biz.airkeeper.net.entity.RongCloudResultBean;
import com.haierac.biz.airkeeper.net.entity.SaveCommentBean;
import com.haierac.biz.airkeeper.net.entity.SaveReplyBean;
import com.haierac.biz.airkeeper.net.entity.ServiceEngineerResultBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by kaka on 2018/1/23.
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("http://vrf.api.eplusplatform.com/manager/app/login")
    Observable<String> login1(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("http://vrf.api.eplusplatform.com/manager/app/login")
    Observable<HaierBaseResultBean> login(@Field("username") String username, @Field("password") String password);

    //开屏广告
    @GET("http://ml.api.eplusplatform.com/openingAdvertising/obtain")
    Observable<OpenAdBean> getAd();
    ////***改造接口***////
    //查询设备列表的节能自适应状态

    //查询设备节能自适应状态,在设备控制页调用
    @GET("app/innerMachine/smartControlFlag")
    Observable<InnerMacSmartCtrlBean> getInnerMacSmartCtrlFlag(@Query("machineSn") String machineSn,
                                                               @Query("imuSerialCode") String imuSerialCode);

    //登录获取融云token（登录，找回密码，注册）
    @GET("app/chatUserInfo")
    Observable<RongCloudResultBean> getRCToken();


    ////***设备相关接口***////
    //查询设备评分(本人评分状态)
    @GET("app/score/findScoreByInnerId")
    Observable<InnerMacScoreBean> getInnerMacScore(@Query("innerId") String innerId);

    //提交设备评分，总评分和三种体验评分
    @FormUrlEncoded
    @POST("app/score/saveScore")
    Observable<GeneralBean> submitStar(@Field("innerId") String innerId, @Field("totalScore") String totalScore,
                                       @Field("useScore") String useScore, @Field("installScore") String installScore, @Field("serviceScore") String serviceScore);

    //提交内机操作记录
    @FormUrlEncoded
    @POST("app/equipment/operationRecord")
    Observable<GeneralBean> submitCommand(@Field("innerMachineId") String innerId, @Field("runMode") String runMode,
                                          @Field("windSpeed") String windSpeed, @Field("settingTemperature") String settingTemperature);

    //查询内机操作记录列表
    @GET("app/equipment/operationRecords")
    Observable<QueryHistoryBean> queryHistory(@Query("innerMachineId") String innerMachineId, @Query("pageNum") String pageNum, @Query("pageCount") String pageCount);

    //查询（某个内机）工程师userId+查询内机工程师的名片
    @GET("app/serviceEngineer")
    Observable<ServiceEngineerResultBean> getServiceEngineer();


    ////***评论相关接口***////
    //查询设备评论开关状态 评论开关状态0关闭1开启
    @GET("app/comment/findCommentSwitchStatus")
    Observable<InnerMacComtFlagBean> getInnerMacCommentStatus(@Query("innerId") String innerId);

    //获取评论列表
    @GET("app/comment/findCommentListByInnerId")
    Observable<CommentListBean> getCommentList(@Query("vrfInnerId") String innerId,
                                               @Query("pageNum") String pageNum,
                                               @Query("pageSize") String pageSize,
                                               @Query("replyNum") String replyNum);

    //获取某条评论的回复列表
    @GET("app/reply/findReplyByCommentId")
    Observable<ReplyListBean> getReplyList(@Query("commentId") String commentId,
                                           @Query("pageNum") String pageNum,
                                           @Query("pageSize") String pageSize);

    //删除评论
    @FormUrlEncoded
    @POST("app/comment/removeComment")
    Observable<HaierBaseResultBean> removeComment(@Field("ids") String id);

    //删除回复
    @FormUrlEncoded
    @POST("app/reply/removeReply")
    Observable<HaierBaseResultBean> removeReply(@Field("id") String id);

    //提交内机评论
    @FormUrlEncoded
    @POST("app/comment/saveComment")
    Observable<SaveCommentBean> saveComment(@Field("content") String content,
                                            @Field("type") String type,
                                            @Field("vrfInnerId") String vrfInnerId);

    //提交回复
    @FormUrlEncoded
    @POST("app/reply/saveReply")
    Observable<SaveReplyBean> saveReply(@Field("content") String content,
                                        @Field("commentId") String commentId,
                                        @Field("parentId") String parentId);

    //评论点赞/取消点赞
    @FormUrlEncoded
    @POST("app/comment/likeComment")
    Observable<CommentResultBean> likeComment(@Field("commentId") String id);

    //回复点赞/取消点赞
    @FormUrlEncoded
    @POST("app/reply/likeReply")
    Observable<ReplyResultBean> likeReply(@Field("replyId") String id);

    //获取通知列表
    @GET("app/notice/findUserNotice")
    Observable<MessageContentBean> getMessageContent(@Query("pageNum") String pageNum,
                                                     @Query("pageSize") String pageSize);

    //查询收未读评论通知数量
    @GET("app/notice/findNotReadStatusCount")
    Observable<GetMessgaeBean> getMessageNum();


}
