package com.haierac.biz.airkeeper.net.entity;

import java.util.List;

public class CommentListBean extends HaierBaseResultBean {


    /**
     * data : {"pageData":[{"content":"你也好啊啊啊","createTime":1550714548000,"id":17,"like":false,"likeNum":0,"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","readStatus":0,"replyModelList":[{"commentId":0,"content":"你也好","createTime":1550718983000,"id":7,"like":false,"likeNum":0,"parent":{"commentId":0,"content":"你也好","createTime":1550718746000,"id":5,"like":false,"likeNum":0,"parent":null,"portraitUrl":"","userName":"haierac"},"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","userName":"haierac"},{"commentId":0,"content":"你也好","createTime":1550718926000,"id":6,"like":false,"likeNum":0,"parent":{"commentId":0,"content":"你也好","createTime":1550718746000,"id":5,"like":false,"likeNum":0,"parent":null,"portraitUrl":"","userName":"haierac"},"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","userName":"haierac"},{"commentId":0,"content":"你也好","createTime":1550718746000,"id":5,"like":false,"likeNum":0,"parent":null,"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","userName":"haierac"}],"totalReply":3,"userName":"haierac"},{"content":"你也好啊啊","createTime":1550714405000,"id":16,"like":false,"likeNum":0,"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","readStatus":0,"replyModelList":[],"totalReply":0,"userName":"haierac"},{"content":"你也好啊","createTime":1550658337000,"id":15,"like":false,"likeNum":0,"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","readStatus":0,"replyModelList":[],"totalReply":0,"userName":"haierac"},{"content":"你也好","createTime":1550655777000,"id":14,"like":false,"likeNum":0,"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","readStatus":0,"replyModelList":[],"totalReply":0,"userName":"haierac"},{"content":"你好","createTime":1550654113000,"id":12,"like":false,"likeNum":0,"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","readStatus":0,"replyModelList":[],"totalReply":0,"userName":"haierac"}],"total":5}
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
         * pageData : [{"content":"你也好啊啊啊","createTime":1550714548000,"id":17,"like":false,"likeNum":0,"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","readStatus":0,"replyModelList":[{"commentId":0,"content":"你也好","createTime":1550718983000,"id":7,"like":false,"likeNum":0,"parent":{"commentId":0,"content":"你也好","createTime":1550718746000,"id":5,"like":false,"likeNum":0,"parent":null,"portraitUrl":"","userName":"haierac"},"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","userName":"haierac"},{"commentId":0,"content":"你也好","createTime":1550718926000,"id":6,"like":false,"likeNum":0,"parent":{"commentId":0,"content":"你也好","createTime":1550718746000,"id":5,"like":false,"likeNum":0,"parent":null,"portraitUrl":"","userName":"haierac"},"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","userName":"haierac"},{"commentId":0,"content":"你也好","createTime":1550718746000,"id":5,"like":false,"likeNum":0,"parent":null,"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","userName":"haierac"}],"totalReply":3,"userName":"haierac"},{"content":"你也好啊啊","createTime":1550714405000,"id":16,"like":false,"likeNum":0,"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","readStatus":0,"replyModelList":[],"totalReply":0,"userName":"haierac"},{"content":"你也好啊","createTime":1550658337000,"id":15,"like":false,"likeNum":0,"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","readStatus":0,"replyModelList":[],"totalReply":0,"userName":"haierac"},{"content":"你也好","createTime":1550655777000,"id":14,"like":false,"likeNum":0,"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","readStatus":0,"replyModelList":[],"totalReply":0,"userName":"haierac"},{"content":"你好","createTime":1550654113000,"id":12,"like":false,"likeNum":0,"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","readStatus":0,"replyModelList":[],"totalReply":0,"userName":"haierac"}]
         * total : 5
         */

        private int total;
        private List<CommentBean> pageData;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<CommentBean> getPageData() {
            return pageData;
        }

        public void setPageData(List<CommentBean> pageData) {
            this.pageData = pageData;
        }

    }
}
