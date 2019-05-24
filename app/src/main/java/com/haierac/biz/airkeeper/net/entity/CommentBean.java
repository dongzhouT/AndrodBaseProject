package com.haierac.biz.airkeeper.net.entity;

import java.io.Serializable;
import java.util.List;

public class CommentBean implements Serializable {

    /**
     * content : 你也好啊啊
     * createTime : 1550714405000
     * id : 16
     * like : false
     * likeNum : 0
     * portraitUrl : http://47.93.185.230/images/headers/logo.jpg
     * readStatus : 0
     * replyModelList : []
     * totalReply : 0
     * userName : haierac
     */

    private String content;
    private long createTime;
    private int id;
    private boolean like;
    private int likeNum;
    private String portraitUrl;
    private int readStatus;
    private int totalReply;
    private String userName;
    private List<ReplyBean> replyModelList;
    private String userId;

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

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    public int getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(int readStatus) {
        this.readStatus = readStatus;
    }

    public int getTotalReply() {
        return totalReply;
    }

    public void setTotalReply(int totalReply) {
        this.totalReply = totalReply;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<ReplyBean> getReplyModelList() {
        return replyModelList;
    }

    public void setReplyModelList(List<ReplyBean> replyModelList) {
        this.replyModelList = replyModelList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentBean that = (CommentBean) o;
        return id == that.id;
    }
}
