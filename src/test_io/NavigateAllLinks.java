package test_io;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateAllLinks {
	WebDriver driver;
	// List to save visited links
	static List<String> visitedLinks = new ArrayList<String>();

	public NavigateAllLinks(WebDriver driver) {
		this.driver = driver;
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.walmart.com/");
		new NavigateAllLinks(driver).linkTest();
	}
	
	public void linkTest() {
		// Loop over all the a elements in the page
		for(WebElement link : driver.findElements(By.tagName("a"))) {
			// Check if link is displayed and not previously visited
			if(link.isDisplayed() && !visitedLinks.contains(link.getText())) {
				// add link to list of links already visited
				visitedLinks.add(link.getText());
				System.out.println(link.getText());
				// click on the link. This opens a new page
				link.click();
				new NavigateAllLinks(driver).linkTest();
			}
		}
		driver.navigate().back();
	}
}
