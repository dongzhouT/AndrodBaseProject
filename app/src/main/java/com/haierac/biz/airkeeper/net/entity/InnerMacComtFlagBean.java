package com.haierac.biz.airkeeper.net.entity;


/**
 * 设备评论开关状态
 */
public class InnerMacComtFlagBean extends HaierBaseResultBean {

    /**
     * data : {"innerId":11,"switchStatus":1}
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
         * innerId : 11
         * switchStatus : 1
         */

        private int innerId;
        private String switchStatus; //评论开关状态:0关闭;1开启

        public int getInnerId() {
            return innerId;
        }

        public void setInnerId(int innerId) {
            this.innerId = innerId;
        }

        public String getSwitchStatus() {
            return switchStatus;
        }

        public void setSwitchStatus(String switchStatus) {
            this.switchStatus = switchStatus;
        }

        public boolean isStatusOn() {
            return "1".equals(getSwitchStatus());
        }
    }
}
