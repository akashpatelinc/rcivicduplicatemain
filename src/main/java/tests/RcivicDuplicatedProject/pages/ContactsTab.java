package tests.RcivicDuplicatedProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.Rcivic.TestBase.TestBase;

public class ContactsTab extends TestBase {
	
	@FindBy(xpath="//td/div[contains(@class,'checkbox') and @xpath='2']")
	WebElement CheckBox;
	
	@FindBy(xpath="//td/a[contains(text(),'Test1')]")
	WebElement ContactsName;
	
	
	//xpath for check box ->> //td/div[contains(@class,'checkbox') and @xpath='2']
	
		//---->>>> "//td/a[contains(text(),'Test1')]" -->>For name contains 
	
	public ContactsTab() {
		PageFactory.initElements(driver, this);
	}
	
	public void SelectCheckBox() {
		CheckBox.click();
	}
	
	public ContactsDetails SelectContactsName() {
		ContactsName.click();
		return new ContactsDetails();
	}
	
	public void SelectedContact(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	

}
