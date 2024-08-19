package com.hackathon.pack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GiftCard {

	WebDriver driver;
	String baseUrl = "https://www.makemytrip.com/gift-cards/";
	
	@BeforeClass
	public WebDriver ConfigDriver() {
	    driver = DriverSetup.getWebDriver();
	    driver.manage().window().maximize();
	    driver.get(baseUrl);
	    return driver;
	}
	
	@Test
	public void GiftCardMakeMyTrip() {
		driver.get(baseUrl);
		driver.findElement(By.xpath("/html/body/header/div[1]/div/ul/li[3]/a")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		File file =new File("C:\\Users\\Siddhartha\\eclipse-workspace\\Hackathon\\xlsx files\\My_Test.xlsx");
	    FileInputStream inputStream=null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    
	    XSSFWorkbook wb=null;
		try {
			wb = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet=wb.getSheet("GiftCard");
		
		String name = sheet.getRow(1).getCell(0).getStringCellValue();
    	//double contact = sheet.getRow(1).getCell(1).getNumericCellValue();
    	String mailid = sheet.getRow(1).getCell(2).getStringCellValue();
    	String organisation = sheet.getRow(1).getCell(3).getStringCellValue();
    	String location = sheet.getRow(1).getCell(4).getStringCellValue();
    	//String otp = sheet.getRow(1).getCell(5).getStringCellValue();
    	
    	
    	
		driver.findElement(By.xpath("/html/body/section[1]/div[1]/div/a")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Filling out the Gift Card form
		driver.findElement(By.xpath("//*[@id='name_info']")).sendKeys(name);
		driver.findElement(By.xpath("//*[@id='contact_info']")).sendKeys("7894561230");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(mailid);
		driver.findElement(By.xpath("//*[@id='organization_info']")).sendKeys(organisation);
		driver.findElement(By.xpath("//*[@id='location_info']")).sendKeys(location);
		driver.findElement(By.xpath("//*[@id='captcha']")).sendKeys("1234");
		
		driver.findElement(By.xpath("//*[@id='submit']")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String errorMsg = driver.findElement(By.xpath("//*[@id='email_error']")).getText();
		System.out.println(errorMsg);
		
		
	}
	
			@AfterClass
			public void closeBrowser()
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
				driver.close();
			}
	
}
