package com.commonutilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class LaunchBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CommonUtilities cu = new CommonUtilities();
		cu.launchApplication("chrome", "https://google.com");
		
		try {
		WebElement element=cu.driver.findElement(By.xpath("//input[@name='q']"));
		cu.waitForVisbilityOfElement("Link", "HomePage", element, 1000);
		cu.fluentWaitElementToBeClickable("SearchBox", "Google", element, 10, 2);
		}
		
		catch(Exception e)
		{
			System.out.println("Element not found");
		}
		
		
		
		cu.driver.quit();
	}

}
