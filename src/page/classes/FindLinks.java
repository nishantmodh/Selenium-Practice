package page.classes;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindLinks {
	
	private WebDriver driver;
	private String baseURL;
	
	@Before
	public void beforeClass() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://www.expedia.com/";
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testFindLinks() {
		driver.get(baseURL);
		HomePage.navigateToFlightTab(driver);
		
		List<WebElement> linksList = clickableLinks(driver);
		
		for(WebElement link: linksList) {
			String href = link.getAttribute("href");
			try {
				System.out.println("URL: "+href+" retruned "+linkStatus(new URL(href)));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static List<WebElement> clickableLinks(WebDriver driver){
		List<WebElement> linksToClick = new ArrayList<WebElement>();
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		elements.addAll(driver.findElements(By.tagName("img")));
		
		for(WebElement e: elements) {
			if(e.getAttribute("href") != null) {
				linksToClick.add(e);
			}
		}
		return linksToClick;
	}
	
	public static String linkStatus(URL url) {
		try {
			HttpURLConnection http = (HttpsURLConnection) url.openConnection(); 
			http.connect();
			String responseMessage = http.getResponseMessage();
			http.disconnect();
			return responseMessage;
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}

}
