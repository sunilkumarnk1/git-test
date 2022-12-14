package com.statwig.workspace.pageobjects;

import com.statwig.workspace.utility.BasePage;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getHomePageTitle(){
        return super.driver.getTitle();
    }

   public SignUpPage clickSignUpButton(){
       WebElement signUpButton=HomePage.super.findAnyElement(All_Locators.XPATH,"//a[text()='Signup']");
       signUpButton.click();
       return new SignUpPage(super.driver);
   }

   public void login(){
        WebElement login_ele=HomePage.super.findAnyElement(All_Locators.XPATH,"//a[text()='Login']");
        login_ele.click();
   }

   public void enterEmailId(String email){
        WebElement email_ele=HomePage.super.findAnyElement(All_Locators.XPATH,"//input[@name='email']");
        email_ele.sendKeys(email);
   }

   public void clickContinueButton(){
        WebElement continue_ele=HomePage.super.findAnyElement(All_Locators.XPATH,"//button[text()='CONTINUE']");
        continue_ele.click();
   }

   public void enterOtp(String otpNumber){
        WebElement otp_ele=HomePage.super.findAnyElement(All_Locators.XPATH,"//input[@maxlength='1'][1]");
       otp_ele.sendKeys(otpNumber);
   }

   public void clickVerifyButton() throws InterruptedException {
        WebElement verify_ele=HomePage.super.findAnyElement(All_Locators.XPATH,"//button[text()='VERIFY']");
        verify_ele.click();
        Thread.sleep(5000);
   }

   public void clickOnSearch() throws InterruptedException {
        WebElement search=HomePage.super.findAnyElement(All_Locators.XPATH,"//input[@type='text']");
        search.click();
        Thread.sleep(2000);
       //input[@id='controlled-demo']
        //implicit or explicit
   }

   public void enterProductName(String productName) throws InterruptedException {
        WebElement productName_ele=HomePage.super.findAnyElement(All_Locators.XPATH,"//input[@type='text']");
        productName_ele.sendKeys(productName);
   }

    public void actionClass() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        Actions keyboard_actions=new Actions(driver);
        keyboard_actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        keyboard_actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
    }
   public void scrollPage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
       JavascriptExecutor js=(JavascriptExecutor)driver;
       js.executeScript("window.scrollBy(0,350)","");
       Thread.sleep(10000);
   }

    public void enterOrderId(String orderId) throws InterruptedException {
        WebElement productName_ele=HomePage.super.findAnyElement(All_Locators.XPATH,"//input[@id='controlled-demo']");
        productName_ele.sendKeys(orderId);
    }

    public void enterShipmentId(String shipmentId){
        WebElement productName_ele=HomePage.super.findAnyElement(All_Locators.XPATH,"//input[@type='text']");
        productName_ele.sendKeys(shipmentId);
    }

    public void enterTransitNumber(String transitNumber){
        WebElement productName_ele=HomePage.super.findAnyElement(All_Locators.XPATH,"//input[@type='text']");
        productName_ele.sendKeys(transitNumber);
    }

    public void enterProductCategory(String productCategory){
        WebElement productName_ele=HomePage.super.findAnyElement(All_Locators.XPATH,"//input[@type='text']");
        productName_ele.sendKeys(productCategory);
    }

    public void statusPage(){
        FluentWait<WebDriver> wait=new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(120));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class);
        WebElement ele_org_name=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='ml-3 p-2 status rounded text-white secondary-bg bg-info']")));
        WebElement getStatus=HomePage.super.findAnyElement(All_Locators.XPATH,"//span[@class='ml-3 p-2 status rounded text-white secondary-bg bg-info']");
        String statusResult=getStatus.getText();
        System.out.println("The status of order is "+statusResult);
    }
}

