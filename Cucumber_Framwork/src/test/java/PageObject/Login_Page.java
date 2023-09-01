package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	WebDriver ldriver;

	public Login_Page(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}



	@FindBy(name = "Email")
	WebElement email;

	@FindBy(name = "Password")
	WebElement password;

	@FindBy(xpath ="//button[@type='submit']")
	WebElement loginButton;
	
	@FindBy(linkText = "Logout")
	WebElement logoutButton;


	
	public void enterEmail(String emailAdd)  {
		email.clear();
		email.sendKeys(emailAdd);
		System.out.println("Email entered");
	}

	public void enterPassword(String pswrd) {
		password.clear();
		password.sendKeys(pswrd);
		System.out.println("Password entred ");
	}

	public void clickLogin() {
		loginButton.click();
	}

	public void clickLogout() {
		logoutButton.click();
	}
	

}
