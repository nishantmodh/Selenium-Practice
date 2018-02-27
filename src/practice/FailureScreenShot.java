package practice;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class FailureScreenShot {
	private WebDriver driver;
	private String url;
	
	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		url = "https://www.google.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@Test
	public void AssertTest() {
		WebElement element = driver.findElement(By.name("btnK"));
		String value = element.getAttribute("value");
		
		Assert.assertEquals(value, "Search");
	}
	
	@AfterMethod
	public void ScreenShotOnFailure(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println(ITestResult.FAILURE);
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("C:\\Users\\NISHANT\\Desktop\\"+result.getName()+"-"+
								Arrays.toString(result.getParameters())+".jpg"));
		}
	}

}
