package com.excelplugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.annotations.Annotations;
import com.applicationbehaviours.Credentials;
import com.applicationbehaviours.SignIn_Authentication;

public class ExcelParser extends Annotations {

	SoftAssert asrt = new SoftAssert();

	public static XSSFWorkbook workbook;

	public static String crntTestCase;

	public ExcelParser() {
		try {
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
		} catch (Exception e) {
			Assert.assertFalse(false, "Error in loading excel");
			System.out.println();
			System.out.println(e.getStackTrace());
		}
	}

	public static int getRowCount(String sheetName) {

		return workbook.getSheet(sheetName).getLastRowNum();

	}

	public static int getColumnCount(String sheetName) {

		return workbook.getSheet(sheetName).getRow(0).getLastCellNum();

	}

	public static int searchTestCase(String sheetName) {
		int rowNum = 0;
		int rowCount = getRowCount(sheetName);
		for (int r = 1; r <= rowCount; r++) {
			String crntTestCaseName = workbook.getSheet(sheetName).getRow(r).getCell(0).getStringCellValue();
			if (crntTestCaseName.trim().equals(crntTestCase)) {
				rowNum = r;
				System.out.println("The TestCase" + crntTestCase + "is found at row number " + r);
				break;
			}
		}
		return rowNum;
	}

	// search column number method
	public static int searchColumn(String sheetName, String columnName) {
		int ColumnNum = 0;
		int columnCount = getColumnCount(sheetName);
		for (int r = 1; r <= columnCount; r++) {
			String crntTestCaseName = workbook.getSheet(sheetName).getRow(0).getCell(r).getStringCellValue();
			if (crntTestCaseName.trim().equals(columnName)) {
				ColumnNum = r;
				System.out.println("The ColumnName " + columnName + "is found at column number " + (r + 1));
				break;
			}
		}
		return ColumnNum;
	}

	// getting cell value method
	public static String getExcelData(String sheetName, String columnName) throws Exception {

		String data = "";

		int rownumber = searchTestCase(sheetName);
		int colnumber = searchColumn(sheetName, columnName);
		if (rownumber != 0 && colnumber != 0) {
			switch (workbook.getSheet(sheetName).getRow(rownumber).getCell(colnumber).getCellTypeEnum()) {

			case STRING:
				data = workbook.getSheet(sheetName).getRow(rownumber).getCell(colnumber).getStringCellValue();
				break;

			case NUMERIC:

				data = String.valueOf(
						workbook.getSheet(sheetName).getRow(rownumber).getCell(colnumber).getNumericCellValue());
				break;

			}
		}

		if (data.isEmpty()) {
			throw new Exception(
					"Test Data not found fo the test case " + crntTestCase + " Under the sheet " + sheetName);
		}
		return data;

	}

	// writing data to new excel file
	public static String createWorkBookFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		Date d = new Date();

		String crntdate = sdf.format(d);
		String path = "./CredentialsData/" + crntdate;
		File f = new File(path);

		if (!f.exists()) {
			f.mkdirs();
		}

		return path;

	}

	public static void writeDataToExcel(List<Credentials> credentials) throws IOException {
		SignIn_Authentication signin = new SignIn_Authentication();
		XSSFWorkbook workbook = new XSSFWorkbook();
		FileOutputStream fos = new FileOutputStream(createWorkBookFolder() + "/" + "Credentials.xlsx");
		XSSFSheet sheet = workbook.createSheet("Credentials");
		//create new row
		XSSFRow row = sheet.createRow(0);
		//create columns username , password
		row.createCell(0).setCellValue("UserName");
		row.createCell(1).setCellValue("Password");
		
		//storing list data to excel	
		int rownum = 1;
		for (Credentials credential : credentials) {
			row = sheet.createRow(rownum);			
			row.createCell(0).setCellValue(credential.getUsername());
			row.createCell(1).setCellValue(credential.getPassword());			
			rownum++;
		}
		workbook.write(fos);
		fos.close();
	}
}
