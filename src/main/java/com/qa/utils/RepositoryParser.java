package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class RepositoryParser {
	private FileInputStream stream;
	private String RepositoryFile;
	private Properties propertyFile = new Properties();
	
	public RepositoryParser(String fileName) {
		try {
			this.RepositoryFile = fileName;
			stream = new FileInputStream(RepositoryFile);
			propertyFile.load(stream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public By getObjectLocator(String locatorName) {
		String locatorProperty = propertyFile.getProperty(locatorName);
		System.out.println(locatorProperty.toString());
		String locatorType = locatorProperty.split(":")[0];
		String locatorValue = locatorProperty.split(":")[1];
		By locator = null;
		switch(locatorType) {
		case "Id":
				locator = By.id(locatorValue);
				break;
		case "Xpath":
				locator = By.xpath(locatorValue);
		}
		return locator;
	}

}
