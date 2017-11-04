package model;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Files {

    public static String readInputCityNameFromFile() {
        File file = new File("C:\\Users\\Kersti\\Documents\\GitHub\\elutahenemine\\Failid");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuffer fileContents = new StringBuffer();
            String line = br.readLine();
            fileContents.append(line);
            line = br.readLine();
            br.close();
            String cityName = fileContents.toString();
            return cityName;
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
