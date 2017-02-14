package com.sdnawang.mvcdemo1.controller;

import com.sdnawang.mvcdemo1.model.WeatherInfo;

/**
 * Created by android on 2016/5/19.
 */
public interface WeatherController {
    void  getWeather(String cityNum, OnWeatherListener listener);

     interface OnWeatherListener{
        void onSuccess(WeatherInfo weatherInfo);

        void onError();
    }
}
