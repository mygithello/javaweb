package com.test.getservice.getwether;

import com.test.getservice.getwether.entity.WeatherInfo;

public class Test {
    public static void main(String[]  args){
        String info = WetherServiceUtils.GetWeatherData("杭州");
        WeatherInfo weatherinfo = WetherServiceUtils.GetWeather(info);
        System.out.println(weatherinfo.toString());
    }
}
