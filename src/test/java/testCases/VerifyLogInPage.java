package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LogInPage;

public class VerifyLogInPage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
	driver = BrowserFactory.getBrowser("firefox");
	
	driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}
	@Test
	public void testHomePage(){
		
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		String title = home.getApplicationTitle();
		Assert.assertTrue(title.contains("Demo Store"));
		home.clickOnSignInLink();
		
		
		LogInPage login = PageFactory.initElements(driver, LogInPage.class);
		
		login.LogInApplication("jamil.jamil@yahoo.com", "jamil1234");
		
		login.verifySignOutLink();
		
	}

	@AfterMethod
	public void tearDown(){
		 
	BrowserFactory.closeBrowser(driver);
	}
	
}
