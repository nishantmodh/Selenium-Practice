package performance_test;

import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.classes.HomePageFactory;

public class PerformanceTestingUsingStopWatch {
	
	private WebDriver driver;
	private String baseURL;
	HomePageFactory HomePage;
	StopWatch watch = new StopWatch();

	@BeforeClass
	public void beforeClass() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://www.expedia.com/";
		HomePage = new HomePageFactory(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Tell the code about the location of Excel file
		ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "Sheet1");
	}

	@Test
	public void searchFlight() throws Exception {
		watch.start();
		driver.get(baseURL);
//		HomePage.clickFlightTab();
//		HomePage.setOriginCity("New York");
//		HomePage.setDestinationCity("San Francisco");
//		HomePage.setDepartureDate("08/28/2017");
//		HomePage.setReturnDate("09/11/2017");
//		HomePage.clickOnSearchButton();
		double seconds = (double)watch.getTime() / 1000.0;
		watch.reset();
		System.out.println("*****************************************");
		System.out.println("Time taken to execute this method was "+seconds+" seconds");
		ExcelUtility.setCellData("Flights Page", 1, 0);
		ExcelUtility.setCellData(seconds, 1, 1);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}