package com.CRM.vTiger1.organisation;

import org.testng.Assert;
import org.testng.Reporter;
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
public class OrganisationTest extends BaseClass{
	
	@Test(groups = "SmokeSuite",retryAnalyzer = com.CRM.vTiger1.genericUtility.RetryAnalizer.class)
	public void verifyOrganisationTest() throws Throwable {
		ExcelFileUtility exUtil=new ExcelFileUtility();
		String organisationName= exUtil.toGetDataFromExcelFile("Organisation", 0, 0);
		JavaUtility ju = new JavaUtility();
		int random = ju.getrandom();
		String orgTitle = organisationName + random;
		HomePage hp = new HomePage(driver);
		hp.clickOrganisation();
		Reporter.log("Clicked on Organisation", true);
		OrganisationPage op = new OrganisationPage(driver);
		op.createOrganisation();
		CreateNewOrganisationPage cn = new CreateNewOrganisationPage(driver);
		cn.createAcc(orgTitle);
		cn.save();
		OrganisationInfoPage oip = new OrganisationInfoPage(driver);
		String orgName = oip.organisationHeader();
		Assert.assertTrue(orgName.contains(orgTitle));
		Reporter.log("Organisation name Validation passed", true);
	}
}
