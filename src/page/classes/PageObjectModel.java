package page.classes;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageObjectModel {
	
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
	public void test() {
		driver.get(baseURL);
		HomePage.navigateToFlightTab(driver);
		HomePage.fillOriginTextBox(driver, "New York");
		HomePage.fillDestinationTextBox(driver, "Chicago");
		HomePage.fillDepartureDateTextBox(driver, "09/04/2017");
		HomePage.returnDateTextBox(driver).clear();
		HomePage.fillReturnDateTextBox(driver, "09/14/2017");;
		HomePage.clickOnSearchButton(driver);
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
