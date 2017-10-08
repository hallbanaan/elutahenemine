package weatherRepo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WeatherFor {
    private static String apiKey;
    private static String apiCallUrl;
    private static String units;

    private static JSONObject getCityForecastInfoJSON (String cityName){
        JSONObject weatherReportJson = null;
        try {
            URL url = new URL(apiCallUrl + cityName + "&units" + units + "&appid=" + apiKey);
            URLConnection newCon = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(newCon.getInputStream()));
            String readerResult = reader.readLine();
            reader.close();
            try{
                weatherReportJson = new JSONObject(readerResult);
                return weatherReportJson;
            } catch (JSONException e){
                System.out.println(e.getMessage());
            }
        } catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }
    }
}
