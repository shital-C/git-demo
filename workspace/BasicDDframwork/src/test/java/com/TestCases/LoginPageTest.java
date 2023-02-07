package com.TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.Base;
import com.Utility.TestUtil;

import Page.HomePage;
import Page.LoginPage;

public class LoginPageTest extends Base{
	LoginPage loginPage;
	
	String sheetname="loginData";
	HomePage hp;
@BeforeTest
	public void setup() throws IOException, InterruptedException {
		driver=initializeDriver();
	 loginPage=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		loginPage=hp.clickOnLoginbtn();
		//log.info("click on login");
		//log.info("nevagated to loginPage");
	
		
}
@Test
public void validateloginpageTitle() {
	loginPage=new LoginPage(driver);
Assert.assertEquals(loginPage.gettitle(), "WebServices Testing using SoapUI");
//log.info("validate loginpage title");
}
@DataProvider
public Object[][]getData() throws Exception  {
	
//Object[][]data=new Object[2][2];
//data[0][0]="Shital@gmail.com";
//data[0][1]="test@123";
//data[1][0]="Choudhari@123";
//	data[1][1]="sample@1223";
//return data;
//	
	
		Object[][]data=TestUtil.getTestData(sheetname);
		return data;
	}


@Test (dataProvider="getData")
public void validateLogin(String username,String password) throws InterruptedException {
	 loginPage=new LoginPage(driver);
	//loginPage.getEmail().sendKeys(username);
	//loginPage.getpwd().sendKeys(password);
	 loginPage.getEmail(username);
	 loginPage.getpwd(password);
Thread.sleep(4000);
	loginPage.clickOnlogbtn();
	Thread.sleep(4000);
}

@AfterTest
public void tearDown() {
	driver.quit();
}
}
