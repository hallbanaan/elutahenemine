package openWeatherAPI;

public class OpenWeatherRequest {
    public final String cityName;
    public final String countryCode;

    public OpenWeatherRequest(String cityName, String countryCode){
        this.cityName = cityName;
        this.countryCode = countryCode;
    }
}
