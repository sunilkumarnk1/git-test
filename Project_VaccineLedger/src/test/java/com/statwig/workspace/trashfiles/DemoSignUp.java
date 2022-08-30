package com.statwig.workspace.trashfiles;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoSignUp {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\all_executables\\chromedriver.exe");
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
        driver.findElement(By.xpath("//span[text()='Inventory']")).click();
        driver.findElement(By.xpath("//b[text()='Add Inventory']")).click();

        Thread.sleep(5000);

        driver.findElement(By.className("select-placeholder-text-prod-category")).click();
        FluentWait<WebDriver> wait=new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(120));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class);
        WebElement createAcc=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=' css-yt9ioa-option']")));
        List<WebElement> list=driver.findElements(By.xpath("//div[@class=' css-yt9ioa-option']"));
        System.out.println("size of the list is:"+list.size());

        for(WebElement eachElement : list){
            String text=eachElement.getText();
            if(text.equalsIgnoreCase("Equipment")){
                eachElement.click();
                break;
            }
        }
    }

}
