package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facbook.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//div[contains(text(),'Summer Sharotri')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span//div[contains(text(),'Marketplace')]")
	WebElement MarketplaceLink;
	
	@FindBy(xpath="//span//div[contains(text(),'Pages')]")
	WebElement PagesLink;
	
	//Initializing the Page Object
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
		
	}
	public String verifyHomePageTitle() {
		return driver.getTitle();
		
	}
	
	public MarketPlace clickOnMarketPlaceLink() {
		MarketplaceLink.click();
		return new MarketPlace();
		 
	}
	public  PagesPage clickOnPagesLink() {
		PagesLink.click();
		return new PagesPage();
		 
	}
}
