package com.haierac.biz.airkeeper.net.entity;

/**
 * Created by Administrator on 2019/2/25.
 */

public class SubmitStarBean {
    private String innerId;
    private String totalScore;
    private String useScore;
    private String installScore;
    private String serviceScore;

    public void setInnerId(String innerId) {
        this.innerId = innerId;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    public void setUseScore(String useScore) {
        this.useScore = useScore;
    }

    public void setInstallScore(String installScore) {
        this.installScore = installScore;
    }

    public void setServiceScore(String serviceScore) {
        this.serviceScore = serviceScore;
    }
}
