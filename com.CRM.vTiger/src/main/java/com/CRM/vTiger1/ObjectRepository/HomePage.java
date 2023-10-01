package com.CRM.vTiger1.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.vTiger1.genericUtility.WebDriverUtility;

public class HomePage {
	@FindBy(xpath = "(//a[.='Organizations'])[position()=1]") private WebElement OrganizationLink;
	@FindBy(linkText = "Contacts") private WebElement contactLink;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") private WebElement administratorLink;
	@FindBy(xpath = "//a[.='Sign Out']") private WebElement signoutLink;
	
	WebDriverUtility web=new WebDriverUtility();
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOrganisation() {
		OrganizationLink.click();
	}
	
	public void clickContact() {
		contactLink.click();
	}
	
	public void signoutFromApp(WebDriver driver) {
		web.moveToElement(driver, administratorLink);
		signoutLink.click();
	}
	
}
