package com.statwig.workspace.testrunner;

import com.statwig.workspace.pageobjects.HomePage;
import com.statwig.workspace.pageobjects.OrderPage;
import com.statwig.workspace.utility.BaseTest;
import com.statwig.workspace.utility.CommonUtility;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.awt.*;

public class OrderTestRunner extends BaseTest {

    @Test(priority = 1,groups={"regression"})
    public void verifyCreateOrderPharmacy_Test_001() throws InterruptedException {
        HomePage homePage= PageFactory.initElements(super.driver,HomePage.class);
        languageTranslateHome();
        Reporter.log("clicked on login button");

        String emailId= CommonUtility.getPropertyValue("orderpage","orderpage.loginmail");
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

        OrderPage op=PageFactory.initElements(super.driver,OrderPage.class);
        op.clickOnOrders();
        op.clickOnCreateNewOrder();
        op.clickSelectProductCategory();

        String productCategoryName=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.productcategory");
        op.sendTextIntoSelectProductCategory(productCategoryName);
        Reporter.log(productCategoryName+" is Selected");

        op.clickSelectProductName();

        String product_Name=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.productname");
        op.selectProductName(product_Name);
        Reporter.log(product_Name+" is Selected");

        String enter_quantity=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.batchquantity");
        op.enterQuantity(enter_quantity);
        Reporter.log(enter_quantity+" is entered");

        op.clickSelectOrganizationType();

        String organization_type=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.toOrgType");
        op.selectOrganizationType(organization_type);
        Reporter.log(organization_type+" is selected");

        op.clickOnOrganizationName();
        String organization_name=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.toOrgName");
        op.selectOrganizationName(organization_name);
        Reporter.log(organization_name+" is selected");

        op.clickToOrganizationType();

        String toOrgType=CommonUtility.getPropertyValue("orderpage","orderpage.toorganizationtype");
        op.selectToOrganizationType(toOrgType);

        op.clickToOrgName();
        String selectToOrgName=CommonUtility.getPropertyValue("orderpage","orderpage.toorganizationname");
        op.selectToOrgName(selectToOrgName);

        op.clickDeliveryLocation();

       String delivery_location=CommonUtility.getPropertyValue("orderpage","orderpage.todeliverylocation");
        op.selectDeliveryLocation(delivery_location);
        op.clickOnReviewOrder();
        op.clickOnCreateOrder();
//        System.out.println("VerifyCreateOrderPharmacy_Test_001");
    }

    @Test
    public void verifyCreateOrderByImport_Test_002() throws InterruptedException, AWTException {
        HomePage homePage= PageFactory.initElements(super.driver,HomePage.class);
       // homePage.login();
        Reporter.log("clicked on login button");

        String emailId= CommonUtility.getPropertyValue("homepage","homepage.emailid");
        homePage.enterEmailId(emailId);
        Reporter.log(emailId+" is Entered");

       // homePage.clickContinueButton();
        homePage.clickSigninButton();
        Reporter.log("Clicked on Continue Button");

        String otp=CommonUtility.getPropertyValue("homepage","homepage.otp");
        homePage.enterOtp(otp);
        Reporter.log("Otp is Entered");

        homePage.clickVerifyButton();
        Reporter.log("Clicked on Verify Button");

        OrderPage op=PageFactory.initElements(super.driver,OrderPage.class);
        op.clickOnOrders();
        op.clickOnImport();
        op.clickOnExcel();
        op.clickOnSelectAFile();
        op.clickOnFinalImport();
    }

    @Test
    public void verifyAcceptOrRejectOrder_Test_003() throws InterruptedException {
        HomePage homePage= PageFactory.initElements(super.driver,HomePage.class);
       // homePage.login();
        Reporter.log("clicked on login button");

        String emailId= CommonUtility.getPropertyValue("homepage","homepage.emailid");
        homePage.enterEmailId(emailId);
        Reporter.log(emailId+" is Entered");

       // homePage.clickContinueButton();
        homePage.clickSigninButton();
        Reporter.log("Clicked on Continue Button");

        String otp=CommonUtility.getPropertyValue("homepage","homepage.otp");
        homePage.enterOtp(otp);
        Reporter.log("Otp is Entered");

        homePage.clickVerifyButton();
        Reporter.log("Clicked on Verify Button");

        OrderPage op=PageFactory.initElements(super.driver,OrderPage.class);
        op.clickOnOrders();
        op.clickOnOrdersReceived();

        String selectOrderId=CommonUtility.getPropertyValue("orderpage","orderpage.orderIdAcceptReject");
        op.selectOrderToAcceptReject(selectOrderId);

        String selectAcceptOrReject=CommonUtility.getPropertyValue("orderpage","orderpage.accept");
        op.clickAcceptOrReject(selectAcceptOrReject);
    }

    @Test
    public void verifyCancelOrder_Test_004() throws InterruptedException {
        HomePage homePage= PageFactory.initElements(super.driver,HomePage.class);
       // homePage.login();
        Reporter.log("clicked on login button");

        String emailId= CommonUtility.getPropertyValue("homepage","homepage.emailid");
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

        OrderPage op=PageFactory.initElements(super.driver,OrderPage.class);
        op.clickOnOrders();

        String selectOrderIdCancel=CommonUtility.getPropertyValue("orderpage","orderpage.orderIdCancel");
        op.selectOrderToAcceptReject(selectOrderIdCancel);
        op.clickCancelButton();
    }

    @Test(priority = 2,groups = {"regression"})
    public void verifyAcceptOrder_D_Test_003() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(super.driver, HomePage.class);
        languageTranslateHome();

        String emailId = CommonUtility.getPropertyValue("receiveshipment", "receiveshipment.loginDistributor");
        homePage.enterEmailId(emailId);
        Reporter.log(emailId + " is Entered");

        homePage.clickSigninButton();
        Reporter.log("Clicked on Continue Button");

        String otp = CommonUtility.getPropertyValue("homepage", "homepage.otp");
        homePage.enterOtp(otp);
        Reporter.log("Otp is Entered");

        homePage.clickVerifyButton();
        Reporter.log("Clicked on Verify Button");

        OrderPage op=PageFactory.initElements(super.driver,OrderPage.class);
        op.clickOnOrders();
        op.clickOnOrdersReceived();
        op.clickOnFirstView();
        op.clickOnAccept();
//        System.out.println("VerifyAcceptOrder_D_Test_003");
    }
}
