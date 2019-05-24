package com.haierac.biz.airkeeper.net.entity;

public class HistoryChildBean {
    private String model;
    private String temperature;
    private String windspeed;

    public String getModel() {
        return model;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getWindspeed() {
        return windspeed;
    }

    public HistoryChildBean(String model, String temperature, String windspeed) {
        this.model = model;
        this.temperature = temperature;
        this.windspeed = windspeed;
    }

}
