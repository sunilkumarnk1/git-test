package com.statwig.workspace.testrunner;

import com.statwig.workspace.pageobjects.HomePage;
import com.statwig.workspace.pageobjects.ShipmentPage;
import com.statwig.workspace.utility.BaseTest;
import com.statwig.workspace.utility.CommonUtility;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.awt.*;

public class ShipmentTestRunner extends BaseTest {

    @Test(priority = 1,groups = {"regression"})
    public void verifyCreateShipment_CA_Test_001() throws InterruptedException, AWTException {
//        HomePage homePage = PageFactory.initElements(super.driver, HomePage.class);
//        languageTranslateHome();
//
//        String emailId = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.loginmail");
//        homePage.enterEmailId(emailId);
//        Reporter.log(emailId + " is Entered");
//
//        homePage.clickSigninButton();
//        Reporter.log("Clicked on Continue Button");
//
//        String otp = CommonUtility.getPropertyValue("homepage", "homepage.otp");
//        homePage.enterOtp(otp);
//        Reporter.log("Otp is Entered");
//
//        homePage.clickVerifyButton();
//        Reporter.log("Clicked on Verify Button");
//
//        ShipmentPage sp = PageFactory.initElements(super.driver, ShipmentPage.class);
//        sp.clickOnShipmentPage();
//        sp.clickCreateShipment();
//        sp.clickSelectOrganizationLocation();
//        String org_location = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.orglocation");
//        sp.selectOrganizationLocation(org_location);
//
//        sp.clickToOrgType();
//        String toOrg_Type = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.toOrgType");
//        sp.selectToOrgType(toOrg_Type);
//
//        sp.clickToOrgName();
//        String toOrgName = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.toOrgName");
//        sp.selectOrgName(toOrgName);
//
//        sp.clickOnDeliveryLocation();
//        String deliveryLocation = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.deliverylocation");
//        sp.selectDeliveryLocation(deliveryLocation);
//
//        String transitNumber = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.transitnumber");
//        sp.enterTransitNumber(transitNumber);
//
//        String labelCode = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.labelcode");
//        sp.enterLabelCode(labelCode);
//
//        sp.clickOnShipmentDate();
//        String shipmentYear = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.shipmentyear");
//        String shipmentMonth = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.shipmentmonth");
//        String shipmentDate = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.shipmentdate");
//        sp.enterShipmentDate(shipmentYear, shipmentMonth, shipmentDate);
//
//        sp.clickOnDeliveryDate();
//        String deliveryYear = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.deliveryyear");
//        String deliveryMonth = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.deliverymonth");
//        String deliveryDate = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.deliverydate");
//        sp.enterdeliveryDate(deliveryYear, deliveryMonth, deliveryDate);
//
//        sp.clickOnProductCategory();
//        String productCategory = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.productcategory");
//        sp.selectProductCategory(productCategory);
//
//        sp.clickOnProductName();
//        String productName = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.productname");
//        sp.selectProductName(productName);
//
//        sp.clickOnFetchButton();
//        String quantity = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.batchquantity");
//        sp.enterQuantityFromBatchWithOutOrder(quantity);
//        sp.clickOnNextButton();
//		sp.clickOnCreateShipment();
        System.out.println("VerifyCreateShipment_CA_Test_001");

    }

    @Test(priority = 3,groups = {"regression"})
    public void verifyCreateShipmentWithOrderFullQuantity_Test_002() throws InterruptedException, AWTException {
//        HomePage homePage = PageFactory.initElements(super.driver, HomePage.class);
//        languageTranslateHome();
//        Reporter.log("clicked on login button");
//
//        String emailId = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.loginmaildistributor");
//        homePage.enterEmailId(emailId);
//        Reporter.log(emailId + " is Entered");
//
//        homePage.clickSigninButton();
//        Reporter.log("Clicked on Continue Button");
//
//        String otp = CommonUtility.getPropertyValue("homepage", "homepage.otp");
//        homePage.enterOtp(otp);
//        Reporter.log("Otp is Entered");
//
//        homePage.clickVerifyButton();
//        Reporter.log("Clicked on Verify Button");
//
//        ShipmentPage sp = PageFactory.initElements(super.driver, ShipmentPage.class);
//        sp.clickOnShipmentPage();
//        sp.clickCreateShipment();
//
//        sp.clickOnOrderId();
//        sp.orderIDSelection();
//
//        sp.clickSelectOrganizationLocation();
//        String org_location = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.orglocationdistributor");
//        sp.selectOrganizationLocation(org_location);
//        sp.clickOnShipmentDate();
//        sp.enterDate();
//        sp.clickOnFetchButton();
//        sp.enterBatchQty();
//        sp.clickOnNextButton();
//		sp.clickOnCreateShipment();
        System.out.println("verifyCreateShipmentWithOrderFullQuantity_Test_002");
    }

