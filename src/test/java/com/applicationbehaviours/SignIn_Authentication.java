package com.applicationbehaviours;

import org.openqa.selenium.support.PageFactory;

import com.applicationor.SignInPage_OR;
import com.commonutilities.CommonUtilities;

public class SignIn_Authentication extends CommonUtilities{
	
	
	public SignInPage_OR signInPageOR;
	
	public SignIn_Authentication()
	{
		if(signInPageOR==null)signInPageOR=PageFactory.initElements(driver, SignInPage_OR.class);
		
	}
	
	
	public void verify_Authentication_Page_Display()
	{
		boolean status=true;
		
		try
		{
			
			status=isDisplayed("Authentication", "Sign In", signInPageOR.heading_authentication);
			if(status)
			{
				System.out.println("Authentication header is displayed");
			}else
			{
				System.out.println("Authentication header is not displayed");
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
		
	}
	
	public void createAccount() {
		boolean status = true;
		try {
			status = isDisplayed("CreateAccountEmail", "SignIn", signInPageOR.txt_emailCcreate);
			if(status) {
				System.out.println("Create Account Email is displayed");
			}
			else {
				System.out.println("Create Account Email is not displayed");
			}
			sendData("createAccount_Email", "SignIn", signInPageOR.txt_emailCcreate, "lakshmigottipati13@gmail.com");
			
			
			
		}catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
		
		try {
			status = isDisplayed("CreateAccount_SubmitBtn", "Sign", signInPageOR.btn_CreateAccount);
			if(status) {
				System.out.println("Create Account Button is displayed");
			}
			else {
				System.out.println("Create Account Button is not displayed");
			}
			elementClick("CreateAccount_Btn", "SignIn", signInPageOR.btn_CreateAccount);
			
		}catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
		
	}

}
