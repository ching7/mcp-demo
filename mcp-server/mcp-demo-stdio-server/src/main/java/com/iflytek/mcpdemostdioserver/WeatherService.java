package com.iflytek.mcpdemostdioserver;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    /**
     * 根据城市名称查询近3天的天气情况
     *
     * @param cityName 城市名
     * @return 天气情况JSON
     */
    @Tool(description = "根据城市名称查询近3天的天气情况")
    public String getWeatherByCityName(String cityName) {
        // 创建预报数组
        JSONArray forecastArray = new JSONArray();
        for (int i = 1; i <= 3; i++) {
            JSONObject dailyWeather = new JSONObject();
            dailyWeather.put("day", "Day " + i);
            dailyWeather.put("condition", "Sunny");
            dailyWeather.put("temperature", "25°C");
            forecastArray.add(dailyWeather);
        }

        // 创建主 JSON 对象
        JSONObject mainJson = new JSONObject();
        mainJson.put("city", cityName);
        mainJson.put("forecast", forecastArray);

        return mainJson.toString();
    }
}
