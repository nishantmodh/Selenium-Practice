package test_io;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkAllLinks {
	WebDriver driver;
	String homepage;
	String url = "";
	HttpURLConnection huc =null;
	int respCode = 200;

	@Before
	public void setUpBeforeClass() throws Exception {
		driver = new ChromeDriver();
		homepage = "http://www.warehouse.co.uk/gb/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(homepage);
	}

	@Test
	public void test() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();
		
		while(it.hasNext()) {
			url = it.next().getAttribute("href");
			System.out.println(url);
			
			if(url == null || url.isEmpty()) {
				System.out.println("Url is not working " +url);
				continue;
			}
			if(!url.startsWith(homepage)) {
				System.out.println("URL belongs to another domain." +url);
				continue;
			}
			try {
				huc = (HttpURLConnection)(new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				respCode = huc.getResponseCode();
				
				if(respCode >= 400) {
					System.err.println(url+" Link is broken");
				}else {
					System.out.println(url+" is a valid link");
				}
			}catch(MalformedURLException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@After
	public void tearDownAfterClass() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
