package com.facbook.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facbook.base.TestBase;
import com.facebook.pages.HomePage;
import com.facebook.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		
		loginPage = new LoginPage();
		
	}
		
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPage();
		Assert.assertEquals(title, "Facebook - Log In or Sign Up");
	}
	
	@Test(priority=2)
	public void faceBookLogoTest() {
		
		boolean flag= loginPage.validateFacebookImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
