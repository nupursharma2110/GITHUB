package com.qa.advance1.start;
import org.openqa.selenium.WebDriver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class home2 {
	

		private WebDriver driver;
		String pa;
		String a,b;

		@FindBy(id="login_field")
		private WebElement login;

		@FindBy(id="password")
		private WebElement pass;

		
	       @FindBy(name="commit")
		private WebElement sign;
	    
	        String line = null;
	    
	        File file = new File("/home/nupursharma/Desktop/op.csv");
	    


		public home2 (WebDriver driver){
			this.driver=driver;

			PageFactory.initElements(driver, this);

		}
                data obj=new data();


		public void signin() throws IOException
		{   
		   String var_1=(String)obj.fetchData("username");
		   String var_3=(String)obj.fetchData("password");
		    login.click();
			login.sendKeys(var_1);
			
			pass.click();
			pass.sendKeys(var_3);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			sign.click();
		    }

		}

	



