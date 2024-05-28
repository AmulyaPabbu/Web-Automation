package day35;

import org.testng.annotations.*;

public class AllAnnotations {

	@BeforeSuite
	void bs()
	{
		System.out.println("This is before suite");
	}
	
	@AfterSuite
	void as()
	{
		System.out.println("This is after suite");
	}
	
	@BeforeTest
	void t1()
	{
		System.out.println("This is before test method");
	}
	
	@AfterTest
	void t2()
	{
		System.out.println("This is after test method");
	}
	
	@BeforeClass
	void cl1()
	{
		System.out.println("This is before class method");
	}
	
	@AfterClass
	void cl2()
	{
		System.out.println("This is after class method");
	}
	
	@BeforeMethod
	void m1()
	{
		System.out.println("This is before method");
	}
	
	@AfterMethod
	void m2()
	{
		System.out.println("This is after method");
	}
	
	@Test(priority=1)
	void tm1()
	{
		System.out.println("This is test method1");
	}
	
	@Test(priority=2)
	void tm2()
	{
		System.out.println("This is test method2");
	}
	
}
