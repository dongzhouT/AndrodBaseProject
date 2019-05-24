package com.haierac.biz.airkeeper.net.entity;

import java.io.Serializable;

public class ReplyBean implements Serializable {

    /**
     * commentId : 0
     * content : 你也好
     * createTime : 1550718983000
     * id : 7
     * like : false
     * likeNum : 0
     * parent : {"commentId":0,"content":"你也好","createTime":1550718746000,"id":5,"like":false,"likeNum":0,"parent":null,"portraitUrl":"","userName":"haierac"}
     * portraitUrl : http://47.93.185.230/images/headers/logo.jpg
     * userName : haierac
     */

    private int commentId;
    private String content;
    private long createTime;
    private int id;
    private boolean like;
    private int likeNum;
    private ReplyBean parent;
    private String portraitUrl;
    private String userName;
    private String userId;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public ReplyBean getParent() {
        return parent;
    }

    public void setParent(ReplyBean parent) {
        this.parent = parent;
    }

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
