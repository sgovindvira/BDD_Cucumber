package StepDefinitions1;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import PageObject.Add_New_Customer_Page;
import PageObject.Login_Page;
import PageObject.Search_Customer_Page;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends BaseClass{

	@Before
	public void setup() {



		readconfing = new Properties();
		try {
			FileInputStream file = new FileInputStream("Confing.properties");
			readconfing.load(file);
		} catch (Exception e) {

			e.printStackTrace();
		}




		log = LogManager.getLogger("StepDef");

		String browser = readconfing.getProperty("browser");

		if(browser.equalsIgnoreCase("Chrome"))

		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else  {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}


		log.info("Setup executed");


	}


	@AfterStep
	public void addScreenshot1(Scenario scenario) {
		if(scenario.isFailed())
		{
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}


	}

	//	@After
	public void teardown() {

		/*	System.out.println("Tear Down executed");
		if(sc.isFailed()==true) {
			String filepath = "/Users/sanjaygovindvira/eclipse-workspace/Cucumber_Framwork/Fail Test Screenshots/screenshot.png";
			TakesScreenshot srshot = ((TakesScreenshot)driver);
			File file = srshot.getScreenshotAs(OutputType.FILE);
			File destfile = new File(filepath);
			try {
				FileUtils.copyFile(file, destfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} */

		driver.quit();
		log.info("last method executed");
	}



	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {

		loginpage = new Login_Page(driver);
		addcx = new Add_New_Customer_Page(driver);
		search = new  Search_Customer_Page(driver);


	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		log.info("user opens website");

	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String eml, String psw) {

		loginpage.enterEmail(eml);

		loginpage.enterPassword(psw);
		log.info("user enter email and password");

	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException  {
		Thread.sleep(2000);

		loginpage.clickLogin();
		log.info("user clicks on login");
	}
	//*** LOGIN FEATURE **** ////




	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {

		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);



	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {

		loginpage.clickLogout();
		log.info("Logout button clicked");
	}


	@Then("Page Title should be After Logout {string}")
	public void page_title_should_be_after_logout(String expectedlogouttitle) {
		String actualtitlelogout = driver.getTitle();
		Assert.assertEquals(actualtitlelogout, expectedlogouttitle);

	}


	@Then("close browser")
	public void close_browser() throws InterruptedException {

		driver.quit();

	}

	///********************* ADD A NEW CUSTOMER***************************///



	@Then("User can view the Dashboard")
	public void user_can_view_the_dashboard() {
		String actualTitle = addcx.get_dashboard_title();
		String expectedTitle = "Dashboard / nopCommerce administration";
		Assert.assertEquals(actualTitle,expectedTitle);



	}

	@When("User clicks on Customer button")
	public void user_clicks_on_customer_button() {
		addcx.clickOnCustomerMenu();

	}

	@When("Click on Customer sub menu button")
	public void click_on_customer_sub_menu_button() throws InterruptedException {
		Thread.sleep(2000);
		addcx.clicOnCustomerMenuItem();

	}

	@When("Click on Add new button")
	public void click_on_add_new_button() {
		addcx.clickOnAddnew();

	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualtitle = addcx.get_dashboard_title();
		String expectedtitle = "Add a new customer / nopCommerce administration";
		Assert.assertEquals(actualtitle,expectedtitle);
	}

	@When("User enter  customer info")
	public void user_enter_customer_info() {
		addcx.enterEmail(generateEmail() + "@yopmail.com");
		addcx.enterPassword("Test1");
		addcx.enterFirstName("Sanhay");
		addcx.enterLastName("Gov");
		addcx.enterGender("Male");
		addcx.enterDob("01/01/2000");
		addcx.enterCompanyName("BRM");

	}

	@When("click on save button")
	public void click_on_save_button() {
		addcx.clickOnSave();

	}

	@Then("User can view confirmation messages {string}")
	public void user_can_view_confirmation_messages(String expectedConfirmationMessage) {

		String expected = expectedConfirmationMessage;
		String Actual = driver.findElement(By.tagName("Body")).getText(); 
		if (Actual.contains(expectedConfirmationMessage))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertFalse(false);
		}


	}

	//**************  SearcH Customer****************
	@When("Enter Customer Email")
	public void enter_customer_email() {
		search.enteremail("victoria_victoria@nopCommerce.com");


	}




	@When("click on search button")
	public void click_on_search_button() {
		search.clickSearch();

	}






}