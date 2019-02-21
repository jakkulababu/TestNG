package mypack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Sample1 
{
  @Test(priority=1)
  public void testCase1() 
  {
	  System.out.println("i am in test case1 sample1");
  }
  @Test(priority=2)
   public void testcase2() 
  {
	  System.out.println("i am in  test case 2 in sample1");
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("in before Method in sample1");
  }
  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("in after Method in sample1");
  }
  @BeforeClass
  public void beforeClass() 
  {
	  System.out.println("in before Class in sample1");
  }
  @AfterClass
  public void afterClass() 
  {
	  System.out.println("in after class in sample1");
  }
  @BeforeTest
  public void beforeTest() 
  {
	System.out.println("in before test");  
  }
  @AfterTest
  public void afterTest() 
  {
	  System.out.println("in after Test");
  }
  @BeforeSuite
  public void beforeSuite() 
  {
	  System.out.println("in before suite");
  }
  @AfterSuite
  public void afterSuite() 
  {
	  System.out.println("in after suite");
  }
}