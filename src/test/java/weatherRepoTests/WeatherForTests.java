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
        WeatherFor.setApiCallUrl("http://api.openweathermap.org/data/2.5/forecast?q=");
        WeatherFor.setApiKey("1d8d2592a2ae91ebd738f45541285340");
        WeatherFor.setUnits("metric");
        JSONObject forecast;
        try {
            forecast = WeatherFor.getCityForecastInfoJSON("Tallinn");
        } catch (Exception e) {
            fail("Test failed because: " + e.getMessage());
        }
    }

    @Test
    public void testIfWeatherForecastByCityNameResponseCityIsCorrect(){
        WeatherFor.setApiCallUrl("http://api.openweathermap.org/data/2.5/forecast?q=");
        WeatherFor.setApiKey("1d8d2592a2ae91ebd738f45541285340");
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
        WeatherFor.setApiCallUrl("http://api.openweathermap.org/data/2.5/forecast?q=");
        WeatherFor.setApiKey("1d8d2592a2ae91ebd738f45541285340");
        WeatherFor.setUnits("metric");
        JSONObject forecast = WeatherFor.getCityForecastInfoJSON("Tallinn");
        String maxTemp = WeatherFor.getThreeDayMaxTemp(forecast);
        //String minTemp = WeatherFor.getThreeDayMinTemp(forecast);
        //assertTrue(maxTemp >= minTemp);
    }


    @Test
    public void testReturnsMaxTemperatureforThreeDays(){
        WeatherFor.setApiCallUrl("http://api.openweathermap.org/data/2.5/forecast?q=");
        WeatherFor.setApiKey("1d8d2592a2ae91ebd738f45541285340");
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
        WeatherFor.setApiCallUrl("http://api.openweathermap.org/data/2.5/forecast?q=");
        WeatherFor.setApiKey("1d8d2592a2ae91ebd738f45541285340");
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
