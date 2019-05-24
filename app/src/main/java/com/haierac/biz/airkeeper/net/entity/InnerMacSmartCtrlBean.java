package com.haierac.biz.airkeeper.net.entity;


public class InnerMacSmartCtrlBean extends HaierBaseResultBean {

    /**
     * data : {"machineSn":"1","imuSerialCode":"11","smartControlFlag":"ON"}
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
         * machineSn : 1
         * imuSerialCode : 11
         * smartControlFlag : ON
         */

        private String machineSn;
        private String imuSerialCode;
        private String smartControlFlag;

        public String getMachineSn() {
            return machineSn;
        }

        public void setMachineSn(String machineSn) {
            this.machineSn = machineSn;
        }

        public String getImuSerialCode() {
            return imuSerialCode;
        }

        public void setImuSerialCode(String imuSerialCode) {
            this.imuSerialCode = imuSerialCode;
        }

        public String getSmartControlFlag() {
            return smartControlFlag;
        }

        public void setSmartControlFlag(String smartControlFlag) {
            this.smartControlFlag = smartControlFlag;
        }
    }
}
