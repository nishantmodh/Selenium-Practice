package page.classes;

import java.net.MalformedURLException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumGrid_ParallelTestFramework extends TestSuitBase {

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		
	}

	@Test
	public void SearchFlights() {
		home.clickFlightTab();
		home.setOriginCity("New York");
		home.setDestinationCity("Chicago");
		home.setDepartureDate("09/04/2017");
		home.setReturnDate("09/10/2017");
		home.clickOnSearchButton();
	}

	@AfterClass
	public void afterClass() {
		
	}

}
