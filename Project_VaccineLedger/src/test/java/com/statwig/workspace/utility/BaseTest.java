package com.statwig.workspace.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.Duration;

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
    
    public void languageTranslateHome() {
    	driver.findElement(By.xpath("//p[text()='Spa']")).click();
    	driver.findElement(By.xpath("//p[text()='Inglés']")).click();
    }
    
    public void implicitWait() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

//    @Parameters({"browsername","runmode"})
//    @BeforeTest
//    public WebDriver initializeDriver() throws IOException {
//        Properties prop=new Properties();
//        FileInputStream fis=new FileInputStream("src//test//resources//testdata//config.properties");
//        prop.load(fis);
//        String browserName=prop.getProperty("config.browsername");
//        if(browserName.equalsIgnoreCase("chrome")){
//            System.setProperty("webdriver.chrome.driver","src\\test\\resources\\all_executables\\chromedriver1.exe");
//            driver=new ChromeDriver();
//        }else if(browserName.equalsIgnoreCase("firefox")){
//            System.setProperty("webdriver.gecko.driver","src\\test\\resources\\all_executables\\geckodriver.exe");
//            driver=new FirefoxDriver();
//        }else if(browserName.equalsIgnoreCase("edge")){
//            System.setProperty("webdriver.edge.driver","src\\test\\resources\\all_executables\\msedgedriver.exe");
//            driver=new EdgeDriver();
//        }
//        return driver;
//    }
    
}
