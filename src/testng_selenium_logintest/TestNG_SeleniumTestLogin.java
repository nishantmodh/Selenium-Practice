package testng_selenium_logintest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TestNG_SeleniumTestLogin {
	
	private WebDriver driver;
	private String baseURL;
	public LoginPage lp;

	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String browser) {
		baseURL = "https://letskodeit.teachable.com/";
		
		if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	@Test
	public void testLogin() {
		lp.login("test@email.com", "abcabc");
	}

	@AfterClass
	public void cleanUp() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
