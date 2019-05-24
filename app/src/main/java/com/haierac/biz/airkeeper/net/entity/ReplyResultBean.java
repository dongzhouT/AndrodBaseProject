package com.haierac.biz.airkeeper.net.entity;


public class ReplyResultBean extends HaierBaseResultBean {

    /**
     * data : {"commentId":0,"content":"你猜猜","createTime":1550825504000,"id":21,"like":true,"likeNum":1,"parent":null,"portraitUrl":"","userName":""}
     */

    private ReplyBean data;

    public ReplyBean getData() {
        return data;
    }

    public void setData(ReplyBean data) {
        this.data = data;
    }
}
