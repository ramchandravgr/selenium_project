package com.testcases;

import org.testng.annotations.Test;

import com.applicationbehaviours.HomePage;
import com.applicationbehaviours.SignIn_Authentication;
import com.commonutilities.CommonUtilities;

public class Tc_01_Authentication_Header_Validation extends CommonUtilities{

	
	@Test
	public static void Tc_01_Authentication_Header_Validation() throws Exception {
		
		
		launchApplication("CHROME", getExcelData("TestData","Url"));
		
		HomePage home = new HomePage();		
		SignIn_Authentication signin=new SignIn_Authentication();
		
		
		home.navigateToSignInPage();
		signin.verify_Authentication_Page_Display();
		signin.createAccount();			

	}	
	

}
