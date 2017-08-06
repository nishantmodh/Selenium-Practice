package javascriptexecution;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Screenshots {
	
	private WebDriver driver;
	private String baseURL;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://www.expedia.com";
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testScreenShots() {
		driver.get(baseURL);
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		
		//Find elements
		WebElement flight_origin = driver.findElement(By.id("flight-origin-hp-flight"));
		WebElement flight_destination = driver.findElement(By.id("flight-destination-hp-flight"));
		WebElement departure_date = driver.findElement(By.id("flight-departing-hp-flight"));
		WebElement return_date = driver.findElement(By.id("flight-returning-hp-flight"));
		WebElement search = driver.findElement(By.xpath(".//*[@id='gcw-flights-form-hp-flight']/div[8]/label/button"));
		
		//Send data to the elements
		flight_origin.sendKeys("New York");
		departure_date.sendKeys("09/04/2017");
		return_date.clear();
		return_date.sendKeys("09/10/2017");
		flight_destination.sendKeys("New York");
		search.click();
	}
	
	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for(int i=0;i<length;i++) {
			int index = (int) Math.random() * characters.length();
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
	
	@After
	public void tearDown() throws Exception {
		String fileName = getRandomString(10) + ".png";
		String directory = "C:\\Users\\NISHANT\\Desktop\\";
		
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
		
		Thread.sleep(2000);
		driver.quit();
	}

}
