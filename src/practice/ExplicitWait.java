package practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	private WebDriver driver;
	private String url;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		url = "https://www.google.com/gmail/about/#";
		//driver.manage().window().maximize();
	}
	
	@Test
	public void test() {
		driver.get(url);
		WebElement signInLink = driver.findElement(By.xpath("//div[@class='gmail-nav__nav-links-wrap']//a[text()='Sign In']"));
		signInLink.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
		
		emailField.sendKeys("test");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	}

}
