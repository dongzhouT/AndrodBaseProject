package com.haierac.biz.airkeeper.net.entity;


public class RongCloudResultBean extends HaierBaseResultBean {

    /**
     * data : {"chatBaseUserInfoModel":{"nickName":"王斌","portraitUri":"http://47.93.185.230/images/headers/logo.jpg","userId":"49"},"chatToken":"44ansDglBOWzuHZJolttEQ6hXZbDPdsP1S3eENPpZv8bd0W+HW1cLzfZxWufdNlx8HIyTmMsG7o=","groupIds":[]}
     */

    private RongCloudTokenBean data;

    public RongCloudTokenBean getData() {
        return data;
    }

    public void setData(RongCloudTokenBean data) {
        this.data = data;
    }

}
