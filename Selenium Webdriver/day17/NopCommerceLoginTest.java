package day17;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1)Launch browser.
2)Open url - https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F
3)Provide username - admin@yourstore.com
4)Provide password - admin
5)Click on submit button.
6)Verify the title of dashboard page.
Exp title - Dashboard / nopCommerce administration
7)Close browser.

 */

public class NopCommerceLoginTest {

	public static void main(String[] args) throws InterruptedException {
		//1)Launch browser.
		WebDriver driver=new ChromeDriver();
		
		//2)Open url
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//3)Provide username - admin@yourstore.com
		WebElement txt_ele=driver.findElement(By.name("Email"));
		txt_ele.clear();
		Thread.sleep(2000);
		txt_ele.sendKeys("admin@yourstore.com");
		
		//4)Provide password - admin
		WebElement txt_pwd=driver.findElement(By.id("Password"));
		txt_pwd.clear();
		Thread.sleep(2000);
		txt_pwd.sendKeys("admin");
		
		//5)Click on submit button.
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
		Thread.sleep(7000);
		
		//6)Verify the title of dashboard page.
		//Title validation
		/*
		String act_title=driver.getTitle();	
		String exp_title="Dashboard / nopCommerce administration";
		if(act_title.equals(exp_title))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		*/
		
		//Label validation
		String act_label="";
		try {
	    act_label=driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/h1")).getText();
	    //System.out.println(act_label);
		}
		catch(NoSuchElementException e)
		{
			
		}
		String exp_label="Dashboard";
		if(act_label.equals(exp_label))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}

		//7)Close browser.
		driver.close();
		
	}

}
