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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CabBooking {
	
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
	public void BookingCabInYatra() throws InterruptedException {
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
		
		XSSFSheet sheet=wb.getSheet("cab");
		
		String from = sheet.getRow(1).getCell(0).getStringCellValue();
    	String to = sheet.getRow(1).getCell(1).getStringCellValue();
		
		driver.findElement(By.xpath("//a[@id='booking_engine_cabs']")).click();
		
		//selecting One way trip
		driver.findElement(By.xpath("//input[@id='BE_cab_non_stop']")).click();
		
		//Selecting From as New Delhi
		driver.findElement(By.xpath("//input[@id='BE_cabs_from_station']")).click();
		driver.findElement(By.xpath("//input[@id='BE_cabs_from_station']")).sendKeys(from);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//strong[contains(text(),'New Delhi')]")).click();
		
		//Selecting To as Manali
		driver.findElement(By.xpath("//input[@id='BE_cabs_to_station']")).click();
		driver.findElement(By.xpath("//input[@id='BE_cabs_to_station']")).sendKeys(to);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//strong[contains(text(),'Manali')]")).click();
		
		
		//Selecting the Departure Date as 23rd April 2021
		/*driver.findElement(By.xpath("//input[@id='BE_cabs_checkin_date']")).click();
		driver.findElement(By.xpath("//td[@id='23/04/2021']")).click();*/
		
		//Selecting Departure Time as 06:30 AM
		driver.findElement(By.xpath("//input[@id='checkInTimeField']")).click();
		driver.findElement(By.xpath("//body/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[5]/li[1]/ul[1]/li[1]/div[1]/ul[1]/li[15]")).click();
		
		//Clicking on Search Button
		driver.findElement(By.xpath("//input[@id='BE_cabs_htsearch_btn']")).click();
		Thread.sleep(6000);
		
		
		//Getting The SUV car With Price
		String carName = driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div[1]/div[2]/div[1]/div[1]/div/h2")).getText();
		String carType = driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div[1]/div[1]/h2")).getText();
		String carPrice = driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div[1]/div[2]/div[2]/div[1]/div[2]/p[1]")).getText();
		
		
		//Hovering the Mouse Over the Available Cars
		WebElement trgt = driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div[1]/div[1]/h2"));
		
		Actions action = new Actions(driver);
		action.moveToElement(trgt).build().perform();
		
		//Printing the Car Name, Car Type and its price 
		System.out.println("Car Name: " + carName);
		System.out.println("Car Type: " + carType);
		System.out.println("Car Price: " + carPrice);
		
		Thread.sleep(6000);
			
	}
	
			@AfterClass
			public void closeBrowser()
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
				driver.close();
	

}
}
