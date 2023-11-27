package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class NewTest {
	
	WebDriver driver;

  @Test (priority = 5)
  public void forgot_password() {
	
	  driver.findElement(By.linkText("Forgot your password?")).click();
//	 driver.findElement(By.linkText("Contacts")).click();
//	 driver.findElement(By.xpath("//span [text() ='Contacts']")).click();
//	  
	  
  }
	  @Test (priority = 6)
	  public void signup() {
		  
		  driver.findElement(By.linkText("Sign Up")).click();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gggg\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://ui.cogmento.com/deals");
//		 driver.findElement(By.name("email")).sendKeys("abdocr77@gmail.com");
//		 driver.findElement(By.name("password")).sendKeys("abdo MO11");
//		 driver.findElement(By.xpath("//div [@class='ui fluid large blue submit button']")).click();

  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }
  
  	
}
