package mypack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class Testngtest1 
{
  @Test
  public void f()
  {
	  System.setProperty("webdriver.chrome.driver", "D:\\SeleniumMindQ\\chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.google.co.in");
	  WebDriverWait w=new WebDriverWait(driver, 20);
	  w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
	  driver.manage().window().maximize();
	  String t=driver.getTitle();
	  if(t.contains("Google")) 
	  {
		  Reporter.log("Title test Passed");
		  Assert.assertTrue(true);	  
		  
	  }
	  else 
	  {
		  Reporter.log("Title test Failed");
		  Assert.assertTrue(false);		  
	  }
	  
	  driver.close();
	  //System.out.println("i am one");
  }
}
