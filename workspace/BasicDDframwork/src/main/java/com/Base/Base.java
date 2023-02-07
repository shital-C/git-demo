package com.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import com.Utility.TestUtil;
import com.Utility.WebEventListener;


public class Base {
	public WebDriver driver;
 public Properties prop;
 public static EventFiringWebDriver e_driver;
 public static WebEventListener eventListener;

	
public WebDriver initializeDriver() throws IOException {
		Properties prop=new Properties();
		FileInputStream ip=new FileInputStream("D:\\shital\\workspace\\BasicDDframwork\\src\\main\\java\\com\\Config\\config.properties");
		prop.load(ip);
		String brawserName=prop.getProperty("Brawser");
		if(brawserName.equals("Chrome")) {
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\amitn\\eclipse-workspace\\FramworkDesign\\src\\main\\resources\\driver\\chromedriver.exe");
		driver=new ChromeDriver(option);
		//log.info("Lounched Brawser");
		}
		
		else if(brawserName.equals("FireFox")){
			System.setProperty("webdriver.fireFox.driver", "D:\\shital\\workspace\\BasicDDframwork\\Driver\\geckodriver.exe");
		driver=new FirefoxDriver();
		}
		
		else if(brawserName.equals("IE")) {
			
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
				e_driver.register(eventListener);
				driver = e_driver;

driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		//log.info("open url");
		
		return driver;
}



}
