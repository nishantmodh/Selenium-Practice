package basicWeb;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalendarSelection {
	
	private WebDriver driver;
	private String baseURL;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://www.expedia.com/";
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test1() throws Exception {
		driver.get(baseURL);
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		WebElement departingField = driver.findElement(By.id("flight-departing-hp-flight"));
		departingField.click();
		Thread.sleep(3000);
		WebElement dateToSelect = driver.findElement(By.xpath("//div[@class='datepicker-cal-month'][position()=1]//button[text()='7']"));
		dateToSelect.click();
	}
	
	@Test
	public void test2() throws Exception {
		driver.get(baseURL);
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		WebElement departingField = driver.findElement(By.id("flight-departing-hp-flight"));
		departingField.click();
		WebElement calMonth = driver.findElement(By.xpath("//div[@class='datepicker-cal-month'][position()=1]"));
		
		List<WebElement> allValidDates = calMonth.findElements(By.tagName("button"));
		
		for(WebElement date: allValidDates) {
			if(date.getText().equals("7")) {
				date.click();
				break;
			}
		}
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
