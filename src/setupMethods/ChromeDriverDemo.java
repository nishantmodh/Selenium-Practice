package setupMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverDemo {

	public static void main(String[] args) {
		
		//http://chromedriver.storage.googleapis.com/index.html
		
		String baseURL = "http://www.google.com";
		WebDriver driver;
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(baseURL);
		
	}

}
