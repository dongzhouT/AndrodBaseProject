package com.haierac.biz.airkeeper.net.entity;


/**
 * Created by Administrator on 2019/2/25.
 */

public class GetMessgaeBean extends HaierBaseResultBean {

    /**
     * data : {"count":0,"notice":{"comment":{"content":"你明明","createTime":1551694504000,"id":186,"like":false,"likeNum":1,"manager":false,"mobile":"","portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","readStatus":0,"replyModelList":[],"totalReply":0,"userId":2080,"userName":"185****0817","vrfInnerId":14},"innerId":14,"reply":{"commentId":186,"content":"123","createTime":1551694535000,"id":314,"like":false,"likeNum":0,"manager":true,"mobile":"","parent":null,"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","userId":49,"userName":"小联管家"}}}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * count : 0
         * notice : {"comment":{"content":"你明明","createTime":1551694504000,"id":186,"like":false,"likeNum":1,"manager":false,"mobile":"","portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","readStatus":0,"replyModelList":[],"totalReply":0,"userId":2080,"userName":"185****0817","vrfInnerId":14},"innerId":14,"reply":{"commentId":186,"content":"123","createTime":1551694535000,"id":314,"like":false,"likeNum":0,"manager":true,"mobile":"","parent":null,"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","userId":49,"userName":"小联管家"}}
         */

        private int count;
        private NoticeBean notice;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public NoticeBean getNotice() {
            return notice;
        }

        public void setNotice(NoticeBean notice) {
            this.notice = notice;
        }

    }
}
