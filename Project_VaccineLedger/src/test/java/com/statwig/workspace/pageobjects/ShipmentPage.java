package com.statwig.workspace.pageobjects;

import com.microsoft.playwright.*;
import com.statwig.workspace.utility.BasePage;
import com.statwig.workspace.utility.BrowserFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class ShipmentPage extends BasePage {

    public ShipmentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnShipmentPage() {
        WebElement shipmentPageButton = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//span[text()='Shipments']");
        shipmentPageButton.click();
    }

    public void clickCreateShipment() {
        WebElement createShipment_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//b[text()='Create Shipment']");
        createShipment_ele.click();
    }

    public void clickSelectOrganizationLocation() {
        WebElement org_loc_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "(//div[contains(@class,'css-ackcql')])[2]");
        org_loc_ele.click();
    }

    public void selectOrganizationLocation(String orgLocation) throws InterruptedException {
        int count = 0;
        List<WebElement> org_locations_ele = ShipmentPage.super.findAllElements(All_Locators.XPATH, "//div[text()='" + orgLocation + "']");
        for (WebElement ele : org_locations_ele) {
            orgLocation = ele.getText();
            if (orgLocation.contains(orgLocation)) {
                ele.click();
                count++;
                break;
            }
        }
        if (count != 0) {
            System.out.println(orgLocation + " has been selected in the DD");
        } else {
            System.out.println("options you want to select is not available in DD");
        }
        Thread.sleep(5000);
    }

    public void clickToOrgType() {
        WebElement toOrgLocation_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "(//div[contains(@class,'css-ackcql')])[3]");
        toOrgLocation_ele.click();
    }

    public void selectToOrgType(String orgType) throws InterruptedException {
        int count = 0;
        List<WebElement> toOrgLocation_ele = ShipmentPage.super.findAllElements(All_Locators.XPATH, "//div[text()='" + orgType + "']");
        for (WebElement ele : toOrgLocation_ele) {
            orgType = ele.getText();
            if (orgType.contains(orgType)) {
                ele.click();
                count++;
                break;
            }
        }
        if (count != 0) {
            System.out.println(orgType + " has been selected in the DD");
        } else {
            System.out.println("options you want to select is not available in DD");
        }
        Thread.sleep(2000);
    }

    public void clickToOrgName() {
        WebElement orgName_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "(//div[contains(@class,'css-ackcql')])[4]");
        orgName_ele.click();
    }

    public void selectOrgName(String toOrgName) throws InterruptedException {
        int count = 0;
        List<WebElement> toOrgName_ele = ShipmentPage.super.findAllElements(All_Locators.XPATH, "//div[text()='" + toOrgName + "']");
        for (WebElement ele : toOrgName_ele) {
            toOrgName = ele.getText();
            if (toOrgName.contains(toOrgName)) {
                ele.click();
                count++;
                break;
            }
        }
        if (count != 0) {
            System.out.println(toOrgName + " has been selected in the DD");
        } else {
            System.out.println("options you want to select is not available in DD");
        }
        Thread.sleep(2000);
    }

    public void clickOnDeliveryLocation() throws InterruptedException {
        WebElement deliverylocation_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "(//div[contains(@class,'css-ackcql')])[5]");
        deliverylocation_ele.click();
    }

    public void selectDeliveryLocation(String deliveryLocation) throws InterruptedException {
        int count = 0;
        List<WebElement> deleviryLocation_ele = ShipmentPage.super.findAllElements(All_Locators.XPATH, "//div[text()='" + deliveryLocation + "']");
        for (WebElement ele : deleviryLocation_ele) {
            deliveryLocation = ele.getText();
            if (deliveryLocation.contains(deliveryLocation)) {
                ele.click();
                count++;
                break;
            }
        }
        if (count != 0) {
            System.out.println(deliveryLocation + " has been selected in the DD");
        } else {
            System.out.println("options you want to select is not available in DD");
        }
        Thread.sleep(2000);
    }

    public void enterTransitNumber(String transitNumber) {
        WebElement transitNumber_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//input[@placeholder='Enter Transit Number']");
        transitNumber_ele.sendKeys(transitNumber);
    }

    public void enterLabelCode(String labelCode) {
        WebElement labelCode_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//input[@placeholder='Enter Label code']");
        labelCode_ele.sendKeys(labelCode);
    }

    public void clickOnShipmentDate() {
        WebElement shipmentDate_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//input[@placeholder='Enter Shipment Date']");
        shipmentDate_ele.click();
    }

    public void enterShipmentDate(String year_value, String month_value, String date_value) throws InterruptedException {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(120));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class);
        //year selection
        WebElement ele_year = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='react-datepicker__year-read-view--selected-year']")));
        while (true) {
            String year = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//span[@class='react-datepicker__year-read-view--selected-year']").getText();
            if (year.equalsIgnoreCase(year_value))
                break;
            else
                driver.findElement(By.xpath("//span[@class='react-datepicker__year-read-view--down-arrow']")).click();
        }
        //month selection
        while (true) {
            WebElement ele_month = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='react-datepicker__current-month react-datepicker__current-month--hasYearDropdown']")));
            String month = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//div[@class='react-datepicker__current-month react-datepicker__current-month--hasYearDropdown']").getText();
            if (month.equalsIgnoreCase(month_value))
                break;
            else
                driver.findElement(By.xpath("//span[text()='Next Month']")).click();
        }
        //date selection
        List<WebElement> allDates = ShipmentPage.super.findAllElements(All_Locators.XPATH, "//div[@aria-selected='false']");
        for (WebElement ele : allDates) {
            String dates = ele.getText();
            if (dates.equalsIgnoreCase(date_value)) {
                ele.click();
                break;
            }
        }
        Thread.sleep(5000);
    }

    public void clickOnDeliveryDate() {
        WebElement deliveryDate_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//input[@placeholder='Enter delivery date']");
        deliveryDate_ele.click();
    }

    public void enterdeliveryDate(String year_value, String month_value, String date_value) throws InterruptedException {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(120));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class);
        //year selection
        WebElement ele_year = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='react-datepicker__year-read-view--selected-year']")));
        while (true) {
            String year = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//span[@class='react-datepicker__year-read-view--selected-year']").getText();
            if (year.equalsIgnoreCase(year_value))
                break;
            else
                driver.findElement(By.xpath("//span[@class='react-datepicker__year-read-view--down-arrow']")).click();
        }
        //month selection
        while (true) {
            WebElement ele_month = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='react-datepicker__current-month react-datepicker__current-month--hasYearDropdown']")));
            String month = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//div[@class='react-datepicker__current-month react-datepicker__current-month--hasYearDropdown']").getText();
            if (month.equalsIgnoreCase(month_value))
                break;
            else
                driver.findElement(By.xpath("//span[text()='Next Month']")).click();
        }
        //date selection
        List<WebElement> allDates = ShipmentPage.super.findAllElements(All_Locators.XPATH, "//div[@aria-selected='false']");
        for (WebElement ele : allDates) {
            String dates = ele.getText();
            if (dates.equalsIgnoreCase(date_value)) {
                ele.click();
                break;
            }
        }
        Thread.sleep(5000);
    }

    public void clickOnProductCategory() {
        WebElement productCategory_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "(//div[contains(@class,'css-ackcql')])[6]");
        productCategory_ele.click();
    }

    public void selectProductCategory(String productCategory) throws InterruptedException {
        int count = 0;
        List<WebElement> productCategory_ele = ShipmentPage.super.findAllElements(All_Locators.XPATH, "//div[text()='" + productCategory + "']");
        for (WebElement ele : productCategory_ele) {
            productCategory = ele.getText();
            if (productCategory.contains(productCategory)) {
                ele.click();
                count++;
                break;
            }
        }
        if (count != 0) {
            System.out.println(productCategory + " has been selected in the DD");
        } else {
            System.out.println("options you want to select is not available in DD");
        }
        Thread.sleep(2000);
    }

    public void clickOnProductName() {
        WebElement productName_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "(//div[contains(@class,'css-ackcql')])[7]");
        productName_ele.click();
    }

    public void selectProductName(String productName) throws InterruptedException {
        int count = 0;
        List<WebElement> productName_ele = ShipmentPage.super.findAllElements(All_Locators.XPATH, "//div[text()='" + productName + "']");
        for (WebElement ele : productName_ele) {
            productName = ele.getText();
            if (productName.contains(productName)) {
                ele.click();
                count++;
                break;
            }
        }
        if (count != 0) {
            System.out.println(productName + " has been selected in the DD");
        } else {
            System.out.println("options you want to select is not available in DD");
        }
        Thread.sleep(2000);
    }

    public void enterQuantity(String quantity) {
        WebElement quanity_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//input[@placeholder='Quantity']");
        quanity_ele.clear();
        quanity_ele.sendKeys(quantity);
    }

    public void clickOnFetchButton() {
        WebElement fetchButton_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//div[text()='Fetch']");
        fetchButton_ele.click();
    }

    public void clickCheckBox() throws InterruptedException {
        Thread.sleep(2000);
        WebElement checkBox_ele=ShipmentPage.super.findAnyElement(All_Locators.XPATH,"//div[@class='rTableRow mb-1']/input[@id='0']");
        checkBox_ele.click();
    }

    public void clickPencilEdit() throws InterruptedException {
        Thread.sleep(2000);
        WebElement pencilEdit_ele=ShipmentPage.super.findAnyElement(All_Locators.XPATH,"(//i)[1]");
        pencilEdit_ele.click();
    }

    public void editQuantity(String excatQuantity) throws InterruptedException {
        Thread.sleep(2000);
        WebElement editQuantity_ele=ShipmentPage.super.findAnyElement(All_Locators.XPATH,"//input[@value='"+excatQuantity+"']");
        editQuantity_ele.click();
        editQuantity_ele.clear();
        editQuantity_ele.sendKeys(excatQuantity);
    }

    public void clickOnNextButton(){
        WebElement nextButton_ele=ShipmentPage.super.findAnyElement(All_Locators.XPATH,"//button[text()='Next']");
        nextButton_ele.click();
    }

    public void clickOnCreateShipment(){
        WebElement createShipment_ele=ShipmentPage.super.findAnyElement(All_Locators.XPATH,"//span[text()='Create Shipment']");
        createShipment_ele.click();
    }

    public void clickOnOrderId() throws InterruptedException {
        WebElement orderid_ele=ShipmentPage.super.findAnyElement(All_Locators.XPATH,"(//div[contains(@class,'css-ackcql')])[1]");
        orderid_ele.click();
    }

    public void enterOrderId(String orderId){
        WebElement enterOrderId_ele=ShipmentPage.super.findAnyElement(All_Locators.XPATH,"//div[text()='"+orderId+"']");
        enterOrderId_ele.click();
    }

    public void enterQuantityFromBatch(String givenQuantity){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        List<WebElement> allQuantityBatches=ShipmentPage.super.findAllElements(All_Locators.XPATH,"//input[@class='form-control text-center input1']");
        List<WebElement> allCheckBoxes=ShipmentPage.super.findAllElements(All_Locators.XPATH,"//input[@type='checkbox']");
        System.out.println(allQuantityBatches.size());
        for(WebElement ele:allQuantityBatches){
            String attributeName=ele.getAttribute("disabled value");
            System.out.println(attributeName);
            int attribute_names=Integer.valueOf(attributeName);
            if(attribute_names>=Integer.valueOf(givenQuantity)){
                System.out.println(attribute_names);

            }
        }
        }
    }
//}

