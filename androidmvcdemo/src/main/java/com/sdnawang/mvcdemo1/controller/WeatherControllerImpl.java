package com.sdnawang.mvcdemo1.controller;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.sdnawang.mvcdemo1.model.WeatherInfo;
import com.sdnawang.mvcdemo1.util.SingleVolley;

/**
 * Created by android on 2016/5/19.
 */
public class WeatherControllerImpl implements WeatherController {

    private Context context;

    public WeatherControllerImpl(Context context) {
        this.context = context;
    }

    @Override
    public void getWeather(final String cityNum, final OnWeatherListener listener) {

        String path = "http://wthrcdn.etouch.cn/weather_mini?citykey=" + cityNum;
        /* 数据层操作 */
        SingleVolley.getInstance(context).addToRequestQueue(new StringRequest(path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response == null || "".equals(response)) {
                    listener.onError();
                } else {
                    Toast.makeText(context, "onsuccess", Toast.LENGTH_SHORT).show();
                    WeatherInfo weatherInfo = com.alibaba.fastjson.JSONObject.parseObject(response, WeatherInfo.class);
                    listener.onSuccess(weatherInfo);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("------>OUT", "error.getMessage()" + error.getMessage() + error.getLocalizedMessage());
                listener.onError();
            }
        }));
    }
}
