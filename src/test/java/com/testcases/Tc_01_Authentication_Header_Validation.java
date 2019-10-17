package com.testcases;

import com.applicationbehaviours.SignIn_Authentication;
import com.commonutilities.CommonUtilities;

public class Tc_01_Authentication_Header_Validation extends CommonUtilities{

	public static void main(String[] args) {
		
		String url="http://automationpractice.com/index.php?controller=authentication&back=my-account";
		launchApplication("CHROME", url);
		
		SignIn_Authentication signin=new SignIn_Authentication();
		
		signin.verify_Authentication_Page_Display();
		signin.createAccount();
		
		

	}

}
