package day22;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//get(url)
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//getTitle()
		System.out.println("Title of page: " +driver.getTitle());
		
		//getCurrentUrl()
		System.out.println("Current Url is: " +driver.getCurrentUrl());
		
		//getPageSource()
		//System.out.println("Page Source is: ");
		//System.out.println(driver.getPageSource());
		
		//getWindowHandle()
		System.out.println(driver.getWindowHandle());
		
		//getWindowHandles()
		Thread.sleep(3000);
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		Set<String> windowids=driver.getWindowHandles();
		for(String winid:windowids)
		{
			System.out.println(winid);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
