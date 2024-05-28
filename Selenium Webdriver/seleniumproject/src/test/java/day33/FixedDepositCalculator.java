package day33;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FixedDepositCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		//capture file location to pass to excel utils
		String file=System.getProperty("user.dir")+"\\testdata\\caldata.xlsx";
		
		//get number of rows
		int rows=ExcelUtils.getRowCount(file, "Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
			//read data from excel
			String princple=ExcelUtils.getCellData(file, "Sheet1", i, 0);
			String roi=ExcelUtils.getCellData(file, "Sheet1", i, 1);
			String period1=ExcelUtils.getCellData(file, "Sheet1", i, 2);
			String period2=ExcelUtils.getCellData(file, "Sheet1", i, 3);
			String freq=ExcelUtils.getCellData(file, "Sheet1", i, 4);
			String exp_mv=ExcelUtils.getCellData(file, "Sheet1", i, 5);
			
			//pass data to app
			driver.findElement(By.id("principal")).sendKeys(princple);
			driver.findElement(By.id("interest")).sendKeys(roi);
			driver.findElement(By.id("tenure")).sendKeys(period1);
			
			Select perioddrp=new Select(driver.findElement(By.id("tenurePeriod")));
			perioddrp.selectByVisibleText(period2);
			
			Select frqdrp=new Select(driver.findElement(By.id("frequency")));
			frqdrp.selectByVisibleText(freq);
			
			JavascriptExecutor js=(JavascriptExecutor)driver;			
			WebElement calculate_btn=driver.findElement(By.xpath("//div[@class='cal_div']//a[1]"));	
			js.executeScript("arguments[0].click();", calculate_btn);  //clicking on calculate btn
			
			//validation & update result in excel
			String act_mv=driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
			
			//both mvs are in string format so convert into decimal to get accurate result after comparison

			if( Double.parseDouble(exp_mv)==Double.parseDouble(act_mv))
			{
				System.out.println("Test Passed");
				ExcelUtils.setCellData(file, "Sheet1", i, 7, "Passed");
				ExcelUtils.fillGreenColor(file, "Sheet1", i, 7);
			}
			else
			{
				System.out.println("Test Failed");
				ExcelUtils.setCellData(file, "Sheet1", i, 7, "Failed");
				ExcelUtils.fillRedColor(file, "Sheet1", i, 7);
			}	
			Thread.sleep(3000);
			
			//clear the data before validating next row data
			WebElement clear_btn=driver.findElement(By.xpath("//img[@class='PL5']"));
			js.executeScript("arguments[0].click();", clear_btn);
						
		}
		
		
	}

}
