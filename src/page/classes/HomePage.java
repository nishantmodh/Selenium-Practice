package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public static WebElement element = null;
	
	/**
	 * Returns the flight origin text box element
	 * @param driver
	 * @return
	 */
	public static WebElement originTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-origin-hp-flight"));
		return element;
	}
	
	public static void fillOriginTextBox(WebDriver driver, String origin) {
		element = originTextBox(driver);
		element.sendKeys(origin);
	}
	
	/**
	 * Returns the flight destination text box element
	 * @param driver
	 * @return
	 */
	public static WebElement destinationTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-destination-hp-flight"));
		return element;
	}
	
	public static void fillDestinationTextBox(WebDriver driver, String destination) {
		element = destinationTextBox(driver);
		element.sendKeys(destination);
	}
	
	/**
	 * Returns the departure date text box element
	 * @param driver
	 * @return
	 */
	public static WebElement departureDateTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-departing-hp-flight"));
		return element;
	}
	
	public static void fillDepartureDateTextBox(WebDriver driver, String departureDate) {
		element = departureDateTextBox(driver);
		element.sendKeys(departureDate);;
	}
	
	/**
	 * Returns the return date text box element
	 * @param driver
	 * @return
	 */
	public static WebElement returnDateTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-returning-hp-flight"));
		return element;
	}
	
	public static void fillReturnDateTextBox(WebDriver driver, String returnDate) {
		element = returnDateTextBox(driver);
		element.sendKeys(returnDate);
	}
	
	/**
	 * Returns the search button box element
	 * @param driver
	 * @return
	 */
	public static WebElement SearchButton(WebDriver driver) {
		element = driver.findElement(By.xpath(".//*[@id='gcw-flights-form-hp-flight']/div[8]/label/button"));
		return element;
	}
	
	/**
	 * Click on search button
	 * @param driver
	 */
	public static void clickOnSearchButton(WebDriver driver) {
		element = SearchButton(driver);
		element.click();
	}
	
	/**
	 * Navigate to flights tab
	 * @param driver
	 */
	public static void navigateToFlightTab(WebDriver driver) {
		element = driver.findElement(By.id("tab-flight-tab-hp"));
		element.click();
	}

}
