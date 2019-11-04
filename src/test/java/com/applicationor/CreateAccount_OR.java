package com.applicationor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccount_OR {

	@FindBy(xpath="//input[@id='id_gender1']")
	public WebElement radio_title_Mr;
	
	@FindBy(xpath="//input[@id='id_gender2']")
	public WebElement radio_title_Mrs;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	public WebElement txt_firstName;
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	public WebElement txt_lastName;
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement txt_Email;
	
	@FindBy(xpath="//input[@id='passwd']")
	public WebElement txt_Password;
	
	@FindBy(xpath="//select[@id='days']")
	public WebElement select_Day;
	
	@FindBy(xpath="//select[@id='months']")
	public WebElement select_Month;
	
	@FindBy(xpath="//select[@id='years']")
	public WebElement select_Years;
	
	@FindBy(xpath="//input[@id='newsletter']")
	public WebElement checkbox_Newsletter;
	
	@FindBy(xpath="//input[@id='optin']")
	public WebElement checkbox_Specialoffers;
	
	@FindBy(xpath="//input[@id='firstname']")
	public WebElement txt_address_FirstName;
	
	@FindBy(xpath="//input[@id='lastname']")
	public WebElement txt_address_LastName;
	
	@FindBy(xpath="//input[@id='company']")
	public WebElement txt_address_Company;
	
	@FindBy(xpath="//input[@id='address1']")
	public WebElement txt_address_Address;
	
	@FindBy(xpath="//input[@id='address2']")
	public WebElement txt_address_AddressHome;
	
	@FindBy(xpath="//input[@id='city']")
	public WebElement txt_address_City;
	
	@FindBy(xpath="//select[@id='id_state']")
	public WebElement select_State;
	
	@FindBy(xpath="//input[@id='postcode']")
	public WebElement txt_Zipcode;
	
	@FindBy(xpath="//select[@id='id_country']")
	public WebElement select_Country;
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	public WebElement txt_Mobile;
	
	@FindBy(xpath="//input[@id='alias']")
	public WebElement txt_AlternateAdress;
	
	@FindBy(xpath="//button[@id='submitAccount']")
	public WebElement btn_Register;

	
	
	
	
	
}
