package com.statwig.workspace.trashfiles;

import com.statwig.workspace.pageobjects.ShipmentPage;
import com.statwig.workspace.utility.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class ShipmentDemoPage {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\all_executables\\chromedriver_1.exe");
        WebDriver driver = new ChromeDriver();
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
        //click on shipment page
        driver.findElement(By.xpath("//span[text()='Shipments']")).click();

        //click on create shipment
        driver.findElement(By.xpath("//b[text()='Create Shipment']")).click();

        //click on order id
        driver.findElement(By.xpath("(//div[contains(@class,'css-ackcql')])[1]")).click();

        //enter order id
        driver.findElement(By.xpath("//div[text()='PO101213']")).click();
        //fetch
        driver.findElement(By.xpath("//div[text()='Fetch']")).click();
        //org location
        driver.findElement(By.xpath("(//div[contains(@class,'css-ackcql')])[2]")).click();
        //select org location
        driver.findElement(By.xpath("(//div[contains(@class,'css-ackcql')])[2]")).click();


        List<WebElement> allQuantityBatches = driver.findElements(By.xpath("//input[@class='form-control text-center input1']"));
        List<WebElement> allCheckBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 0; i < allQuantityBatches.size(); i++) {
            String names = allQuantityBatches.get(i).getText();
            System.out.println(names);
        }
    }
}
