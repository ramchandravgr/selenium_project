package com.applicationor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage_OR {

	//********************************* HOME PAGE HEADER SECTION***************
	@FindBy(xpath="//a[normalize-space(text())='Sign in']")
	public WebElement lnk_Signin;
	
	@FindBy(xpath="//input[@id='search_query_top']")
	public WebElement edi_SearchBox;
	
	
	@FindBy(xpath="//button[@name='submit_search']")
	public WebElement btn_Search;
	
	
	@FindBy(xpath="//a[text()= 'Women']")
	public WebElement lnk_Women;
	
	@FindBy(xpath="//div[@id='block_top_menu']//li[1]//a[text()='Dresses']")
	public WebElement lnk_Dresses;
	 
	
	@FindBy(xpath="//div[@ id='block_top_menu']// li[last()]//a[text()='T-shirts']")
	public WebElement lnk_Tshirts;
	
	
	@FindBy(xpath="//a[@title ='View my shopping cart' ]")
	public WebElement lnk_Cart;
	
	@FindBy(xpath="//h1[@id='cart_title']")
	public WebElement cartheading;
	
	@FindBy(xpath="//li[@class='step_current  first']")
	public WebElement Tabs_summary;
	
	@FindBy(xpath="//li[@class='step_current  second']")
	public WebElement Tabs_signin;
	
	
	
	
	
}
