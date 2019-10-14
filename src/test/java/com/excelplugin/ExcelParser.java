package com.excelplugin;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelParser {
	public XSSFWorkbook workbook;

	ExcelParser() throws Exception {
		System.out.println("Parsing Excel...");
		String path = "./TestData/TestData.xlsx";
		File f = new File(path);
		if (!f.exists()) {
			throw new Exception("TestData workbook not available at " + path);
		} else {
			FileInputStream fis = new FileInputStream(f);
			workbook = new XSSFWorkbook(fis);
			System.out.println("Excel loaded successfully");
		}
	}
	
	public int getRowCount(String sheetName) {
				
		return workbook.getSheet(sheetName).getLastRowNum();		
		
		
	}
	public int getColumnCount(String sheetName) {
		
		return workbook.getSheet(sheetName).getRow(0).getLastCellNum();		
		
		
	}
	
	public int searchTestCase(String sheetName,String testCaseName) {
		int rowNum = 0;
		int rowCount = getRowCount(sheetName);
		for(int r=1;r<=rowCount;r++) {
		String crntTestCaseName = workbook.getSheet(sheetName).getRow(r).getCell(0).getStringCellValue();
		if(crntTestCaseName.trim().equals(testCaseName)) {
			rowNum = r;
			System.out.println("The TestCase"+testCaseName+"is found at row number "+ r);
			break;
		}
		}
		return rowNum;
	}
	// search column number method
	public int searchColumn(String sheetName,String columnName) {
		int ColumnNum = 0;
		int columnCount = getColumnCount(sheetName);
		for(int r=1;r<=columnCount;r++) {
		String crntTestCaseName = workbook.getSheet(sheetName).getRow(0).getCell(r).getStringCellValue();
		if(crntTestCaseName.trim().equals(columnName)) {
			ColumnNum = r;
			System.out.println("The ColumnName "+columnName+"is found at column number "+ (r+1));
			break;
		}
		}
		return ColumnNum;
	}
	//getting cell value method
	public String getExcelData(String sheetName, String testCaseName, String columnName) throws Exception {
		
		String data="";
		
		int rownumber=searchTestCase(sheetName,testCaseName);
		int colnumber=searchColumn(sheetName,columnName);
		if(rownumber!=0 && colnumber!=0)
		{
			switch(workbook.getSheet(sheetName).getRow(rownumber).getCell(colnumber).getCellTypeEnum())
			{
			
			case STRING:
				data=workbook.getSheet(sheetName).getRow(rownumber).getCell(colnumber).getStringCellValue();
				break;
				
			case NUMERIC:
				
				data=String.valueOf(workbook.getSheet(sheetName).getRow(rownumber).getCell(colnumber).getNumericCellValue());
				break;
			
			
			}
		}
		
		if(data.isEmpty())
		{
			throw new Exception ("Test Data not found fo the test case "+testCaseName +" Under the sheet "+sheetName);
		}
		return data;
		
	}
}
