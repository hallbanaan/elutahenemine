package weatherRepo;

public class WeatherRepo implements Weather{

    private static String units;
    private static String apiKey;
    private static String apiCallUrl;

    public CurrentWeatherReport getCurrentWeather(WeatherRequest request){
        throw new UnsupportedOperationException("Coming soon");
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

    public static void setApiKey(String apiKey){
        WeatherRepo.apiKey = apiKey;
    }
    public static void setApiCallUrl(String apiCallUrl){
        WeatherRepo.apiCallUrl = apiCallUrl;
    }
    public static void setUnits(String units){
        WeatherRepo.units = units;
    }
}
