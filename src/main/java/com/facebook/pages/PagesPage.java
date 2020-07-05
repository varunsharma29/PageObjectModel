package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facbook.base.TestBase;

public class PagesPage extends TestBase {

	@FindBy(xpath = "//h1[contains(text(),'Pages')]")
	WebElement Pageslabel;

	@FindBy(xpath = "//span[contains(text(),'Create New Page')]")
	WebElement CreatenewPage;

	@FindBy(xpath = "//h1[contains(text(),'Create a Page')]")
	WebElement createnewpageTitle;

	//Initializing the Page Object
	public PagesPage() {
		PageFactory.initElements(driver, this);

	}

	public String varifyPageTitle() {
		return driver.getTitle();
	}

	public boolean verifyPagesLabel() {
		return Pageslabel.isDisplayed();
	}

	public void verifyCreateNewPageButton() {
		CreatenewPage.click();
	}

	public boolean verifycreateNewPageTitle() {

		return createnewpageTitle.isDisplayed();
	}
}
