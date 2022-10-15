package test.Rcivic.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import tests.RcivicDuplicatedProject.util.TestsUtil;
import tests.RcivicDuplicatedProject.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver x_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\selenium_workspace\\RcivicDuplicatedProject\\src\\main\\java\\tests\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() throws InterruptedException {
		String browser = prop.getProperty("browser");		
		
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			// ClassName ObjName = new ClassName();
			driver = new FirefoxDriver(); // open Firefox
		} else if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\UpdatedChrome\\chromedriver.exe");
			// ClassName ObjName = new ClassName();
			driver = new ChromeDriver(); // open Chrome
		} else {
			System.setProperty("webdriver.safari.driver", "C:\\SeleniumJars\\safaridriver.exe");
			// ClassName ObjName = new ClassName();
			
		     driver = new SafariDriver(); // open Safari
		}
		// PageFactory.initElements(driver, this);
		
		x_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		
		x_driver.register(eventListener);
		driver = x_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestsUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestsUtil.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		Thread.sleep(4000);
	}
	
	
}
