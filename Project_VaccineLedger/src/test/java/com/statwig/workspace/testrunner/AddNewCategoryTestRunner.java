package com.statwig.workspace.testrunner;

import java.awt.AWTException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.statwig.workspace.pageobjects.HomePage;
import com.statwig.workspace.pageobjects.InventoryPage;
import com.statwig.workspace.pageobjects.ProductList;
import com.statwig.workspace.utility.BaseTest;
import com.statwig.workspace.utility.CommonUtility;

public class AddNewCategoryTestRunner extends BaseTest {

    @Test
    public void verifyAddCategory_Test_002() throws InterruptedException, AWTException {
        HomePage homePage= PageFactory.initElements(super.driver,HomePage.class);
        languageTranslateHome();
        Reporter.log("clicked on login button");

        String emailId= CommonUtility.getPropertyValue("addnewcategory","addnewcategory.loginmail");
        homePage.enterEmailId(emailId);
        Reporter.log(emailId+" is Entered");

        homePage.clickSigninButton();
        Reporter.log("Clicked on Continue Button");

        String otp=CommonUtility.getPropertyValue("homepage","homepage.otp");
        homePage.enterOtp(otp);
        Reporter.log("Otp is Entered");

        homePage.clickVerifyButton();
        Reporter.log("Clicked on Verify Button");

       ProductList pl=PageFactory.initElements(super.driver, ProductList.class);
       pl.clickUser();
       pl.switchToAdmin();
       pl.clickProductList();
       pl.clickProductCategory();
       
       String productCategoryName=CommonUtility.getPropertyValue("addnewcategory","addnewcategory.productcategory");
       pl.selectProductCategory(productCategoryName);
    }
}
