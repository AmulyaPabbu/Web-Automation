package day38;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener
{
	public void onTestStart(ITestResult result) 
	{
		System.out.println("onTest started");
	  }
	
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("onTest success");
	  }
	
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("onTest failure");
	  }
	
	public void onTestSkipped(ITestResult result) 
	{
	    System.out.println("onTest skipped");
	  }
	
	public void onFinish(ITestContext context) 
	{
		System.out.println("onTest finish");
	  }

}
