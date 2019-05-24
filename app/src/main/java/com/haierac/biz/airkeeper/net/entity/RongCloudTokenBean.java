package com.haierac.biz.airkeeper.net.entity;

import java.util.List;

public class RongCloudTokenBean {

    /**
     * chatBaseUserInfoModel : {"nickName":"王斌","portraitUri":"http://47.93.185.230/images/headers/logo.jpg","userId":"49"}
     * chatToken : 44ansDglBOWzuHZJolttEQ6hXZbDPdsP1S3eENPpZv8bd0W+HW1cLzfZxWufdNlx8HIyTmMsG7o=
     * groupIds : []
     */

    private ChatBaseUserInfoModelBean chatBaseUserInfoModel;
    private String chatToken;
    private List<?> groupIds;

    public ChatBaseUserInfoModelBean getChatBaseUserInfoModel() {
        return chatBaseUserInfoModel;
    }

    public void setChatBaseUserInfoModel(ChatBaseUserInfoModelBean chatBaseUserInfoModel) {
        this.chatBaseUserInfoModel = chatBaseUserInfoModel;
    }

    public String getChatToken() {
        return chatToken;
    }

    public void setChatToken(String chatToken) {
        this.chatToken = chatToken;
    }

    public List<?> getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(List<?> groupIds) {
        this.groupIds = groupIds;
    }

    public static class ChatBaseUserInfoModelBean {
        /**
         * nickName : 王斌
         * portraitUri : http://47.93.185.230/images/headers/logo.jpg
         * userId : 49
         */

        private String nickName;
        private String portraitUri;
        private String userId;

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPortraitUri() {
            return portraitUri;
        }

        public void setPortraitUri(String portraitUri) {
            this.portraitUri = portraitUri;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
