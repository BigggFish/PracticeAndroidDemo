package com.sdnawang.mvcdemo1.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by android on 2016/5/21.
 */
public class Data {

    private String wendu;
    private String ganmao;
    private String forecast;
    private String aqi;
    private String city;

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {

        try {
            ganmao = new String(ganmao.getBytes("iso-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.ganmao = ganmao;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {

        try {
            city = new String(city.getBytes("iso-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.city = city;
    }

    public String toString(){
        return "\n"+"城市:" + city +"\n"+ "温度:" + wendu +"\n"+ "感冒:" + ganmao;
    }
}
