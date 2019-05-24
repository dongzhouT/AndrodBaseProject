package com.haierac.biz.airkeeper.net.entity;

public class NoticeBean {

    /**
     * comment : {"content":"你明明","createTime":1551694504000,"id":186,"like":false,"likeNum":1,"manager":false,"mobile":"","portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","readStatus":0,"replyModelList":[],"totalReply":0,"userId":2080,"userName":"185****0817","vrfInnerId":14}
     * innerId : 14
     * reply : {"commentId":186,"content":"123","createTime":1551694535000,"id":314,"like":false,"likeNum":0,"manager":true,"mobile":"","parent":null,"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","userId":49,"userName":"小联管家"}
     */

    private CommentBean comment;
    private int innerId;
    private ReplyBean reply;

    public CommentBean getComment() {
        return comment;
    }

    public void setComment(CommentBean comment) {
        this.comment = comment;
    }

    public int getInnerId() {
        return innerId;
    }

    public void setInnerId(int innerId) {
        this.innerId = innerId;
    }

    public ReplyBean getReply() {
        return reply;
    }

    public void setReply(ReplyBean reply) {
        this.reply = reply;
    }


}
