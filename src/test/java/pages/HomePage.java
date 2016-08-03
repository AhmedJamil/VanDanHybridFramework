package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
		WebDriver driver;
	
	public HomePage(WebDriver lDriver){
		
		this.driver=lDriver;
		
	}
	
	
	
	@FindBy (xpath="html/body/div[1]/div/div/div[2]/div/ul/li[1]/span/a")WebElement signInLink;

	@FindBy (xpath="html/body/div[1]/div/div/div[2]/div/ul/li[2]/a")WebElement myAccountLink;
	
	@FindBy (xpath="html/body/div[1]/div/div/div[2]/div/ul/li[3]/a")WebElement myCartLink;
	
	@FindBy (xpath="html/body/div[1]/div/div/div[2]/div/ul/li[4]/a")WebElement checkOutLink;
	
	
	
	public void clickOnSignInLink(){
		signInLink.click();
	}
	public void clickOnmyAccountLink(){
		myAccountLink.click();
	}
	public void clickOnmyCartLink(){
		myCartLink.click();
	}
	public void clickOncheckOutLink(){
		checkOutLink.click();
	}
	
	public String getApplicationTitle(){
		return driver.getTitle();
		
	}
	
	}
	
