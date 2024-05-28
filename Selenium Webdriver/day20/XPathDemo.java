package day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPathDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		//using relative xpath
		//String productname=driver.findElement(By.xpath("//a[text()='MacBook']")).getText();   //returns text of element
		//System.out.println(productname);
		
		//using abs xpath
		String productname=driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div[2]/div[1]/form/div/div[2]/div[1]/h4/a")).getText();
		System.out.println(productname);
		
	}

}
