package model;

import org.junit.Test;

import static model.Files.readInputCityNameFromFile;

public class FilesTests {

    @Test
    public void testFileReaderForCityName(){
        try {
            String expectedRequestCity = "Tallinn";
            String resultCity = readInputCityNameFromFile();
            assert expectedRequestCity.equals(resultCity);
        } catch (Exception e){
            System.out.println("Test failed because: " + e.getMessage());
        }
    }
}
