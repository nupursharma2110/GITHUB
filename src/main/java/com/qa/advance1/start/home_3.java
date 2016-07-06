package com.qa.advance1.start;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Cookie;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;


public class home_3 {
	


	private WebDriver driver;

	@FindBy(xpath="//div[@class='main-content']//a[text()='Start a project']")
	private WebElement start;




	public home_3 (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);


	}


	public void start()
	{
		start.click();
	}




}


