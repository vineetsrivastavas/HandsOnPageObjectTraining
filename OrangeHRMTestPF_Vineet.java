package PFTestCases;

import org.testng.annotations.Test;

import PFPages.LoginPagePF;
import PFPages.OrangeHRMLoginPagePF_Vineet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.LoginPage;
public class OrangeHRMTestPF_Vineet {
	static WebDriver driver;
	OrangeHRMLoginPagePF_Vineet login;
	
	@BeforeTest
	public void beforeAll () throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vineet.srivastva\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		login  = new OrangeHRMLoginPagePF_Vineet(driver);
		
	}
	
	@Test
 
  public void titleTest() {
      
      
	  boolean titlechk = login.chkTitle("OrangeHRM");
	  System.out.println("In Titile check Test Method :" + driver.getTitle().toString());
	  Assert.assertEquals(titlechk, true);
  
  }
	
	@Test
	public void asecurityChk()
	{
		String pwdtype = login.isPasswordMasked();
		System.out.println(pwdtype);
		System.out.println("In Password Masked check Test Method");
		Assert.assertEquals(pwdtype, "password");
	}
@Test	
 public void doLogin()
 {
	 login.setUserCredentials("Admin", "admin123");
	 login.clickLogin();
	 System.out.println("Logged in Method");
 }

@Test
public void validateSuccessLogin() {
	
	String successlogin = login.successLogin();
	Assert.assertEquals(successlogin, "Dashboard");
	
}

@Test
public void validateLeftNavigationHomePage() throws InterruptedException {
	
	String leftNavigation = login.leftNavigationVisible();
	Assert.assertEquals(leftNavigation, "Dashboard");
	Thread.sleep(2000);
	
}

@AfterTest
public void afterAllTest () throws InterruptedException
{
	driver.close();
	
}
	
}
