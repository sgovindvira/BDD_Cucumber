package StepDefinitions1;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObject.Add_New_Customer_Page;
import PageObject.Login_Page;
import PageObject.Search_Customer_Page;

public class BaseClass {
	
	public WebDriver driver;
	public Login_Page loginpage;
	public Add_New_Customer_Page addcx;
	public Search_Customer_Page search;
	public static Logger log;
	public Properties readconfing;

	

	//Generate random email id
	
	public String generateEmail() {
		return RandomStringUtils.randomAlphabetic(5);
	}

}
