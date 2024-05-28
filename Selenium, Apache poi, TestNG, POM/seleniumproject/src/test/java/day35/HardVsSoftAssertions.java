package day35;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {
	
	/*@Test
	void test_hardassertions()
	{
		System.out.println("testing");
		System.out.println("testing");
		System.out.println("testing");
		System.out.println("testing");
		
		Assert.assertEquals(1, 2);//if it fails then below statements will not be executed
		
		System.out.println("hard assertion completed");
		Assert.assertEquals(1, 1);
		*/
	
		@Test
		void test_softassertions()
		{
			System.out.println("testing");
			System.out.println("testing");
			System.out.println("testing");
			System.out.println("testing");
			
			SoftAssert sa=new SoftAssert();
			sa.assertEquals(1, 2);
			
			System.out.println("assertion completed");
			sa.assertAll(); //mandatory for soft assertions to work
			
		}
		
		
	}


