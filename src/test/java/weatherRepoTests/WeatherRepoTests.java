package weatherRepoTests;

import org.json.JSONObject;
import org.junit.Test;
import weatherRepo.WeatherRepo;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class WeatherRepoTests {

    @Test
    public void testReturnsCurrentTemperature(){
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
        try {
            String responseCity = WeatherRepo.getCityName(WeatherRepo.getCityWeatherInformationJSON(requestCity));
            assertEquals(requestCity, responseCity);
        } catch (Exception e){
            fail("Test failed because: " + e.getMessage());
        }
    }

    @Test
    public void testIfTemperatureIsValid(){
        try{
            double currentTemperature = WeatherRepo.getCurrentTemperature(WeatherRepo.getCityWeatherInformationJSON("Tallinn"));
            assert(currentTemperature >= -100);
            assert(currentTemperature <= 100);
        } catch (Exception e){
            fail("Test failed because: " + e.getMessage());
        }
    }

    @Test
    public void testIfReturnsJsonForCityWeatherReport(){
        try{
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
