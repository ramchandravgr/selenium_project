package com.annotations;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.excelplugin.ExcelParser;
import com.reporting.Reporting;

public class Annotations {

	@BeforeSuite
	public void intializeTestSuite() 
	{
		
		try {
			ExcelParser parser=new ExcelParser();			
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@BeforeMethod
	public void getTestCaseDetails(Method m)
	{
		System.out.println(m.getName());
		
		ExcelParser.crntTestCase=m.getName().trim();
		Reporting.intializeReport(ExcelParser.crntTestCase);
		Reporting.startReporting(ExcelParser.crntTestCase);
	}
	
	@AfterMethod
	public void publishReport()
	{
		Reporting.flushReport();
	}
	
	
	
}
