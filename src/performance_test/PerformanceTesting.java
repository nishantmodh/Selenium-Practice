package performance_test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.classes.HomePageFactory;

public class PerformanceTesting {
	long startTime;
	long endTime;
	long duration;
	double seconds;
	
	private WebDriver driver;
	private String baseURL;
	HomePageFactory HomePage;

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
	public void searchFlight(Method name) throws Exception {
		startTime = System.nanoTime();
		driver.get(baseURL);
//		HomePage.clickFlightTab();
//		HomePage.setOriginCity("New York");
//		HomePage.setDestinationCity("San Francisco");
//		HomePage.setDepartureDate("08/28/2017");
//		HomePage.setReturnDate("09/11/2017");
//		HomePage.clickOnSearchButton();
		endTime = System.nanoTime();
		duration = endTime - startTime;
		seconds = (double)duration / 1000000000.0;
		System.out.println("*****************************************");
		System.out.println("Time taken to execute this method: " + seconds + " seconds");
		ExcelUtility.setCellData("Flights Page", 1, 0);
		ExcelUtility.setCellData(seconds, 1, 1);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}