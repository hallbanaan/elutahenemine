package weatherRepo;

import model.WeatherRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WeatherRepo implements Weather{

    private static String units;
    private static String apiKey;
    private static String apiCallUrl;

    public static JSONObject getCityWeatherInformationJSON(String cityName){
        JSONObject weatherReportJson = null;
        try {
            URL url = new URL(apiCallUrl + cityName + "&units=" + units + "&appid=" + apiKey);
            URLConnection newCon = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(newCon.getInputStream()));
            String readerResult = reader.readLine();
            reader.close();
            try{
                weatherReportJson = new JSONObject(readerResult);
            } catch (JSONException e){
                System.out.println(e.getMessage());
            }
        } catch (MalformedURLException e){
            System.out.println(e.getMessage());
        } return weatherReportJson;
    }

    public static double getCurrentTemperature(JSONObject weatherReportJson){
        double currentTemperature = 0;
        try {
            JSONObject mainInfo = weatherReportJson.getJSONObject("main");
            return currentTemperature = mainInfo.getDouble("temp");
        } catch (JSONException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public static String getCityName(JSONObject weatherReportJson){
        String cityName = "Null";
        try{
            cityName = weatherReportJson.getString("name");
        } catch (JSONException e){
            System.out.println(e.getMessage());
        } return cityName;
    }

   public static String changeWeatherUnit(String newUnit){
        if (newUnit == "Metric" || newUnit == "Imperial" || newUnit == "Kelvin"){
            units = newUnit;
            return "Units sucessfully changed to: " + newUnit;
        } else {
            return "Unit change failed.";
        }
    }

    public static void setApiKey(String apiKey){
        WeatherRepo.apiKey = apiKey;
    }
    public static String getApiKey(){return apiKey;}

    public static void setApiCallUrl(String apiCallUrl){
        WeatherRepo.apiCallUrl = apiCallUrl;
    }
    public static String getApiCallUrl(){return apiCallUrl;}

    public static void setUnits(String units){
        WeatherRepo.units = units;
    }
    public static String getUnits(){return units;}
}
