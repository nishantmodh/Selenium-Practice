package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {
	WebDriver driver;
	
	@FindBy(id="header-container")
	WebElement header;
	
	@FindBy(id="tab-flight-tab-hp")
	WebElement flightTab;
	
	@FindBy(id="flight-origin-hp-flight")
	WebElement originCity;
	
	@FindBy(id="flight-destination-hp-flight")
	WebElement destinationCity;
	
	@FindBy(id="flight-departing-hp-flight")
	WebElement departureDate;
	
	@FindBy(id="flight-returning-hp-flight")
	WebElement returnDate;
	
	@FindBy(xpath=".//*[@id='gcw-flights-form-hp-flight']/div[8]/label/button")
	WebElement searchButton;
	
	public HomePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFlightTab() {
		header.click();
		flightTab.click();
	}
	
	public void setOriginCity(String origin) {
		originCity.sendKeys(origin);
	}
	
	public void setDestinationCity(String destination) {
		destinationCity.sendKeys(destination);
	}
	
	public void setDepartureDate(String dDate) {
		departureDate.sendKeys(dDate);
	}
	
	public void setReturnDate(String rDate) {
		returnDate.clear();
		returnDate.sendKeys(rDate);
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
}
