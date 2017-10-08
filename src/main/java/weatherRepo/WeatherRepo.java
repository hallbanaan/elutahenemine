package weatherRepo;

import model.WeatherRequest;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
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
            String result = reader.readLine();
            reader.close();
            try{
                weatherReportJson = new JSONObject(result);
                return weatherReportJson;
            } catch (JSONException e){
                System.out.println(e.getMessage());
            }
        } catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }
    }

    public static getCurrentWeatherReport (WeatherRequest request){
        throw new UnsupportedOperationException("Not yet");
    }
    public ThreeDayWeatherReport getThreeDayWeather(WeatherRequest request){
        throw new UnsupportedOperationException("Coming soon");
    }
    public static String getCityByID(){
        throw new UnsupportedOperationException("Coming soon");
    }

    public static String getThreeDayForecast(){
        throw new UnsupportedOperationException("Coming soon");
    }

    public static double getCurrentTemperature(){
        throw new UnsupportedOperationException("Coming soon");
    }

    public static double getThreeDayMaxTemp(){
        throw new UnsupportedOperationException("Coming soon");
    }

    public static double getThreeDayMinTemp(){
        throw new UnsupportedOperationException("Coming soon");
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
