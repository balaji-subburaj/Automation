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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

	public class Login {
		
	WebDriver driver;
	String baseUrl = "https://www.yatra.com/";
		
		// Invoke getWebDriver method 
		
		@BeforeClass
		public WebDriver ConfigDriver() {
		    driver = DriverSetup.getWebDriver();
		    driver.manage().window().maximize();
		    driver.get(baseUrl);
		    return driver;
		}
		
		
		@Test
		public void loginToYatra() throws InterruptedException {
			
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
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
			
			XSSFSheet sheet=wb.getSheet("login");
			
			String userId = sheet.getRow(1).getCell(0).getStringCellValue();
	    	String pass = sheet.getRow(1).getCell(1).getStringCellValue();
			
			Thread.sleep(2000);
			
			WebElement trgt = driver.findElement(By.linkText("My Account"));
			
			
			Actions action1 = new Actions(driver);
			action1.moveToElement(trgt).build().perform();
			
			WebDriverWait wait1 = new WebDriverWait(driver, 20);
			wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Login"))));
			
			WebElement loginLink = driver.findElement(By.xpath("//a[@id='signInBtn']"));
			loginLink.click();
			
			driver.findElement(By.xpath("//input[@id='login-input']")).sendKeys(userId);
			
			driver.findElement(By.xpath("//button[@id='login-continue-btn']")).click();
			
			driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys(pass);
			
			driver.findElement(By.xpath("//button[@id='login-submit-btn']")).click();
			Thread.sleep(2000);
			System.out.println("Login Successful");
			Thread.sleep(6000);
		}
		
		
		
		
		@AfterClass
		public void closeBrowser()
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
			driver.close();
		}
			

}
