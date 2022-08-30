package com.statwig.workspace.testrunner;

import com.statwig.workspace.pageobjects.HomePage;
import com.statwig.workspace.pageobjects.ShipmentPage;
import com.statwig.workspace.utility.BasePage;
import com.statwig.workspace.utility.BaseTest;
import com.statwig.workspace.utility.CommonUtility;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ShipmentTestRunner extends BaseTest {

    @Test
    public void verifyCreateShipmentWithOutOrderId_Test_001() throws InterruptedException {
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

        ShipmentPage sp=PageFactory.initElements(super.driver,ShipmentPage.class);
        sp.clickOnShipmentPage();
        sp.clickCreateShipment();
        sp.clickSelectOrganizationLocation();
        String org_location=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.orglocation");
        sp.selectOrganizationLocation(org_location);

        sp.clickToOrgType();
        String toOrg_Type=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.toOrgType");
        sp.selectToOrgType(toOrg_Type);

        sp.clickToOrgName();
        String toOrgName=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.toOrgName");
        sp.selectOrgName(toOrgName);

        sp.clickOnDeliveryLocation();
        String deliveryLocation=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.deliverylocation");
        sp.selectDeliveryLocation(deliveryLocation);

        String transitNumber=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.transitnumber");
        sp.enterTransitNumber(transitNumber);

        String labelCode=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.labelcode");
        sp.enterLabelCode(labelCode);

        sp.clickOnShipmentDate();
        String shipmentYear=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.shipmentyear");
        String shipmentMonth=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.shipmentmonth");
        String shipmentDate=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.shipmentdate");
        sp.enterShipmentDate(shipmentYear,shipmentMonth,shipmentDate);

        sp.clickOnDeliveryDate();
        String deliveryYear=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.deliveryyear");
        String deliveryMonth=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.deliverymonth");
        String deliveryDate=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.deliverydate");
        sp.enterdeliveryDate(deliveryYear,deliveryMonth,deliveryDate);

        sp.clickOnProductCategory();
        String productCategory=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.productcategory");
        sp.selectProductCategory(productCategory);

        sp.clickOnProductName();
        String productName=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.productname");
        sp.selectProductName(productName);

//        String quantity_value=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.productquantity");
//        sp.enterQuantity(quantity_value);

        sp.clickOnFetchButton();
//        sp.clickCheckBox();
//        sp.clickPencilEdit();
        String edit_quantity=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.productquantity");
        sp.editQuantity(edit_quantity);
        sp.enterQuantityFromBatch(edit_quantity);
//        sp.clickOnNextButton();
//        sp.clickCreateShipment();
    }

    @Test
    public void verifyCreateShipmentWithOrder_Test_002() throws InterruptedException {
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

        ShipmentPage sp=PageFactory.initElements(super.driver,ShipmentPage.class);
        sp.clickOnShipmentPage();
        sp.clickCreateShipment();

        String order_id=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.orderid");
        sp.clickOnOrderId();
        sp.enterOrderId(order_id);
        sp.clickSelectOrganizationLocation();
        String org_location=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.orglocation");
        sp.selectOrganizationLocation(org_location);

        String transitNumber=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.transitnumber");
        sp.enterTransitNumber(transitNumber);

        String labelCode=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.labelcode");
        sp.enterLabelCode(labelCode);

        sp.clickOnShipmentDate();
        String shipmentYear=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.shipmentyear");
        String shipmentMonth=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.shipmentmonth");
        String shipmentDate=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.shipmentdate");
        sp.enterShipmentDate(shipmentYear,shipmentMonth,shipmentDate);

        sp.clickOnDeliveryDate();
        String deliveryYear=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.deliveryyear");
        String deliveryMonth=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.deliverymonth");
        String deliveryDate=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.deliverydate");
        sp.enterdeliveryDate(deliveryYear,deliveryMonth,deliveryDate);

        sp.clickOnFetchButton();
        String enterQuantity=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.batchquantity");
        sp.enterQuantityFromBatch(enterQuantity);
//        String enterQuantity=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.batchquantity");
//        sp.enterQuantityFromBatch(enterQuantity);
//        sp.clickCheckBox();
//        sp.clickPencilEdit();
//
//        String edit_quantity=CommonUtility.getPropertyValue("shipmentpage","shipmentpage.batchquantity");
//        sp.editQuantity(edit_quantity);
//        sp.clickOnNextButton();
//        sp.clickCreateShipment();

    }
}
