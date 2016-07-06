package com.qa.advance1.start;
import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.InputStream;
	import java.util.Map;
	import org.yaml.snakeyaml.Yaml;
	import org.yaml.snakeyaml.Yaml;

	public class data
	{
	Object obj;
	Map map;
	Yaml yaml;
	InputStream ios;
		 
	public Object fetchData(String key) throws FileNotFoundException
	{
		  String current;
		  current = System.getProperty("user.dir")+"/src/main/java/com/qa/advance1/start/test.yml";
		  
		  ios = new FileInputStream(new File(current));
		  yaml=new Yaml();
		  obj=yaml.load(ios);
		  map=(Map)obj;
		  return  map.get(key);      
			 
	}
	}
	
	