    @Test
    public void verifyCreateShipmentWithOrderPartial_Test_003() throws InterruptedException, AWTException {
        //for partial quantity
        HomePage homePage = PageFactory.initElements(super.driver, HomePage.class);
        //homePage.login();
        Reporter.log("clicked on login button");

        String emailId = CommonUtility.getPropertyValue("homepage", "homepage.emailid");
        homePage.enterEmailId(emailId);
        Reporter.log(emailId + " is Entered");

//		homePage.clickContinueButton();
        homePage.clickSigninButton();
        Reporter.log("Clicked on Continue Button");

        String otp = CommonUtility.getPropertyValue("homepage", "homepage.otp");
        homePage.enterOtp(otp);
        Reporter.log("Otp is Entered");

        homePage.clickVerifyButton();
        Reporter.log("Clicked on Verify Button");

        ShipmentPage sp = PageFactory.initElements(super.driver, ShipmentPage.class);
        sp.clickOnShipmentPage();
        sp.clickCreateShipment();

        String order_id = CommonUtility.getPropertyValue("shipmentpartial", "shipmentpartial.partialorderid");
        sp.clickOnOrderId();
        sp.enterOrderId(order_id);
        sp.clickSelectOrganizationLocation();
        String org_location = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.orglocation");
        sp.selectOrganizationLocation(org_location);

        String transitNumber = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.transitnumber");
        sp.enterTransitNumber(transitNumber);

        String labelCode = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.labelcode");
        sp.enterLabelCode(labelCode);

        sp.clickOnShipmentDate();
        String shipmentYear = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.shipmentyear");
        String shipmentMonth = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.shipmentmonth");
        String shipmentDate = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.shipmentdate");
        sp.enterShipmentDate(shipmentYear, shipmentMonth, shipmentDate);

        sp.clickOnDeliveryDate();
        String deliveryYear = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.deliveryyear");
        String deliveryMonth = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.deliverymonth");
        String deliveryDate = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.deliverydate");
        sp.enterdeliveryDate(deliveryYear, deliveryMonth, deliveryDate);

        sp.clickOnFetchButton();
        String partialQuantity = CommonUtility.getPropertyValue("shipmentpartial", "shipmentpartial.batchquantity");
        sp.partialQuantityOrderFromBatch(partialQuantity);
        sp.clickOnNextButton();
        sp.clickOnCreateShipment();
    }

    @Test
    public void createShipmentReferenceShipment_Test_004() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(super.driver, HomePage.class);

        String emailId = CommonUtility.getPropertyValue("homepage", "homepage.emailid");
        homePage.enterEmailId(emailId);
        Reporter.log(emailId + " is Entered");

//		homePage.clickContinueButton();
        homePage.clickSigninButton();
        Reporter.log("Clicked on Continue Button");

        String otp = CommonUtility.getPropertyValue("homepage", "homepage.otp");
        homePage.enterOtp(otp);
        Reporter.log("Otp is Entered");

        homePage.clickVerifyButton();
        Reporter.log("Clicked on Verify Button");

        ShipmentPage sp = PageFactory.initElements(super.driver, ShipmentPage.class);
        sp.clickOnShipmentPage();
        sp.clickCreateShipment();

        String referenceId = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.refid");
        sp.enterReferenceShipmentId(referenceId);
        sp.clickReferenceFetchButton();

        sp.clickSelectOrganizationLocation();
        String org_location = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.orglocation");
        sp.selectOrganizationLocation(org_location);

        sp.clickToOrgType();
        String toOrg_Type = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.toOrgType");
        sp.selectToOrgType(toOrg_Type);

        sp.clickToOrgName();
        String refToOrg = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.reftoOrgName");
        sp.selectRefToOrgName(refToOrg);

        sp.clickOnDeliveryLocation();
        String refDeliveryLocation = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.refdeliverylocation");
        sp.selectDeliveryLocation(refDeliveryLocation);

        String transitNumber = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.transitnumber");
        sp.enterTransitNumber(transitNumber);

        String labelCode = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.labelcode");
        sp.enterLabelCode(labelCode);

