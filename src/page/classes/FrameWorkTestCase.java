package page.classes;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameWorkTestCase {
	
	private WebDriver driver;
	private String baseURL;
	HomePageFactory homePage;
	
	@Before
	public void beforeClass() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://www.expedia.com/";
		
		homePage = new HomePageFactory(driver);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void test() {
		homePage.clickFlightTab();
		homePage.setOriginCity("New York");
		homePage.setDestinationCity("Chicago");
		homePage.setDepartureDate("09/04/2017");
		homePage.setReturnDate("09/14/2017");
		homePage.clickOnSearchButton();
		
	}
	
	@After
	public void afterClass() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
