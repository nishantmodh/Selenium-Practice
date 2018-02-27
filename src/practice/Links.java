package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Links {
	
	public static List<WebElement> clickableLinks(WebDriver driver){
		List<WebElement> allLinks = new ArrayList<WebElement>();
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		elements.addAll(driver.findElements(By.tagName("img")));
		
		for(WebElement element : elements) {
			if(element.getAttribute("href") != null) {
				allLinks.add(element);
			}
		}
		return allLinks;
	}
	
	public static String linkStatus(URL url) {
		try {
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			http.connect();
			String response = http.getResponseMessage();
			http.disconnect();
			return response;
		} catch (IOException e) {
			return e.getMessage();
		}
	}
}
