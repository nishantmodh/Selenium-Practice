package keypress;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyPressDemo {
	private WebDriver driver;
	private String url;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		url = "https://letskodeit.teachable.com/p/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get(url);
		Thread.sleep(2000);
		//1.Without Key Chord
		//driver.findElement(By.id("openwindow")).sendKeys(Keys.CONTROL + "a");
		
		//2. Using Key Chord
		//driver.findElement(By.id("openwindow")).sendKeys(Keys.chord(Keys.CONTROL + "a"));
		
		//3. Using Key Chord_2
		//String selectAll = Keys.chord(Keys.CONTROL + "a");
		//driver.findElement(By.id("openwindow")).sendKeys(selectAll);
		
		//4. Using Action Class
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		
		Thread.sleep(2000);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
