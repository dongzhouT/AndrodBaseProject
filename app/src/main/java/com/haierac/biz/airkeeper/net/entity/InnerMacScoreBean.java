package com.haierac.biz.airkeeper.net.entity;


public class InnerMacScoreBean extends HaierBaseResultBean {

    /**
     * data : {"innerId":1,"installScore":1,"myTotalScore":4,"serviceScore":0,"totalScore":4,"useScore":4}
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
         * innerId : 1
         * installScore : 1
         * myTotalScore : 4
         * serviceScore : 0
         * totalScore : 4
         * useScore : 4
         */

        private int innerId;
        private int installScore;
        private int myTotalScore;//0 可以评分；其他不可以评分
        private int serviceScore;
        private int totalScore;
        private int useScore;

        public boolean isCanScore() {
            return getMyTotalScore() == 0;
        }

        public int getInnerId() {
            return innerId;
        }

        public void setInnerId(int innerId) {
            this.innerId = innerId;
        }

        public int getInstallScore() {
            return installScore;
        }

        public void setInstallScore(int installScore) {
            this.installScore = installScore;
        }

        public int getMyTotalScore() {
            return myTotalScore;
        }

        public void setMyTotalScore(int myTotalScore) {
            this.myTotalScore = myTotalScore;
        }

        public int getServiceScore() {
            return serviceScore;
        }

        public void setServiceScore(int serviceScore) {
            this.serviceScore = serviceScore;
        }

        public int getTotalScore() {
            return totalScore;
        }

        public void setTotalScore(int totalScore) {
            this.totalScore = totalScore;
        }

        public int getUseScore() {
            return useScore;
        }

        public void setUseScore(int useScore) {
            this.useScore = useScore;
        }
    }
}
