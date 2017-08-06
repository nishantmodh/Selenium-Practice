package switchto;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchFrame {
	
	private WebDriver driver;
	private String baseURL;
	private JavascriptExecutor js;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		js = (JavascriptExecutor) driver;
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void test() throws InterruptedException {
		Thread.sleep(3000);
		js.executeScript("window.scroll(0, 1500)");
		// Switch to frame by id
		driver.switchTo().frame("courses-iframe");
		
		// Switch to frame by name
		// driver.switchTo().frame("iframe-name");
		
		// Switch to frame by number
		// driver.switchTo().frame(0);
		
		WebElement searchBox = driver.findElement(By.id("search-courses"));
		searchBox.sendKeys("python");
		
		driver.switchTo().defaultContent();
		js.executeScript("window.scroll(0, -1900)");
		Thread.sleep(6000);
		driver.findElement(By.id("name")).sendKeys("Test Successful");
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
