package com.qa.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlsUtils {
	public globalVar global = new globalVar();
	
	public static String getExcelPath(String testDataSheetFullPath) {
		String path = "C:/Users/jitvishw/git/Jitendra-02091993/Jitendra-02091993/src/test/resources/testData/"+globalVar.globalTestDataFile+"";
		return path;
	}
	
	public static int getWorksheetCount(String testDataSheetFullPath) {
		String path = getExcelPath(testDataSheetFullPath);
		int numberOfSheets = 0;
        try (FileInputStream fis = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            numberOfSheets = workbook.getNumberOfSheets();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numberOfSheets;
    }
	
//	public static String getDataFromExcel(String sheet , String testDataSheetFullPath) {
//		String path = getExcelPath(testDataSheetFullPath);
////		int countOfSheets = getWorksheetCount(testDataSheetFullPath);
//		try (FileInputStream fis = new FileInputStream(path);
//	             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//				 XSSFSheet sheets = workbook.getSheet(sheet);
//				//get all rows in the sheet
//			        int rowCount=sheets.getLastRowNum()-sheets.getFirstRowNum();
//			        Row row = 
//			        int columnCount = 
//			        
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//		
//		
//	}
	public static String getValue(String fullTestId) throws IOException {
        String[] parts = fullTestId.split("\\.");
        String testCaseNumber = parts[0];
        String fieldName = parts[1];
        String valueName = parts[2];

        // Determine environment
        String environment = System.getenv("ENV");
        if (environment == null) {
            environment = "QA"; // default environment
        }

        // Load Excel file
//        String filePath = "src/testData/" + environment + "/" + "dataFile.xlsx"; // Adjust filename as needed
		String excelPath = getExcelPath(globalVar.globalTestDataFile);
        FileInputStream fileInputStream = new FileInputStream(excelPath);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

        String dataString = "undefined";
        
        // Iterate through rows to find matching test case number and field name
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Cell testCaseCell = row.getCell(0); // Assuming Test Case Number is in the first column
            Cell fieldCell = row.getCell(1); // Assuming Field Name is in the second column
            
            if (testCaseCell != null && testCaseCell.getStringCellValue().equals(testCaseNumber) &&
                fieldCell != null && fieldCell.getStringCellValue().equals(fieldName)) {
                
                Cell valueCell = row.getCell(2); // Assuming Value is in the third column
                if (valueCell != null){
                    dataString = valueCell.getStringCellValue();
                }
                break; // Exit loop once found
            }
        }

        workbook.close();
        return dataString;
    }

		
	}