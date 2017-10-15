import org.json.JSONObject;
import sun.applet.Main;
import weatherRepo.WeatherRepo;

public class Runner {

    public static void JSONWeatherReport(){
        JSONObject report;
        WeatherRepo.setUnits("metric");
        WeatherRepo.setApiKey("1d8d2592a2ae91ebd738f45541285340");
        WeatherRepo.setApiCallUrl("http://api.openweathermap.org/data/2.5/weather?q=");
        report = WeatherRepo.getCityWeatherInformationJSON("Tallinn");
        System.out.println(report);
    }

    public static void main(String[] args){
        JSONWeatherReport();
    }
}


