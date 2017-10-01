import openWeatherAPI.OpenWeatherRequest;
import org.junit.Before;
import weatherRepo.WeatherRepo;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

public class Tests {

    @Before
    public static void setUpTests(){
       OpenWeatherRequest weatherRequest = new OpenWeatherRequest("Tallinn", "EE");
    }

    @Test
    public void testAPIConnection(){

    }

    @Test
    public void testHighestTemperatureAndLowestTemperatureForThreeDays(){
        double maxTemp = weatherRequest.getThreeDayMaxTemp();
        double minTemp = weatherRequest.getThreeDayMinTemp();
        assertTrue(maxTemp >= minTemp);
    }

    @Test
    public void testReturnsCurrentTemperature(){
        try{
            weatherRequest.getCurrentTempterature();
        } catch (Exception e) {
            fail("Test failed because: " + e.getMessage());
        }
    }

    @Test
    public void testIfWeatherForecastByCityNameResponseCityIsCorrect(){
        String requestCity = weatherRequest.getCityName();
        String responseCity = weatherResponse.getCityName();
        assertEquals(requestCity, responseCity);
    }

    @Test
    public void testWeatherForecastByCityID(){

    }

    @Test
    public void testWeatherForecastByCityZIPCode(){

    }

    @Test
    public void invalidCityIDShouldThrowIllegalArgumentException(){

    }

    @Test
    public void shouldParseCurrentTemperature(){

    }

    @Test
    public void shouldParseMaxTemperature(){

    }

    @Test
    public void shouldParseMinTemperature(){

    }

    @Test
    public void shouldParseWeatherData(){

    }

    @Test
    public void shouldParseCityName(){

    }

    @Test
    public void testHighestPossibleTemperature(){

    }

    @Test
    public void testLowestPossibleTemperature(){

    }

    @Test
    public void testExceedsHighestTemperatureShouldThrowException(){

    }

    @Test
    public void testExceedsLowestTemperatureShouldThrowException(){

    }
}
