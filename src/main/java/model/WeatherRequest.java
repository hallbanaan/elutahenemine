package model;

import weatherRepo.WeatherFor;
import weatherRepo.WeatherRepo;

import static model.Files.readInputCityNameFromFile;

public class WeatherRequest {

    public String cityName = readInputCityNameFromFile();
    public String units;

    public WeatherRequest(String cityName, String units){
        this.cityName = cityName;
        this.units = units;

        WeatherRepo.setApiKey("1d8d2592a2ae91ebd738f45541285340");
        WeatherRepo.setApiCallUrl("http://api.openweathermap.org/data/2.5/weather?q=");
        WeatherRepo.changeWeatherUnit(units);

        WeatherFor.setApiKey("1d8d2592a2ae91ebd738f45541285340");
        WeatherFor.setApiCallUrl("http://api.openweathermap.org/data/2.5/forecast?q=");
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
