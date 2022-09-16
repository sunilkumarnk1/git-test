package com.statwig.workspace.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.statwig.workspace.utility.BasePage;

public class InventoryPage extends BasePage {

	public InventoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnInventory() {
		WebElement inventory_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH, "//span[text()='Inventory']");
		inventory_ele.click();
	}

	public void clickAddInventory() throws InterruptedException {
		WebElement addInventory_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH,
				"//b[text()='Add Inventory']");
		addInventory_ele.click();
	}

	public void clickSelectProductCategory() throws InterruptedException {
		Thread.sleep(5000);
		WebElement productCategoryButton = InventoryPage.super.findAnyElement(All_Locators.CLASSNAME,
				"select-placeholder-text-prod-category");
		productCategoryButton.click();
	}

	public void sendTextIntoSelectProductCategory(String selectProduct) throws InterruptedException {
		FluentWait<WebDriver> wait = new FluentWait<>(driver);
		wait.withTimeout(Duration.ofSeconds(120));
		wait.pollingEvery(Duration.ofSeconds(1));
		wait.ignoring(NoSuchElementException.class);
		WebElement ele_category = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=' css-yt9ioa-option']")));
		List<WebElement> list = driver.findElements(By.xpath("//div[@aria-disabled='false']"));
		System.out.println("size of the list is:" + list.size());

		for (WebElement eachElement : list) {
			String text = eachElement.getText();
			if (text.equalsIgnoreCase(selectProduct)) {
				eachElement.click();
				break;
			}
		}
		Thread.sleep(2000);
	}

	public void clickSelectProductName() throws InterruptedException {
		WebElement ele_productName = InventoryPage.super.findAnyElement(All_Locators.XPATH,
				"//div[text()='Select Product Name']");
		ele_productName.click();
		Thread.sleep(2000);
	}

	public void selectProductName(String productName) throws InterruptedException {
		FluentWait<WebDriver> wait = new FluentWait<>(driver);
		wait.withTimeout(Duration.ofSeconds(120));
		wait.pollingEvery(Duration.ofSeconds(1));
		wait.ignoring(NoSuchElementException.class);
		WebElement ele_category = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=' css-yt9ioa-option']")));
		List<WebElement> listOfProductNames = driver.findElements(By.xpath("//div[@aria-disabled='false']"));
		for (WebElement ele : listOfProductNames) {
			String text = ele.getText();
			if (text.equalsIgnoreCase(productName)) {
				ele.click();
				break;
			}
		}
		Thread.sleep(5000);
	}

	public void enterBatchNumber(String batchNumber) {
		WebElement batchNumber_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH,
				"//input[@placeholder='Enter Batch No']");
		batchNumber_ele.sendKeys(batchNumber);
	}

	public void enterQuantity(String quantity) {
		WebElement quantity_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH,
				"//input[@placeholder='Enter Quantity']");
		quantity_ele.sendKeys(quantity);
	}

	public void clickOnAddDetails() {
		WebElement addDetails_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH,
				"//span[@class='txt-inventory']");
		addDetails_ele.click();
	}

	public void clickOnManufactureDate() throws InterruptedException {
		WebElement manufacutedate_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH,
				"//input[@placeholder='Enter Mfg Date']");
		manufacutedate_ele.click();
		Thread.sleep(2000);
	}

	public void enterManufactureYearDate(String year_value, String month_value) throws InterruptedException {
		FluentWait<WebDriver> wait = new FluentWait<>(driver);
		wait.withTimeout(Duration.ofSeconds(120));
		wait.pollingEvery(Duration.ofSeconds(1));
		wait.ignoring(NoSuchElementException.class);
		// webelement year above the calendar
		WebElement ele_year = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class='react-datepicker__month-container']/div[1]")));
		while (true) {
			String year = InventoryPage.super.findAnyElement(All_Locators.XPATH,
					"//div[@class='react-datepicker__month-container']/div[1]").getText();
			if (year.equalsIgnoreCase(year_value))
				break;
			else
				driver.findElement(By.xpath("//button[@aria-label='Next Year']")).click();
		}
		// month selection
		List<WebElement> allMonths = InventoryPage.super.findAllElements(All_Locators.XPATH,
				"//div[@aria-selected='false']");
		for (WebElement ele : allMonths) {
			String months = ele.getText();
			if (months.equalsIgnoreCase(month_value)) {
				ele.click();
				break;
			}
		}
		Thread.sleep(5000);
	}

	public void clickExpireDate() {
		WebElement expireDate_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH,
				"//input[@placeholder='Enter Exp Date']");
		expireDate_ele.click();
	}

	public void selectExpireYearDate(String year_value, String month_value) throws InterruptedException {
		FluentWait<WebDriver> wait = new FluentWait<>(driver);
		wait.withTimeout(Duration.ofSeconds(120));
		wait.pollingEvery(Duration.ofSeconds(1));
		wait.ignoring(NoSuchElementException.class);
		// webelement year above the calendar
		WebElement ele_year = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class='react-datepicker__month-container']/div[1]")));
		while (true) {
			String year = InventoryPage.super.findAnyElement(All_Locators.XPATH,
					"//div[@class='react-datepicker__month-container']/div[1]").getText();
			if (year.equalsIgnoreCase(year_value))
				break;
			else
				driver.findElement(By.xpath("//button[@aria-label='Next Year']")).click();
		}
		// month selection
		List<WebElement> allMonths = InventoryPage.super.findAllElements(All_Locators.XPATH,
				"//div[@aria-selected='false']");
		for (WebElement ele : allMonths) {
			String months = ele.getText();
			if (months.equalsIgnoreCase(month_value)) {
				ele.click();
				break;
			}
		}
		Thread.sleep(5000);
	}

	public void enterSerialNumber(String serialNumber) {
		WebElement serialNumber_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH,
				"//input[@placeholder='Enter Serial Numbers']");
		serialNumber_ele.sendKeys(serialNumber);
	}

	public void clickReviewProduct() {
		WebElement reviewProduct_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH,
				"//b[text()='Review Product']");
		reviewProduct_ele.click();
	}

	public void clickSaveButton() throws InterruptedException {
		WebElement save_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH, "//b[text()='Save']");
		save_ele.click();
		Thread.sleep(2000);
	}

	public void clickOkButton() {
		WebElement ok_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH, "//button[text()='OK']");
		ok_ele.click();
	}

	public void clickViewAll() {
		WebElement viewAll_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH, "//b[text()='View All']");
		viewAll_ele.click();
	}

	public void clickAddNewProduct() {
		WebElement clickViewAll_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH,
				"//b[text()='Add new product']");
		clickViewAll_ele.click();
	}

	public void enterProductName(String productName) {
		WebElement productName_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH, "//input[@name='product']");
		productName_ele.sendKeys(productName);
	}

	public void clickManufacturer() {
		WebElement manufacturer_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH,
				"//input[@placeholder='Enter manufacturer']");
		manufacturer_ele.click();
	}

	public void selectManufacturers(String manufacturerName) throws InterruptedException {
		List<WebElement> manufacturers_list = InventoryPage.super.findAllElements(All_Locators.XPATH,
				"//li[@tabindex='-1']");
		for (WebElement ele : manufacturers_list) {
			String manufacturer_values = ele.getText();
			if (manufacturer_values.equalsIgnoreCase(manufacturerName)) {
				ele.click();
				break;
			}
		}
	}

	public void clickproductCategory() {
		WebElement productCategory_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH,
				"//input[@placeholder='Product Category']");
		productCategory_ele.click();
	}

	public void selectProductCategory(String productCategory) throws InterruptedException {
		List<WebElement> productCategory_list = InventoryPage.super.findAllElements(All_Locators.XPATH,
				"//li[@tabindex='-1']");
		for (WebElement ele : productCategory_list) {
			String productCategoryValues = ele.getText();
			if (productCategoryValues.equalsIgnoreCase(productCategory)) {
				ele.click();
				break;
			}
		}
	}

	public void enterUnitOfMeasure(String unit) {
		WebElement unit_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH,
				"//input[@placeholder='Enter Unit of Measure']");
		unit_ele.sendKeys(unit);
	}

	public void enterShortDescription(String description) {
		WebElement description_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH,
				"//input[@placeholder='Enter Short Description']");
		description_ele.sendKeys(description);
	}

	public void clickAddNewProductButton() {
		WebElement addNewProduct_button = InventoryPage.super.findAnyElement(All_Locators.XPATH,
				"//span[text()='Add new product']");
		addNewProduct_button.click();
	}

	public void clickOnAddNewCategory() {
		WebElement addnewcategory_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH,
				"//a[@href='/addNewCategory']");
		addnewcategory_ele.click();
	}

	public void enterCategoryName(String categoryName) {
		WebElement categoryName_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH,
				"//input[@placeholder='Enter Category Name']");
		categoryName_ele.sendKeys(categoryName);
	}

	public void enterDescriptionForCategory(String categoryDescription) {
		WebElement categoryDescription_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH,
				"//input[@placeholder='Enter Description']");
		categoryDescription_ele.sendKeys(categoryDescription);
	}

	public void clickAddNewCategory() {
		WebElement addNewCategory_ele = InventoryPage.super.findAnyElement(All_Locators.XPATH,
				"//span[text()='Add new category']");
		addNewCategory_ele.click();
	}
}
