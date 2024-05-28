package day38;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
	
	public ExtentSparkReporter sparkReporter;  //UI of report
	public ExtentReports extent;  //populate common info on the report
	public ExtentTest test;  //creating test case entries in the report and update status of test methods
	
	public void onStart(ITestContext context) { //generates empty report
		
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html"); //specify location
		
		sparkReporter.config().setDocumentTitle("Automation Report");  //title of report
		sparkReporter.config().setReportName("Funtional testing");  //name of report
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Amulya");
		extent.setSystemInfo("os", "Windows10");
		extent.setSystemInfo("Browser Name", "Chrome,Firefox,Edge");	
			
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test=extent.createTest(result.getName()); //create a new entry in report
	    test.log(Status.PASS, "Test case passed is: "+result.getName());  //update status p/f/s
	    		
	}
	
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case failed is: "+result.getName());
		test.log(Status.FAIL, "Test case failed cause is: " +result.getThrowable());
	}
	
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case skipped is: "+result.getName());
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
