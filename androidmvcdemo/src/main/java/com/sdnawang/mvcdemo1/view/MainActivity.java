package com.sdnawang.mvcdemo1.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sdnawang.mvcdemo1.R;
import com.sdnawang.mvcdemo1.controller.WeatherController;
import com.sdnawang.mvcdemo1.controller.WeatherControllerImpl;
import com.sdnawang.mvcdemo1.model.WeatherInfo;

public class MainActivity extends AppCompatActivity implements WeatherController.OnWeatherListener, View.OnClickListener{


    private TextView textView;
    private EditText editText;
    private Button button;
    private WeatherControllerImpl weatherModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherModel = new WeatherControllerImpl(this);
        initView();
    }

    private void initView(){
        textView = findView(R.id.textview);
        editText = findView(R.id.edittext);
        button = findView(R.id.button);
        button.setOnClickListener(this);
    }

    private <T extends View> T findView(int id){
        return (T)findViewById(id);
    }

    @Override
    public void onSuccess(WeatherInfo weatherInfo) {
        Log.e("---->OUT","city:" + weatherInfo.getData().getCity());
        textView.setText(weatherInfo.toString());
    }

    @Override
    public void onError() {
        Toast.makeText(this, "获取天气信息失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                //获取临沂天气情况
                weatherModel.getWeather(editText.getText().toString(),this);
                break;
        }
    }
}
