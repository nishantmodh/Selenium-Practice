package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class multipleSelect {
	private WebDriver driver;
	private String url;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		url = "http://letskodeit.teachable.com/p/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@Test
	public void test() throws InterruptedException {
		Boolean isChecked = false;
		List<WebElement> buttons = driver.findElements(By.xpath("//input[contains(@type,'radio') or contains(@type,'checkbox')]"));
		
		for(int i=0; i<buttons.size(); i++) {
			isChecked = buttons.get(i).isSelected();
			
			if(!isChecked) {
				buttons.get(i).click();
				Thread.sleep(3000);
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
