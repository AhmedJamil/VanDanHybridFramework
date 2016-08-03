package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {
	
	WebDriver driver;
	
	public LogInPage(WebDriver lDriver){
		this.driver= lDriver;
		
	}

	@FindBy(xpath=".//*[@id='account_sign_in_form_email_id']")WebElement uName;
	
	@FindBy(xpath=".//*[@id='account_sign_in_form_passwd_id']")WebElement passwd;
	
	@FindBy(xpath="html/body/div[4]/div/div/div[2]/div/div/div[2]/form/div[5]/div/input")WebElement sInButton;
	
	By signout = By.xpath("html/body/div[1]/div/div/div[2]/div/ul/li[1]/span/a");
	
	public void LogInApplication(String userName, String password){
		
		uName.sendKeys(userName);
		passwd.sendKeys(password);
		sInButton.click();
	}
	
	public void verifySignOutLink(){
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(signout));
		String text = ele.getText();
		Assert.assertEquals("Sign out not veirfied", text, "Sign Out");
		
		//Assert.assertEquals(text, "Sign Out","Sign out link not verified");
		
		
		
	}
	
}
