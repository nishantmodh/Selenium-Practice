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

public class AutoComplete {
	
	private WebDriver driver;
	private String baseURL;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://www.southwest.com/";
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws Exception {
		driver.get(baseURL);
		String searchText = "New York/Newark, NJ - EWR";
		String partialText = "New York";
		
		WebElement text = driver.findElement(By.id("air-city-departure"));
		text.sendKeys(partialText);
		
		WebElement element = driver.findElement(By.xpath("//div[@class='js-overlay-container overlay--container ']"));
		List<WebElement> results = element.findElements(By.tagName("li"));
		int size = results.size();
		
		for(int i=0; i<size;i++) {
			System.out.println(results.get(i).getText());
		}
		
		Thread.sleep(3000);
		
		for(WebElement result: results) {
			if(result.getText().equals(searchText)) {
				result.click();
			}
		}
		Thread.sleep(3000);
	}
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
