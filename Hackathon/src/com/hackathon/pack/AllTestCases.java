package com.hackathon.pack;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AllTestCases {

	WebDriver driver;
	String baseUrl = "https://www.yatra.com/";
	String baseUrl2 = "https://www.makemytrip.com/gift-cards/";
	// Invoke getWebDriver method

	@BeforeClass
	public WebDriver ConfigDriver() {
		driver = DriverSetup.getWebDriver();
		driver.manage().window().maximize();
		return driver;
	}

	// Entering Invalid Email
	@Test(priority = 1) 
	public void TestCase01() { 
		driver.get(baseUrl);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	  WebElement trgt = driver.findElement(By.linkText("My Account"));
	  
	  Actions action1 = new Actions(driver);
	  action1.moveToElement(trgt).build().perform();
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, 20);
	  wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Login"))));
	  
	  WebElement loginLink = driver.findElement(By.xpath("//a[@id='signInBtn']"));
	  loginLink.click();
	  
	  driver.findElement(By.xpath("//input[@id='login-input']")).sendKeys("mrxmtj"); 
	  driver.findElement(By.xpath("//button[@id='login-continue-btn']")).click();
	  try { Thread.sleep(6000); } catch (InterruptedException e) { 
		  // TODOAuto-generated catch block 
		  e.printStackTrace(); }
	  System.out.println("Test case 01: Entering Invalid Email"); String
	  invalidMail = driver .findElement(By.
	  xpath("//p[@id='login-error' and @class='text-red fs-12 mt10 login-error']"))
	  .getText(); System.out.println(invalidMail); }

	// Entering Invalid Phone Number
	@Test(priority = 2) 
	public void TestCase02() { driver.get(baseUrl);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); WebElement
	  trgt = driver.findElement(By.linkText("My Account"));
	  
	  Actions action1 = new Actions(driver);
	  action1.moveToElement(trgt).build().perform();
	 
	  WebDriverWait wait1 = new WebDriverWait(driver, 20);
	  wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(
	  "Login"))));
	  
	  WebElement loginLink = driver.findElement(By.xpath("//a[@id='signInBtn']"));
	  loginLink.click();
	  
	  driver.findElement(By.xpath("//input[@id='login-input']")).sendKeys(
	  "78945612");
	  driver.findElement(By.xpath("//button[@id='login-continue-btn']")).click();
	  try { Thread.sleep(6000); } catch (InterruptedException e) { 
		  // TODO Auto-generated catch block 
	  e.printStackTrace(); }
	  System.out.println("Test case 02: Entering Invalid Phone Number"); String
	  invalidNumber = driver .findElement(By.
	  xpath("//p[@id='login-error' and @class='text-red fs-12 mt10 login-error']")).getText(); System.out.println(invalidNumber); }

	// Entering Invalid Password
	@Test(priority = 3) 
	public void TestCase03() { driver.get(baseUrl);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); WebElement
	  trgt = driver.findElement(By.linkText("My Account"));
	  
	  Actions action1 = new Actions(driver);
	  action1.moveToElement(trgt).build().perform();
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, 20);
	  wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(
	  "Login"))));
	  
	  WebElement loginLink = driver.findElement(By.xpath("//a[@id='signInBtn']"));
	  loginLink.click();
	  
	  driver.findElement(By.xpath("//input[@id='login-input']")).sendKeys(
	  "mrxmtj@gmail.com");
	  
	  driver.findElement(By.xpath("//button[@id='login-continue-btn']")).click();
	  
	  driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys(
	  "asdflkjh");
	  driver.findElement(By.xpath("//button[@id='login-submit-btn']")).click(); try
	  { Thread.sleep(6000); } catch (InterruptedException e) { 
		  // TODO Auto-generated catch block 
	  e.printStackTrace(); }
	  
	  System.out.println("Test case 03: Entering Invalid Password "); String
	  invalidPassword = driver .findElement(By.
	  xpath("//p[@id='login-error' and @class='text-red fs-12 mt10 login-error']"))
	  .getText(); System.out.println(invalidPassword);
	  
	  }

	// Clicking on Login Button without entering any value into the Email/Phone Text box
	@Test(priority=4)
	public void TestCase04() { driver.get(baseUrl);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); WebElement
	  trgt = driver.findElement(By.linkText("My Account"));
	  
	  Actions action1 = new Actions(driver);
	  action1.moveToElement(trgt).build().perform();
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, 20);
	  wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(
	  "Login"))));
	  
	  WebElement loginLink = driver.findElement(By.xpath("//a[@id='signInBtn']"));
	  loginLink.click();
	  
	  try { Thread.sleep(3000); } catch (InterruptedException e) {  e.printStackTrace(); }
	  
	  driver.findElement(By.xpath("//button[@id='login-continue-btn']")).click();
	  try { Thread.sleep(3000); } catch (InterruptedException e) {  e.printStackTrace(); }
	  
	  System.out.println(
	 "Test case 04: Clicking on Login Button without entering any value into the Email/Phone Text box "
	  ); String NoInput = driver .findElement(By.
	  xpath("//p[@class='text-red fs-12 mt10 login-error' and @id='login-error']"))
	  .getText();
	  
	  System.out.println(NoInput);
	  
	  }

	// Clicking on Login button without entering any value into Password text box
	@Test(priority = 5) 
	public void TestCase05() { driver.get(baseUrl);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); WebElement
	  trgt = driver.findElement(By.linkText("My Account"));
	  
	  Actions action1 = new Actions(driver);
	  action1.moveToElement(trgt).build().perform();
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, 20);
	  wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(
	  "Login"))));
	  
	  WebElement loginLink = driver.findElement(By.xpath("//a[@id='signInBtn']"));
	  loginLink.click();
	  
	  driver.findElement(By.xpath("//input[@id='login-input']")).sendKeys(
	  "mrxmtj@gmail.com");
	  
	  driver.findElement(By.xpath("//button[@id='login-continue-btn']")).click();
	  
	  try { Thread.sleep(3000); } catch (InterruptedException e) {  e.printStackTrace(); }
	  
	  driver.findElement(By.xpath("//button[@id='login-submit-btn']")).click();
	  
	  try { Thread.sleep(3000); } catch (InterruptedException e) {  e.printStackTrace(); }
	  
	  System.out.
	  println("Test case 05: Clicking on Login button without entering any value into Password text box "
	  );
	  
	  String NoPassword = driver .findElement(By.
	  xpath("//p[@id='login-error' and @class='text-red fs-12 mt10 login-error']"))
	  .getText(); System.out.println(NoPassword);
	  
	  }

	// Entering Valid Email Id and Password
	@Test(priority = 6)
	public void TestCase06() { driver.get(baseUrl);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  try { Thread.sleep(2000); } catch (InterruptedException e) {  e.printStackTrace(); }
	  
	  WebElement trgt = driver.findElement(By.linkText("My Account"));
	  
	  Actions action1 = new Actions(driver);
	  action1.moveToElement(trgt).build().perform();
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, 20);
	  wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(
	 "Login"))));
	  
	  WebElement loginLink = driver.findElement(By.xpath("//a[@id='signInBtn']"));
	  loginLink.click();
	  
	  driver.findElement(By.xpath("//input[@id='login-input']")).sendKeys(
	  "mrxmtj@gmail.com");
	  
	  driver.findElement(By.xpath("//button[@id='login-continue-btn']")).click();
	  
	  driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys(
	  "Asdf@123");
	 
	  driver.findElement(By.xpath("//button[@id='login-submit-btn']")).click(); try
	  { Thread.sleep(2000); } catch (InterruptedException e) {  e.printStackTrace(); }
	 
	  System.out.println("Test case 06: Entering Valid Email Id and Password ");
	  System.out.println("Login Successful"); try { Thread.sleep(6000); } catch
	  (InterruptedException e) { // TODO Auto-generated catch block
	  e.printStackTrace(); } }

	
	// Selecting Both Source and Destination as New Delhi in One way Cab
	@Test(priority = 7)
	public void TestCase07() throws Exception {
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='booking_engine_cabs']")).click();

		// selecting One way trip
		driver.findElement(By.xpath("//input[@id='BE_cab_non_stop']")).click();

		// Selecting From as New Delhi
		driver.findElement(By.xpath("//input[@id='BE_cabs_from_station']")).click();
		driver.findElement(By.xpath("//input[@id='BE_cabs_from_station']")).sendKeys("New Delhi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//strong[contains(text(),'New Delhi')]")).click();

		// Selecting To as New Delhi
		driver.findElement(By.xpath("//input[@id='BE_cabs_to_station']")).click();
		driver.findElement(By.xpath("//input[@id='BE_cabs_to_station']")).sendKeys("New Delhi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//strong[contains(text(),'New Delhi')]")).click();

		// Clicking on Search Button
		driver.findElement(By.xpath("//input[@id='BE_cabs_htsearch_btn']")).click();
		Thread.sleep(6000);
		System.out.println("Test Case 07: Selecting Both Source and Destination as New Delhi in One way Cab");
		System.out.println("please enter different from and To City");
	}

	// Selecting Both Source and Destination as New Delhi in two way(Round-Trip) Cab
	@Test(priority = 8)
	public void TestCase08() throws Exception {

		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='booking_engine_cabs']")).click();

		// Selecting From as New Delhi
		driver.findElement(By.xpath("//input[@id='BE_cabs_from_station']")).click();
		driver.findElement(By.xpath("//input[@id='BE_cabs_from_station']")).sendKeys("New Delhi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//strong[contains(text(),'New Delhi')]")).click();

		// Selecting To as New Delhi
		driver.findElement(By.xpath("//input[@id='BE_cabs_to_station']")).click();
		driver.findElement(By.xpath("//input[@id='BE_cabs_to_station']")).sendKeys("New Delhi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//strong[contains(text(),'New Delhi')]")).click();

		// Clicking on Search Button
		driver.findElement(By.xpath("//input[@id='BE_cabs_htsearch_btn']")).click();
		Thread.sleep(6000);
		System.out
				.println("Test Case 08: Selecting Both Source and Destination as New Delhi in two way(Round-Trip) Cab");
		System.out.println("please enter different from and To City");
	}

	// Selecting no values in From Field
	@Test(priority = 9)
	public void TestCase09() throws Exception {

		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='booking_engine_cabs']")).click();

		// selecting One way trip
		driver.findElement(By.xpath("//input[@id='BE_cab_non_stop']")).click();

		System.out.println("Test Case 09: Selecting no values in From Field ");

		// Selecting Nothing in From Field
		driver.findElement(By.xpath("//input[@id='BE_cabs_from_station']")).click();
		driver.findElement(By.xpath("//input[@id='BE_cabs_from_station']")).sendKeys(" ");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//strong[contains(text(),'New Delhi')]")).click();

		String error01 = driver.findElement(By.xpath(
				"/html/body/div[2]/div/section/div[1]/div/div[1]/section/div/div/div/div[1]/div[2]/ul[4]/li[1]/div/div/ul/div/div/div/li"))
				.getText();

		System.out.println(error01);
	}

	// Selecting Invalid Date
	@Test(priority = 10)
	public void TestCase10() throws Exception {

		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='booking_engine_cabs']")).click();

		// selecting One way trip
		driver.findElement(By.xpath("//input[@id='BE_cab_non_stop']")).click();

		// Selecting From as New Delhi
		driver.findElement(By.xpath("//input[@id='BE_cabs_from_station']")).click();
		driver.findElement(By.xpath("//input[@id='BE_cabs_from_station']")).sendKeys("New Delhi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//strong[contains(text(),'New Delhi')]")).click();

		// Selecting To as Manali
		driver.findElement(By.xpath("//input[@id='BE_cabs_to_station']")).click();
		driver.findElement(By.xpath("//input[@id='BE_cabs_to_station']")).sendKeys("Manali");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//strong[contains(text(),'Manali')]")).click();

		System.out.println("Test Case 10: Selecting Invalid Date");

		// Selecting the Departure Date as 23th March 2021
		driver.findElement(By.xpath("//input[@id='BE_cabs_checkin_date']")).click();
		driver.findElement(By.xpath("//td[@id='25/03/2021']")).click();
	}

	// Not Selecting any date from the date Field
	@Test(priority = 11)
	public void TestCase11() throws Exception {
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='booking_engine_cabs']")).click();

		// selecting One way trip
		driver.findElement(By.xpath("//input[@id='BE_cab_non_stop']")).click();

		// Selecting From as New Delhi
		driver.findElement(By.xpath("//input[@id='BE_cabs_from_station']")).click();
		driver.findElement(By.xpath("//input[@id='BE_cabs_from_station']")).sendKeys("New Delhi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//strong[contains(text(),'New Delhi')]")).click();

		// Selecting To as Manali
		driver.findElement(By.xpath("//input[@id='BE_cabs_to_station']")).click();
		driver.findElement(By.xpath("//input[@id='BE_cabs_to_station']")).sendKeys("Manali");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//strong[contains(text(),'Manali')]")).click();

		System.out.println("Test Case 11: Not Selecting any date from the date Field");

		// Selecting Departure Time as 06:30 AM
		driver.findElement(By.xpath("//input[@id='checkInTimeField']")).click();
		driver.findElement(By.xpath(
				"//body/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[5]/li[1]/ul[1]/li[1]/div[1]/ul[1]/li[15]"))
				.click();

		System.out.println("Website selects default date");

		// Clicking on Search Button
		driver.findElement(By.xpath("//input[@id='BE_cabs_htsearch_btn']")).click();
		Thread.sleep(6000);

	}

	// Not Selecting any time from the time Field
	@Test(priority = 12)
	public void TestCase12() throws Exception {
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='booking_engine_cabs']")).click();

		// selecting One way trip
		driver.findElement(By.xpath("//input[@id='BE_cab_non_stop']")).click();

		// Selecting From as New Delhi
		driver.findElement(By.xpath("//input[@id='BE_cabs_from_station']")).click();
		driver.findElement(By.xpath("//input[@id='BE_cabs_from_station']")).sendKeys("New Delhi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//strong[contains(text(),'New Delhi')]")).click();

		// Selecting To as Manali
		driver.findElement(By.xpath("//input[@id='BE_cabs_to_station']")).click();
		driver.findElement(By.xpath("//input[@id='BE_cabs_to_station']")).sendKeys("Manali");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//strong[contains(text(),'Manali')]")).click();

		System.out.println("Test Case 12: Not Selecting any Time from the Time Field");

		// Selecting the Departure Date as 30th March 2021
		driver.findElement(By.xpath("//input[@id='BE_cabs_checkin_date']")).click();
		driver.findElement(By.xpath("//td[@id='30/03/2021']")).click();
		Thread.sleep(6000);
		System.out.println("Website will not select any default Time");
		Thread.sleep(6000);

	}

	// Not Selecting any Place from the Place Field
	@Test(priority = 13)
	public void TestCase13() throws Exception {
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='booking_engine_hotels']")).click();
		Thread.sleep(2000);

		System.out.println("Test Case 13: Not Selecting any Place from the Place Field");

		driver.findElement(By.xpath("//input[@id='BE_hotel_htsearch_btn']")).click();

		System.out.println("Website will select default Place");

		Thread.sleep(6000);
	}

	
	// Not Selecting Check-in and Check-out date from the Date Fields
	@Test(priority = 14)
	public void TestCase14() throws Exception {
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='booking_engine_hotels']")).click();
		Thread.sleep(2000);

		// Selecting city as Delhi
		driver.findElement(By.xpath("//input[@id='BE_hotel_destination_city']")).click();
		driver.findElement(By.xpath("//input[@id='BE_hotel_destination_city']")).sendKeys("New Delhi");
		driver.findElement(By.xpath("//input[@id='BE_hotel_destination_city']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		System.out.println("Test Case 14: Not Selecting Check-in and Check-out date from the Date Fields");

		driver.findElement(By.xpath("//input[@id='BE_hotel_htsearch_btn']")).click();

		System.out.println("Website will select default Check-in and Check-out date");

		Thread.sleep(6000);

	}

	// Not Selecting Number of Travelers and Rooms
	@Test(priority = 15)
	public void TestCase15() throws Exception {
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='booking_engine_hotels']")).click();
		Thread.sleep(2000);

		// Selecting city as Delhi
		driver.findElement(By.xpath("//input[@id='BE_hotel_destination_city']")).click();
		driver.findElement(By.xpath("//input[@id='BE_hotel_destination_city']")).sendKeys("New Delhi");
		driver.findElement(By.xpath("//input[@id='BE_hotel_destination_city']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		System.out.println("Test Case 15: Not Selecting Number of Travelers and Rooms");

		driver.findElement(By.xpath("//input[@id='BE_hotel_htsearch_btn']")).click();

		System.out.println("Website will select default Number of Travelers and Rooms");

		Thread.sleep(6000);

	}

	// Not Entering any Name into the Name Field in Gift Card Form
	@Test(priority = 16)
	public void TestCase16() throws Exception {
		driver.get(baseUrl2);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/header/div[1]/div/ul/li[3]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/section[1]/div[1]/div/a")).click();

		// Filling out the Gift Card form
		driver.findElement(By.xpath("//*[@id='name_info']")).sendKeys("");
		driver.findElement(By.xpath("//*[@id='contact_info']")).sendKeys("7894561230");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("MyTestCase.com");
		driver.findElement(By.xpath("//*[@id='organization_info']")).sendKeys("JSS");
		driver.findElement(By.xpath("//*[@id='location_info']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//*[@id='captcha']")).sendKeys("1234");

		System.out.println("Test Case 16: Not Entering any Name into the Name Field in Gift Card Form");

		driver.findElement(By.xpath("//*[@id='submit']")).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String errorMsg1 = driver.findElement(By.xpath("//span[@id='name_error' and @class='error_info']")).getText();
		System.out.println(errorMsg1);

	}

	// Not Entering any Number into the Number Field in Gift Card Form
	@Test(priority = 17)
	public void TestCase17() throws Exception {
		driver.get(baseUrl2);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/header/div[1]/div/ul/li[3]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/section[1]/div[1]/div/a")).click();

		// Filling out the Gift Card form
		driver.findElement(By.xpath("//*[@id='name_info']")).sendKeys("My Test Case");
		driver.findElement(By.xpath("//*[@id='contact_info']")).sendKeys("");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("MyTestCase.com");
		driver.findElement(By.xpath("//*[@id='organization_info']")).sendKeys("JSS");
		driver.findElement(By.xpath("//*[@id='location_info']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//*[@id='captcha']")).sendKeys("1234");

		System.out.println("Test Case 17: Not Entering any Number into the Number Field in Gift Card Form");

		driver.findElement(By.xpath("//*[@id='submit']")).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String errorMsg2 = driver.findElement(By.xpath("//span[@id='contact_error' and @class='error_info']"))
				.getText();
		System.out.println(errorMsg2);

	}

	// Not Entering mail id into the mail id Field in Gift Card Form
	@Test(priority = 18)
	public void TestCase18() throws Exception {
		driver.get(baseUrl2);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/header/div[1]/div/ul/li[3]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/section[1]/div[1]/div/a")).click();

		// Filling out the Gift Card form
		driver.findElement(By.xpath("//*[@id='name_info']")).sendKeys("My Test Case");
		driver.findElement(By.xpath("//*[@id='contact_info']")).sendKeys("7894561230");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("");
		driver.findElement(By.xpath("//*[@id='organization_info']")).sendKeys("JSS");
		driver.findElement(By.xpath("//*[@id='location_info']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//*[@id='captcha']")).sendKeys("1234");

		System.out.println("Test Case 18: Not Entering mail id into the mail id Field in Gift Card Form");

		driver.findElement(By.xpath("//*[@id='submit']")).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String errorMsg3 = driver.findElement(By.xpath("//span[@id='email_error' and @class='error_info']")).getText();
		System.out.println(errorMsg3);

	}

	// Not Entering Organization name into the Organization name Field in Gift Card
	// Form
	@Test(priority = 19)
	public void TestCase19() throws Exception {
		driver.get(baseUrl2);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/header/div[1]/div/ul/li[3]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/section[1]/div[1]/div/a")).click();

		// Filling out the Gift Card form
		driver.findElement(By.xpath("//*[@id='name_info']")).sendKeys("My Test Case");
		driver.findElement(By.xpath("//*[@id='contact_info']")).sendKeys("7894561230");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("asdf@gmail.com");
		driver.findElement(By.xpath("//*[@id='organization_info']")).sendKeys("");
		driver.findElement(By.xpath("//*[@id='location_info']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//*[@id='captcha']")).sendKeys("1234");

		System.out.println(
				"Test Case 19: Not Entering Organization name into the Organization name Field in Gift Card Form");

		driver.findElement(By.xpath("//*[@id='submit']")).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String errorMsg4 = driver.findElement(By.xpath("//span[@id='organization_error' and @class='error_info']"))
				.getText();
		System.out.println(errorMsg4);

	}

	// Not Entering Location into the Location Field in Gift Card Form
	@Test(priority = 20)
	public void TestCase20() throws Exception {
		driver.get(baseUrl2);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/header/div[1]/div/ul/li[3]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/section[1]/div[1]/div/a")).click();

		// Filling out the Gift Card form
		driver.findElement(By.xpath("//*[@id='name_info']")).sendKeys("My Test Case");
		driver.findElement(By.xpath("//*[@id='contact_info']")).sendKeys("7894561230");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("asdf@gmail.com");
		driver.findElement(By.xpath("//*[@id='organization_info']")).sendKeys("JSS");
		driver.findElement(By.xpath("//*[@id='location_info']")).sendKeys("");
		driver.findElement(By.xpath("//*[@id='captcha']")).sendKeys("1234");

		System.out.println("Test Case 20: Not Entering Location into the Location Field in Gift Card Form");

		driver.findElement(By.xpath("//*[@id='submit']")).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String errorMsg5 = driver.findElement(By.xpath("//span[@id='location_error' and @class='error_info']"))
				.getText();
		System.out.println(errorMsg5);

	}

	@AfterClass
	public void closeBrowser() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		driver.close();
	}

}
