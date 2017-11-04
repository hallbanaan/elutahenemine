package model;

import org.junit.Test;

import static model.Files.readInputCityNameFromFile;

public class FilesTests {

    @Test
    public void testFileReaderForCityName(){
        try {
            String expectedRequestCity = "Tallinn";
            String resultCity = readInputCityNameFromFile();
            if(expectedRequestCity != resultCity) throw new AssertionError();
        } catch (Exception e){
            System.out.println("Test failed because: " + e.getMessage());
        }
    }
}
