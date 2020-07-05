package com.facbook.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facbook.base.TestBase;
import com.facebook.pages.HomePage;
import com.facebook.pages.LoginPage;
import com.facebook.pages.PagesPage;

public class CreatePagesTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	PagesPage pagespage;
	
	public CreatePagesTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
	initialization();
	
	loginPage = new LoginPage();
	pagespage = new PagesPage();
	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	@Test
	public void varifyPageTitleTest() {
		String pagetitile=pagespage.varifyPageTitle();
		System.out.println(pagetitile);
		Assert.assertEquals(pagetitile, "Facebook - Log In or Sign Up","page title did not match");
		
	}
	@Test
	public void verifyCreateNewPageButtonTest() throws InterruptedException {
		Thread.sleep(5000);
		homePage.clickOnPagesLink();
		pagespage.verifyCreateNewPageButton();
		Thread.sleep(4000);
	}
	
	@Test
	public void verifycreateNewPageTitleTest() throws InterruptedException {
		
		Thread.sleep(5000);
		homePage.clickOnPagesLink();
		pagespage.verifyCreateNewPageButton();
		Thread.sleep(4000);
		Assert.assertTrue(pagespage.verifycreateNewPageTitle());
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
