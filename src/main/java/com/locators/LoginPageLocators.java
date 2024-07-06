package com.locators;

import org.openqa.selenium.By;

public class LoginPageLocators {
	public By logo = By.xpath("//img[@alt='company-branding']");
	public By loginHeaderTxt = By.xpath("//h5[.='Login']");
	public By usernameText = By.xpath("//p[normalize-space()='Username : Admin']");
	public By passwordText = By.xpath("//p[normalize-space()='Password : admin123']");
	public By usernameInputTextBox = By.xpath("//input[@placeholder='Username']");
	public By passwordInputTextBox = By.xpath("//input[@placeholder='Password']");
	public By loginButton = By.xpath("//button[normalize-space()='Login']");
	public By forgetPasswordLinkText = By.xpath("//div[@class='orangehrm-login-forgot']");
}
