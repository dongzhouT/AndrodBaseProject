package com.haierac.biz.airkeeper.net.entity;


public class ServiceEngineerResultBean extends HaierBaseResultBean {

    /**
     * data : {"nickName":"王斌","portraitUri":"http://47.93.185.230/images/headers/logo.jpg","userId":"49","position":"高级工程师","introduce":"是一个很厉害的人"}
     */

    private ServiceEngineerBean data;

    public ServiceEngineerBean getData() {
        return data;
    }

    public void setData(ServiceEngineerBean data) {
        this.data = data;
    }
}
