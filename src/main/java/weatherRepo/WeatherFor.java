package weatherRepo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.util.*;

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

    public void outputFileWriter(JSONObject weatherReportJson){
        try {
            FileWriter fileWriter = new FileWriter("output.txt");
            fileWriter.write(weatherReportJson.toString());
            fileWriter.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static String cityNameFromConsoleInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter city name: ");
        String cityName = scanner.nextLine();
        return cityName;
    }

    public static JSONObject getForecastForSpecificDay(JSONObject weatherReportJson, int dayNumber){
        if (dayNumber<=3 && dayNumber>=1){
            JSONArray list;
            dayNumber-=1;
            try{
                String currentDate = weatherReportJson.getJSONArray("list").getJSONObject(0).getString("dt_txt");
                System.out.println(currentDate);
            } catch (JSONException e){
                System.out.println(e.getMessage());
            }
        }
        return null;
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
            JSONArray threeDaysWeather = weatherReportJson.getJSONArray("list");
            int forecastNumber = 0;
            String newMaxTemp;
            String currentMaxTemp = threeDaysWeather.getJSONObject(forecastNumber).getJSONObject("main").getString("temp_max");
            System.out.println(currentMaxTemp);
            for(int i = 0; i< threeDaysWeather.length(); i++){
                forecastNumber++;
                String maxTemp = threeDaysWeather.getJSONObject(forecastNumber).getJSONObject("main").getString("temp_max");
                if(Double.parseDouble(currentMaxTemp)<Double.parseDouble(maxTemp)){
                    newMaxTemp = maxTemp.toString();
                }
            }
            return null;
        } catch (JSONException e){
            System.out.println(e.getMessage());
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

    public String getCityCoordinatesForecast(JSONObject weatherReportJson){
        int lon = 0;
        int lat = 0;
        String cityCoordinates;
        try{
            JSONObject cityName = weatherReportJson.getJSONObject("city");
            JSONObject coordinate = cityName.getJSONObject("coord");
            lon = coordinate.getInt("lon");
            lat = coordinate.getInt("lat");
        } catch (JSONException e){
            System.out.println(e.getMessage());
        }
        return cityCoordinates = Integer.toString(lon) + ":" + Integer.toString(lat);
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
