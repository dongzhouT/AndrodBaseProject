package com.haierac.biz.airkeeper.net.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/8/10.
 */

public class LoginResultBean extends HaierBaseResultBean {

    /**
     * data : {"accessToken":"d7b0e8e30f480acd9fd499e8237af8ac9468f34b3240a1298171f7cd6fb588b9","company":"","email":"","industry":"0","mobile":"18561311200","realName":"","roles":[{"description":"手机用户","roleId":"2","roleName":"手机用户"}],"userId":2,"username":"18561311200"}
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
         * accessToken : d7b0e8e30f480acd9fd499e8237af8ac9468f34b3240a1298171f7cd6fb588b9
         * company :
         * email :
         * industry : 0
         * mobile : 18561311200
         * realName :
         * roles : [{"description":"手机用户","roleId":"2","roleName":"手机用户"}]
         * userId : 2
         * username : 18561311200
         */

        private String accessToken;
        private String company;
        private String email;
        private String industry;
        private String mobile;
        private String realName;
        private int userId;
        private String username;
        private List<RolesBean> roles;

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getIndustry() {
            return industry;
        }

        public void setIndustry(String industry) {
            this.industry = industry;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public List<RolesBean> getRoles() {
            return roles;
        }

        public void setRoles(List<RolesBean> roles) {
            this.roles = roles;
        }

        public static class RolesBean {
            /**
             * description : 手机用户
             * roleId : 2
             * roleName : 手机用户
             */

            private String description;
            private String roleId;
            private String roleName;

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getRoleId() {
                return roleId;
            }

            public void setRoleId(String roleId) {
                this.roleId = roleId;
            }

            public String getRoleName() {
                return roleName;
            }

            public void setRoleName(String roleName) {
                this.roleName = roleName;
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "accessToken='" + accessToken + '\'' +
                    ", company='" + company + '\'' +
                    ", email='" + email + '\'' +
                    ", industry='" + industry + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", realName='" + realName + '\'' +
                    ", userId=" + userId +
                    ", username='" + username + '\'' +
                    ", roles=" + roles +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LoginResultBean{" +
                "data=" + data +
                '}';
    }
}
