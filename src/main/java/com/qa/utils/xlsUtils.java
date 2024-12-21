package com.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;

public class xlsUtils {
	private WebDriver driver;
	public globalVar global = new globalVar(DriverFactory.getDriver());
	
	// Constructor of the page class
			public xlsUtils(WebDriver driver) {
				this.driver = driver;
			}
	
	public static String getExcelPath(String testDataSheetFullPath) {
		String path = "/opensource-demo.orangehrmlive.com/src/testData/"+globalVar.globalTestDataFile+"";
		return path;
	}
	
	public static int getWorksheetCount(String testDataSheetFullPath) {
		String path = "C:/Users/jitvishw/git/Jitendra-02091993/Jitendra-02091993/src/test/resources/testData/"+globalVar.globalTestDataFile+"";
		System.out.println(path);
		int numberOfSheets = 0;
        try (FileInputStream fis = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            numberOfSheets = workbook.getNumberOfSheets();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numberOfSheets;
    }

		
	}