package basicWeb;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandleAuthenticationAutoIT {
	
	private WebDriver driver;
	private String baseURL;
 
  @BeforeClass
  public void beforeClass() {
	  baseURL = "http://engprod-charter.net";
	  driver = new FirefoxDriver();
	  
	  //driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @Test
  public void HandleAuthentication() throws InterruptedException, AWTException, IOException {
	  Runtime.getRuntime().exec("C:\\Users\\NISHANT\\eclipse-workspace\\SeleniumPractice\\scripts\\Authentication.exe");
	  driver.get(baseURL);
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.quit();
  }

}
