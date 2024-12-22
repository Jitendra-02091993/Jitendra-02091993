package com.pages;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.qa.utils.CommonStepsAction;

public class LoginPage {
	public WebDriver driver;
	CommonStepsAction action = new CommonStepsAction(driver);
	private static Logger logger = LogManager.getLogger(LoginPage.class);
	
	
	// Constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getText(String ele) {
		logger.info("Text get");
		return action.getElement(ele).getText();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void enterText(String userName, String ele) {
		action.getElement(ele).sendKeys(userName);
		logger.info("Text is entered");
	}
	
	public void click(String ele) {
		action.getElement(ele).click();
	}
}
