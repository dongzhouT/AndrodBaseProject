
package com.haierac.biz.airkeeper.net.entity;

/**
 * 实体Bean基类，封装一些通用的属性和方法
 */
public class HaierBaseResultBean {


    /**
     * 通用接口中错误代码
     */
    public String retCode;

    /**
     * 通用接口中错误信息
     */
    public String retInfo;

//    /**
//     * 业务接口中错误代码
//     */
//    public String error;
//
//    /**
//     * 业务接口中错误信息
//     */
//    public String error_info;
//    /**
//     * 服务器当前时间
//     */
//    public String nowTime;


    public boolean ok() {
        // 兼容Uhome更新接口
        return "000000".equals(retCode);
    }

    public boolean tokenInvalid() {
        return "112233".equals(retCode);
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetInfo() {
        return retInfo;
    }

    public void setRetInfo(String retInfo) {
        this.retInfo = retInfo;
    }
    //    @Override
//    public String toString() {
//        return "HaierBaseResultBean{" +
//                "retCode='" + retCode + '\'' +
//                ", retInfo='" + retInfo + '\'' +
//                ", error='" + error + '\'' +
//                ", error_info='" + error_info + '\'' +
//                ", nowTime='" + nowTime + '\'' +
//                '}';
//    }
}
