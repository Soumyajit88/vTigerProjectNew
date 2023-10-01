package com.CRM.vTiger1.organisation;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.CRM.vTiger1.ObjectRepository.CreateNewOrganisationPage;
import com.CRM.vTiger1.ObjectRepository.HomePage;
import com.CRM.vTiger1.ObjectRepository.OrganisationInfoPage;
import com.CRM.vTiger1.ObjectRepository.OrganisationPage;
import com.CRM.vTiger1.genericUtility.BaseClass;
import com.CRM.vTiger1.genericUtility.ExcelFileUtility;
import com.CRM.vTiger1.genericUtility.JavaUtility;

/**
 * @author Soumyajit
 * Verifying Organization creation by using different names.
 */

@Listeners(com.CRM.vTiger1.genericUtility.ListnerImplimentation.class)
public class MultipleUserOrganisationTest extends BaseClass {
	
	@Test(dataProvider = "multipleData",dataProviderClass = ExcelFileUtility.class)
	public void verifyOrganisationTest(String name) throws Throwable {
		
		//Create Organization title with different Names
		JavaUtility ju=new JavaUtility();
		int random = ju.getrandom();
		String orgTitle=name+random;
		
		//Click on Organization
		HomePage hp=new HomePage(driver);
		hp.clickOrganisation();
		
		//Click on Create Organization
		OrganisationPage op=new OrganisationPage(driver);
		op.createOrganisation();
		
		//Create New Organization
		CreateNewOrganisationPage cn=new CreateNewOrganisationPage(driver);
		cn.createAcc(orgTitle);
		cn.save();
		
		//Verify Organization Name
		OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		String orgName = oip.organisationHeader();
		Assert.assertTrue(orgName.contains(orgTitle));
		System.out.println("pass");
	}
}
