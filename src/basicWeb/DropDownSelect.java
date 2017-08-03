package basicWeb;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownSelect {

	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "http://letskodeit.teachable.com/p/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
	}
	
	@Test
	public void test() throws Exception {
		driver.get(baseURL);
		WebElement element = driver.findElement(By.id("carselect"));
		Select s = new Select(element);
		
		Thread.sleep(2000);
		System.out.println("Select Benz by value");
		s.selectByValue("benz");
		
		Thread.sleep(2000);
		System.out.println("Select Honda by index");
		s.selectByIndex(2);
		
		Thread.sleep(2000);
		System.out.println("Select BMW by visible text");
		s.selectByVisibleText("BMW");
		
		Thread.sleep(2000);
		System.out.println("Print the list of all options");
		List<WebElement> options = s.getOptions();
		int size = options.size();
		
		for(int i=0;i<size;i++) {
			String optionName = options.get(i).getText();
			System.out.println(optionName);
		}
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}


}
