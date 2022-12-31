package com.statwig.workspace.testrunner;

import com.statwig.workspace.pageobjects.HomePage;
import com.statwig.workspace.pageobjects.InventoryPage;
import com.statwig.workspace.utility.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddNewInventoryTestRunner extends BaseTest {

    WebDriver driver = null;
    String browserName = null;

    @Test(priority = 1,groups = {"regression"})
    public void verifyAddInventoryAtCA_Test_001() throws InterruptedException {
        HomePage homePage=PageFactory.initElements(super.driver,HomePage.class);
        languageTranslateHome();
        Reporter.log("clicked on login button");

        String emailId=CommonUtility.getPropertyValue("inventorypage","inventorypage.loginmail");
        homePage.enterEmailId(emailId);
        Reporter.log(emailId+" is Entered");

        //homePage.clickContinueButton();
        homePage.clickSigninButton();
        Reporter.log("Clicked on Continue Button");

        String otp=CommonUtility.getPropertyValue("homepage","homepage.otp");
        homePage.enterOtp(otp);
        Reporter.log("Otp is Entered");

        homePage.clickVerifyButton();
        Reporter.log("Clicked on Verify Button");

        InventoryPage ip=PageFactory.initElements(super.driver,InventoryPage.class);
        ip.clickOnInventory();
        Reporter.log("Clicked on Inventory");

        ip.clickAddInventory();
        Reporter.log("Clicked on Add Inventory");

        ip.clickSelectProductCategory();
        Reporter.log("Clicked on Select Product Category");

        String productCategoryName=CommonUtility.getPropertyValue("inventorypage","inventorypage.productcategory");
        ip.sendTextIntoSelectProductCategory(productCategoryName);
        Reporter.log(productCategoryName+" is Selected");

        ip.clickSelectProductName();
        Reporter.log("Clicked on Product Name");

        String product_Name=CommonUtility.getPropertyValue("inventorypage","inventorypage.productname");
        ip.selectProductName(product_Name);
        Reporter.log(product_Name+" is Selected");

        String batch_Number=CommonUtility.getPropertyValue("inventorypage","inventorypage.batchnumber");
        ip.enterBatchNumber(batch_Number);
        Reporter.log(batch_Number+" is Entered");

        String number_of_quantity=CommonUtility.getPropertyValue("inventorypage","inventorypage.quantity");
        ip.enterQuantity(number_of_quantity);
        Reporter.log(number_of_quantity+" is Entered");

        ip.clickOnAddDetails();
        Reporter.log("Clicked on Add Details");

        ip.clickOnManufactureDate();
        Reporter.log("Clicked on Manufacturer Date");

        String input_manufacturedate=CommonUtility.getPropertyValue("inventorypage","inventorypage.manufacturedate");
        ip.entermfgdate(input_manufacturedate);
        Reporter.log(input_manufacturedate+" is Selected");

        ip.clickExpireDate();
        Reporter.log("Clicked on Expire Date");

        String input_expiredate=CommonUtility.getPropertyValue("inventorypage","inventorypage.expireyear");
        String input_expireday=CommonUtility.getPropertyValue("inventorypage","inventorypage.expiredate");
        ip.selectExpireYearDate(input_expiredate, input_expireday);
        Reporter.log(input_expiredate+"" +input_expireday+"is Selected");

        String serialNumberValue=CommonUtility.getPropertyValue("inventorypage","inventorypage.serialnumber");
        ip.enterSerialNumber(serialNumberValue);
        Reporter.log(serialNumberValue+" is Entered");

        ip.clickReviewProduct();
        Reporter.log("Clicked on Review Product");

        ip.clickSaveButton();
        Reporter.log("Clicked on Save button");

        ip.clickOkButton();
        Reporter.log("Clicked on OK button");
//        System.out.println("verifyAddInventoryAtCA_001");
    }
}
