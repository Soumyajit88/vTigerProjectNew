package com.CRM.vTiger1.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	
	@FindBy(name = "lastname") private WebElement lastName;
	@FindBy(css = "input[title='Save [Alt+S]']") private WebElement save;
	
	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void createContact(String name) {
		lastName.sendKeys(name);
		save.click();
		
	}
}

