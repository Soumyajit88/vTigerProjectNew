package com.CRM.vTiger1.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganisationPage {
	
	@FindBy(name = "accountname") private WebElement accountName;
	@FindBy(name = "button") private WebElement save;
	
	public CreateNewOrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void createAcc(String value)
	{
		accountName.sendKeys(value);
	}
	
	public void save() {
		save.click();
	}
}
