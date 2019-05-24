package com.haierac.biz.airkeeper.net.entity;


public class OpenAdBean  extends HaierBaseResultBean {

    /**
     * data : {"advertisement":{"aid":"1","clickUrl":"101.200.210.97:8100","decription":"decription","imgUrl":"http://eplusplatform.oss-cn-beijing.aliyuncs.com/LaunchScreen/b28b46811d7cbab8eb5f24c727342387.jpg","showNow":"true","title":"青岛市崂山区海尔路1号海尔工业园"},"appVersion":{"decription":"1、升级版本\n2、描述语言\n","forceUpdateVersion":"1.0","updateVersion":"1.0"},"productNews":{"caseNew":"http://101.200.210.97/centralac/","productNews":"http://101.200.210.97/centralac/","reference":"http://101.200.210.97"}}
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
         * advertisement : {"aid":"1","clickUrl":"101.200.210.97:8100","decription":"decription","imgUrl":"http://eplusplatform.oss-cn-beijing.aliyuncs.com/LaunchScreen/b28b46811d7cbab8eb5f24c727342387.jpg","showNow":"true","title":"青岛市崂山区海尔路1号海尔工业园"}
         * appVersion : {"decription":"1、升级版本\n2、描述语言\n","forceUpdateVersion":"1.0","updateVersion":"1.0"}
         * productNews : {"caseNew":"http://101.200.210.97/centralac/","productNews":"http://101.200.210.97/centralac/","reference":"http://101.200.210.97"}
         */

        private AdvertisementBean advertisement;
        private AppVersionBean appVersion;
        private ProductNewsBean productNews;

        public AdvertisementBean getAdvertisement() {
            return advertisement;
        }

        public void setAdvertisement(AdvertisementBean advertisement) {
            this.advertisement = advertisement;
        }

        public AppVersionBean getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(AppVersionBean appVersion) {
            this.appVersion = appVersion;
        }

        public ProductNewsBean getProductNews() {
            return productNews;
        }

        public void setProductNews(ProductNewsBean productNews) {
            this.productNews = productNews;
        }

        public static class AdvertisementBean {
            /**
             * aid : 1
             * clickUrl : 101.200.210.97:8100
             * decription : decription
             * imgUrl : http://eplusplatform.oss-cn-beijing.aliyuncs.com/LaunchScreen/b28b46811d7cbab8eb5f24c727342387.jpg
             * showNow : true
             * title : 青岛市崂山区海尔路1号海尔工业园
             */

            private String aid;
            private String clickUrl;
            private String decription;
            private String imgUrl;
            private String showNow;
            private String title;

            public String getAid() {
                return aid;
            }

            public void setAid(String aid) {
                this.aid = aid;
            }

            public String getClickUrl() {
                return clickUrl;
            }

            public void setClickUrl(String clickUrl) {
                this.clickUrl = clickUrl;
            }

            public String getDecription() {
                return decription;
            }

            public void setDecription(String decription) {
                this.decription = decription;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getShowNow() {
                return showNow;
            }

            public void setShowNow(String showNow) {
                this.showNow = showNow;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class AppVersionBean {
            /**
             * decription : 1、升级版本
             2、描述语言
             * forceUpdateVersion : 1.0
             * updateVersion : 1.0
             */

            private String decription;
            private String forceUpdateVersion;
            private String updateVersion;

            public String getDecription() {
                return decription;
            }

            public void setDecription(String decription) {
                this.decription = decription;
            }

            public String getForceUpdateVersion() {
                return forceUpdateVersion;
            }

            public void setForceUpdateVersion(String forceUpdateVersion) {
                this.forceUpdateVersion = forceUpdateVersion;
            }

            public String getUpdateVersion() {
                return updateVersion;
            }

            public void setUpdateVersion(String updateVersion) {
                this.updateVersion = updateVersion;
            }
        }

        public static class ProductNewsBean {
            /**
             * caseNew : http://101.200.210.97/centralac/
             * productNews : http://101.200.210.97/centralac/
             * reference : http://101.200.210.97
             */

            private String caseNew;
            private String productNews;
            private String reference;

            public String getCaseNew() {
                return caseNew;
            }

            public void setCaseNew(String caseNew) {
                this.caseNew = caseNew;
            }

            public String getProductNews() {
                return productNews;
            }

            public void setProductNews(String productNews) {
                this.productNews = productNews;
            }

            public String getReference() {
                return reference;
            }

            public void setReference(String reference) {
                this.reference = reference;
            }
        }
    }
}
