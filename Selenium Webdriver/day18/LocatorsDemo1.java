package day18;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LocatorsDemo1 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		//open app
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("search_query_top")).sendKeys("T-shirts"); //search box
		
		driver.findElement(By.name("submit_search")).click(); //search button
		
		driver.findElement(By.linkText("Printed Chiffon Dress")).click(); //complete value of linktext
		
		driver.findElement(By.partialLinkText("Printed Chiffon")); //only some portion is enough - partial
		
		List<WebElement> sliders=driver.findElements(By.className("homeslider-container")); //returns list of webelements
		System.out.println("Number of sliders are: " +sliders.size());
		
		List<WebElement> images=driver.findElements(By.tagName("img"));
		System.out.println("Number of images are: " +images.size());
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Number of links are: " +links.size());
		
		driver.quit();
		
		
		
		
		
		
		

	}

}
