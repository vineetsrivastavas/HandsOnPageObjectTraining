package PFPages;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrangeHRMLoginPagePF_Vineet {
	WebDriver driver;
	
	/*
	 By username=By.id("username");
	 By password=By.id("password");
	 By loginbtn = By.cssSelector("#login > button > i");
	 By footer = By.linkText("Elemental Selenium"); */
	
	 @FindBy (xpath ="//input[@name='username']") 
	 private WebElement username;

	 @FindBy (xpath ="//input[@name='password']") 
	 private WebElement password;
	 
	 @FindBy(xpath = "//button[@type='submit']")
	 private WebElement loginbtn;
	 
	 @FindBy(xpath = "//h6[contains(.,'Dashboard')]")
	 private WebElement successLoginText;
	 
	 @FindBy(xpath = "//span[text()='Dashboard']")
	 private WebElement leftNavigation;
	 
	//Constructor
	public OrangeHRMLoginPagePF_Vineet(WebDriver p_driver)
	{
		this.driver = p_driver;
		PageFactory.initElements(driver, this);
	}
	
	//getter and setter methods
	
	public void setUserCredentials(String un,String pw)
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		
	}
	
	public void clickLogin()
	{
		loginbtn.click();
	}
	
	public boolean chkTitle(String expTitle)
	{
		return driver.getTitle().contains(expTitle);
	}
	
	public String isPasswordMasked()
	{
		
		System.out.println(password.getAttribute("type"));
		return password.getAttribute("type");
	}
	
	public String successLogin()
	{
		
		System.out.println(successLoginText.getText());
		return successLoginText.getText();
	}
	
	public String leftNavigationVisible()
	{
		
		System.out.println(leftNavigation.getText());
		return leftNavigation.getText();
	}
	
}
