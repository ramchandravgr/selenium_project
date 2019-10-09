package com.commonutilities;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtilities {
	
	static CommonUtilities cu = new CommonUtilities();
	
	public static WebDriver driver;
	
	/**
	 * @author RC 95
	 * @param browsertype,url
	 * @return boolean
	 * @description This method helps the user to launch the browsers like chrome,ff,edge
	 */
	public static boolean launchApplication(String browsertype,String url)
	{
		
		// declare a variable to track the success of execution
		boolean status = true ;
		try {
		
		//check for input parameters
		if(browsertype.isEmpty() || browsertype==null)
		{
			throw new Exception("Browser type cannot be blank or null");
		}
		else 
		{
			System.out.println("Browser type parameter is verified sucessfully");
		}
		
		//check for the URL
		if(url.isEmpty() || url == null || !url.startsWith("https://") )
		{
			throw new Exception("URL cannot be blank or null. URL must start with https://");
		}
		else 
		{
			System.out.println("URL parameter is verified successfully");
		}
		
		System.out.println("Launching application.....!!!");
		
		//Convert the user given argument to lower case to avoid case mismatch
		switch(browsertype.toLowerCase())
		{
		case "chrome" :
			//set the system path
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
			break;
		
		case "firefox" :
			//set the system path
			System.setProperty("webdriver.firefox.driver", "firefoxdriver.exe");
			driver=new FirefoxDriver();
			break;	
			
		default :
			//for any in valid browser, raise your exception
			throw new Exception("Invalid Brower Option "+browsertype);
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("Application is launched sucesfully...!!");
		
		}
		
		catch(Exception e)
		{
			System.out.println("Application is not launched successfully...!!"+e.getMessage());
			status=false;
				
		}
		
		return status;
		
	}

	/**
	 * @author RC 95
	 * @param element
	 * @return extractedXPATH
	 * @description This method helps the user to convert the extracted xpath to identifiable xpath
	 */
	public static String getXpath(WebElement element) 
	{
		String actualXPATH=element.toString();
	
		String extractedXPATH=actualXPATH.substring(actualXPATH.lastIndexOf(":")+1).replace("]", "").trim();
	
		return extractedXPATH;
	}
	
	
	/**
	 * @author RC 95
	 * @param elementName
	 * @param pagename
	 * @param element
	 * @param duration
	 * @return boolean
	 * @description This method helps to wait for the visibility of the element using explicit wait
	 */
	public static boolean waitForVisbilityOfElement(String elementName, String pagename,WebElement element,int duration)
	{
		boolean status = false ;
		try
		{
		 //get the xpath of webelement
			
			String actualXPATH=element.toString();
			
			String extractedXPATH=actualXPATH.substring(actualXPATH.lastIndexOf(":")+1).replace("]", "").trim();
			WebDriverWait wait=new WebDriverWait(driver, duration);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(extractedXPATH)));
			System.out.println("Element "+elementName+" is identified on the page "+pagename);	
		 }
		 catch (Exception e)
		 {
			 System.out.println("Element "+elementName+" not identified in "+duration+" sec");
			 status=false;
		 }
		 
		 return status;
		 
		 
		 
		 
	}
	
	
	/**
	 * @author RC 95
	 * @param elementName
	 * @param pagename
	 * @param element
	 * @param duration
	 * @return boolean
	 * @description This method helps to wait for the element to be clickable using explicit wait
	 */
	public static boolean waitForElementToBeClickable(String elementName, String pagename,WebElement element,int duration)
	{
		boolean status = false ;
		try
		{
		 //get the xpath of webelement
			
			WebDriverWait wait=new WebDriverWait(driver, duration);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cu.getXpath(element))));
			System.out.println("Element "+elementName+" is identified on the page "+pagename);	
		 }
		 catch (Exception e)
		 {
			 System.out.println("Element "+elementName+" not identified in "+duration+" sec");
			 status=false;
		 }
		 
		 return status;	
	}
	
	
	/**
	 * @author RC 95
	 * @param elementName
	 * @param pagename
	 * @param element
	 * @param duration
	 * @return boolean
	 * @description This method helps to wait for the presence of element using explicit wait
	 */
	public static boolean waitForPresenceOfElement(String elementName, String pagename,WebElement element,int duration)
	{
		boolean status = false ;
		try
		{
		 //get the xpath of webelement
			
			WebDriverWait wait=new WebDriverWait(driver, duration);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(cu.getXpath(element))));
			System.out.println("Element "+elementName+" is identified on the page "+pagename);	
		 }
		 catch (Exception e)
		 {
			 System.out.println("Element "+elementName+" not identified in "+duration+" sec");
			 status=false;
		 }
		 
		 return status;	
	}
	
	
	/**
	 * @author RC 95
	 * @param elementName
	 * @param pagename
	 * @param element
	 * @param timeoutduration
	 * @param pollingduration
	 * @return boolean
	 * @description This method helps to wait for the element to be clickable using fluent wait
	 */
	public static boolean fluentWaitElementToBeClickable(String elementName, String pagename, WebElement element,int timeoutduration,int pollingduration)
	{
		boolean status=true;
		try
		{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
				wait.withTimeout(timeoutduration, TimeUnit.SECONDS);
				wait.pollingEvery(pollingduration, TimeUnit.SECONDS);
				wait.ignoring(Exception.class);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				
				System.out.println("Element "+elementName+" is identified on the page "+pagename);
		}
		catch(Exception e)	
		{
			System.out.println(e.getMessage());
			status=false;
		}				
		return status;
	}

}
