package com.statwig.workspace.testrunner;

import com.statwig.workspace.pageobjects.HomePage;
import com.statwig.workspace.pageobjects.OrganizationDetails;
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
        SignUpPage sup=hp.clickSignUpButton();
        Reporter.log("Clicked on SignUp button");
        Thread.sleep(2000);

        String firstName= CommonUtility.getPropertyValue("signuppage","signuppage.firstName");
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

        String organization_Type=CommonUtility.getPropertyValue("signuppage","signuppage.organizationtype");
        sup.selectOrganizationType(organization_Type);
        Reporter.log(organization_Type+" is selected");

        String org_name=CommonUtility.getPropertyValue("signuppage","signuppage.organizationname");
        sup.selectOrganizationName(org_name);
        Reporter.log(org_name+" is Selected");

        OrganizationDetails od=PageFactory.initElements(super.driver,OrganizationDetails.class);
        String organizationName=CommonUtility.getPropertyValue("organizationdetails","organizationdetails.name");
        od.enterOrganizationName(organizationName);
        Reporter.log(organizationName+" is Entered");

        String selectRegion=CommonUtility.getPropertyValue("organizationdetails","organizationdetails.region");
        od.selectRegion_1(selectRegion);
        Reporter.log(selectRegion+" is Entered");
        Thread.sleep(2000);

        String countryName=CommonUtility.getPropertyValue("organizationdetails","organizationdetails.country");
        od.selectCountry(countryName);
        Reporter.log(countryName+" is Entered");

        String stateName=CommonUtility.getPropertyValue("organizationdetails","organizationdetails.state");
        od.selectState(stateName);
        Reporter.log(stateName+" is Entered");

        String cityName=CommonUtility.getPropertyValue("organizationdetails","organizationdetails.city");
        od.selectCity(cityName);
        Reporter.log(cityName+" is Entered");

        String addressDetails=CommonUtility.getPropertyValue("organizationdetails","organizationdetails.address");
        od.enterAddress(addressDetails);
        Reporter.log(addressDetails+" is Entered");

        String pincode=CommonUtility.getPropertyValue("organizationdetails","organizationdetails.pincode");
        od.enterPinCode(pincode);
        Reporter.log(pincode+" is Entered");

        od.clickDoneButton();
        Reporter.log("clicked on Done button");
    }
}
