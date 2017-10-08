package model;

import weatherRepo.WeatherFor;
import weatherRepo.WeatherRepo;

public class WeatherRequest {

    public String cityName;
    public String units;

    public WeatherRequest(String cityName, String units){
        this.cityName = cityName;
        this.units = units;

        WeatherRepo.setApiKey("adcbffcebeea43ec2d5db311c52848bd");
        WeatherRepo.setApiCallUrl("api.openweathermap.org/data/2.5/weather?q=");
        WeatherRepo.changeWeatherUnit(units);

        WeatherFor.setApiKey("adcbffcebeea43ec2d5db311c52848bd");
        WeatherFor.setApiCallUrl("api.openweathermap.org/data/2.5/weatherforecast?q=");
        WeatherFor.changeWeatherUnit(units);

    }

    public void setCityName(String cityName){
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setUnits(String units) {
        this.units = units;
    }
    public String getUnits(){
        return units;
    }
}
