package com.reporting;

import com.commonutilities.CommonUtilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class Reporting {
	
	public static ExtentReports extent;
	
	public static ExtentTest test;
	
	public static void intializeReport(String testcasename)
	{System.out.println("Intializing Extent Report");
		extent=new ExtentReports(createResultFolder()+"/"+testcasename+".html");
		extent.addSystemInfo("Environment","QA")
		.addSystemInfo("Sprint #","1");
		
	}
	
	public static void startReporting(String testcasename)
	{
		test=extent.startTest(testcasename);
	}
	
	public static void endReport()
	{
		extent.endTest(test);
	}
	
	public static void flushReport()
	{	
		extent.flush();
	}
	
	public static void logStatus(String status,String description)
	{
		switch (status.toLowerCase()) {
		case "pass":
			test.log(LogStatus.PASS, description+test.addBase64ScreenShot(getScreenShot()));
			
			break;
			
		case "fail":
			test.log(LogStatus.FAIL, description+test.addBase64ScreenShot(getScreenShot()));
			break;
			
		case "warning":
			test.log(LogStatus.WARNING, description);
			break;
			
	
		default:
			break;
		}
	}
	
	
	
	public static String createResultFolder()
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		
		Date d=new Date();
		
		String crntdate=sdf.format(d);
		String path="./Results/"+crntdate;
		
		
		File f=new File(path);
		
		if(!f.exists())
		{
			f.mkdirs();
		}
		
		return path;
		
		
	}
	
	
public static String getScreenShot()
{
	String scnShot = ((TakesScreenshot) CommonUtilities.driver).getScreenshotAs(OutputType.BASE64);
	return "data:image/png;base64,"+scnShot;
}
	
	
	

}
