package weatherRepoTests;

import org.json.JSONObject;
import org.junit.Test;
import weatherRepo.WeatherRepo;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class WeatherRepoTests {

    @Test
    public void testReturnsCurrentTemperature(){
        WeatherRepo.setApiKey("1d8d2592a2ae91ebd738f45541285340");
        WeatherRepo.setApiCallUrl("http://api.openweathermap.org/data/2.5/weather?q=");
        WeatherRepo.setUnits("metric");
        JSONObject weatherReport = WeatherRepo.getCityWeatherInformationJSON("Tallinn");
        try{
            WeatherRepo.getCurrentTemperature(weatherReport);
        } catch (Exception e) {
            fail("Test failed because: " + e.getMessage());
        }
    }

    @Test
    public void testIfWeatherReportByCityNameResponseCityIsCorrect(){
        String requestCity = "Tallinn";
        WeatherRepo.setApiKey("1d8d2592a2ae91ebd738f45541285340");
        WeatherRepo.setApiCallUrl("http://api.openweathermap.org/data/2.5/weather?q=");
        WeatherRepo.setUnits("metric");
        JSONObject forecast;
        try {
            forecast = WeatherRepo.getCityWeatherInformationJSON(requestCity);
            String responseCity = WeatherRepo.getCityName(forecast);
            assertEquals(requestCity, responseCity);
        } catch (Exception e){
            fail("Test failed because: " + e.getMessage());
        }
    }

    @Test
    public void testIfTemperatureIsValid(){
        try{
            WeatherRepo.setApiKey("1d8d2592a2ae91ebd738f45541285340");
            WeatherRepo.setApiCallUrl("http://api.openweathermap.org/data/2.5/weather?q=");
            WeatherRepo.setUnits("metric");
            JSONObject result;
            result = WeatherRepo.getCityWeatherInformationJSON("Tallinn");
            double currentTemperature = WeatherRepo.getCurrentTemperature(result);
            assert(currentTemperature >= -100);
            assert(currentTemperature <= 100);
        } catch (Exception e){
            fail("Test failed because: " + e.getMessage());
        }
    }

    @Test
    public void testIfReturnsJsonForCityWeatherReport(){
        try{
            WeatherRepo.setApiKey("1d8d2592a2ae91ebd738f45541285340");
            WeatherRepo.setApiCallUrl("http://api.openweathermap.org/data/2.5/weather?q=");
            WeatherRepo.setUnits("metric");
            WeatherRepo.getCityWeatherInformationJSON("Tallinn");
        } catch (Exception e){
            fail("Test failed because: " + e.getMessage());
        }
    }

    @Test
    public void testIfUnitChangeRejectsFaultyUnit(){
        try{
            WeatherRepo.changeWeatherUnit("Potato");
        } catch (Exception e){
            fail("Test failed because: " + e.getMessage());
        }
    }


}
