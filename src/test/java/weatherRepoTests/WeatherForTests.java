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
        try {
            WeatherFor.getCityForecastInfoJSON("Tallinn");
        } catch (Exception e){
            fail("Test failed because: " + e.getMessage());
        }
    }

    @Test
    public void testIfWeatherForecastByCityNameResponseCityIsCorrect(){
        String requestCity = "Tallinn";
        try {
            String responseCity = WeatherFor.getCityName(WeatherFor.getCityForecastInfoJSON(requestCity));
            assertEquals(requestCity, responseCity);
        } catch (Exception e){
            fail("Test failed because: " + e.getMessage());
        }
    }

    @Test
    public void testHighestTemperatureAndLowestTemperatureForThreeDays(){
        JSONObject forecast = WeatherFor.getCityForecastInfoJSON("Tallinn");
        double maxTemp = WeatherFor.getThreeDayMaxTemp(forecast);
        double minTemp = WeatherFor.getThreeDayMinTemp(forecast);
        assertTrue(maxTemp >= minTemp);
    }


    @Test
    public void testReturnsMaxTemperatureforThreeDays(){
        try{
            WeatherFor.getThreeDayMaxTemp(WeatherFor.getCityForecastInfoJSON("Tallinn"));
        } catch (Exception e){
            fail("Test failed because: " + e.getMessage());
        }
    }

    @Test
    public void testReturnsMinTemperatureforThreeDays(){
        try{
            WeatherFor.getThreeDayMinTemp(WeatherFor.getCityForecastInfoJSON("Tallinn"));
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
