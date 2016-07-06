package com.qa.advance1.start;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class home_4 {

	private WebDriver driver;

	@FindBy(id="repository_name")
	private WebElement create;

	@FindBy(id="repository_auto_init")
	private WebElement read;

	@FindBy(className="btn-primary")
	WebElement submit1;



	private WebElement submit;

	public home_4 (WebDriver driver){
		this.driver=driver;

		PageFactory.initElements(driver, this);


	}
	data obj=new data();


	public void start() throws FileNotFoundException
	{
		create.click();
		String pa=(String)obj.fetchData("repoName");
	
		create.sendKeys(pa);
		read.click();
		submit1.click();
	}

}

