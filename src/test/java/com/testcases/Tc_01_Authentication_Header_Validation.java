package com.testcases;

import org.testng.annotations.Test;

import com.applicationbehaviours.SignIn_Authentication;
import com.commonutilities.CommonUtilities;

public class Tc_01_Authentication_Header_Validation extends CommonUtilities{

	
	@Test
	public static void Tc_01_Authentication_Header_Validation() throws Exception {
		
		//String url="http://automationpractice.com/index.php?controller=authentication&back=my-account";
		launchApplication("CHROME", getExcelData("TestData","Url"));
		
		SignIn_Authentication signin=new SignIn_Authentication();
		
		signin.verify_Authentication_Page_Display();
		signin.createAccount();			

	}	
	

}
