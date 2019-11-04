package com.applicationbehaviours;

import org.openqa.selenium.support.PageFactory;

import com.applicationor.CreateAccount_OR;
import com.applicationor.HomePage_OR;
import com.commonutilities.CommonUtilities;
import com.commonutilities.FakerData;

public class CreateAccount extends CommonUtilities {
	
	public CreateAccount_OR createAccountOR;
	FakerData f = new FakerData();
	
	public CreateAccount()
	{
		if(createAccountOR==null)createAccountOR=PageFactory.initElements(driver, CreateAccount_OR.class);
		
	}
	
	public void accountRegister() {
		//Title
		elementClick("title", "Registration", createAccountOR.radio_title_Mrs);
		//Firstname
		sendData("FirstName", "Registration", createAccountOR.txt_firstName, f.getFirstname());
		System.out.println("Firstname "+f.getFirstname());
		//Lastname
		sendData("LastName", "Registration", createAccountOR.txt_lastName, f.getLastname());
		
		//Email
		//sendData("Email", "Registration", createAccountOR.txt_Email, f.getEmail());
		
		//Password
		sendData("Password", "Registration", createAccountOR.txt_Password, f.getPassword());
		
		//DateOfBirth
		selectDropDownByIndex("DOB_Day", "Registration", createAccountOR.select_Day, 1);
		selectDropDownByIndex("DOB_month", "Registration", createAccountOR.select_Month, 1);
		selectDropDownByIndex("DOB_year", "Registration", createAccountOR.select_Years, 1);
		
		//Address fields
		
		//firstname
		sendData("Address_firstName", "Registration", createAccountOR.txt_address_FirstName, f.getAddress_firstname());
		
		//lastname
		sendData("Address_lastName", "Registration", createAccountOR.txt_address_LastName, f.getAddress_lastname());
		
		
		//company
		//sendData("Company", "Registration", createAccountOR.txt_address_Company,f.getAddress_company());
		
		
		//full address
		sendData("Address_address", "Registration", createAccountOR.txt_address_Address, f.getAddress_address());
		
		
		//city
		sendData("City", "Registration", createAccountOR.txt_address_City, f.getCity());
		
		//state
		selectDropDownByIndex("State", "registration", createAccountOR.select_State, 1);
		
		
		
		//zipcode
		sendData("Zipcode", "Registration", createAccountOR.txt_Zipcode, f.getZipcode());
		
		
		//country
		
		selectDropDownByIndex("country", "registration", createAccountOR.select_Country, 1);
		
		//mobile number
		sendData("mobile", "Registration", createAccountOR.txt_Mobile, "1234567890");
		
		
		//Alternate address
		sendData("AlternateAddress", "Registration", createAccountOR.txt_AlternateAdress, f.getAlternateAddress());
		
		
		//click register button
		elementClick("Register", "registration", createAccountOR.btn_Register);
		
		//signout
		
		
	}
	
}
