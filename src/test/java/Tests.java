import model.WeatherRequest;
import openWeatherAPI.OpenWeatherRequest;
import org.json.JSONObject;
import org.junit.Before;
import weatherRepo.Weather;
import weatherRepo.WeatherFor;
import weatherRepo.WeatherRepo;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

public class Tests {


    @Test
    public void testAPIConnection(){

    }

    @Test
    public void testHighestTemperatureAndLowestTemperatureForThreeDays(){
        double maxTemp = WeatherFor.getThreeDayMaxTemp();
        double minTemp = WeatherFor.getThreeDayMinTemp();
        assertTrue(maxTemp >= minTemp);
    }

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
    public void testIfWeatherForecastByCityNameResponseCityIsCorrect(){
        String requestCity = "Tallinn";
        try {
            String responseCity = WeatherRepo.getCityName(WeatherRepo.getCityWeatherInformationJSON(requestCity));
            assertEquals(requestCity, responseCity);
        } catch (Exception e){
            
        }
    }

    @Test
    public void testReturnsMaxTemperature(){
        try{
            weatherResponse.getMaxTemperature();
        } catch (Exception e){
            fail("Test failed because: " + e.getMessage());
        }
    }

    @Test
    public void testReturnsMinTemperature(){
        try{
            weatherResponse.getMinTemperature();
        } catch (Exception e){
            fail("Test failed because: " + e.getMessage());
        }
    }


    @Test
    public void testIfTemperatureIsValid(){
        try{
            double currentTemperature = WeatherRepo.getCurrentTemperature();
            assert(currentTemperature >= -100);
            assert(currentTemperature <= 100);
        } catch (Exception e){
            fail("Test failed because: " + e.getMessage());
        }

    }

}
