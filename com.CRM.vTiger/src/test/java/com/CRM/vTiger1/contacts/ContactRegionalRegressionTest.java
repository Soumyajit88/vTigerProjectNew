
 package com.CRM.vTiger1.contacts;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.CRM.vTiger1.ObjectRepository.ContactInfoPage;
import com.CRM.vTiger1.ObjectRepository.ContactPage;
import com.CRM.vTiger1.ObjectRepository.CreatingNewContactPage;
import com.CRM.vTiger1.ObjectRepository.HomePage;
import com.CRM.vTiger1.genericUtility.BaseClass;
import com.CRM.vTiger1.genericUtility.ExcelFileUtility;
import com.CRM.vTiger1.genericUtility.JavaUtility;


public class ContactRegionalRegressionTest extends BaseClass {
	
	@Test
	public void verifyContactTest() throws Throwable {
		ExcelFileUtility exUtil=new ExcelFileUtility();
		String contact= exUtil.toGetDataFromExcelFile("ContactName", 0, 0);
		JavaUtility ju=new JavaUtility();
		int random = ju.getrandom();
		String contactTitle=contact+random;
		
		HomePage hp=new HomePage(driver);
		hp.clickContact();
		ContactPage cp=new ContactPage(driver);
		cp.createContact();
		CreatingNewContactPage cnp=new CreatingNewContactPage(driver);
		cnp.createContact(contactTitle);
		ContactInfoPage cip=new ContactInfoPage(driver);
		String contactHeaderName = cip.contactHeaderText();
		Assert.assertTrue(contactHeaderName.contains(contactTitle));
		Reporter.log("Organisation name Validation passed", true);
	}
	public void create() {
		Reporter.log("Patch Added");
	}
}
