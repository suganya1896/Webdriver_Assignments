package testng.week6;

import java.io.IOException;
import org.testng.annotations.Test;

public class GroupTC {

	@Test(groups = "functional")
	public void testCase1()
		{
			System.out.println("testcase1");
		}
	@Test(groups = "smoke")	
	public void testCase2() throws IOException
	{
		System.out.println("testcase2");
		throw new IOException();
	}
	@Test(groups= "regression")
	public void testCase3()
	{
		System.out.println("testcase3");
	}
	
	@Test(groups = "smoke")
	public void testCase4()
	{
		System.out.println("testcase4");
	}
	@Test(groups="functional")
	public void testCase5()
	{
		System.out.println("testcase5");
	}
	
	@Test(groups="functional")
	public void testCase6()
	{
		System.out.println("testcase6");
	}
	@Test(groups = {"regression","smoke"})
	public void testCase7()
	{
		System.out.println("testcase7");
	}
		
	}


