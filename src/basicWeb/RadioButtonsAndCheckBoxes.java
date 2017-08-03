package basicWeb;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButtonsAndCheckBoxes {
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "http://letskodeit.teachable.com/p/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		driver.get(baseURL);
	}
	
	@Test
	public void test() throws Exception {
		WebElement bmwRadioButton = driver.findElement(By.id("bmwradio"));
		bmwRadioButton.click();
		
		Thread.sleep(2000);
		WebElement benzRadioButton = driver.findElement(By.id("benzradio"));
		benzRadioButton.click();
		
		WebElement bmwCheckBox = driver.findElement(By.id("bmwcheck"));
		bmwCheckBox.click();
		
		Thread.sleep(2000);
		WebElement benzCheckBox = driver.findElement(By.id("benzcheck"));
		benzCheckBox.click();
		
		System.out.println("BMW radio button is selected? "+bmwRadioButton.isSelected());
		System.out.println("Benz radio button is selected? "+benzRadioButton.isSelected());
		System.out.println("BMW checkbox is selected? "+bmwCheckBox.isSelected());
		System.out.println("Benz checkbox is selected? "+benzCheckBox.isSelected());
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
