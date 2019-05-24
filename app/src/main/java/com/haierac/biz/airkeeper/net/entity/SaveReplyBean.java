package com.haierac.biz.airkeeper.net.entity;


public class SaveReplyBean extends HaierBaseResultBean {


    /**
     * data : {"commentId":30,"content":"你猜猜","createTime":null,"id":21,"like":false,"likeNum":0,"parent":null,"portraitUrl":"","userName":""}
     */

    private ReplyBean data;

    public ReplyBean getData() {
        return data;
    }

    public void setData(ReplyBean data) {
        this.data = data;
    }

}
