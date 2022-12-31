package com.statwig.workspace.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserFactory {

    private static WebDriver driver;

    public static WebDriver openLocalBrowser(String bname){
        if(bname.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","src\\test\\resources\\all_executables\\chromedriver1.exe");
            return driver=new ChromeDriver();
        }else if(bname.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","src\\test\\resources\\all_executables\\geckodriver.exe");
            return driver=new FirefoxDriver();
        }else if(bname.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver","src\\test\\resources\\all_executables\\msedgedriver.exe");
            return driver=new EdgeDriver();
        }
        return driver;
    }

    public static void launchApplication(String url){
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
    }

    public static void closeBrowser(){
        driver.close();
    }

    public static void endDriverTaskManager(){
        driver.quit();
    }

}
