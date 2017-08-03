package basicWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindByLinkText {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		driver = new FirefoxDriver();
		String baseURL = "https://demostore.x-cart.com/";
		driver.get(baseURL);
		
		driver.findElement(By.linkText("iGoods")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.partialLinkText("Terms")).click();
	}

}