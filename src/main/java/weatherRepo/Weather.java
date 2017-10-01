package weatherRepo;

public interface Weather {
    CurrentWeatherReport getCurrentWeather(WeatherRequest request);
    ThreeDayWeatherReport getThreeDayWeather(WeatherRequest request);
}
