package page.classes;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

public class SeleniumGrid_ParallelTest {
	private WebDriver driver;
	private String baseURL;
	private String nodeURL;
	
	HomePageFactory homePage;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		baseURL = "https://www.expedia.com/";
		nodeURL = "http://192.168.0.3:5555/wd/hub";
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setBrowserName("chrome");
		caps.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL(nodeURL), caps);
		
		homePage = new HomePageFactory(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void SearchFlights() {
		homePage.clickFlightTab();
		homePage.setOriginCity("New York");
		homePage.setDestinationCity("Chicago");
		homePage.setDepartureDate("09/04/2017");
		homePage.setReturnDate("09/14/2017");
		homePage.clickOnSearchButton();
	}

	@AfterClass
	public void afterClass() {
		
	}

}
