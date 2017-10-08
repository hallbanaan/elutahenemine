package model;

import weatherRepo.WeatherRepo;

public class WeatherRequest {

    public final String cityName;
    public final String units;

    public WeatherRequest(String cityName, String units){
        this.cityName = cityName;
        this.units = units;

        WeatherRepo.setApiKey("1d8d2592a2ae91ebd738f45541285340");
        WeatherRepo.setApiCallUrl("api.openweathermap.org/data/2.5/weather?q=");
        WeatherRepo.changeUnit(units);

    }
}
