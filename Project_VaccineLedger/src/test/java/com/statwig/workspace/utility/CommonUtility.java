package com.statwig.workspace.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class CommonUtility {


    private static Properties p = new Properties();

    private CommonUtility(){
        try(FileInputStream fis = new FileInputStream("src/test/resources/testdata/config.properties")){
            p.load(fis);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private CommonUtility(String filenName){
        try(FileInputStream fis = new FileInputStream("src/test/resources/testdata/"+filenName+".properties")){
            p.load(fis);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static String getPropertyValue(String key){
        CommonUtility c = new CommonUtility();
        return p.getProperty(key);
    }

    public static String getPropertyValue(String fileName, String key){
        CommonUtility c = new CommonUtility(fileName);
        return p.getProperty(key);
    }

    public static String getCurrentDate(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy_hh-mm-ss"));
    }
}
