package com.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.listener.Sel_Listener;


public class TestBase {	
	
	public static WebDriver driver=null;
	public static Logger log = Logger.getLogger(TestBase.class);
	public static EventFiringWebDriver edriver=null;
	
	public static WebDriver initialization() {
		log.info("initializing  chrome browser");
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		driver = new ChromeDriver();
		
		edriver = new EventFiringWebDriver(driver);
		Sel_Listener selList= new Sel_Listener();
		edriver.register(selList);
		driver=edriver;
		log.info("launching JBK offline application");
		edriver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		edriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		edriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.info("returning a initialized driver object");
		return edriver;
	}
	
	
public static  void takeScreenshot() {
	
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
		String name="Demo"+ sdf.format(new Date())+".png";///   Demo15052021091540.png
		log.info("taking a screenshot");
		TakesScreenshot ts = (TakesScreenshot)edriver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		log.info("saving a file with name: "+name);
		File dest = new File(System.getProperty("user.dir")+"/screenshot/"+name);
		try {
			log.warn("file location should be proper");
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			log.error("file not saved properly");
			e.printStackTrace();
		}
		
	}
	
}

