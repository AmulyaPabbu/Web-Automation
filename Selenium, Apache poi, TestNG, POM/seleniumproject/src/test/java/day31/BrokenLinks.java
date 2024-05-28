package day31;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total number of links: " +links.size());
		
		int brokenlinks=0;
		for(WebElement link:links)
		{
			String targetlink=link.getAttribute("href");
			
			//pre requisite for checking broken link
			if(targetlink==null || targetlink.isEmpty())
			{
				System.out.println("href attribute value is empty.");
				continue;
			}
			
			//checking link is broken or not
			URL linkurl=new URL(targetlink); //converts string to url format; so that we can connect to server
			
			//send request to server - open connection and connect to server
			HttpURLConnection connection=(HttpURLConnection)linkurl.openConnection(); //opens connection
			connection.connect(); //connects
			
			if(connection.getResponseCode()>=400)
			{
				System.out.println(link.getText()+"   is a broken link");
				brokenlinks++;
				
			}
			else
			{
				System.out.println(link.getText()+"   is not a broken link");
			}	
			
		}
		
		System.out.println("Total number of broken links: " +brokenlinks);	

	}

}