        sp.clickOnShipmentDate();
        String shipmentYear = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.shipmentyear");
        String shipmentMonth = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.shipmentmonth");
        String shipmentDate = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.shipmentdate");
        sp.enterShipmentDate(shipmentYear, shipmentMonth, shipmentDate);

        sp.clickOnDeliveryDate();
        String deliveryYear = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.deliveryyear");
        String deliveryMonth = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.deliverymonth");
        String deliveryDate = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.deliverydate");
        sp.enterdeliveryDate(deliveryYear, deliveryMonth, deliveryDate);

        sp.clickOnCreateShipment();
    }

    @Test
    public void verifyUpdateShipmentToConsignee_Test_005() throws InterruptedException {
        //update shipments: SH101460, SH101459,SH101454,SH101449,SH101448
        HomePage homePage = PageFactory.initElements(super.driver, HomePage.class);
        //homePage.login();
        Reporter.log("clicked on login button");

        String emailId = CommonUtility.getPropertyValue("homepage", "homepage.emailid");
        homePage.enterEmailId(emailId);
        Reporter.log(emailId + " is Entered");

//		homePage.clickContinueButton();
        homePage.clickSigninButton();
        Reporter.log("Clicked on Continue Button");

        String otp = CommonUtility.getPropertyValue("homepage", "homepage.otp");
        homePage.enterOtp(otp);
        Reporter.log("Otp is Entered");

        homePage.clickVerifyButton();
        Reporter.log("Clicked on Verify Button");

        ShipmentPage sp = PageFactory.initElements(super.driver, ShipmentPage.class);
        sp.clickOnShipmentPage();
        sp.clickUpdateShipmentButton();

        String update_shipmentId = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.updateshipmentid");
        sp.enterUpdateShipmentId(update_shipmentId);
        sp.clickUpdateButton();

        String update_location = CommonUtility.getPropertyValue("shipmentpage", "shipmentpage.updatelocation");
        sp.enterUpdateLocation(update_location);
        sp.clickUpdateStatusButton();
    }

    @Test(priority = 2,groups = {"regression"})
    public void verifyReceiveShipment_D_Test_006() throws InterruptedException {

//        HomePage homePage = PageFactory.initElements(super.driver, HomePage.class);
//        languageTranslateHome();
//
//        String emailId = CommonUtility.getPropertyValue("receiveshipment", "receiveshipment.loginDistributor");
//        homePage.enterEmailId(emailId);
//        Reporter.log(emailId + " is Entered");
//
//        homePage.clickSigninButton();
//        Reporter.log("Clicked on Continue Button");
//
//        String otp = CommonUtility.getPropertyValue("homepage", "homepage.otp");
//        homePage.enterOtp(otp);
//        Reporter.log("Otp is Entered");
//
//        homePage.clickVerifyButton();
//        Reporter.log("Clicked on Verify Button");
//
//        ShipmentPage sp = PageFactory.initElements(super.driver, ShipmentPage.class);
//        sp.clickOnShipmentPage();
//        sp.viewElementDirectClick();
//        sp.receiveShipmentButton();
//        sp.enterQtyDirect();
//        sp.clickOnSaveReceive();
        System.out.println("verifyReceiveShipment_D_Test_006");
    }

    @Test(priority = 4,groups = {"regression"})
    public void verifyReceiveShipmentPharmacy_Test_006() throws InterruptedException {

//        HomePage homePage = PageFactory.initElements(super.driver, HomePage.class);
//        languageTranslateHome();
//
//        String emailId = CommonUtility.getPropertyValue("receiveshipment", "receiveshipment.loginpharmacy");
//        homePage.enterEmailId(emailId);
//        Reporter.log(emailId + " is Entered");
//
//        homePage.clickSigninButton();
//        Reporter.log("Clicked on Continue Button");
//
//        String otp = CommonUtility.getPropertyValue("homepage", "homepage.otp");
//        homePage.enterOtp(otp);
//        Reporter.log("Otp is Entered");
//
//        homePage.clickVerifyButton();
//        Reporter.log("Clicked on Verify Button");
//
//        ShipmentPage sp = PageFactory.initElements(super.driver, ShipmentPage.class);
//        sp.clickOnShipmentPage();
//        sp.viewElementDirectClick();
//        sp.receiveShipmentButton();
//        sp.enterQtyDirect();
//        sp.clickOnSaveReceive();
        System.out.println("VerifyReceiveShipmentPharmacy_Test_006");
    }
}
