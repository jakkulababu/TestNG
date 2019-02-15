package mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testngtest2 
{
  public ChromeDriver driver;
  public WebDriverWait w;
  @BeforeMethod
  public void launch() 
  {
	  System.setProperty("webdriver.chrome.driver", "D:\\SeleniumMindQ\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://www.way2sms.com/");
	  w=new WebDriverWait(driver, 60);
	  w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
	  driver.manage().window().maximize();  
  }
  @Test(priority=1)
  public void validatetitle() 
  {
	  String t=driver.getTitle();
	  if(t.contains("Free SMS")) 
	  {
		  Reporter.log("Title test Passed");
		  Assert.assertTrue(true);	  
		  
	  }
	  else 
	  {
		  Reporter.log("Title test Failed");
		  Assert.assertTrue(false);		  
	  }
  }
  @AfterMethod
  public void closesite() throws Exception 
  {
	  //Thread.sleep(5000);
	  driver.quit();
  }
}
