package com.TestCases;


import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.Base;

import Page.HomePage;
import Page.LoginPage;


	public class HomepageTest extends Base{	
		HomePage hp;
		LoginPage loginPage;
	
	
@BeforeTest
@Test
public void Homenevigation() throws IOException, InterruptedException {
	driver=initializeDriver();
	//log.info("driver is initialised");
	//log.info("open url");
	HomePage hp=new HomePage(driver);
	//log.info("nevigates to home page");
}	

/*@Test
public void validateHomepaheTitle() {
	HomePage hp=new HomePage(driver);
	String title=hp.gettitle();
	System.out.println(title);
	//log.info(title);
	//log.info("Home page title validate");
	Assert.assertEquals(title, "QA Click Academy 123| Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy");
	//Assert.assertEquals(title,"QA Click Academy 123| Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy");
}*/



@Test
public void validateLoginClick() throws InterruptedException  {
	hp=new HomePage(driver);
loginPage=hp.clickOnLoginbtn();
//log.info("clicked on login");
	
}
@AfterTest
public void tearDown() {
	driver.quit();
}
	}
