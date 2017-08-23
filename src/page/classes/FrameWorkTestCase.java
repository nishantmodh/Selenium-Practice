package page.classes;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrameWorkTestCase {
	
	private WebDriver driver;
	private String baseURL;
	HomePageFactory homePage;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		baseURL = "https://www.expedia.com/";
		
		homePage = new HomePageFactory(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	@Test
	public void test() {
		homePage.clickFlightTab();
		homePage.setOriginCity("New York");
		homePage.setDestinationCity("Chicago");
		homePage.setDepartureDate("09/04/2017");
		homePage.setReturnDate("10/08/2017");
		homePage.clickOnSearchButton();
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
