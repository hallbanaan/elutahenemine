import org.json.JSONObject;
import weatherRepo.WeatherRepo;

import java.io.FileWriter;
import java.io.IOException;

import static model.Files.readInputCityNameFromFile;
import static weatherRepo.WeatherRepo.cityNameFromConsoleInput;

public class Runner {

    public static JSONObject JSONWeatherReport(){
        JSONObject report;
        WeatherRepo.setUnits("metric");
        WeatherRepo.setApiKey("1d8d2592a2ae91ebd738f45541285340");
        WeatherRepo.setApiCallUrl("http://api.openweathermap.org/data/2.5/weather?q=");
        report = WeatherRepo.getCityWeatherInformationJSON("Tallinn");
        System.out.println(report);
        return report;
    }


    public static void main(String[] args){
        JSONObject weather = JSONWeatherReport();
        outputFileWriter(weather);
        readInputCityNameFromFile();
        cityNameFromConsoleInput();
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


