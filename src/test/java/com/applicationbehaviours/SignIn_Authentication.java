package com.applicationbehaviours;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.applicationor.SignInPage_OR;
import com.commonutilities.CommonUtilities;
import com.commonutilities.FakerData;

import junit.framework.Assert;

public class SignIn_Authentication extends CommonUtilities{
	
	
	public SignInPage_OR signInPageOR;
	
	public List<Credentials> credentials=new ArrayList();
	
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
	
	public static String DynamicEmailUsername()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date d = new Date();
		String crntDate = sdf.format(d);
		//System.out.println(crntDate);
		String emailUsername = "lakshmi"+crntDate+"@gmail.com";
		System.out.println("email username is :"+emailUsername);
		return emailUsername;
		
	}
	
	public void createAccount() {
		FakerData fd = new FakerData();
		boolean status = true;

			status = isDisplayed("CreateAccountEmail", "SignIn", signInPageOR.txt_emailCcreate);
			if(status) {
				System.out.println("Email address field is displayed");
				logStatus("pass", "Email address field is displayed");
			}
			else {
				System.out.println("Email address field is not displayed");
				logStatus("fail", "Email address field is not displayed");
				Assert.fail("Email address field is not displayed");
				
			}
			sendData("createAccount_Email", "SignIn", signInPageOR.txt_emailCcreate,fd.getEmail());
			
			credentials.add(new Credentials(fd.getEmail(), fd.getPassword()));
		
		
		try {
			status = isDisplayed("CreateAccount_SubmitBtn", "Sign", signInPageOR.btn_CreateAccount);
			if(status) {
				System.out.println("Create Account Button is displayed");
				logStatus("pass", "Create Account Button is displayed");
			}
			else {
				System.out.println("Create Account Button is not displayed");
				logStatus("fail", "Create Account Button is not displayed");
				Assert.fail("Create Account Button is not displayed");
			}
			elementClick("CreateAccount_Btn", "SignIn", signInPageOR.btn_CreateAccount);
			
		}catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
		
	}
	
	public  void signOut() {
		elementClick("signout", "My account",signInPageOR.lnk_signout);
	}

}
