package day35pack1;

import org.testng.annotations.*;

public class Class2 {

	@Test
	void xyz()
	{
		System.out.println("This is xyz from class2");
	}
	
	@AfterTest
	void n()
	{
		System.out.println("This is after test method");
	}
}
