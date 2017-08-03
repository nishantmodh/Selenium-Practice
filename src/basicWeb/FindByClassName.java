package basicWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindByClassName {
	
	public static void main(String args[]) {
		
		WebDriver driver;
		driver = new FirefoxDriver();
		String baseURL = "https://demostore.x-cart.com/";
		driver.get(baseURL);
		
		driver.findElement(By.className("title")).click();
	}

}
