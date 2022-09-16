package com.statwig.workspace.pageobjects;

import com.statwig.workspace.utility.BasePage;
import com.statwig.workspace.utility.CommonUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.awt.*;
import java.awt.event.KeyEvent;
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

    public void clickCreateShipment() throws InterruptedException {
        WebElement createShipment_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//b[text()='Create Shipment']");
        createShipment_ele.click();
        Thread.sleep(2000);
    }

    public void clickSelectOrganizationLocation() throws InterruptedException {
        WebElement org_loc_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "(//div[contains(@class,'css-ackcql')])[2]");
        org_loc_ele.click();
        Thread.sleep(2000);
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

    public void selectRefToOrgName(String reftoOrgName) throws InterruptedException {
        int count = 0;
        List<WebElement> toOrgName_ele = ShipmentPage.super.findAllElements(All_Locators.XPATH, "//div[text()='" + reftoOrgName + "']");
        for (WebElement ele : toOrgName_ele) {
            reftoOrgName = ele.getText();
            if (reftoOrgName.contains(reftoOrgName)) {
                ele.click();
                count++;
                break;
            }
        }
        if (count != 0) {
            System.out.println(reftoOrgName + " has been selected in the DD");
        } else {
            System.out.println("options you want to select is not available in DD");
        }
        Thread.sleep(2000);
    }

    public void refDeliveryLocation(String refDeliveryLoc) throws InterruptedException {
        int count = 0;
        List<WebElement> deleviryLocation_ele = ShipmentPage.super.findAllElements(All_Locators.XPATH, "//div[text()='" + refDeliveryLoc + "']");
        for (WebElement ele : deleviryLocation_ele) {
            refDeliveryLoc = ele.getText();
            if (refDeliveryLoc.contains(refDeliveryLoc)) {
                ele.click();
                count++;
                break;
            }
        }
        if (count != 0) {
            System.out.println(refDeliveryLoc + " has been selected in the DD");
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

    public void clickOnFetchButton() throws InterruptedException {
        WebElement fetchButton_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//div[text()='Fetch']");
        fetchButton_ele.click();
        Thread.sleep(2000);
    }

    public void clickCheckBox() throws InterruptedException {
        Thread.sleep(2000);
        WebElement checkBox_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//div[@class='rTableRow mb-1']/input[@id='0']");
        checkBox_ele.click();
    }

    public void clickPencilEdit() throws InterruptedException {
        Thread.sleep(2000);
        WebElement pencilEdit_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "(//i)[1]");
        pencilEdit_ele.click();
    }

    public void editQuantity(String excatQuantity) throws InterruptedException {
        Thread.sleep(2000);
        WebElement editQuantity_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//input[@value='" + excatQuantity + "']");
        editQuantity_ele.click();
        editQuantity_ele.clear();
        editQuantity_ele.sendKeys(excatQuantity);
    }

    public void clickOnNextButton() {
        WebElement nextButton_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//button[text()='Next']");
        nextButton_ele.click();
        System.out.println("Clicked Next");
    }

    public void clickOnCreateShipment() {
        WebElement createShipment_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//span[text()='Create Shipment']");
        createShipment_ele.click();
        System.out.println("Shipment Created");
    }

    public void clickOnOrderId() throws InterruptedException {
        WebElement orderid_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "(//div[contains(@class,'css-ackcql')])[1]");
        orderid_ele.click();
    }

    public void enterOrderId(String orderId) {
        WebElement enterOrderId_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//div[text()='" + orderId + "']");
        enterOrderId_ele.click();
    }

    public void enterQuantityFromBatchWithOutOrder(String limit) throws InterruptedException, AWTException {
        List<WebElement> tableQuantityList = ShipmentPage.super.findAllElements(All_Locators.XPATH, "(//div[@class='rTableRow mb-1']//input[@class='form-control text-center input1'][1])");
        System.out.println(tableQuantityList.size());

        for (int i = 1; i <= tableQuantityList.size(); i++) {
            String quantityString = driver.findElement(By.xpath("(//div[@class='rTableRow mb-1']//input[@class='form-control text-center input1'][1])[" + i + "]")).getAttribute("value");
            int quantityInterger = Integer.parseInt(quantityString);
            System.out.println(quantityInterger);
            int quantityLimit = 500;
            if (quantityInterger > quantityLimit) {
                Thread.sleep(2000);
                driver.findElement(By.xpath("(//input[@type='checkbox'])[" + i + "]")).click();
                driver.findElement(By.xpath("(//i[@class='fa fa-pencil text-center'])[" + i + "]")).click();
                driver.findElement(By.xpath("(//div[@class='rTableRow mb-1']//input[@class='form-control text-center input1'][1])[" + i + "]")).click();
                Thread.sleep(3000);
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_A);
                robot.keyPress(KeyEvent.VK_DELETE);
                robot.keyRelease(KeyEvent.VK_DELETE);
                robot.keyRelease(KeyEvent.VK_A);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                Thread.sleep(3000);
                driver.findElement(By.xpath("(//div[@class='rTableRow mb-1']//input[@class='form-control text-center input1'][1])[" + i + "]")).sendKeys(limit);
            } else System.out.println("The entered quantity is not present in any one the batches");
            break;
        }
    }

    public void enterQuantityFromBatchWithOrderFull() throws InterruptedException, AWTException {
        //order id:PO101410
        List<WebElement> fetchbuttons = ShipmentPage.super.findAllElements(All_Locators.XPATH, "(//div[contains(text(),'Fetch')])");
        System.out.println(fetchbuttons.size());
        for (int i = 1; i < fetchbuttons.size(); i++) {
            if (fetchbuttons.size()>1) {
                driver.findElement(By.xpath("(//div[contains(text(),'Fetch')])[" + i + "]")).click();
                driver.findElement(By.xpath("(//input[@type='checkbox'])[" + i + "]")).click();
                driver.findElement(By.xpath("//button[text()='Next']")).click();
                Alert a = driver.switchTo().alert();
                a.accept();
            }else {
                driver.findElement(By.xpath("(//div[contains(text(),'Fetch')])[1]")).click();
                driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
                driver.findElement(By.xpath("//button[text()='Next']")).click();
                Alert a = driver.switchTo().alert();
                a.accept();
            }
            Thread.sleep(2000);
        }

    }

    public void partialQuantityOrderFromBatch(String partial) throws InterruptedException, AWTException {
        List<WebElement> tableQuantityList = ShipmentPage.super.findAllElements(All_Locators.XPATH, "(//div[@class='rTableRow mb-1']//input[@class='form-control text-center input1'][1])");
        System.out.println(tableQuantityList.size());

        for (int i = 1; i <= tableQuantityList.size(); i++) {
            String quantityString = driver.findElement(By.xpath("(//div[@class='rTableRow mb-1']//input[@class='form-control text-center input1'][1])[" + i + "]")).getAttribute("value");
            int quantityInterger = Integer.parseInt(quantityString);
            System.out.println(quantityInterger);
            int quantitypartial = 4999;
            if (quantityInterger > quantitypartial) {
                Thread.sleep(2000);
                driver.findElement(By.xpath("(//input[@type='checkbox'])[" + i + "]")).click();
                driver.findElement(By.xpath("(//i[@class='fa fa-pencil text-center'])[" + i + "]")).click();
                driver.findElement(By.xpath("(//div[@class='rTableRow mb-1']//input[@class='form-control text-center input1'][1])[" + i + "]")).click();
                Thread.sleep(3000);
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_A);
                robot.keyPress(KeyEvent.VK_DELETE);
                robot.keyRelease(KeyEvent.VK_DELETE);
                robot.keyRelease(KeyEvent.VK_A);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                Thread.sleep(3000);
                driver.findElement(By.xpath("(//div[@class='rTableRow mb-1']//input[@class='form-control text-center input1'][1])[" + i + "]")).sendKeys(partial);
            } else System.out.println("The entered quantity is not present in any one the batches");
            break;
        }
    }

    public void enterReferenceShipmentId(String shipmentRefId) {
        //Reference Id: SH101447, SH101445, SH101441, SH101418
        WebElement refShipment_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//input[@placeholder='Enter Reference Shipment ID']");
        refShipment_ele.sendKeys(shipmentRefId);
    }

    public void clickReferenceFetchButton() {
        WebElement ref_fetch = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//span[text()='Fetch']");
        ref_fetch.click();
    }

    public void clickUpdateShipmentButton() {
        WebElement updateButton = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//span/b[text()='Update Shipment']");
        updateButton.click();
    }

    public void enterUpdateShipmentId(String updateShipment) throws InterruptedException {
        Actions actions = new Actions(driver);
        ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//input[@placeholder='Enter Shipment ID']").sendKeys(updateShipment);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
    }

    public void clickUpdateButton() {
        WebElement updateButton = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//span[text()='Update Shipment']");
        updateButton.click();
    }

    public void enterUpdateLocation(String updatelocation) {
        WebElement updatelocation_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//input[@placeholder=' Required']");
        updatelocation_ele.sendKeys(updatelocation);
    }

    public void clickUpdateStatusButton() {
        WebElement updateStatus_ele = ShipmentPage.super.findAnyElement(All_Locators.XPATH, "//span[text()='Update Status']");
        updateStatus_ele.click();
    }

    public void receiveShipment(String receiveShipmentId) throws InterruptedException {
        List<WebElement> viewButtons = ShipmentPage.super.findAllElements(All_Locators.XPATH, "/html/body/div[1]/div/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr/td[6]/div/a");
        List<WebElement> receivingShipmentId = ShipmentPage.super.findAllElements(All_Locators.XPATH, "//h5[text()='" + receiveShipmentId + "']");
        for (int i = 1; i <= viewButtons.size(); i++) {
            for (WebElement ele : receivingShipmentId) {
                receiveShipmentId = ele.getText();
                if (receiveShipmentId.equalsIgnoreCase(receiveShipmentId)) {
                    driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[" + i + "]/td[6]/div/a")).click();
                } else System.out.println("Entered Receiving shipment Id is not found");
                break;
            }
        }
        Thread.sleep(5000);
    }
}


