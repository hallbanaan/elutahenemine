package model;

import org.json.JSONObject;

import java.io.*;

public class Files {

    public static String readInputCityNameFromFile() {
        File file = new File("C:\\Users\\Kersti\\Documents\\GitHub\\elutahenemine\\input.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuffer fileContents = new StringBuffer();
            String line = br.readLine();
            fileContents.append(line);
            br.close();
            String cityName = fileContents.toString();
            System.out.println(cityName);
            return cityName;
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
