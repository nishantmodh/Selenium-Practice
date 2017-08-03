package GenericMethods;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class isElementPresentDemo {
	
	private WebDriver driver;
	private String baseURL;
	private GenericMethods gm;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/pages/practice";
		gm = new GenericMethods(driver);

		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		driver.get(baseURL);
		
		boolean result1 = gm.isElementPresent("name", "id");
		System.out.println("Is element present: "+result1);
		
		boolean result2 = gm.isElementPresent("name-not-present", "id");
		System.out.println("Is element present: "+result2);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
