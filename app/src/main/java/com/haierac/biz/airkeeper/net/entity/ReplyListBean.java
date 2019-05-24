package com.haierac.biz.airkeeper.net.entity;


import java.util.List;

public class ReplyListBean extends HaierBaseResultBean {

    /**
     * data : {"pageData":[{"commentId":0,"content":"你也好","createTime":1550718983000,"id":7,"like":false,"likeNum":0,"parent":{"commentId":0,"content":"你也好","createTime":1550718746000,"id":5,"like":false,"likeNum":0,"parent":null,"portraitUrl":"","userName":"haierac"},"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","userName":"haierac"},{"commentId":0,"content":"你也好","createTime":1550718926000,"id":6,"like":false,"likeNum":0,"parent":{"commentId":0,"content":"你也好","createTime":1550718746000,"id":5,"like":false,"likeNum":0,"parent":null,"portraitUrl":"","userName":"haierac"},"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","userName":"haierac"},{"commentId":0,"content":"你也好","createTime":1550718746000,"id":5,"like":false,"likeNum":0,"parent":null,"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","userName":"haierac"}],"total":3}
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
         * pageData : [{"commentId":0,"content":"你也好","createTime":1550718983000,"id":7,"like":false,"likeNum":0,"parent":{"commentId":0,"content":"你也好","createTime":1550718746000,"id":5,"like":false,"likeNum":0,"parent":null,"portraitUrl":"","userName":"haierac"},"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","userName":"haierac"},{"commentId":0,"content":"你也好","createTime":1550718926000,"id":6,"like":false,"likeNum":0,"parent":{"commentId":0,"content":"你也好","createTime":1550718746000,"id":5,"like":false,"likeNum":0,"parent":null,"portraitUrl":"","userName":"haierac"},"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","userName":"haierac"},{"commentId":0,"content":"你也好","createTime":1550718746000,"id":5,"like":false,"likeNum":0,"parent":null,"portraitUrl":"http://47.93.185.230/images/headers/logo.jpg","userName":"haierac"}]
         * total : 3
         */

        private int total;
        private List<ReplyBean> pageData;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ReplyBean> getPageData() {
            return pageData;
        }

        public void setPageData(List<ReplyBean> pageData) {
            this.pageData = pageData;
        }
    }
}
