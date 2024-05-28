package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConditionalMethods {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
		//isDisplayed() isEnabled() 
		//logo element
		//WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		//System.out.println("Display status of logo: " +logo.isDisplayed());
		
		//boolean status=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		//System.out.println(status);
		
		//search box
		WebElement searchbox=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		System.out.println(searchbox.isDisplayed());
		System.out.println(searchbox.isEnabled());
		
		//isSelected()
		WebElement male_rd=driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female_rd=driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		//before selection
		System.out.println("Before Selection:  ");
		System.out.println(male_rd.isSelected());
		System.out.println(female_rd.isSelected());
		
		//after selection of male radio button
		System.out.println("After Selection of male radio button:  ");
		male_rd.click();
		System.out.println(male_rd.isSelected());
		System.out.println(female_rd.isSelected());
		
		//after selection of female radio button
		System.out.println("After Selection of female radio button:  ");
		female_rd.click();
		System.out.println(male_rd.isSelected());
		System.out.println(female_rd.isSelected());
		
		
	}

}
