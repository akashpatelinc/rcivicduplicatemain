package tests.RcivicDuplicatedProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.Rcivic.TestBase.TestBase;

public class LoggedinPage extends TestBase {
	LoginPage lp;
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(text(),'Login') and contains(@class,'button')]")
	WebElement LoginButton;
	
	public LoggedinPage() {
		PageFactory.initElements(driver, this);
	}

	public void ClickLogin() throws InterruptedException {
		lp = new LoginPage();
		lp.LoggedinPageLink.click();
		Thread.sleep(2000);
	}
	
	public HomePage login(String un, String pass) {
		username.sendKeys(un);
		password.sendKeys(pass);
		LoginButton.click();
		return new HomePage();
	}
	
	public String LoginPageTitle() {
		return driver.getTitle();
	}

	public void closeBrowser() {
		driver.quit();		
	}
	
}
