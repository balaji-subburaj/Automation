package com.hackathon.pack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HotelBooking {
	
	WebDriver driver;
	String baseUrl = "https://www.yatra.com/";
	
	@BeforeClass
	public WebDriver ConfigDriver() {
	    driver = DriverSetup.getWebDriver();
	    driver.manage().window().maximize();
	    driver.get(baseUrl);
	    return driver;
	}
	
	@Test
	public void BookHotelInYatra() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		File file =new File("C:\\Users\\user\\my eclipse workspace\\HackathonPracticeNew\\xlsx files\\My_Test.xlsx");
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
		
		XSSFSheet sheet=wb.getSheet("Hotel");
		
		String Hotel_Place = sheet.getRow(1).getCell(0).getStringCellValue();
		
		driver.findElement(By.xpath("//a[@id='booking_engine_hotels']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='BE_hotel_destination_city']")).click();
		driver.findElement(By.xpath("//input[@id='BE_hotel_destination_city']")).sendKeys(Hotel_Place);
		driver.findElement(By.xpath("//input[@id='BE_hotel_destination_city']")).sendKeys( Keys.ENTER);

	/*	driver.findElement(By.xpath("//input[@id='BE_hotel_checkin_date']")).click();
		driver.findElement(By.xpath("//td[@id='31/03/2021']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@id='01/04/2021']")).click();*/
		
		driver.findElement(By.xpath("//input[@id='BE_hotel_htsearch_btn']")).click();
		
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//body/div[@id='bongo-hotel-wrapper']/section[@id='wrapper']/div[1]/div[1]/div[3]/div[1]/div[2]/ul[1]/li[5]/a[1]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//body/div[@id='bongo-hotel-wrapper']/section[@id='wrapper']/div[1]/div[1]/div[3]/div[1]/div[2]/ul[1]/li[5]/a[1]")).click();
		
		WebElement trgt = driver.findElement(By.xpath("//a[contains(text(),'Hotel Shreeram Deluxe')]"));
		
		Actions action = new Actions(driver);
		action.moveToElement(trgt).build().perform();
		
		String HotelName = driver.findElement(By.xpath("//a[contains(text(),'Hotel Maharaja Continental')]")).getText();
		String HotelPrice = driver.findElement(By.xpath("//body/div[@id='bongo-hotel-wrapper']/section[@id='wrapper']/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/article[1]/div[1]/div[2]/div[2]/ul[1]/li[4]/div[2]/p[1]/span[1]")).getText();
		
		System.out.println("Hotel Name: " + HotelName);
		System.out.println("Hotel Price: " + HotelPrice);
		
	
	}
	
			@AfterClass
			public void closeBrowser()
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
				driver.close();

}
}
