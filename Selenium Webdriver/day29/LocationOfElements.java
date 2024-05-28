package day29;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocationOfElements {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		WebElement logo=driver.findElement(By.xpath("//img[@alt='company-branding']"));
		System.out.println("After maximizing window: " +logo.getLocation()); //(460, 127)
		
		driver.manage().window().minimize();
		System.out.println("After minimizing window: " +logo.getLocation()); //(276, 69)
				
		driver.manage().window().fullscreen();
		System.out.println("After Fullscreen: " +logo.getLocation()); //(460, 151)
		Thread.sleep(1000);
		
		Point p=new Point(100,100);
		driver.manage().window().setPosition(p);
		System.out.println("After setting window position: " +logo.getLocation()); //(276, 71)
		Thread.sleep(1000);
		
		driver.close();	

	}

}
