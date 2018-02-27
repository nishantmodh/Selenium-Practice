package practice;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchPageModel {
	private WebDriver driver;
	private String url;
	SearchPage sp;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		url = "https://www.expedia.com/";
		sp = new SearchPage(driver);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@Test
	public void test() {
		sp.navidateToFlights();
		sp.fillOriginBox("New York");
		sp.fillDestinationBox("Chicago");
		sp.departureDate("12/04/2017");
		sp.returnDate("12/10/2017");
		sp.clickSearchButton();
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
