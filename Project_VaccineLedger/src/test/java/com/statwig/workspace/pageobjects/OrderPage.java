package com.statwig.workspace.pageobjects;

import com.statwig.workspace.testrunner.OrderTestRunner;
import com.statwig.workspace.utility.BasePage;
import com.statwig.workspace.utility.VaccineLedgerConstants;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.statwig.workspace.utility.VaccineLedgerConstants;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OrderPage extends BasePage {

    public OrderPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickOnOrders(){
        WebElement order_ele=OrderPage.super.findAnyElement(All_Locators.XPATH,"//span[text()='Orders']");
        order_ele.click();
    }

    public void clickOnCreateNewOrder(){
        WebElement createOrder_ele=OrderPage.super.findAnyElement(All_Locators.XPATH,"//a[@class='text-none']//div[1]");
        createOrder_ele.click();
    }

    public void clickSelectProductCategory() throws InterruptedException {
        Thread.sleep(5000);
        WebElement productCategoryButton=OrderPage.super.findAnyElement(All_Locators.XPATH,"//div[@class='no-border css-b62m3t-container']//div[contains(@class,'css-ackcql')]");
        productCategoryButton.click();
    }

    public void sendTextIntoSelectProductCategory(String selectProduct) throws InterruptedException {
        FluentWait<WebDriver> wait=new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(120));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class);
        WebElement ele_category=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=' css-yt9ioa-option']")));
        List<WebElement> list=driver.findElements(By.xpath("//div[@aria-disabled='false']"));
        System.out.println("size of the list is:"+list.size());

        for(WebElement eachElement : list){
            String text=eachElement.getText();
            if(text.equalsIgnoreCase(selectProduct)){
                eachElement.click();
                break;
            }
        }
        Thread.sleep(2000);
    }

    public void clickSelectProductName() throws InterruptedException {
        WebElement ele_productName=OrderPage.super.findAnyElement(All_Locators.XPATH,"(//div[contains(@class,'css-ackcql')])[2]");
        ele_productName.click();
        Thread.sleep(2000);
    }

    public void selectProductName(String productName) throws InterruptedException {
        FluentWait<WebDriver> wait=new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(120));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class);
        WebElement ele_category=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=' css-yt9ioa-option']")));
        List<WebElement> listOfProductNames=driver.findElements(By.xpath("//div[@aria-disabled='false']"));
        for(WebElement ele:listOfProductNames){
            String text=ele.getText();
            if(text.equalsIgnoreCase(productName)){
                ele.click();
                break;
            }
        }
        Thread.sleep(5000);
    }

    public void enterQuantity(String quantity){
        WebElement quantity_ele=OrderPage.super.findAnyElement(All_Locators.XPATH,"//input[@placeholder='Enter Quantity']");
        quantity_ele.sendKeys(quantity);
    }

    public void clickAddAnotherProduct(){
        WebElement addanotherProduct_ele=OrderPage.super.findAnyElement(All_Locators.XPATH,"//span[text()='Add Another Product']");
        addanotherProduct_ele.click();
    }

    public void clickSelectOrganizationType() throws InterruptedException {
        WebElement selectOrganizationType_ele=OrderPage.super.findAnyElement(All_Locators.XPATH,"(//div[contains(@class,'css-ackcql')])[3]");
        selectOrganizationType_ele.click();
        Thread.sleep(5000);
    }

    public void selectOrganizationType(String organizationType) throws InterruptedException {
        WebElement org_type=OrderPage.super.findAnyElement(All_Locators.XPATH,"//label[text()='Organization Type']/following::input[1]");
        org_type.sendKeys(organizationType);

        Thread.sleep(2000);

        int count=0;
        List<WebElement> optionList=OrderPage.super.findAllElements(All_Locators.XPATH,"//div[@aria-disabled='false']");
        for(WebElement ele:optionList){
            organizationType=ele.getText();
            if(organizationType.contains(organizationType)){
                ele.click();
                count++;
                break;
            }
        }
        if(count!=0){
            System.out.println(organizationType+" has been selected in the DD");
        }
        else{
            System.out.println("options you want to select is not available in DD");
        }
    }

    public void clickOnOrganizationName() throws InterruptedException {
        FluentWait<WebDriver> wait=new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(120));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class);
        WebElement ele_org_name=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='react-select-5-placeholder']")));
        WebElement organizationNameButton_ele=OrderPage.super.findAnyElement(All_Locators.XPATH,"//div[@id='react-select-5-placeholder']");

        Actions action=new Actions(driver);
        action.moveToElement(organizationNameButton_ele).click(organizationNameButton_ele).build().perform();
    }

    public void enterOrganizationName(String organizationName) throws InterruptedException {
        Thread.sleep(5000);
        int count=0;
        List<WebElement> organizationName_ele=OrderPage.super.findAllElements(All_Locators.XPATH,"//div[text()='"+organizationName+"']");
        for(WebElement ele:organizationName_ele){
            organizationName=ele.getText();
            if(organizationName.contains(organizationName)){
                ele.click();
                count++;
                break;
            }
        }
        if(count!=0){
            System.out.println(organizationName+" has been selected in the DD");
        }
        else{
            System.out.println("options you want to select is not available in DD");
        }
        Thread.sleep(2000);
    }

    public void clickToOrganizationType() throws InterruptedException {
        WebElement to_org_Type_ele=OrderPage.super.findAnyElement(All_Locators.XPATH,"(//div[contains(@class,'css-ackcql')])[5]");
        to_org_Type_ele.click();
        Thread.sleep(5000);
    }

    public void selectToOrganizationType(String organizationType) throws InterruptedException {
        Thread.sleep(5000);
        int count=0;
        List<WebElement> toOrganizationType_ele=OrderPage.super.findAllElements(All_Locators.XPATH,"//div[text()='"+organizationType+"']");
        for(WebElement ele:toOrganizationType_ele){
            organizationType=ele.getText();
            if(organizationType.contains(organizationType)){
                ele.click();
                count++;
                break;
            }
        }
        if(count!=0){
            System.out.println(organizationType+" has been selected in the DD");
        }
        else{
            System.out.println("options you want to select is not available in DD");
        }
        Thread.sleep(2000);
    }

    public void clickRegion(){
        WebElement region_ele= OrderPage.super.findAnyElement(All_Locators.XPATH,"(//div[contains(@class,'css-ackcql')])[6]");
        region_ele.click();
    }

    public void selectRegion(String region) throws InterruptedException {
        int count=0;
        List<WebElement> toRegion_ele=OrderPage.super.findAllElements(All_Locators.XPATH,"//div[text()='"+region+"']");
        for(WebElement ele:toRegion_ele){
            region=ele.getText();
            if(region.contains(region)){
                ele.click();
                count++;
                break;
            }
        }
        if(count!=0){
            System.out.println(region+" has been selected in the DD");
        }
        else{
            System.out.println("options you want to select is not available in DD");
        }
        Thread.sleep(2000);
    }

    public void clickOnCountry(){
        WebElement country_ele=OrderPage.super.findAnyElement(All_Locators.XPATH,"(//div[contains(@class,'css-ackcql')])[7]");
        country_ele.click();
    }

    public void selectToCountry(String country) throws InterruptedException {
        int count=0;
        List<WebElement> toCountry_ele=OrderPage.super.findAllElements(All_Locators.XPATH,"//div[text()='"+country+"']");
        for(WebElement ele:toCountry_ele){
            country=ele.getText();
            if(country.contains(country)){
                ele.click();
                count++;
                break;
            }
        }
        if(count!=0){
            System.out.println(country+" has been selected in the DD");
        }
        else{
            System.out.println("options you want to select is not available in DD");
        }
        Thread.sleep(2000);
    }

    public void clickOnToOrganizationName(){
        WebElement toOrgName=OrderPage.super.findAnyElement(All_Locators.XPATH,"(//div[contains(@class,'css-ackcql')])[8]");
        toOrgName.click();
    }

    public void selectToOrganizationName(String orgName) throws InterruptedException {
        int count=0;
        List<WebElement> toOrgName_ele=OrderPage.super.findAllElements(All_Locators.XPATH,"//div[text()='"+orgName+"']");
        for(WebElement ele:toOrgName_ele){
            orgName=ele.getText();
            if(orgName.contains(orgName)){
                ele.click();
                count++;
                break;
            }
        }
        if(count!=0){
            System.out.println(orgName+" has been selected in the DD");
        }
        else{
            System.out.println("options you want to select is not available in DD");
        }
        Thread.sleep(2000);
    }

    public void clickDeliveryLocation(){
        WebElement deliveryLocation_ele=OrderPage.super.findAnyElement(All_Locators.XPATH,"(//div[contains(@class,'css-ackcql')])[9]");
        deliveryLocation_ele.click();
    }

    public void selectDeliveryLocation(String deliveryLocation) throws InterruptedException {
        int count=0;
        List<WebElement> todeliveryLocation_ele=OrderPage.super.findAllElements(All_Locators.XPATH,"//div[text()='"+deliveryLocation+"']");
        for(WebElement ele:todeliveryLocation_ele){
            deliveryLocation=ele.getText();
            if(deliveryLocation.contains(deliveryLocation)){
                ele.click();
                count++;
                break;
            }
        }
        if(count!=0){
            System.out.println(deliveryLocation+" has been selected in the DD");
        }
        else{
            System.out.println("options you want to select is not available in DD");
        }
        Thread.sleep(2000);
    }

    public void clickOnReviewOrder() throws InterruptedException {
        WebElement reviewOrder_ele=OrderPage.super.findAnyElement(All_Locators.XPATH,"//b[text()='Review Order']");
        reviewOrder_ele.click();
        Thread.sleep(2000);
    }

    public void clickOnCreateOrder() throws InterruptedException {
        WebElement createOrder_ele=OrderPage.super.findAnyElement(All_Locators.XPATH,"//span[text()='Create New Order']");
        createOrder_ele.click();
        Thread.sleep(6000);
    }

    public void clickOnImport(){
        WebElement import_ele=OrderPage.super.findAnyElement(All_Locators.XPATH,"//b[text()='Import']");
        import_ele.click();
    }

    public void clickOnExcel(){
        WebElement excel_ele=OrderPage.super.findAnyElement(All_Locators.XPATH,"//button[@class=' btn btn-outline-info mb-2 ']");
        excel_ele.click();
    }

    public void clickOnSelectAFile() throws AWTException, InterruptedException {
        ArrayList<String> allWindows=new ArrayList<>(driver.getWindowHandles());
        String uploadPage=allWindows.get(0);
        driver.switchTo().window(uploadPage);

        WebElement selectFile_ele=OrderPage.super.findAnyElement(All_Locators.XPATH,"//label[text()='Select a file']");
        selectFile_ele.click();

        StringSelection path_to_upload=new StringSelection("D:\\statwig\\VL\\Test_po.xlsx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path_to_upload,null);

        Robot robot=new Robot();

        robot.delay(250);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Assert.isTrue(selectFile_ele.isDisplayed(),"not uploaded");
        Thread.sleep(2000);
    }

    public void clickOnFinalImport(){
        WebElement finalImport_ele=OrderPage.super.findAnyElement(All_Locators.XPATH,"//button[text()='Import']");
        finalImport_ele.click();
    }

    public void clickOnOrdersReceived(){
        WebElement ordersReceived_ele=OrderPage.super.findAnyElement(All_Locators.XPATH,"//div[text()='Orders Received']");
        ordersReceived_ele.click();
    }

    public void selectOrderToAcceptReject(String orderID){
        WebElement viewOrderbutton=OrderPage.super.findAnyElement(All_Locators.XPATH,"//td/a[@href='/vieworder/"+orderID+"']");
        viewOrderbutton.click();
    }

    public void clickAcceptOrReject(String accept_or_reject){
        WebElement acceptReject_button=OrderPage.super.findAnyElement(All_Locators.XPATH,"//button[text()='"+accept_or_reject+"']");
        acceptReject_button.click();
    }

    public void selectOrderToCancel(String orderId){
        WebElement clickViewByOrderId=OrderPage.super.findAnyElement(All_Locators.XPATH,"//td/a[@href='/vieworder/"+orderId+"']");
        clickViewByOrderId.click();
    }

    public void clickCancelButton(){
        WebElement cancelButton_ele=OrderPage.super.findAnyElement(All_Locators.XPATH,"//button[text()='Cancel Order']");
        cancelButton_ele.click();
    }

}

