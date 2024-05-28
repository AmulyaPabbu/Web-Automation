package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SliderDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		//Minimum slider
		WebElement minSlider=driver.findElement(By.xpath("//span[1]"));
		System.out.println("Current Location of element: "+minSlider.getLocation()); //(59, 249) (x-axis,y-axis)
		
		act.dragAndDropBy(minSlider, 100, 249).perform();
		
		System.out.println("Location of element after moving: "+minSlider.getLocation()); //(161, 249)
		
		//Maximum slider
		WebElement maxSlider=driver.findElement(By.xpath("//span[2]"));
		System.out.println("Current Location of element: "+maxSlider.getLocation()); //(595, 249) (x-axis,y-axis)
		
		act.dragAndDropBy(maxSlider, -100, 249).perform();
		
		System.out.println("Location of element after moving: "+maxSlider.getLocation()); //(493, 249)	

	}

}
