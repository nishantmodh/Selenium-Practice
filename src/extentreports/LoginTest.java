package extentreports;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest {
  
	private WebDriver driver;
	private String baseURL;
	ExtentReports report;
	ExtentTest test;
	HomePage hp;

	@BeforeClass
	public void beforeClass() {
		baseURL = "http://www.letskodeit.com/";
		report = ExtentFactory.getInstance();
		test = report.startTest("Verify Welcome Text");
		driver = new ChromeDriver();
		hp = new HomePage(driver, test);

		// Maximize the browser's window
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser Started...");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		test.log(LogStatus.INFO, "Web Application opened");
	}

	@Test
	public void test1_validLoginTest() throws Exception {
		
		hp.login("test@email.com", "abcabc");
		
		Thread.sleep(3000);
		
		boolean result = hp.isWelcomeTextPresent();
		Assert.assertTrue(result);
		test.log(LogStatus.PASS, "Verified Welcome Text");
	}
	
	@AfterClass
	public void tearDownAfterClass() throws Exception {
		Thread.sleep(3000);
		driver.quit();
		report.endTest(test);
		report.flush();
	}
	
}
