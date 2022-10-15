package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.Rcivic.TestBase.TestBase;
import tests.RcivicDuplicatedProject.pages.ContactsUsPage;
import tests.RcivicDuplicatedProject.pages.LoggedinPage;
import tests.RcivicDuplicatedProject.pages.LoginPage;
import tests.RcivicDuplicatedProject.pages.SignedUpPage;

public class LoginPageTest extends TestBase {
	//public WebDriver driver;
	LoginPage lp;
	LoggedinPage loggedinPage;
	SignedUpPage signedup;
	ContactsUsPage contactUs;
	
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void OpenHomePageTest() throws IOException, InterruptedException {
		initialization();
		lp = new LoginPage();
	}
	
	
	
	@Test(priority=1)
	public void ValidateLoginPageLink() {
		loggedinPage = lp.clickonLogin();
	}
	
	@Test(priority = 2)
	public void ValidaCrmLogo() {
		boolean flag = lp.Validatecrmlogo();
		Assert.assertTrue(flag);
	}
	
 	// @Test(priority = 3)
	public void ValidaSignUpPageLink() {
		signedup = lp.clickonSignUp();
	}
	
	// @Test(priority = 4)
	public void ValidateContactsUsPageLink() {
		contactUs = lp.clickContactUs();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
