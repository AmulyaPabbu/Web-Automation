package day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CSSSelectorsDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//CSS with tag & id
		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("MacBook");
		//driver.findElement(By.cssSelector("small-searchterms")).sendKeys("MacBook");
		
		//CSS with tag & class
		//ignore content after space in class name
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("MacBook"); 
		//driver.findElement(By.cssSelector("search-box-text")).sendKeys("MacBook"); 

		//CSS with tag & attribute(name/placeholder/any attribute)
		//driver.findElement(By.cssSelector("input[name=\"q\"]")).sendKeys("MacBook");  //regular expression 
		
		//CSS with class & attribute
		//driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("MacBook");
	}

}
