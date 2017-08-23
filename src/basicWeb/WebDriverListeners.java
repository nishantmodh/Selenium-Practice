package basicWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverListeners {

	public static void main(String[] args) {
		
		String baseURL = "http://www.expedia.com/";
		WebDriver driver = new ChromeDriver();
		
		EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
		HandleEvents he = new HandleEvents();
		eDriver.register(he);
		
		eDriver.get(baseURL);
		eDriver.findElement(By.id("tab-flight-tab-hp")).click();

	}

}
