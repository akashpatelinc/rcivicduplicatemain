package tests.RcivicDuplicatedProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.Rcivic.TestBase.TestBase;

public class HomePage extends TestBase {
	// xpath for contacts = //div[@class='menu-item-wrapper']/a[@class='item' and contains(@href,'contacts')]
	@FindBy(xpath="//span[@class='user-display']")
	WebElement UserNameDisplayed;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement DealsPageLink;
	
	@FindBy(xpath="//div[contains(text(),'Deals')]")
	WebElement DealsSection;
	
	@FindBy(xpath="//div[@class='menu-item-wrapper']/a[@class='item' and contains(@href,'contacts')]")
	WebElement contactsTabLink;
	
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsTab;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public String AccountName() {
		 return UserNameDisplayed.getText();
	}
	
	public boolean DealSection() {
		return DealsSection.isDisplayed();
	}
	
	public DealsPage DealsPageLink() {
		DealsPageLink.click();
		return new DealsPage();
	}
	
	public void HoverToContacts() {		
		Actions builder = new Actions(driver);
		builder.moveToElement(contactsTabLink).build().perform();
	}
	
	public ContactsTab GetContactsTab() {
		contactsTab.click();
		return new ContactsTab();
	}

}
