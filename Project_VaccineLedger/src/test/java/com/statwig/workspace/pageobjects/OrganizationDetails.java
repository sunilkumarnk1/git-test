package com.statwig.workspace.pageobjects;

import com.statwig.workspace.utility.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;
import java.util.List;

public class OrganizationDetails extends BasePage {
    public OrganizationDetails(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void enterOrganizationName(String organization_Name) throws InterruptedException {
        WebElement orgName=OrganizationDetails.super.findAnyElement(All_Locators.XPATH,"//label[text()='Organisation Name']/following::div[1]/input[1]");
        orgName.sendKeys(organization_Name);
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
    }

    public void selectRegion_1(String regionName) throws InterruptedException {
        Actions actions=new Actions(driver);
       OrganizationDetails.super.findAnyElement(All_Locators.XPATH,"//label[text()='Select Region']/following::input[1]").sendKeys(regionName);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
    }

    public void selectCountry(String countryName) throws InterruptedException {
        Actions actions=new Actions(driver);
        OrganizationDetails.super.findAnyElement(All_Locators.XPATH,"//label[text()='Select Region']/following::input[2]").sendKeys(countryName);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
    }

    public void selectState(String stateName) throws InterruptedException {
        Actions actions=new Actions(driver);
        OrganizationDetails.super.findAnyElement(All_Locators.XPATH,"//label[text()='Select Region']/following::input[3]").sendKeys(stateName);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);

    }

    public void selectCity(String cityName) throws InterruptedException {
        Actions actions=new Actions(driver);
        OrganizationDetails.super.findAnyElement(All_Locators.XPATH,"//label[text()='Select Region']/following::input[4]").sendKeys(cityName);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
    }

    public void enterAddress(String addressName) throws InterruptedException {
        WebElement address_ele=OrganizationDetails.super.findAnyElement(All_Locators.XPATH,"//label[text()='Select Region']/following::input[5]");
        address_ele.sendKeys(addressName);
        Thread.sleep(2000);
    }

    public void enterPinCode(String pincodeName) throws InterruptedException {
        WebElement pincode_ele=OrganizationDetails.super.findAnyElement(All_Locators.XPATH,"//label[text()='Select Region']/following::input[6]");
        pincode_ele.sendKeys(pincodeName);
        Thread.sleep(2000);
    }

    public void clickDoneButton() throws InterruptedException {
        WebElement done_button=OrganizationDetails.super.findAnyElement(All_Locators.XPATH,"//button[text()='Done']");
        done_button.click();
        Thread.sleep(2000);
    }
}
