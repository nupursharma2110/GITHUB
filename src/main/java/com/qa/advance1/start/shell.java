package com.qa.advance1.start;
import com.qa.advance1.start.data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class shell {
	WebDriver driver;
	String comment;
	String RepoName;
	String s;
	data obj=new data();
	
	public shell(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public List<String> push() throws IOException, InterruptedException{
		
	File file;
	FileWriter fw;
	PrintWriter pw;	
	Process p;
	String text=null; 
	String line1 = null;
	String line2 = null;
	List<String> list = new ArrayList<String>();
	String UserName=(String)obj.fetchData("username");    
	String Passwd=(String)obj.fetchData("password");
	String txtFile=(String)obj.fetchData("txtfile");
    RepoName=(String)obj.fetchData("repoName");
    String CloneUrl="https://github.com/"+UserName+"/"+RepoName+".git";
    String shpath=(String)obj.fetchData("shpath"); 
    comment=(String)obj.fetchData("commitMessage")+System.currentTimeMillis();
    //String batFilePath=(String)obj.fetchData("clone_batFile_path"); 
    
    
    file = new File(shpath);
	file.createNewFile();
    file.setExecutable(true);
	fw = new FileWriter(file.getAbsoluteFile());
	pw = new PrintWriter(fw);
    pw.println("#!/bin/bash"); 
    pw.println("cd Desktop");
    pw.println("git clone "+CloneUrl);
    pw.println("cd "+ RepoName);
    pw.println("touch "+txtFile);
    pw.println("git add "+txtFile);
    pw.println("git status");
    pw.println("git commit -m \""+comment+"\"");
    pw.println("git status");
    pw.println("git push http://"+UserName+":"+Passwd+"@github.com/"+UserName+"/"+RepoName+".git");
    pw.close();	
    p=new ProcessBuilder(shpath).start();
    int rc = p.waitFor();
    
    InputStream is = p.getInputStream();
	BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	while ((line1 = reader.readLine()) != null) 
	{
		break;
	}
	while ((line2 = reader.readLine()) != null) 
	{
		text=reader.readLine();
	}
	list.add(comment);
	list.add(line1);
	list.add(text);
	return list;
}
	
	public void refresh_browser()
	{
		driver.navigate().refresh();
	}
	
	}

