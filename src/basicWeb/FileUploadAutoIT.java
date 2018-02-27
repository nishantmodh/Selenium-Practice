package basicWeb;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploadAutoIT {
	
	private WebDriver driver;
	private String baseURL;
 
  @BeforeClass
  public void beforeClass() {
	  baseURL = "http://www.gmail.com/";
	  driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(baseURL);
  }
  
  @Test
  public void fileUploadAutoIT() throws InterruptedException, AWTException, IOException {
	  driver.findElement(By.id("identifierId")).sendKeys(""); // Put username/email Id here
	  driver.findElement(By.id("identifierNext")).click();
	  driver.findElement(By.xpath("//div[@class='aXBtI Wic03c']//input[@name='password']")).sendKeys("");
	  // Enter your password
	  driver.findElement(By.id("passwordNext")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
	  driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("modhnishant@gmail.com"); // Put Sender's email id here
	  driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("Test File Upload");
	  WebElement fileInput = driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']"));
	  fileInput.click();
	  Thread.sleep(3000);
	  
	  Runtime.getRuntime().exec("C:\\Users\\NISHANT\\eclipse-workspace\\SeleniumPractice\\scripts\\fileuploadchrome.exe");
	  
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//div[text()='Send']")).click();
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.quit();
  }

}
