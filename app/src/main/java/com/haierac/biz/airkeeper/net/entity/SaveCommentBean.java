package com.haierac.biz.airkeeper.net.entity;


public class SaveCommentBean extends HaierBaseResultBean {

    /**
     * data : {"content":"你好","createTime":null,"id":29,"like":false,"likeNum":0,"pageNum":1,"pageSize":10,"readStatus":0,"replyModelList":[],"type":"VRF","userId":1746,"vrfInnerId":4}
     */

    private CommentBean data;

    public CommentBean getData() {
        return data;
    }

    public void setData(CommentBean data) {
        this.data = data;
    }

}
