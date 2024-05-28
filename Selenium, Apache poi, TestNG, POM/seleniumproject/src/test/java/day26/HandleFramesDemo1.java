package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFramesDemo1 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().maximize();

		//frame1
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("org.openqa.selenium")).click();  
		driver.switchTo().defaultContent(); //switch back to page
		
		//frame2
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("WebDriver")).click();  
		driver.switchTo().defaultContent();
		
		//frame3
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//div[@class='topNav']//a[normalize-space()='Overview']")).click();
		driver.switchTo().defaultContent();
		
		
	}

}
