package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LogInPage;

public class VerifyLogInPageWithExtentReport {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	@BeforeMethod
	public void setUp() {

		report = new ExtentReports(".\\Reports\\LoginpageReport.html", true);
		logger = new ExtentTest("Verify Login page", "This page will verify sign out link");
		logger=report.startTest("Test Login");
		
		logger.log(LogStatus.INFO, "Application is up and running");

		driver = BrowserFactory.getBrowser("firefox");

		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}

	@Test
	public void testHomePage() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);

		String title = home.getApplicationTitle();
		Assert.assertTrue(title.contains("Demo Store"));
		logger.log(LogStatus.INFO, "home page loaded and verified");

		home.clickOnSignInLink();
		logger.log(LogStatus.INFO, "Clicked on sign in button");

		LogInPage login = PageFactory.initElements(driver, LogInPage.class);
		login.LogInApplication("jamil.jamil@yahoo.com", "jamil1234");
		logger.log(LogStatus.INFO, "loged in to the application");

		login.verifySignOutLink();
		logger.log(LogStatus.INFO, "Verified sign out link");
	}

	@AfterMethod
	public void tearDown() {

		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}

}
