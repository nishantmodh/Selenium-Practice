package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	public static WebElement element;
	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navidateToFlights() {
		element = driver.findElement(By.id("tab-flight-tab-hp"));
		element.click();
	}
	
	public void fillOriginBox(String origin) {
		element = driver.findElement(By.id("flight-origin-hp-flight"));
		element.sendKeys(origin);
	}
	
	public void fillDestinationBox(String destination) {
		element = driver.findElement(By.id("flight-destination-hp-flight"));
		element.sendKeys(destination);
	}
	
	public void departureDate(String departureDate) {
		element = driver.findElement(By.id("flight-departing-hp-flight"));
		element.sendKeys(departureDate);
	}
	
	public void returnDate(String returnDate) {
		element = driver.findElement(By.id("flight-returning-hp-flight"));
		element.clear();
		element.sendKeys(returnDate);
	}
	
	public void clickSearchButton() {
		driver.findElement(By.xpath(".//*[@id='gcw-flights-form-hp-flight']/div[8]/label/button")).click();
	}
}
