package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.Rcivic.TestBase.TestBase;
import tests.RcivicDuplicatedProject.pages.ContactsTab;
import tests.RcivicDuplicatedProject.pages.HomePage;
import tests.RcivicDuplicatedProject.pages.LoggedinPage;
import tests.RcivicDuplicatedProject.pages.LoginPage;
import tests.RcivicDuplicatedProject.util.TestsUtil;

public class ContactsTabTest extends TestBase {

	LoginPage loginpage;
	LoggedinPage loggedin;
	HomePage home;
	ContactsTab contacts;
	TestsUtil utilities;
	
	public ContactsTabTest() {
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
		utilities = new TestsUtil();
		Thread.sleep(4000);
		loggedin.login(prop.getProperty("username"), prop.getProperty("password"));
		// utilities.switchToFrame();
		home.GetContactsTab();
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	// @Test(priority=1)
	public void CheckBoxTest() {
		contacts.SelectCheckBox();
	}
	
	@Test(priority=1)
	public void SelectSingleContact() {
		contacts.SelectedContact("Test1 Test1");
	}
	// xpath needs to be corrected
}
