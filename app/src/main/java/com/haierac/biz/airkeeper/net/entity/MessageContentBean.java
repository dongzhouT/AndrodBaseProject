package com.haierac.biz.airkeeper.net.entity;


import java.util.List;

/**
 * Created by Administrator on 2019/2/26.
 */

public class MessageContentBean extends HaierBaseResultBean {

    /**
     * data : {"pageData":[{"innerId":1,"reply":{"commentId":1,"content":"你也好","createTime":1550718983000,"id":8,"like":false,"likeNum":0,"manager":false,"mobile":"","parent":{"commentId":1,"content":"你也好","createTime":1550718983000,"id":7,"like":false,"likeNum":0,"manager":false,"mobile":"","parent":null,"portraitUrl":"","userId":1,"userName":"haierac"},"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","userId":1,"userName":"haierac"},"comment":{"commentId":1,"content":"你也好","createTime":1550718983000,"id":7,"like":false,"likeNum":0,"manager":false,"mobile":"","portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","userId":1,"userName":"13361488731"}}],"total":1}
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
         * pageData : [{"innerId":1,"reply":{"commentId":1,"content":"你也好","createTime":1550718983000,"id":8,"like":false,"likeNum":0,"manager":false,"mobile":"","parent":{"commentId":1,"content":"你也好","createTime":1550718983000,"id":7,"like":false,"likeNum":0,"manager":false,"mobile":"","parent":null,"portraitUrl":"","userId":1,"userName":"haierac"},"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","userId":1,"userName":"haierac"},"comment":{"commentId":1,"content":"你也好","createTime":1550718983000,"id":7,"like":false,"likeNum":0,"manager":false,"mobile":"","portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","userId":1,"userName":"13361488731"}}]
         * total : 1
         */

        private int total;
        private List<NoticeBean> pageData;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<NoticeBean> getPageData() {
            return pageData;
        }

        public void setPageData(List<NoticeBean> pageData) {
            this.pageData = pageData;
        }

    }
}
