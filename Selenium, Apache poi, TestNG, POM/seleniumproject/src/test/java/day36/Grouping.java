package day36;

import org.testng.annotations.Test;

/*
 * loginByEmail - sanity&regression
 * loginByfacebook - sanity
 * loginBytwitter - sanity
 * 
 * signupbyemail - sanity & regression
 * signupbyfacebook - regression
 * signupbytwitter - regression
 * 
 * paymentinrupees - sanity & regression
 * paymentindollar - sanity
 * paymentReturnbybank - regression
 */


public class Grouping {
	
	@Test(priority=1, groups={"sanity","regression"})
	void loginByEmail()
	{
		System.out.println("this is login by email");
	}
	@Test(priority=2, groups={"sanity"})
	void loginByFacebook()
	{
		System.out.println("this is login by facebook");
	}
	@Test(priority=3, groups={"sanity"})
	void loginByTwitter()
	{
		System.out.println("this is login by twitter");
	}
	@Test(priority=4, groups={"sanity","regression"})
	void signUpByEmail()
	{
		System.out.println("this is signUp by email");
	}
	@Test(priority=5, groups={"regression"})
	void signUpByFacebook()
	{
		System.out.println("this is signUp by facebook");
	}
	@Test(priority=6, groups={"regression"})
	void signUpTwitter()
	{
		System.out.println("this is signUp by twitter");
	}
	@Test(priority=7, groups={"sanity","regression"})
	void paymentInRupees()
	{
		System.out.println("this is payment in rupees");
	}
	@Test(priority=8, groups={"sanity"})
	void paymentInDollar()
	{
		System.out.println("this is payment in dollar");
	}
	@Test(priority=9, groups={"regression"})
	void paymentReturnByBank()
	{
		System.out.println("this is payment return by bank");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
