package com.statwig.workspace.pageobjects;

import com.statwig.workspace.utility.BasePage;
import com.statwig.workspace.utility.BasePage.All_Locators;

import net.bytebuddy.implementation.bind.annotation.Super;

import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SignUpPage extends BasePage {
    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    
    public void clickSignUp() {
    	WebElement signupButton_ele=SignUpPage.super.findAnyElement(All_Locators.XPATH, "//button[text()='Sign Up']");
    	signupButton_ele.click();
    }

    public void enterFirstName(String firstName){
        WebElement fn_element=SignUpPage.super.findAnyElement(All_Locators.NAME,"firstName");
        fn_element.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        WebElement ln_element=SignUpPage.super.findAnyElement(All_Locators.NAME,"lastName");
        ln_element.sendKeys(lastName);
    }

    public void enterEmailId(String email){
        WebElement emailId=SignUpPage.super.findAnyElement(All_Locators.NAME,"email");
        emailId.sendKeys(email);
    }

    public void enterMobileNum(String mobileNum){
        WebElement mobileNumber_ele=SignUpPage.super.findAnyElement(All_Locators.NAME,"phone");
        mobileNumber_ele.sendKeys(mobileNum);
    }
    
    public void clickNewOrganizatioButton() {
    	WebElement newOrg_ele=SignUpPage.super.findAnyElement(All_Locators.XPATH, "//input[@value='new']");
    	newOrg_ele.click();
    }

    public void selectOrganizationType(String organizationType) throws InterruptedException {
        WebElement org_type=SignUpPage.super.findAnyElement(All_Locators.XPATH,"//label[text()='Organization Type']/following::input[1]");
        org_type.sendKeys(organizationType);

        Thread.sleep(2000);
        int count=0;
        List<WebElement> optionList=SignUpPage.super.findAllElements(All_Locators.XPATH,"//li[@role='option']");
        for(WebElement ele:optionList){
            organizationType=ele.getText();
            if(organizationType.contains(organizationType)){
                ele.click();
                count++;
                break;
            }
        }
        if(count!=0){
            System.out.println(organizationType+" has been selected in the DD");
        }
        else{
            System.out.println("options you want to select is not available in DD");
        }
        Thread.sleep(2000);
    }
    
    public void clickOrgType() {
    	WebElement orgName_ele=SignUpPage.super.findAnyElement(All_Locators.XPATH, "//label[text()='Organization Type']/following::input[1]");
    	orgName_ele.click();
    }
    
    public void clickOrgName() {
    	WebElement orgName_ele=SignUpPage.super.findAnyElement(All_Locators.XPATH, "//label[text()='Organization Name']/following::input");
    	orgName_ele.click();
    }

    public void selectOrganizationName(String org_name){
    	WebElement orgName_ele=SignUpPage.super.findAnyElement(All_Locators.XPATH,"//label[text()='Organization Name']/following::input" );
    	orgName_ele.sendKeys(org_name);
    	Actions actions=new Actions(driver);
    	 actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

    }
    
    public void clickContinueButton() {
		WebElement continue_ele = SignUpPage.super.findAnyElement(All_Locators.XPATH, "//button[text()='CONTINUE']");
		continue_ele.click();
	}
    
    public void selectState(String stateName) throws InterruptedException {
        Actions actions=new Actions(driver);
        SignUpPage.super.findAnyElement(All_Locators.XPATH,"//label[text()='State']/following::input[1]").sendKeys(stateName);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
    }
    
    public void selectCity(String cityName) throws InterruptedException {
        Actions actions=new Actions(driver);
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[text()='"+cityName+"']")));
        SignUpPage.super.findAnyElement(All_Locators.XPATH,"//label[text()='State']/following::input[2]").sendKeys(cityName);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
    }

    public void clickOnCity(){
        WebElement city_ele=SignUpPage.super.findAnyElement(All_Locators.XPATH,"//label[text()='City']");
        city_ele.click();
    }
    
    public void enterPinCode(String pincodeName) throws InterruptedException {
        WebElement pincode_ele=SignUpPage.super.findAnyElement(All_Locators.NAME,"pincode");
        pincode_ele.sendKeys(pincodeName);
    }
    
    public void enterAddress(String addressName) throws InterruptedException {
        WebElement address_ele=SignUpPage.super.findAnyElement(All_Locators.NAME,"address");
        address_ele.sendKeys(addressName);
    }
    
    public void clickRegister() throws InterruptedException {
    	WebElement register_ele=SignUpPage.super.findAnyElement(All_Locators.XPATH, "//button[text()='Register']");
    	register_ele.click();
    	Thread.sleep(2000);
    }
}

