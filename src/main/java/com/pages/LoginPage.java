package com.pages;
import org.openqa.selenium.WebDriver;
import com.qa.utils.CommonStepsAction;

public class LoginPage {
	public WebDriver driver;
	CommonStepsAction action = new CommonStepsAction(driver);
	
	// Constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getText(String ele) {
		return action.getElement(ele).getText();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void enterText(String userName, String ele) {
		action.getElement(ele).sendKeys(userName);
	}
	
	public void click(String ele) {
		action.getElement(ele).click();
	}
}
