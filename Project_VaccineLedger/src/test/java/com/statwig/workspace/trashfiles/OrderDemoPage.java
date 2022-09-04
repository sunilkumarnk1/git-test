package com.statwig.workspace.trashfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class OrderDemoPage {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\all_executables\\chromedriver_1.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://test.vaccineledger.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("sunilkumarnk.1996@gmail.com");
        driver.findElement(By.xpath("//button[text()='CONTINUE']")).click();

        driver.findElement(By.cssSelector("#otp0")).sendKeys("1");
        driver.findElement(By.cssSelector("#otp1")).sendKeys("2");
        driver.findElement(By.cssSelector("#otp2")).sendKeys("3");
        driver.findElement(By.cssSelector("#otp3")).sendKeys("4");

        driver.findElement(By.xpath("//button[text()='VERIFY']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text()='Orders']")).click();
        driver.findElement(By.xpath("//a[@class='text-none']//div[1]")).click();

        driver.findElement(By.xpath("//div[@class=' css-1s2u09g-control']/div/div/div")).click();
       // WebElement org_name=driver.findElement(By.xpath("//div[@id='react-select-5-placeholder']"));
//        Actions action=new Actions(driver);
//        action.moveToElement(org_name);
//        action.click(org_name).build().perform();
    }
}
