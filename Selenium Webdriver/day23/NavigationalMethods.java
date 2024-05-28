package day23;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationalMethods {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	
		
		driver.navigate().to("https://www.amazon.com");
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().to("https://www.flipkart.com");
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().refresh();
		
		
		
		

	}

}
