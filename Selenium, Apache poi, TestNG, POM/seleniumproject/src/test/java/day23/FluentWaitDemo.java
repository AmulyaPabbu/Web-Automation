package day23;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	
		
		//declaration
		 Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(50))
			       .pollingEvery(Duration.ofSeconds(10))
			       .ignoring(NoSuchElementException.class);
		 
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 driver.manage().window().maximize();
		 
		 //usage
		 WebElement username = mywait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver)
		     {
		       return driver.findElement(By.xpath("//input[@placeholder='Username']"));
		     }
		   });
		 
		 username.sendKeys("Admin");
		 
		

	}

}
