package com.CRM.vTiger1.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	
	@FindBy(css = "img[title*='Cr']") private WebElement createOrganisation;
	
	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void createOrganisation() {
		createOrganisation.click();
	}
}
