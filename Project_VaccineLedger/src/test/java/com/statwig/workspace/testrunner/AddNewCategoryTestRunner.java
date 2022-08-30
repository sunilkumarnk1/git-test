package com.statwig.workspace.testrunner;

import com.statwig.workspace.pageobjects.HomePage;
import com.statwig.workspace.pageobjects.InventoryPage;
import com.statwig.workspace.utility.BaseTest;
import com.statwig.workspace.utility.CommonUtility;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddNewCategoryTestRunner extends BaseTest {

    @Test
    public void verifyAddCategory_Test_002() throws InterruptedException {
        HomePage homePage= PageFactory.initElements(super.driver,HomePage.class);
        homePage.login();
        Reporter.log("clicked on login button");

        String emailId= CommonUtility.getPropertyValue("homepage","homepage.emailid");
        homePage.enterEmailId(emailId);
        Reporter.log(emailId+" is Entered");

        homePage.clickContinueButton();
        Reporter.log("Clicked on Continue Button");

        String otp=CommonUtility.getPropertyValue("homepage","homepage.otp");
        homePage.enterOtp(otp);
        Reporter.log("Otp is Entered");

        homePage.clickVerifyButton();
        Reporter.log("Clicked on Verify Button");

        InventoryPage ip=PageFactory.initElements(super.driver,InventoryPage.class);
        ip.clickOnInventory();
        Reporter.log("Clicked on Inventory");

        ip.clickViewAll();
        Reporter.log("Clicked on View All");

        ip.clickOnAddNewCategory();
        Reporter.log("Clicked on Add New Category");

        String input_categoryName=CommonUtility.getPropertyValue("addnewcategory","addnewcategory.name");
        ip.enterCategoryName(input_categoryName);
        Reporter.log(input_categoryName+" is Entered");

        String input_categoryDescription=CommonUtility.getPropertyValue("addnewcategory","addnewcategory.description");
        ip.enterDescriptionForCategory(input_categoryDescription);
        Reporter.log(input_categoryDescription+" is Entered");

        ip.clickOnAddNewCategory();
        Reporter.log("Clicked on Add New Category");
    }
}
