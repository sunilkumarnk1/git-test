package com.statwig.workspace.testrunner;

import com.statwig.workspace.pageobjects.HomePage;
import com.statwig.workspace.pageobjects.InventoryPage;
import com.statwig.workspace.utility.BaseTest;
import com.statwig.workspace.utility.CommonUtility;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddNewProductTestRunner extends BaseTest {

    @Test
    public void verifyAddNewProduct_Test_001() throws InterruptedException {
        HomePage homePage= PageFactory.initElements(super.driver,HomePage.class);
        //homePage.login();
        Reporter.log("clicked on login button");

        String emailId= CommonUtility.getPropertyValue("homepage","homepage.emailid");
        homePage.enterEmailId(emailId);
        Reporter.log(emailId+" is Entered");

        //homePage.clickContinueButton();
        homePage.clickSigninButton();
        Reporter.log("Clicked on Continue Button");

        String otp=CommonUtility.getPropertyValue("homepage","homepage.otp");
        homePage.enterOtp(otp);
        Reporter.log(otp+" is Entered");

        homePage.clickVerifyButton();
        Reporter.log("Clicked on Verify Button");

        InventoryPage ip=PageFactory.initElements(super.driver,InventoryPage.class);
        ip.clickOnInventory();
        Reporter.log("Clicked on Inventory Page");

        ip.clickViewAll();
        Reporter.log("Clicked on View All");

        ip.clickAddNewProduct();
        Reporter.log("Clicked on Add New Product");

        String input_productName=CommonUtility.getPropertyValue("addnewproduct","addnewproduct.productname");
        ip.enterProductName(input_productName);
        Reporter.log("Entered "+input_productName);

        ip.clickManufacturer();
        Reporter.log("Clicked on Manufacturer");

        String input_manufacturername=CommonUtility.getPropertyValue("addnewproduct","addnewproduct.manufacturer");
        ip.selectManufacturers(input_manufacturername);
        Reporter.log("Manufacturer "+input_manufacturername+" selected");

        ip.clickproductCategory();
        Reporter.log("Clicked on Product Category");

        String input_productcategory=CommonUtility.getPropertyValue("addnewproduct","addnewproduct.productcategory");
        ip.selectProductCategory(input_productcategory);
        Reporter.log(input_productcategory+" is selected");


        String unit_of_measure=CommonUtility.getPropertyValue("addnewproduct","addnewproduct.unitofmeasure");
        ip.enterUnitOfMeasure(unit_of_measure);
        Reporter.log(unit_of_measure+" is entered");

        String shortDescription=CommonUtility.getPropertyValue("addnewproduct","addnewproduct.shortdescription");
        ip.enterShortDescription(shortDescription);
        Reporter.log(shortDescription+" is entered");

        ip.clickAddNewProductButton();
        Reporter.log("Clicked on Add New Product button");
    }
}
