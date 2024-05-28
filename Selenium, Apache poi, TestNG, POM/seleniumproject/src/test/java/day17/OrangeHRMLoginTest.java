package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*1)Launch browser.
2)Open url - https://opensource-demo.orangehrmlive.com/
3)Provide username - Admin.
4)Provide password - admin123.
5)Click on submit button.
6)Verify the title of dashboard page.
Exp title - OrangeHRM.
7)Close browser.
*/

import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLoginTest {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");		
	    //WebDriverManager.chromedriver().setup();
		
		 //1)Launch browser.
		//ChromeDriver driver=new ChromeDriver(); - holds only object of chromedriver
		WebDriver driver=new ChromeDriver();      //holds object of any driver class.
		
		 //2)Open url - https://opensource-demo.orangehrmlive.com/
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.manage().window().maximize();  //chaining of methods; maximizes the page
		
		Thread.sleep(5000);		
		
		//3)Provide username - Admin.
		//WebElement txtUsername=driver.findElement(By.name("username"));
		//txtUsername.sendKeys("Admin");
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		//4)Provide password - admin123.
		driver.findElement(By.name("password")).sendKeys("admin");
		
		//5)Click on submit button.
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(7000);
		
		//6)Verify the title of dashboard page.
		//Title validation
		/*String act_title=driver.getTitle();
		String exp_title="OrangeHRM";
		
		if(act_title.equals(exp_title))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Failed");		
		}
		*/
		
		//Label validation after successful login
		String act_label=null;
		
		try
		{
		act_label=driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText(); //double quotes inside double quotes is not allowed so make it single quotes
		}
		catch(NoSuchElementException e)
		{
			act_label="";  //if we don't make it empty, it will be null and we cannot compare/apply methods on null.
		}
		String exp_label="Dashboard";
	
		
		if(act_label.equals(exp_label))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
			
		}
		//7)Close browser.
		// driver.close();
		//driver.quit();
	}

}
