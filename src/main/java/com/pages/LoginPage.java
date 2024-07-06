package com.pages;
import org.openqa.selenium.WebDriver;
import com.locators.LoginPageLocators;

public class LoginPage {
	public WebDriver driver;
	public LoginPageLocators loginPageLocators = new LoginPageLocators();
	
	// Constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public void launchUrl() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	public String getText() {
		return driver.findElement(loginPageLocators.loginHeaderTxt).getText();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void enterText(String userName) {
		driver.findElement(loginPageLocators.usernameInputTextBox).sendKeys(userName);
	}
	
	public void click() {
		driver.findElement(loginPageLocators.loginButton).click();
	}
}
