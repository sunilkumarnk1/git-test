package com.statwig.workspace.testrunner;

import com.statwig.workspace.pageobjects.HomePage;
import com.statwig.workspace.utility.BaseTest;
import com.statwig.workspace.utility.CommonUtility;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SearchFromHomePageTestRunner extends BaseTest {

    @Test
    public void verifySearchByProductName_Test_001() throws InterruptedException {
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
        Reporter.log(otp+" is Entered");

        homePage.clickVerifyButton();
        Reporter.log("Clicked on Verify Button");

        homePage.clickOnSearch();
        String productName=CommonUtility.getPropertyValue("homepage","homepage.searchproduct");
        homePage.enterProductName(productName);
        homePage.actionClass();
    }

    @Test
    public void verifySearchByOrderId_Test_002() throws InterruptedException {
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
        Reporter.log(otp+" is Entered");

        homePage.clickVerifyButton();
        Reporter.log("Clicked on Verify Button");
        homePage.clickOnSearch();
        String orderId=CommonUtility.getPropertyValue("homepage","homepage.searchorder");
        homePage.enterOrderId(orderId);
        homePage.actionClass();
    }

    @Test
    public void verifySearchByShipmentId_Test_002() throws InterruptedException {
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
        Reporter.log(otp+" is Entered");

        homePage.clickVerifyButton();
        Reporter.log("Clicked on Verify Button");
        homePage.clickOnSearch();

        String shipmentId=CommonUtility.getPropertyValue("homepage","homepage.searchshipmentid");
        homePage.enterShipmentId(shipmentId);
        homePage.actionClass();
    }

    @Test
    public void verifySearchByTransitNumber_Test_003() throws InterruptedException {
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
        Reporter.log(otp+" is Entered");

        homePage.clickVerifyButton();
        Reporter.log("Clicked on Verify Button");
        homePage.clickOnSearch();

        String transitNumber=CommonUtility.getPropertyValue("homepage","homepage.searchtransitnumber");
        homePage.enterTransitNumber(transitNumber);
        homePage.actionClass();
    }

    @Test
    public void verifySearchByProductCategory_Test_004() throws InterruptedException {
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
        Reporter.log(otp+" is Entered");

        homePage.clickVerifyButton();
        Reporter.log("Clicked on Verify Button");
        homePage.clickOnSearch();

        String productCategory=CommonUtility.getPropertyValue("homepage","homepage.searchproductcategory");
        homePage.enterProductCategory(productCategory);
        homePage.actionClass();
    }

    @Test
    public void verifyOrderStatus_Test_005() throws InterruptedException {
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
        Reporter.log(otp+" is Entered");

        homePage.clickVerifyButton();
        Reporter.log("Clicked on Verify Button");
        homePage.clickOnSearch();
        String orderId=CommonUtility.getPropertyValue("homepage","homepage.searchorder");
        homePage.enterOrderId(orderId);
        homePage.actionClass();
        homePage.statusPage();
    }
}
