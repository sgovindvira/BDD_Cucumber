package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_Customer_Page {

	WebDriver ldriver;

	public Search_Customer_Page(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	@FindBy(id ="SearchEmail")
	WebElement emailadd;

	@FindBy(id="search-customers")
	WebElement searchBtn;

	@FindBy(xpath="//table[@id ='customers-grid']")
	WebElement searchResult;

	@FindBy(xpath = "//table[@id ='customers-grid']//tr")
	List<WebElement> tableRows;

	@FindBy(xpath ="//table[@id ='customers-grid']//tr[1]/hd")
	List<WebElement> tableColumns;




	public void enteremail (String Email) {
		emailadd.sendKeys(Email);

	}

	public void clickSearch ()
	{
		searchBtn.click();
	}

	

}
