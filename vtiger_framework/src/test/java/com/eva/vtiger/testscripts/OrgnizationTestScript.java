package com.eva.vtiger.testscripts;


import org.testng.annotations.Test;
import com.eva.vtiger.pages.CreatnewOrgnizationPage;
import com.eva.vtiger.pages.LoginPage;
import com.eva.vtiger.pages.OrgnizationInformationPage;
import com.eva.vtiger.pages.OrgnizationPage;
import com.eva.vtiger.runner.Base;


public class OrgnizationTestScript extends Base {
	@Test
	public void verifyNewOrgnizationsCreation() {
		LoginPage login=   new LoginPage(wu);
		login.validLogin();
		OrgnizationPage orgpage=new OrgnizationPage(wu);
		orgpage.clickOrgnizationButton();

	}
   @Test
	public void verifyUpdateOrgnization() {
		LoginPage login=   new LoginPage(wu);
		login.validLogin();
		OrgnizationPage orgpage=new OrgnizationPage(wu);
		orgpage.clickOrgnizationButton();
		CreatnewOrgnizationPage creatorgpage=new CreatnewOrgnizationPage(wu);
		creatorgpage.ClickAndSaveOrg();
		
	}
   @Test
	public void verifyDeleteOrganization() {
		LoginPage login=   new LoginPage(wu);
		login.validLogin();
		OrgnizationPage orgpage=new OrgnizationPage(wu);
		orgpage.clickOrgnizationButton();
		CreatnewOrgnizationPage creatorgpage=new CreatnewOrgnizationPage(wu);
		creatorgpage.ClickAndSaveOrg();
		OrgnizationInformationPage orginfopage=new OrgnizationInformationPage(wu);
		orginfopage.EditAndSaveOrg();
		
		
	}
}
