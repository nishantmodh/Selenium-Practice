package basicWeb;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindAllLinks {
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
	}
	
	@Test
	public void test() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Size of links:" +links.size());
		
		for (WebElement link : links) {
			String href = link.getAttribute("href");
			try {
				System.out.println("Links: "+href);
			} catch (Exception e) {
				System.err.println("Link is not found");
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
 	}
}
