package testBase;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //for logger
import org.apache.logging.log4j.Logger; //for logger
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public ResourceBundle rb;// to read config.properties
	
	public Logger logger;// for Logging
	
	public WebDriver driver;
	

	@BeforeClass
	@Parameters("browser")   // getting browser parameter from testng.xml
	public void setup(String br)
	{
		rb = ResourceBundle.getBundle("config");// Load config.properties
				
		logger = LogManager.getLogger(this.getClass());// for Logger  
		
		//launch right browser based on parameter
		if (br.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (br.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
					
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(rb.getString("appURL")); // get url from config.properties file
		driver.manage().window().maximize();
	}

	@AfterClass
	public void teadDown() {
		driver.quit();
	}

	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}

}
