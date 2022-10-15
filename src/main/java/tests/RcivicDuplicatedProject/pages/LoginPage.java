package tests.RcivicDuplicatedProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.Rcivic.TestBase.TestBase;


public class LoginPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement LoggedinPageLink;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignedUpPageLink;
	
	@FindBy(xpath="//a[contains(text(),'Contact Us')]")
	WebElement ContactsUsPageLink;
	
	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement crmlogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoggedinPage clickonLogin() {
		LoggedinPageLink.click();
		return new LoggedinPage();
	}
	
	public SignedUpPage clickonSignUp() {
		SignedUpPageLink.click();
		return new SignedUpPage();
	}
	
	public ContactsUsPage clickContactUs() {
		ContactsUsPageLink.click();	
		return new ContactsUsPage();	
	}
	
	public boolean Validatecrmlogo(){
		return crmlogo.isDisplayed();		
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	

	
	

	
}

