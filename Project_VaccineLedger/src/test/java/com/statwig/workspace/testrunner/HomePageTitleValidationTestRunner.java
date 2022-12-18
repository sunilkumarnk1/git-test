package com.statwig.workspace.testrunner;

import com.statwig.workspace.pageobjects.HomePage;
import com.statwig.workspace.utility.BaseTest;
import com.statwig.workspace.utility.CommonUtility;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HomePageTitleValidationTestRunner extends BaseTest {

    @Test
    public void verifyHomePage_Test_001() throws InterruptedException {

        String expectedTitle = CommonUtility.getPropertyValue("homepage", "homepage.title");
        Reporter.log("Read expected title from properties file as :" + expectedTitle);

        HomePage hp = PageFactory.initElements(super.driver, HomePage.class);
        String actualTitle = hp.getHomePageTitle();
        Reporter.log("Got actual title from web page as :" + actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle, "Both titles are not same");
        Reporter.log("Validation completed");
    }
}
