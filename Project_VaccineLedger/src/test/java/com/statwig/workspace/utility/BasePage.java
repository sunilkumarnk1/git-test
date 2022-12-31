package com.statwig.workspace.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BasePage {

    protected static WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public enum All_Locators{
        ID, NAME, CLASSNAME, TAGNAME, LINKTEXT, PARTIALLINKTEXT, XPATH, CSS;
    }

    public WebElement findAnyElement(All_Locators locator_type, String locator_value){

        switch (locator_type){
            case ID:
                return this.driver.findElement(By.id(locator_value));
            case NAME:
                return this.driver.findElement(By.name(locator_value));
            case CLASSNAME:
                return this.driver.findElement(By.className(locator_value));
            case TAGNAME:
                return this.driver.findElement(By.tagName(locator_value));
            case LINKTEXT:
                return this.driver.findElement(By.linkText(locator_value));
            case PARTIALLINKTEXT:
                return this.driver.findElement(By.partialLinkText(locator_value));
            case XPATH:
                return this.driver.findElement(By.xpath(locator_value));
            case CSS:
                return this.driver.findElement(By.cssSelector(locator_value));
        }
        return null;
    }

    public List<WebElement> findAllElements(All_Locators locator_type, String locator_value){

        switch (locator_type){
            case ID:
                return this.driver.findElements(By.id(locator_value));
            case NAME:
                return this.driver.findElements(By.name(locator_value));
            case CLASSNAME:
                return this.driver.findElements(By.className(locator_value));
            case TAGNAME:
                return this.driver.findElements(By.tagName(locator_value));
            case LINKTEXT:
                return this.driver.findElements(By.linkText(locator_value));
            case PARTIALLINKTEXT:
                return this.driver.findElements(By.partialLinkText(locator_value));
            case XPATH:
                return this.driver.findElements(By.xpath(locator_value));
            case CSS:
                return this.driver.findElements(By.cssSelector(locator_value));
        }
        return null;
    }

    public void selectDropDown(WebElement dropdDown_element, String selectType, String value){
        if(selectType.equalsIgnoreCase("index")){
            Select s=new Select(dropdDown_element);
            s.selectByIndex(Integer.valueOf(value));
        }else if(selectType.equalsIgnoreCase("text")){
            Select s=new Select(dropdDown_element);
            s.selectByVisibleText(value);
        }else if(selectType.equalsIgnoreCase("value")){
            Select s=new Select(dropdDown_element);
            s.selectByValue(value);
        }
    }

    public WebElement waitAndFindElement(WebElement element,int waittime){
        return new WebDriverWait(this.driver, Duration.ofMillis(waittime)).pollingEvery(Duration.ofMillis(VaccineLedgerConstants.SHORT_WAIT))
                .ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(element));

    }

    enum ScreenshotType{
        FULLSCREEN, VISIBLESCREEN, ELEMENT;
    }

    public void waitAndSwitchToFrame(String frameName, int waittime){
        new WebDriverWait(this.driver,Duration.ofMillis(waittime)).pollingEvery(Duration.ofMillis(VaccineLedgerConstants.SHORT_WAIT))
                .ignoring(NoSuchElementException.class).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
    }

    public void takingScreenShotAndSave(ScreenshotType screenshotType){

        String date= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss")).toString();
        File dest=new File(".\\src\\test\\resources\\screenshots\\"+date+".png");

        switch (screenshotType){
            case FULLSCREEN:
                Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
                        .takeScreenshot((WebDriver) this.driver);
                try{
                    ImageIO.write(screenshot.getImage(),"jpg",dest);
                }catch(IOException e){
                    e.printStackTrace();
                }
                break;
            case VISIBLESCREEN:
                File src=((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
                try{
                    FileUtils.copyFile(src,dest);
                }catch(IOException e){
                    e.printStackTrace();
                }
        }
    }
    public static void takingScreenShotAndSave(SearchContext driver_or_element){
        String date= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss")).toString();
        File dest=new File(".\\src\\test\\resources\\screenshots\\"+date+".png");
        File src=((TakesScreenshot) driver_or_element).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(src,dest);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void scrollFullUp(){
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.HOME).build().perform();
    }
}
