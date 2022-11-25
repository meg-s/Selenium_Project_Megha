package day3;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;

public class MyFirstTestNGTest3 
{
	@Test
	public void login()
	{
		Assert.assertTrue(true);
		System.out.println("Login Done");
		Reporter.log("Login Done", true);
	}


	@Test(dependsOnMethods = "login")
	public void logOutFromApplication()
	{
		System.out.println("Logout Done");
	}
	

}
