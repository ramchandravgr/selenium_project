package com.applicationbehaviours;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.applicationor.HomePage_OR;
import com.commonutilities.CommonUtilities;

public class HomePage extends CommonUtilities {

	public HomePage_OR homePageOR;
	
	public HomePage()
	{
		if(homePageOR==null)homePageOR=PageFactory.initElements(driver, HomePage_OR.class);
		
	}
	
	
	public void Search_Box(String search_text) {
		boolean status = true;

		try {

			status = isDisplayed("Search Box", "Home Page", homePageOR.edi_SearchBox);
			if (status) {
				System.out.println("Search Box is displayed");
			} else {
				System.out.println("Search Box is not displayed");
			}
			
		} 
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
			
		HomePage.sendData("Search Box", "Home Page", homePageOR.edi_SearchBox , search_text);
		
		HomePage.elementClick("Search Box", "Home Page", homePageOR.btn_Search);
		
		try {
			if(search_text != "t-shirts" || search_text != "women" || search_text !="dresses")
			{
				status = isDisplayed("Search Error", "Search Results", homePageOR.Search_result_error);
				if (status) {
					System.out.println("Error message is displayed");
				} else {
					System.out.println("Error message is not displayed");
				}
				
				//WebElement search_result_error_text = homePageOR.Search_result_error;
				//String error_text = search_result_error_text.getText();
				//error_text.compareTo(arg0);
				
				
			}
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}
	
	
}