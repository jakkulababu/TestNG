package mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SendSMS 
{
	@Test
	public void sendsms() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumMindQ\\chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();	
		driver.get("http://www.way2sms.com/");
		driver.manage().window().maximize();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@name='mobileNo'])[1]")).sendKeys("9986983216");		
		driver.findElement(By.xpath("(//*[@name='password'])[1]")).sendKeys("babu1234");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[contains(text(),'Login')])[2]")).click();
		
		driver.findElement(By.id("mobile")).sendKeys("9986128657");
		
		driver.findElement(By.id("message")).sendKeys("this is test message");
		//Thread.sleep(3000);
		driver.findElement(By.id("sendButton")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"fa icon-logout hidden-xs\"]")).click();
		//Thread.sleep(5000);
		driver.close();
	}

}
