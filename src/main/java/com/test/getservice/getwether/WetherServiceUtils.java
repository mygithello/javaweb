package com.test.getservice.getwether;

import com.test.getservice.getwether.entity.WeatherInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

public class WetherServiceUtils {

    /**
     * 通过城市名称获取该城市的天气信息
     */

    public  static String GetWeatherData(String cityname) {
        StringBuilder sb=new StringBuilder();;
        try {
            //cityname = URLEncoder.encode(cityName, "UTF-8");
            String weather_url = "http://wthrcdn.etouch.cn/weather_mini?city="+cityname;


            URL url = new URL(weather_url);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            GZIPInputStream gzin = new GZIPInputStream(is);
            InputStreamReader isr = new InputStreamReader(gzin, "utf-8"); // 设置读取流的编码格式，自定义编码
            BufferedReader reader = new BufferedReader(isr);
            String line = null;
            while((line=reader.readLine())!=null)
                sb.append(line+" ");
            reader.close();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //System.out.println(sb.toString());
        return sb.toString();

    }


    /**
     * 将JSON格式数据进行解析 ，返回一个weather对象
     * @return
     */
    public static WeatherInfo GetWeather(String weatherInfobyJson){
        JSONObject dataOfJson = JSONObject.fromObject(weatherInfobyJson);
        if(dataOfJson.getInt("status")!=1000)
            return null;

        //创建WeatherInfo对象，提取所需的天气信息
        WeatherInfo weatherInfo = new WeatherInfo();

        //从json数据中提取数据
        String data = dataOfJson.getString("data");

        dataOfJson = JSONObject.fromObject(data);
        weatherInfo.setCityname(dataOfJson.getString("city"));;
        weatherInfo.setAirquality(dataOfJson.getString("aqi"));

        //获取预测的天气预报信息
        JSONArray forecast = dataOfJson.getJSONArray("forecast");


        //取得当天的
        JSONObject result=forecast.getJSONObject(0);

        weatherInfo.setDate(result.getString("date"));

        System.out.println(result.getString("fengxiang"));
        System.out.println(result.getString("fengli"));


        String high = result.getString("high").substring(2);
        String low  = result.getString("low").substring(2);

        weatherInfo.setTemperature(low+"~"+high);

        weatherInfo.setWeather(result.getString("type"));

        //"{\"data\":{\"yesterday\":{\"date\":\"20日星期一\",\"high\":\"高温 12℃\",\"fx\":\"无持续风向\",\"low\":\"低温 3℃\",\"fl\":\"\",\"type\":\"晴\"},\"city\":\"武汉\",\"aqi\":\"105\",\"forecast\":[{\"date\":\"21日星期二\",\"high\":\"高温 13℃\",\"fengli\":\"\",\"low\":\"低温 6℃\",\"fengxiang\":\"无持续风向\",\"type\":\"多云\"},{\"date\":\"22日星期三\",\"high\":\"高温 13℃\",\"fengli\":\"\",\"low\":\"低温 4℃\",\"fengxiang\":\"北风\",\"type\":\"多云\"},{\"date\":\"23日星期四\",\"high\":\"高温 14℃\",\"fengli\":\"\",\"low\":\"低温 3℃\",\"fengxiang\":\"无持续风向\",\"type\":\"多云\"},{\"date\":\"24日星期五\",\"high\":\"高温 15℃\",\"fengli\":\"\",\"low\":\"低温 3℃\",\"fengxiang\":\"无持续风向\",\"type\":\"多云\"},{\"date\":\"25日星期六\",\"high\":\"高温 16℃\",\"fengli\":\"\",\"low\":\"低温 4℃\",\"fengxiang\":\"无持续风向\",\"type\":\"多云\"}],\"ganmao\":\"天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。\",\"wendu\":\"10\"},\"status\":1000,\"desc\":\"OK\"}"

        return weatherInfo;
    }

}
