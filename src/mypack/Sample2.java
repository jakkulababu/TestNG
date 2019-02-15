package mypack;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Sample2 
{
  @Test(priority=3)
  public void method1() 
  {
	  System.out.println("in test case 1 in sample2");
  }
  @Test(priority=4)
  public void method2()
  {
	  System.out.println("in test case 2 in sample2");
  }
  @BeforeMethod
  public void method3() 
  {
	  System.out.println("in before method in sample2");
  }
  @AfterMethod
  public void method4() 
  {
	  System.out.println("in after method in sample2");
  }
  @BeforeClass
  public void method5()
  {
	  System.out.println("in before class in sample2");
  }
  @AfterClass
  public void method6() 
  {
	  System.out.println("in after class in samle2");
  }
}