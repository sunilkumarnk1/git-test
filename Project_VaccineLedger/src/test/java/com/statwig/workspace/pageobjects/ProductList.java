package com.statwig.workspace.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import com.statwig.workspace.utility.BasePage.All_Locators;

public class ProductList extends BasePage{

	public ProductList(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickUser() {
		WebElement user_ele=ProductList.super.findAnyElement(All_Locators.XPATH, "//p[text()='User']");
		user_ele.click();
	}
	
	public void switchToAdmin() {
		WebElement switchAdmin_ele=ProductList.super.findAnyElement(All_Locators.XPATH, "//button[text()='Switch to Admin']");
		switchAdmin_ele.click();
	}
	
	public void clickProductList() {
		WebElement productList_ele=ProductList.super.findAnyElement(All_Locators.XPATH, "//p[text()='Product List']");
		productList_ele.click();
	}
	
	public void clickProductCategory() {
		WebElement productCategory_ele=ProductList.super.findAnyElement(All_Locators.ID,"mui-5");
		productCategory_ele.click();
	}
	
	public void selectProductCategory(String productCategory) throws AWTException {
		 WebElement org_type=ProductList.super.findAnyElement(All_Locators.ID,"mui-5");
	        org_type.sendKeys(productCategory);

	        Robot robot=new Robot();
	        robot.delay(250);
	        robot.keyPress(KeyEvent.VK_DOWN);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_DOWN);
	        robot.keyRelease(KeyEvent.VK_ENTER);

	    }	
}

