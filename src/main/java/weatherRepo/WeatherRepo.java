package weatherRepo;

public class WeatherRepo implements Weather{

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

}
