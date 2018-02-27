package practice;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindAllLinks {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://www.zuerchertech.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() {
		driver.get(baseUrl);
		
		List<WebElement> allLinks = Links.clickableLinks(driver);
		
		for(WebElement link : allLinks) {
			String href = link.getAttribute("href");
			
			try {
				System.out.println("URL: "+href);
				System.out.println("Status: "+Links.linkStatus(new URL(href)));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@After
	public void tearDown() throws Exception {
	}

}
