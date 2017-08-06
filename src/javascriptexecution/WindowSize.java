package javascriptexecution;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowSize {
	
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
	public void testJavaScriptExecution() {
		js.executeScript("window.location = 'https://letskodeit.teachable.com/pages/practice';");
		
		//size of the window
		long height = (long) js.executeScript("return window.innerHeight;");
		long width = (long) js.executeScript("return window.innerWidth;");
		
		System.out.println("Height is: "+height);
		System.out.println("Width is: "+width);
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
