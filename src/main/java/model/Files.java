package model;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class Files {

    private static String readInputCityNameFromFile() {
        File file = new File("C:\\Users\\Kersti\\Documents\\GitHub\\elutahenemine\\Failid\\input.txt");
        try {
            String cityName = FileUtils.readFileToString(file);
        } catch (IOException e){

        }
        return cityName;
    }
}
