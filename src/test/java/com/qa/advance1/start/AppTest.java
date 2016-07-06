package com.qa.advance1.start;

import java.util.List;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.advance1.start.App;
import com.qa.advance1.start.home_3;
import com.qa.advance1.start.home_4;
import com.qa.advance1.start.home2;
import com.qa.advance1.start.shell;


public class AppTest
    {
	WebDriver driver;


	@BeforeTest
	public void setup(){
		driver =new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://github.com/");
	}


	@Test(priority=1)
	public void proceed() throws IOException, InterruptedException{
		
		System.out.println("into proceed");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		App h1 = new App(driver);
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "How people build software · GitHub");
		h1.account();

		home2 h2 = new home2(driver);
		System.out.println(driver.getTitle());
        	Assert.assertEquals(driver.getTitle(), "Sign in to GitHub · GitHub");
		h2.signin();
		
                home_3 h3 = new home_3(driver);
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"GitHub");
		h3.start();

		home_4 h4=new home_4(driver);
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Create a New Repository");
		h4.start();
		
	}
		
		
		
	        @Test(priority=2)
	        public void authenticatepush() throws IOException, InterruptedException
	        {
		shell clone = new shell(driver);
		List<String> commit;
		commit= clone.push();
		Thread.sleep(2000);
		clone.refresh_browser();
		Assert.assertTrue(commit.get(1).contains("On branch master"));	
	        }

			
		

	}



    

