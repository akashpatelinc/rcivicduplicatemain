package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.Rcivic.TestBase.TestBase;
import tests.RcivicDuplicatedProject.pages.ContactsTab;
import tests.RcivicDuplicatedProject.pages.HomePage;
import tests.RcivicDuplicatedProject.pages.LoggedinPage;
import tests.RcivicDuplicatedProject.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	LoggedinPage loggedin;
	HomePage home;
	ContactsTab contacts;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void Begin() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		loggedin = new LoggedinPage();
		home = new HomePage();
		contacts = new ContactsTab();
		loginpage.clickonLogin();
		Thread.sleep(4000);
		loggedin.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	// @Test
	public void ValidateAccountName() {
		String Actualusername = home.AccountName();
		Assert.assertEquals(Actualusername, "Akash P", "Username is not Matched");
	}
	
	@Test
	public void ValidateHowertoContacts() {
		home.HoverToContacts();
		contacts = home.GetContactsTab();
	}
	
}