package javascriptexecution;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavascriptExecution {
	
	private WebDriver driver;
	//private String baseURL;
	private JavascriptExecutor js;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		//baseURL = "https://letskodeit.teachable.com/pages/practice";
		js = (JavascriptExecutor) driver;
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testJavascriptExecution() throws Exception {
		//driver.get(baseURL);
		js.executeScript("window.location = 'https://letskodeit.teachable.com/pages/practice';");
		Thread.sleep(3000);
		//WebElement textBox = driver.findElement(By.id("name"));
		WebElement textBox = (WebElement) js.executeScript("return document.getElementById('name');"); 
		textBox.sendKeys("test");
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
