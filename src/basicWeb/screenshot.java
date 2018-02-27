package basicWeb;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenshot {
	
	WebDriver driver;
	String baseURL;
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		baseURL = "https://www.google.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws IOException {
		driver.get(baseURL);
		// Capture the screenshot 
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Copy screenshot to the location
		FileUtils.copyFile(file, new File("C:\\Users\\NISHANT\\Desktop\\google.jpg"));
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
