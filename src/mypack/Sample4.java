package mypack;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Sample4 
{
  public ChromeDriver driver;
  public WebDriverWait w;
  @DataProvider(name="testdata")//property name "test data"
  public Object[][] method()
  {
	  //Row - no : of time test has to be repeated
	  //Columns - number of parameters in test data
	  Object[][] data=new Object[5][4];
	  //1st row
	  data[0][0]="9986983216";
	  data[0][1]="valid";
	  data[0][2]="babu1234";
	  data[0][3]="valid";
	  //2nd row
	  data[1][0]="";
	  data[1][1]="invalid";
	  data[1][2]="babu1234";
	  data[1][3]="valid";
	  //3rd row
	  data[2][0]="9986";
	  data[2][1]="invalid";
	  data[2][2]="babu1234";
	  data[2][3]="valid";
	  //4th row
	  data[3][0]="9986983216";
	  data[3][1]="valid";
	  data[3][2]="";
	  data[3][3]="valid";
	  //5th row
	  data[4][0]="9986983216";
	  data[4][1]="valid";
	  data[4][2]="xxxx";
	  data[4][3]="invalid";
	  //return array
	  return(data);
  }//test data method ending
	  
	  @BeforeMethod
	  public void lanch() 
	  {
		  System.setProperty("webdriver.chrome.driver", "D:\\SeleniumMindQ\\chromedriver.exe");
			driver=new ChromeDriver();
			driver .get("http://www.way2sms.com/");
			WebDriverWait w=new WebDriverWait(driver ,20);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
			driver.manage().window().maximize();
	  }
	  @Test(dataProvider="testdata")
	  public void dologin(String x,String y,String z,String w) throws Exception
	  {
		    driver.findElement(By.name("mobileNo")).sendKeys(x);
			driver.findElement(By.name("password")).sendKeys(z);
			driver.findElement(By.xpath("(//button[contains(text(),'Login')])[1]")).click();
			Thread.sleep(5000);
			//validations
			try 
				{
				if(x.length()==0 && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
				{
					Reporter.log("1.Blank Mobile number test passed");
					Assert.assertTrue(true);
				}
				else if(x.length()<10 && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed()) 
				{
					Reporter.log("2.Wrong size mobile number test passed");
					Assert.assertTrue(true);	
				}
				else if(z.length()==0 && driver.findElement(By.xpath("(//*[contains(text(),'Enter password')])[2]")).isDisplayed()) 
				{
					Reporter.log("3.Blank password test passed");
					Assert.assertTrue(true);
				}
				else if(y.equalsIgnoreCase("invalid") && driver.findElement
					(By.xpath("(//*[contains(text(),'not register with us.')])[1]")).isDisplayed())
				{	
					Reporter.log("4.Invalid mobile number test passed");
					Assert.assertTrue(true);
				}
				else if(y.equalsIgnoreCase("valid") && 
				    w.equalsIgnoreCase("invalid") && 
				    driver.findElement(By.xpath("(//*[contains(text(),'password! Try Again.')])[1]")).isDisplayed())
				{
					Reporter.log("5.Invalid pws test passed");
					Assert.assertTrue(true);
				}
				else if(y.equalsIgnoreCase("Valid") &&
					w.equalsIgnoreCase("Valid") &&
					driver.findElement(By.xpath("//*[contains(text(),'SendSMS')]")).isDisplayed())
							
				{
					Reporter.log("6. Valid data test passed");
					Assert.assertTrue(true);
				}
				else 
				{
					SimpleDateFormat sf=new SimpleDateFormat("dd-mm-yy-hh-mm-ss");
					Date d=new Date();
					String ssname=sf.format(d)+".png";
					File src=driver.getScreenshotAs(OutputType.FILE);
					File dest=new File(ssname);
					FileHandler.copy(src, dest);
					Reporter.log("Login test failed an see");
					String sspath="path"+ssname;
					String code="<img src=\"file:///"+sspath+"\" alt=\"\"/>";
					Reporter.log(code);
					Assert.assertTrue(false);
				}

			}
			catch(Exception ex) 
			{
				Reporter.log(ex.getMessage());
				Assert.assertTrue(false);
			}
	  }
	  @AfterMethod
	  public void closesite() 
	  {
		driver.quit();  
	  }	  
}
