package com.testcases;

import com.applicationbehaviours.HomePage;
import com.commonutilities.CommonUtilities;
import com.reporting.Reporting;

public class TC_02_Search_Box_Results extends CommonUtilities{

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Reporting report=new Reporting();
		
		
		String url="http://automationpractice.com/index.php?controller=authentication&back=my-account";
		launchApplication("CHROME", url);
		
		HomePage search_box=new HomePage();
		
		search_box.Search_Box("shoes");
		
		
		report.endReport();
		report.flushReport();
		
		//driver.quit();

	}

}
