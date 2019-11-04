package com.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.applicationbehaviours.CreateAccount;
import com.applicationbehaviours.Credentials;
import com.applicationbehaviours.HomePage;
import com.applicationbehaviours.SignIn_Authentication;
import com.applicationor.CreateAccount_OR;
import com.commonutilities.CommonUtilities;

public class Tc_01_Authentication_Header_Validation extends CommonUtilities{

	
	@Test
	public static void Tc_01_Authentication_Header_Validation() throws Exception {
		
		
		launchApplication("CHROME", getExcelData("TestData","Url"));
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		HomePage home = new HomePage();			
		SignIn_Authentication signin=new SignIn_Authentication();
		CreateAccount createAcnt= new CreateAccount();
		CreateAccount_OR createAcntOR = new CreateAccount_OR();
		
		
		home.navigateToSignInPage();
		signin.verify_Authentication_Page_Display();
		for(int i=1;i<=3;i++)
		{
		signin.createAccount();	
		//waitForVisbilityOfElement("Title", "Registration",createAcntOR.txt_firstName, 4000);
		createAcnt.accountRegister();
		signin.signOut();
		}
		
		
		
		System.out.println(signin.credentials);
		

		for(Credentials credential : signin.credentials) {
			
			System.out.println(credential.getUsername());
			System.out.println(credential.getPassword());
			
		}
		
		writeDataToExcel(signin.credentials);
		
		
	}	
	

}
