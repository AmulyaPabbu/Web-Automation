package day27;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticTableDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");	
		driver.manage().window().maximize();
		
		//1)find total number of rows
		int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size(); //preferred
		//int rows=driver.findElements(By.tagName("tr")).size(); //use this approach only when there is single table in page
		System.out.println("Number of rows: " +rows);		
		
		//2)find total number of columns
		int cols=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		//int rows=driver.findElements(By.tagName("th")).size();
		System.out.println("Number of columns: " +cols);
		
		//3)read specific row and column data
		//String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr[7]//td[1]")).getText();
		//System.out.println(value);
		
		//4)read data from all rows and columns
	/*	for(int r=2;r<=rows;r++)
		{
			for(int c=1;c<=cols;c++)
			{
				String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(value+"   ");
				
			}
			System.out.println();
		}
		*/
		//5)print book names of specific author
	/*	for(int r=2;r<=rows;r++)
		{
			String author=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			if(author.equals("Amit"))
			{
				String bookname=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.println(author +"  " +bookname);
			}
			
		}
		*/
		//6)find sum of prices for all books 
		int sum=0;
		for(int r=2;r<=rows;r++)
		{
			String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			sum=sum+Integer.parseInt(price);		
		}
		System.out.println("Total Price of books:" +sum);		
	}

}
