package com.qa.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonStepsAction {
	private WebDriver driver;
	private RepositoryParser parser;
	public  ConfigReader configReader = new ConfigReader();
	
	// Constructor of the page class
		public CommonStepsAction(WebDriver driver) {
			this.driver = driver;
		}
		
		public WebElement getElement(String ele) {
			parser = new RepositoryParser("./src/test/resources/configFile/loginPageLocators.properties");
			return driver.findElement(parser.getObjectLocator(ele));
		}
		
		public void enterText(String userName, String ele) {
			WebElement elem = getElement(ele);
			elem.sendKeys(userName);
		}
		
		public void clickElement(String ele) {
			getElement(ele).click();
		}
		

		public void launchUrl() {
			driver.get(configReader.init_prop().getProperty("url"));
		}

		public void waitTime(String value) throws Exception {
			int time = Integer.parseInt(value);
			Thread.sleep(time * 1000);	
		}
		
}
