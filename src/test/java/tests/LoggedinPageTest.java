package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.Rcivic.TestBase.TestBase;
import tests.RcivicDuplicatedProject.pages.HomePage;
import tests.RcivicDuplicatedProject.pages.LoggedinPage;
import tests.RcivicDuplicatedProject.pages.LoginPage;

public class LoggedinPageTest extends TestBase {
	LoggedinPage loggedin;
	LoginPage lp;
	HomePage loginHome;
	 
	
	public LoggedinPageTest() {
		super();
	}
	
	@BeforeMethod
	public void InitializeLogin() throws InterruptedException {
		initialization();
		loggedin = new LoggedinPage();
		loggedin.ClickLogin();
	}
	
	@AfterMethod
	public void CloseBrowser1() {
		loggedin.closeBrowser();
	}
	
	@Test(priority=1)
	public void ValidateLoginPageTitle() {
		String title = loggedin.LoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void ValidateloginTest(){
		 loginHome = loggedin.login(prop.getProperty("username"), prop.getProperty("password"));
	}



}
