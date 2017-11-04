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
        String line;
        try {
            URL url = new URL(apiCallUrl + cityName + "&units=" + units + "&appid=" + apiKey);
            URLConnection newCon = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(newCon.getInputStream()));
            while((line = reader.readLine()) != null){
                try{
                    weatherReportJson = new JSONObject(line);
                } catch (JSONException e){
                    System.out.println(e.getMessage());
                }
            }
            reader.close();
        } catch (MalformedURLException e){
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }return weatherReportJson;
    }

    public double getCurrentTemperature(JSONObject weatherReportJson){
        try {
            JSONObject mainInfo = weatherReportJson.getJSONObject("main");
            double currentTemperature = mainInfo.getDouble("temp");
            return currentTemperature;
        } catch (JSONException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public String getCityName(JSONObject weatherReportJson){
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

    public String getCityCoordinates(JSONObject weatherReportJson){
        int lon = 0;
        int lat = 0;
        String cityCoordinates;
        try{
            JSONObject coordinate = weatherReportJson.getJSONObject("coord");
            lon = coordinate.getInt("lon");
            lat = coordinate.getInt("lat");
        } catch (JSONException e){
            System.out.println(e.getMessage());
        }
        return cityCoordinates = Integer.toString(lon) + ":" + Integer.toString(lat);
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
