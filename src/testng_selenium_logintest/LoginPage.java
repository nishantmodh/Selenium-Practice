package testng_selenium_logintest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='navbar']//a[contains(text(),'Login')]")
	WebElement loginLink;
	
	@FindBy(id="user_email")
	WebElement emailField;
	
	@FindBy(id="user_password")
	WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickLoginLink() {
		loginLink.click();
	}
	
	public void fillEmailField(String email) {
		emailField.sendKeys(email);
	}
	
	public void fillPasswordField(String Password) {
		passwordField.sendKeys(Password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void login(String email, String password) {
		clickLoginLink();
		fillEmailField(email);
		fillPasswordField(password);
		clickLoginButton();
	}

}
