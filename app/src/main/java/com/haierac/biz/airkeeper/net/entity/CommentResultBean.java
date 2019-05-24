package com.haierac.biz.airkeeper.net.entity;


/**
 * 新增评论，点赞
 */
public class CommentResultBean extends HaierBaseResultBean {

    /**
     * data : {"content":"你也好啊啊啊","createTime":1550714548000,"id":17,"like":true,"likeNum":1,"portraitUrl":"","readStatus":0,"replyModelList":[],"totalReply":0,"userName":""}
     */

    private CommentBean data;

    public CommentBean getData() {
        return data;
    }

    public void setData(CommentBean data) {
        this.data = data;
    }

}
