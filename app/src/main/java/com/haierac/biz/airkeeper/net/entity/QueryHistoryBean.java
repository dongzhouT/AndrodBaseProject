package com.haierac.biz.airkeeper.net.entity;


import java.util.List;

/**
 * Created by Administrator on 2019/2/25.
 */

public class QueryHistoryBean extends HaierBaseResultBean {


    /**
     * data : {"pageData":[{"mobile":18561311200,"runMode":"制热","windSpeed":"自动","settingTemperature":"26","createTime":"13位时间戳"}],"total":1}
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
         * pageData : [{"mobile":18561311200,"runMode":"制热","windSpeed":"自动","settingTemperature":"26","createTime":"13位时间戳"}]
         * total : 1
         */

        private int total;
        private List<PageDataBean> pageData;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<PageDataBean> getPageData() {
            return pageData;
        }

        public void setPageData(List<PageDataBean> pageData) {
            this.pageData = pageData;
        }

        public static class PageDataBean {
            /**
             * mobile : 18561311200
             * runMode : 制热
             * windSpeed : 自动
             * settingTemperature : 26
             * createTime : 13位时间戳
             */

            private long mobile;
            private String runMode;
            private String windSpeed;
            private String settingTemperature;
            private long createTime;

            public long getMobile() {
                return mobile;
            }

            public void setMobile(long mobile) {
                this.mobile = mobile;
            }

            public String getRunMode() {
                return runMode;
            }

            public void setRunMode(String runMode) {
                this.runMode = runMode;
            }

            public String getWindSpeed() {
                return windSpeed;
            }

            public void setWindSpeed(String windSpeed) {
                this.windSpeed = windSpeed;
            }

            public String getSettingTemperature() {
                return settingTemperature;
            }

            public void setSettingTemperature(String settingTemperature) {
                this.settingTemperature = settingTemperature;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }
        }
    }
}
