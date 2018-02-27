package basicWeb;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class FileUpload {
	
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
  public void fileUpload() throws InterruptedException, AWTException {
	  driver.findElement(By.id("identifierId")).sendKeys(""); // Put username/email Id here
	  driver.findElement(By.id("identifierNext")).click();
	  driver.findElement(By.xpath("//div[@class='aXBtI Wic03c']//input[@name='password']")).sendKeys("");
	  // Enter your password
	  driver.findElement(By.id("passwordNext")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
	  driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys(""); // Put Sender's email id here
	  driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("Test File Upload");
	  WebElement fileInput = driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']"));
	  fileInput.click();
	  
	  StringSelection ss = new StringSelection("C:\\Users\\NISHANT\\Desktop\\test.txt");
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	  
	  // Ctrl + v
	  Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_CONTROL);
	  robot.keyPress(KeyEvent.VK_V);
	  robot.keyRelease(KeyEvent.VK_V);
	  robot.keyRelease(KeyEvent.VK_CONTROL);
	  Thread.sleep(3000);
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//div[text()='Send']")).click();
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.quit();
  }

}
