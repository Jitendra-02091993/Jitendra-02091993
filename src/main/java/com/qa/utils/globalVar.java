package com.qa.utils;

import org.openqa.selenium.WebDriver;

public class globalVar {
	private WebDriver driver;
	
	public globalVar(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public static String globalTestDataFile = "some value";
	private static String apiResponseName;
	private static String fileUploadTAG = "";
	private static String twilioMobileNumber = "7897014149";
	private static String twilioCountryCodevalue = "+44";
	private static String staticOTP = "251299";
	private static int fundingEndDate = 14;
}
