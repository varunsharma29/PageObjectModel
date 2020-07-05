package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facbook.base.TestBase;

public class LoginPage extends TestBase{

	// Page Factory  -OR
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class='_1lch']//button[contains(text(),'Sign Up')]")
	WebElement SigUpBtn;
	
	@FindBy(xpath = "//div[@id=\"blueBarDOMInspector\"]//div[@class='lfloat _ohe']")
	WebElement facebookLogo;
	
	//Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	//Actions
	public String validateLoginPage() {
		
		return driver.getTitle();
	}
	
	public boolean validateFacebookImage() {
		
		return facebookLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		loginBtn.click();
		return new HomePage();
	}
}
