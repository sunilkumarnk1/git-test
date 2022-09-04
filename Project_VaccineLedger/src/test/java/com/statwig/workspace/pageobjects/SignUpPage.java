package com.statwig.workspace.pageobjects;

import com.statwig.workspace.utility.BasePage;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SignUpPage extends BasePage {
    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
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
        WebElement emailId=SignUpPage.super.findAnyElement(All_Locators.XPATH,"//input[@type='email']");
        emailId.sendKeys(email);
    }

    public void enterMobileNum(String mobileNum){
        WebElement mobileNumber_ele=SignUpPage.super.findAnyElement(All_Locators.XPATH,"//input[@placeholder='Enter Phone number']");
        mobileNumber_ele.sendKeys(mobileNum);
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

    }

    public void selectOrganizationName(String org_name){
        WebElement organizationName_ele=SignUpPage.super.findAnyElement(All_Locators.XPATH,"//label[text()='Organization Name']/following::input[1]");
        organizationName_ele.sendKeys(org_name);
        int count=0;
        List<WebElement> allOptions=SignUpPage.super.findAllElements(All_Locators.XPATH,"//li[@role='option']");
        for(WebElement ele:allOptions){
            org_name=ele.getText();
            if(org_name.contains(org_name)){
                ele.click();
                count++;
                break;
            }
        }
        if(count!=0){
            System.out.println(org_name+" has been selected in the DD");
        }
        else{
            System.out.println("options you want to select is not available in DD");
        }
    }
}

