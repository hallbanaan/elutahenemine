package weatherRepo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;

public class WeatherFor implements Weather{

    private static String apiKey;
    private static String apiCallUrl;
    private static String units;

    public static JSONObject getCityForecastInfoJSON (String cityName){
        JSONObject weatherReportJson = null;
        String line;
        try {
            URL url = new URL(apiCallUrl + cityName + "&units=" + units + "&appid=" + apiKey);
            URLConnection newCon = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(newCon.getInputStream()));
            while ((line = reader.readLine()) != null){
                try{
                    weatherReportJson = new JSONObject(line);
                    return weatherReportJson;
                } catch (JSONException e){
                    System.out.println(e.getMessage());
                }
            }
            reader.close();

        } catch (MalformedURLException e){
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return weatherReportJson;
    }

    public static JSONObject getForecastForSpecificDay(JSONObject weatherReportJson, int dayNumber){
        JSONArray list;
        JSONObject forecastForDay = null;
        try{
            list = weatherReportJson.getJSONArray("list");
            forecastForDay = list.getJSONObject(dayNumber);
        } catch (JSONException e){
            System.out.println(e.getMessage());
        } return forecastForDay;
    }

    public static String getCityName(JSONObject weatherReportJson){
        String cityName = "Null";
        try {
            JSONObject city = weatherReportJson.getJSONObject("city");
            cityName = city.getString("name");
        } catch (JSONException e){
            System.out.println(e.getMessage());
        }
         return cityName;
    }

    public static String getThreeDayMaxTemp(JSONObject weatherReportJson){
        try{
            JSONArray list = weatherReportJson.getJSONArray("list");
            JSONArray main = list.getJSONArray(1);
            String maxTemp = main.getString(2);
            return maxTemp;
        } catch (JSONException e){
            System.out.println();
        } return null;
    }

    public static double getThreeDayMinTemp(JSONObject weatherReportJson){
        try{
            JSONObject main = weatherReportJson.getJSONObject("main");
            double minTemp = main.getDouble("temp_min");
            return minTemp;
        } catch (JSONException e){
            System.out.println(e.getMessage());
        } return 0;
    }

    public static String changeWeatherUnit(String newUnit){
        if (newUnit == "metric" || newUnit == "imperial" || newUnit == "kelvin"){
            units = newUnit;
            return "Units sucessfully changed to: " + newUnit;
        } else {
            return "Unit change failed.";
        }
    }

    public static void setApiKey(String apiKey){
        WeatherFor.apiKey = apiKey;
    }
    public static String getApiKey(){return apiKey;}

    public static void setApiCallUrl(String apiCallUrl){
        WeatherFor.apiCallUrl = apiCallUrl;
    }
    public static String getApiCallUrl(){return apiCallUrl;}

    public static void setUnits(String units){
        WeatherFor.units = units;
    }
    public static String getUnits(){return units;}
}
