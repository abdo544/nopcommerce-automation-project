package testng;

import org.testng.Assert;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class crm {
	
	WebDriver driver;
	
	//@Parameters(("url"))
	@BeforeMethod
	public void before() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gggg\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com");
	
	}
	
	
 @Test (priority = 4 , groups = ("E2E"))
 public void url() {
	 
	 String actualresult = driver.getCurrentUrl();
	 String expectedresult = ("https://demo.nopcommerce.com/");
	 System.out.println(actualresult);
 }



  @Test (priority = 2)
  public void title() {
	  
	  
	  String actualresult = driver.getTitle();
	  String expectedresult = ("nopCommerce demo store");
	  System.out.println(actualresult);
  }

  @Test (priority = 3)
  public void logo() {
	  
	  WebElement logo = driver.findElement(By.xpath("//img[@src='https://demo.nopcommerce.com/Themes/DefaultClean/Content/images/logo.png']"));
	  boolean actualresult = logo.isDisplayed();
	  boolean expectedresult = true;
	  System.out.println(actualresult);
	  
  }
  
  @Test (priority = 1 , dataProvider = "mydata")
  public void login(String username, String password) {
	  
	  driver.findElement(By.className("ico-login")).click();
	  driver.findElement(By.name("Email")).sendKeys(username);
	  driver.findElement(By.name("Password")).sendKeys(password);
	  driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
	  
  }

  @Test
  public void computers() {
	  
	  driver.findElement(By.partialLinkText("Comput")).click();
	  driver.findElement(By.linkText("Electronics")).click();
	  
	  WebElement testerhub = driver.findElement(By.linkText("Tester’s Hub"));
	  Actions action =new Actions(driver);
	  action.moveToElement(testerhub);
  };
  
  
  
  @DataProvider
  public Object[][] mydata() {
	  
	  Object [][] data = new Object [4][2];
	  
	  data [0][0] = "abdocr77@gmail.com";
	  data [0][1] = "abdo mo11";
	  data [1][0] = "abdocr77@gmail.com";
	  data [1][1] = "abdo mo";
	  data [2][0] = "abdocr@gmail.com";
	  data [2][1] = "abdo mo11";
	  data [3][0] = "abdocrr@gmail.com";
	  data [3][1] = "abdo moo";
	  
	  return data;

  }
  
  
@AfterMethod
public void after() {
		driver.quit();}
}
