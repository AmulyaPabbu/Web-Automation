package day36;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderDemo {
	
	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	@Test(dataProvider="dp") //here dataprovider is parameter of test annotation
	void testLogin(String email, String pwd)
	{
		driver.get("https://demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("Email")).sendKeys("email");
		driver.findElement(By.id("Password")).sendKeys("pwd");
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		
		String exp_title= "nopCommerce demo store";
		String act_title=driver.getTitle();
		
		Assert.assertEquals(exp_title, act_title);
		
	}
	
	@AfterClass
	void tearDown()
	{
	   driver.close();	
	}

	@DataProvider(name="dp", indices= {0,4}) //here dataprovider is annotation itself //if using different datatypes of parameters then use object datatype
	String[][] loginData()
	{
		String data[][]= { 
				{"abc@gmail.com", "abcxyz"},
				{"xyz@gmail.com", "abxyz"},
				{"abcxyz@gmail.com", "abyz"},
				{"xyzabc@gmail.com", "xyz"},
				{"abxy@gmail.com", "z"}
				};
		
		return data;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
