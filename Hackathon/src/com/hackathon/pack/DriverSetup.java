package com.hackathon.pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverSetup
{ 
     private static WebDriver driver;
    public static WebDriver getWebDriver()
{
    	//Create a instance of ChromeOptions class
    	ChromeOptions options = new ChromeOptions();

    	//Add chrome switch to disable notification - "**--disable-notifications**"
    	options.addArguments("--disable-notifications");
    	
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Siddhartha\\eclipse-workspace\\Hackathon\\Drivers\\chromedriver.exe");
    	driver =new ChromeDriver(options);
		return driver;
	}
 }