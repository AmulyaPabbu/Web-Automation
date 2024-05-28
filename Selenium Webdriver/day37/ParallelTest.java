package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTest {
	
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser","url"}) //parameter name from xml
	void setup(String br, String appurl) throws InterruptedException //value of parameter stored in br
	{
		if(br.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(appurl);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	}
	
	@Test(priority=1)
	void testUsername()
	{
		try
		{
		boolean status=driver.findElement(By.xpath("//input[@placeholder='Username']")).isDisplayed();
		Assert.assertEquals(status, true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}

	@Test(priority=2)
	void testHomePageTitle()
	{
		Assert.assertEquals(driver.getTitle(), "OrangeHRM", "titles are not matched");
	}
	
	@AfterClass
	void closeApp()
	{
		driver.quit();
	}
}
