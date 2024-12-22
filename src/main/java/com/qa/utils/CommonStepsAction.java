package com.qa.utils;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.datatable.DataTable;

public class CommonStepsAction {
	private WebDriver driver;
	private RepositoryParser parser;
	public ConfigReader configReader = new ConfigReader();
	

	// Constructor of the page class
	public CommonStepsAction(WebDriver driver) {
		this.driver = driver;
	}

//		public WebElement getElement(String ele) {
//			parser = new RepositoryParser("./src/test/resources/configFile/loginPageLocators.properties");
//			return driver.findElement(parser.getObjectLocator(ele));
//		}

	public WebElement getElement(String ele) {
		// List of all locator properties files
		List<String> locatorFiles = List.of("./src/test/resources/configFile/loginPageLocators.properties"
		// Add more paths as needed
		);
		parser = new RepositoryParser(locatorFiles);
		return driver.findElement(parser.getObjectLocator(ele));
	}

	public void enterText(String text, String ele) {
		WebElement elem = getElement(ele);
		elem.sendKeys(text);
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

	public static void wait(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitAndVerifyIfElementIsDisplayed(String ele) {
		try {
			WebElement element = getElement(ele);
			if (element.isDisplayed() == true) {
				System.out.println("Element Visibility is: " + element.isDisplayed());
			} else {
				System.out.println("Element Visibility is: " + element.isDisplayed());
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		}

	}

	public void testDataTableVerification(DataTable dataTable) {
		// Wait for a few seconds if necessary
		wait(2);

		// Convert DataTable to List<List<String>>
		List<List<String>> rows = dataTable.asLists(String.class);

		// Iterate through each row
		for (List<String> row : rows) {
			String elementLocator = row.get(0); // Get the first column which contains locators
			WebElement ele = getElement(elementLocator);
			// Check if the element is displayed and print its status
			boolean isDisplayed = ele.isDisplayed();
			System.out.println("Element: " + elementLocator + " Visibility Status: " + isDisplayed);
			assertTrue(isDisplayed == true);
		}
	}
}
