package setupMethods;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicActions {
	
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\libs\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseURL =  "https://letskodeit.teachable.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
	}
	
	@Test
	public void test() {
		driver.get(baseURL);
		driver.findElement(By.xpath(".//*[@id='navbar']//a[@href='/sign_in']")).click();
		System.out.println("Clicked on login");
		driver.findElement(By.id("user_email")).clear();
		driver.findElement(By.id("user_password")).sendKeys("test");
		driver.findElement(By.id("user_password")).clear();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
