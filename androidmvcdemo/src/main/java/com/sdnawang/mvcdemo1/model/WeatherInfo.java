package com.sdnawang.mvcdemo1.model;

import com.sdnawang.mvcdemo1.model.Data;

/**
 * Created by android on 2016/5/19.
 */
public class WeatherInfo {

    private String desc;
    private int status;
    private Data data;

    public WeatherInfo() {
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String toString(){
        return "desc:"+desc +"\n"+ "status:"+status+"\n"+"data:" + data.toString() ;
    }
}
