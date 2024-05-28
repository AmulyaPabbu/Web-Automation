package day35pack1;

import org.testng.annotations.*;

public class Class1 {
	
	@Test
	void abc()
	{
		System.out.println("This is abc from class1");
	}

	@BeforeTest
	void m()
	{
		System.out.println("This is before test method");
	}
	
	@BeforeSuite
	void bs()
	{
		System.out.println("This is before suite method");
	}
	
	@AfterSuite
	void as()
	{
		System.out.println("This is after suite method");
	}
}
