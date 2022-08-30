package com.statwig.workspace.utility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {
    private String browsername, runmode;
    protected WebDriver driver;

    @BeforeSuite(groups={"smoke","regression","uat"})
    public void beforeSuite(){
        Reporter.log("Welcome to test automation execution");
    }

    @Parameters({"browsername","runmode"})
    @BeforeTest(groups = {"smoke","regression","uat"})
    public void readTestConfig(@Optional("chrome") String brname, @Optional("local") String rm){
        this.browsername=brname;
        this.runmode=rm;
        Reporter.log("Test is running in "+this.browsername+" and runmode as "+this.runmode);
    }

    @BeforeClass(groups = {"smoke","regression","uat"})
    public void classLogger(){
        Reporter.log(this.getClass().getName()+" started execution");
    }

    @BeforeMethod(groups = {"smoke","regression","uat"})
    public void init(Method m){
        this.driver=BrowserFactory.openLocalBrowser(this.browsername);
        BrowserFactory.launchApplication(CommonUtility.getPropertyValue("config.url"));
        Reporter.log(m.getName()+" started execution");
        Reporter.log(this.browsername+" browser is opened");
    }

    @AfterMethod(groups = {"smoke","regression","uat"})
    public void closure(ITestResult result, Method m){
        Reporter.log(result.getTestName()+" result execution status passed is = "+result.isSuccess());
        if(!result.isSuccess()){
            BasePage.takingScreenShotAndSave(this.driver);
            Reporter.log("Pass percentage = "+result.SUCCESS_PERCENTAGE_FAILURE);
        }
        BrowserFactory.endDriverTaskManager();     //driver.quit();
        Reporter.log(m.getName()+" execution is completed");
        Reporter.log(this.browsername+" is closed");
    }

    @AfterClass(groups = {"smoke","regression","uat"})
    public void classClosure(){
        Reporter.log(this.getClass().getName()+ " completed execution");
    }

    @AfterTest(groups = {"smoke","regression","uat"})
    public void testClosure(){
        Reporter.log("All Tests completed on browser"+this.browsername);
    }

    @AfterSuite(groups = {"smoke","regression","uat"})
    public void executionCompleted(){
        Reporter.log("All Tests Completed - Reports are avilable in target/surefire-reports/emailable-report.html");
        Reporter.log("Screenshots are available in src/resources/screenshots folder");
    }
}
