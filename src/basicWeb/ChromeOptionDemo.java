package basicWeb;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionDemo {

	public static void main(String[] args) {
		String baseURL = "http://www.google.com";
		WebDriver driver;
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\Users\\NISHANT\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\aapbdbdomjkkjkaonfhkkikfgjllcleb\\2.0.6_0.crx"));
		
		driver = new ChromeDriver(options);
		driver.get(baseURL);
	}

}
