package com.haierac.biz.airkeeper.net.entity;

public class ServiceEngineerBean {
    /**
     * nickName : 王斌
     * portraitUri : http://47.93.185.230/images/headers/logo.jpg
     * userId : 49
     * position : 高级工程师
     * introduce : 是一个很厉害的人
     */

    private String nickName;
    private String portraitUri;
    private String userId;
    private String rongUserId;
    private String position;
    private String introduce;

    public String getRongUserId() {
        return rongUserId;
    }

    public void setRongUserId(String rongUserId) {
        this.rongUserId = rongUserId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPortraitUri() {
        return portraitUri;
    }

    public void setPortraitUri(String portraitUri) {
        this.portraitUri = portraitUri;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
