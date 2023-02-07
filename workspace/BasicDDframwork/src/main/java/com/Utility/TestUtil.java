package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Base.Base;

public class TestUtil extends Base{
	public static long Pageload_Timeout=20;
	public static long Implecit_Wait=10;
	public static String TestData_Path="D:\\shital\\workspace\\BasicDDframwork\\src\\main\\java\\com\\TestData\\LoginCredentials.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	
	public static String getScreenShot(String testCaseName,WebDriver driver) throws IOException {
	
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(src,new File(destFile));
		return destFile;
		
	}
	
	

	 public static Object[][] getTestData(String sheetname) {
		 FileInputStream file =null;
	 
		 try {
			 file=new FileInputStream(TestData_Path);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
			
		try {
			book=WorkbookFactory.create(file);
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		sheet=book.getSheet(sheetname);
		Object[][]data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int row=0;row<sheet.getLastRowNum();row++) {
			for(int col=0;col<sheet.getRow(0).getLastCellNum();col++) {
				data[row][col]=sheet.getRow(row+1).getCell(col).toString();
				}
		}
		return data;
		
	 }

public static void takeScreenshotAtEndOfTest( WebDriver driver) throws IOException {
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");

	FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
}



}
