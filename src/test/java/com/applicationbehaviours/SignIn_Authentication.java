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
				System.out.println("Authenticatio header is displayed");
			}else
			{
				System.out.println("Authentication header is not displayed");
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
		
	}

}
