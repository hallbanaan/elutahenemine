package weatherRepoTests;

import org.json.JSONObject;
import org.junit.Test;
import weatherRepo.WeatherFor;
import weatherRepo.WeatherRepo;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

public class WeatherForTests {

    @Test
    public void testIfReturnsJsonForCityForecast(){
        WeatherFor.setApiCallUrl("api.openweathermap.org/data/2.5/weatherforecast?q=");
        WeatherFor.setApiKey("adcbffcebeea43ec2d5db311c52848bd");
        WeatherFor.setUnits("Metric");
        JSONObject forecast;
        try {
            forecast = WeatherFor.getCityForecastInfoJSON("Tallinn");
        } catch (Exception e) {
            fail("Test failed because: " + e.getMessage());
        }
    }

    @Test
    public void testIfWeatherForecastByCityNameResponseCityIsCorrect(){
        WeatherFor.setApiCallUrl("api.openweathermap.org/data/2.5/weatherforecast?q=");
        WeatherFor.setApiKey("adcbffcebeea43ec2d5db311c52848bd");
        WeatherFor.setUnits("metric");
        JSONObject forecast;
        String requestCity = "Tallinn";
        try {
            forecast = WeatherFor.getCityForecastInfoJSON(requestCity);
            String responseCity = WeatherFor.getCityName(forecast);
            assertEquals(requestCity, responseCity);
        } catch (Exception e){
            fail("Test failed because: " + e.getMessage());
        }
    }

    @Test
    public void testHighestTemperatureAndLowestTemperatureForThreeDays(){
        WeatherFor.setApiCallUrl("api.openweathermap.org/data/2.5/weatherforecast?q=");
        WeatherFor.setApiKey("adcbffcebeea43ec2d5db311c52848bd");
        WeatherFor.setUnits("metric");
        JSONObject forecast = WeatherFor.getCityForecastInfoJSON("Tallinn");
        double maxTemp = WeatherFor.getThreeDayMaxTemp(forecast);
        double minTemp = WeatherFor.getThreeDayMinTemp(forecast);
        assertTrue(maxTemp >= minTemp);
    }


    @Test
    public void testReturnsMaxTemperatureforThreeDays(){
        WeatherFor.setApiCallUrl("api.openweathermap.org/data/2.5/weatherforecast?q=");
        WeatherFor.setApiKey("adcbffcebeea43ec2d5db311c52848bd");
        WeatherFor.setUnits("metric");
        JSONObject forecast = WeatherFor.getCityForecastInfoJSON("Tallinn");
        try{
            WeatherFor.getThreeDayMaxTemp(forecast);
        } catch (Exception e){
            fail("Test failed because: " + e.getMessage());
        }
    }

    @Test
    public void testReturnsMinTemperatureforThreeDays(){
        WeatherFor.setApiCallUrl("api.openweathermap.org/data/2.5/weatherforecast?q=");
        WeatherFor.setApiKey("adcbffcebeea43ec2d5db311c52848bd");
        WeatherFor.setUnits("metric");
        JSONObject forecast = WeatherFor.getCityForecastInfoJSON("Tallinn");
        try{
            WeatherFor.getThreeDayMinTemp(forecast);
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
