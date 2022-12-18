package com.statwig.workspace.testrunner;

import com.statwig.workspace.pageobjects.HomePage;
import com.statwig.workspace.pageobjects.SignUpPage;
import com.statwig.workspace.utility.BaseTest;
import com.statwig.workspace.utility.CommonUtility;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class NewRegistrationOrganizationTestRunner extends BaseTest {

    @Test
    public void verifyNewRegistrationOrganization_Test_002() throws InterruptedException {

        HomePage hp= PageFactory.initElements(super.driver,HomePage.class);
        languageTranslateHome();
        SignUpPage sup=hp.clickSignUpButton();
        Reporter.log("Clicked on SignUp button");
        Thread.sleep(2000);

        String firstName=CommonUtility.getPropertyValue("signuppage","signuppage.firstName");
        sup.enterFirstName(firstName);
        Reporter.log(firstName+" is Entered");

        String lastName=CommonUtility.getPropertyValue("signuppage","signuppage.lastName");
        sup.enterLastName(lastName);
        Reporter.log(lastName+" is Entered");

        String emailId=CommonUtility.getPropertyValue("signuppage","signuppage.emailId");
        sup.enterEmailId(emailId);
        Reporter.log(emailId+" is Entered");

        String mobileNum=CommonUtility.getPropertyValue("signuppage","signuppage.mobileNum");
        sup.enterMobileNum(mobileNum);
        Reporter.log(mobileNum+" is entered");

        sup.clickNewOrganizatioButton();
        Reporter.log("New Organization type selected");
        
        sup.clickOrgType();
        String organization_Type=CommonUtility.getPropertyValue("signuppage","signuppage.organizationtype");
        sup.selectOrganizationType(organization_Type);
        Reporter.log(organization_Type+" is selected");

        sup.clickOrgName();
        String org_name=CommonUtility.getPropertyValue("signuppage","signuppage.organizationname");
        sup.selectOrganizationName(org_name);
        Reporter.log(org_name+" is Selected");

        sup.clickContinueButton();
        
        String stateName=CommonUtility.getPropertyValue("signuppage","signuppage.state");
        sup.selectState(stateName);
        Reporter.log(stateName+" is Entered");

        sup.clickOnCity();
        String cityName=CommonUtility.getPropertyValue("signuppage","signuppage.city");
        sup.selectCity(cityName);
        Reporter.log(cityName+" is Entered");

        String pincode=CommonUtility.getPropertyValue("signuppage","signuppage.pincode");
        sup.enterPinCode(pincode);
        Reporter.log(pincode+" is Entered");
        
        String addressDetails=CommonUtility.getPropertyValue("signuppage","signuppage.address");
        sup.enterAddress(addressDetails);
        Reporter.log(addressDetails+" is Entered");

        sup.clickRegister();
        Reporter.log("Clicked on Register Button");
        
    }
}
