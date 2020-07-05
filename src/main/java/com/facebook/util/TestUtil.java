package com.facebook.util;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.facbook.base.TestBase;

public class TestUtil extends TestBase{
	
	
	
	public static long PAGE_LOAD_TIMEOUT =50;
	public static long IMPLICIT_WAIT=20;
	
	
	public void switchToFrame(){
		driver.switchTo().frame(0);
	}
	

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
