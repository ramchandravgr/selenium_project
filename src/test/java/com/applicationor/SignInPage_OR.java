package com.applicationor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage_OR {
	
	
	//******************************* Create Account *****************************************
	
	@FindBy(xpath="//h1[text()='Authentication']")
	public WebElement heading_authentication;
	
	@FindBy(xpath="//h3[text()='Create an account']")
	public WebElement heading_createAnAccount;
	
	@FindBy(xpath="//h3[text()='//h3[text()='Already registered?']']")
	public WebElement heading_AlreadyRegistered;
	
	@FindBy(xpath="//input[@id='email_create']")
	public WebElement txt_emailCcreate;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	public WebElement btn_CreateAccount;
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement txt_emailRegistered;
	
	@FindBy(xpath="//input[@id='passwd']")
	public WebElement txt_password;
	
	@FindBy(xpath="//a[text()='Forgot your password?']")
	public WebElement link_forgotPassword;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	public WebElement btn_SignIn;
	
	

}
