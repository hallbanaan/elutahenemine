import org.json.JSONObject;
import weatherRepo.WeatherFor;
import weatherRepo.WeatherRepo;

import java.io.FileWriter;
import java.io.IOException;

import static model.Files.readInputCityNameFromFile;
import static weatherRepo.WeatherRepo.cityNameFromConsoleInput;
import static weatherRepo.WeatherRepo.getCityCoordinates;
import static weatherRepo.WeatherRepo.getCurrentTemperature;

public class Runner {

    public static JSONObject JSONWeatherReport(String cityName){
        JSONObject report;

        WeatherRepo.setUnits("metric");
        WeatherRepo.setApiKey("1d8d2592a2ae91ebd738f45541285340");
        WeatherRepo.setApiCallUrl("http://api.openweathermap.org/data/2.5/weather?q=");
        report = WeatherRepo.getCityWeatherInformationJSON(cityName);
        return report;
    }

    public static JSONObject JSONWeatherForecast(String cityName){
        JSONObject report;

        WeatherFor.setUnits("metric");
        WeatherFor.setApiKey("1d8d2592a2ae91ebd738f45541285340");
        WeatherFor.setApiCallUrl("http://api.openweathermap.org/data/2.5/forecast?q=");
        report = WeatherFor.getCityForecastInfoJSON(cityName);
        return report;
    }

    public static void main(String[] args){
        System.out.println("Getting weather report based on input.txt city");
        String cityName = readInputCityNameFromFile();
        JSONObject weatherFromF = JSONWeatherReport(cityName);
        System.out.println("Get the current temperature in input city");
        WeatherRepo.getCurrentTemperature(weatherFromF);
        System.out.println("Write the weather report into a file");
        outputFileWriter(weatherFromF);
        System.out.println("Get the city coordinates");
        WeatherRepo.getCityCoordinates(weatherFromF);

        System.out.println("Getting weather report based on console input city");
        String cityNameC = cityNameFromConsoleInput();
        JSONObject weatherFromC = JSONWeatherReport(cityNameC);
        System.out.println("Get current temperature in console input city");
        getCurrentTemperature(weatherFromC);

        System.out.println("Get weather forecast based on input.txt city");
        JSONObject weatherForecast = JSONWeatherForecast(cityName);
        System.out.println("Ger weather forcast city coordinates");
        getCityCoordinates(weatherForecast);
    }

    private static void outputFileWriter(JSONObject weather) {
            try {
                FileWriter fileWriter = new FileWriter("output.txt");
                fileWriter.write(weather.toString());
                fileWriter.close();
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        }


}


