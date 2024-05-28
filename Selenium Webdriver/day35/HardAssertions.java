package day35;

import org.testng.Assert;
import org.testng.annotations.*;

public class HardAssertions {

	@Test
	void test()
	{

	/*	int x=10;
		int y=15;
		
		//if else cannot make the test method pass/fail
		if(x==y)
		{
			System.out.println("test passed");
		}
		else
		{
			System.out.println("test failed");
		}
		*/
		
		//Assert.assertEquals(x, y);
		//Assert.assertTrue(false);
		
		int a=20;
		int b=10;
		
		//Assert.assertEquals(actual, expected, description)
		//Assert.assertEquals(a>b, true, "a is greater than b"); 	
		
		String s1="abc1";
		String s2="abc";
		
		//Assert.assertEquals(s1, s2, "Strings are not equal"); //fail
		
		//Assert.assertNotEquals(s1, s2); //pass
		
		if(false)
		{
			Assert.assertTrue(true);		
		}
		else
		{
			//Assert.assertTrue(false);
			Assert.fail();
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
