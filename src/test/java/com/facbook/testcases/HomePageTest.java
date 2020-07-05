package com.facbook.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facbook.base.TestBase;
import com.facebook.pages.HomePage;
import com.facebook.pages.LoginPage;
import com.facebook.pages.MarketPlace;
import com.facebook.pages.PagesPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	MarketPlace marketplacelink;
	PagesPage pagespage;

	public HomePageTest() {
		super();
	}

	// testcases should be separated -- independent with each other
	// before each test cases -- launch the browser and login
	// @test -- execute test case
	// after each testcase -- close the browser

	@BeforeMethod
	public void setUp() {

		initialization();

		marketplacelink = new MarketPlace();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() throws InterruptedException {
		String homePagetitle = homePage.verifyHomePageTitle();
		System.out.println(homePagetitle);
		Thread.sleep(4000);
		Assert.assertEquals(homePagetitle, "Facebook - Log In or Sign Up");// the message here is only printed if
																			// testcase got failed
	}

	@Test(priority = 2)
	public void verifyCorrectUsernameTest() throws InterruptedException {
		Thread.sleep(4000);
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}

	@Test(priority = 3)

	public void verifyMarketplacelinktest() throws InterruptedException {
		Thread.sleep(4000);
		marketplacelink = homePage.clickOnMarketPlaceLink();
		Thread.sleep(4000);
	}
	@Test(priority =4)
	public void verifyPagepagelinkTest() throws InterruptedException {
		Thread.sleep(4000);
		pagespage=homePage.clickOnPagesLink();
		Thread.sleep(4000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
