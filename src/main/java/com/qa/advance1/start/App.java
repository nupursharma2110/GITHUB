package com.qa.advance1.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class App {
	private WebDriver driver;

	@FindBy(xpath="//a[text()='Sign in']")
	private WebElement signin;





	public App (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);


	}



	public void account()
	{

		signin.click();
	}

}

