package com.eva.vtiger.testscripts;

import org.testng.annotations.Test;
import com.eva.vtiger.pages.CreateNewLeadPage;
import com.eva.vtiger.pages.HomePage;
import com.eva.vtiger.pages.LeadInformationPage;
import com.eva.vtiger.pages.LeadsPage;
import com.eva.vtiger.pages.LoginPage;
import com.eva.vtiger.runner.Base;


public class LeadsTestScripts extends Base {

   @Test
	public void verifyLeadNewCreation() {
		
			LoginPage login=   new LoginPage(wu);
			login.validLogin();
			HomePage home= new HomePage(wu);
			home.gotoleadPage();
			home.gotoContactsPage();		
			LeadsPage leads= new LeadsPage(wu);
			leads.clickCreateLeadButton();
			CreateNewLeadPage   createlead= new CreateNewLeadPage(wu);		
			createlead.createAndSaveLead();
			LeadInformationPage  deletelead= new LeadInformationPage(wu);	
			deletelead.deleteLead();
		
	}
   @Test
	public void verifyUpdateLead() {
		LoginPage login=   new LoginPage(wu);
		login.validLogin();
		HomePage home= new HomePage(wu);
		home.gotoleadPage();
		LeadsPage leads= new LeadsPage(wu);
		leads.clickCreateLeadButton();
		CreateNewLeadPage   createlead= new CreateNewLeadPage(wu);		
		createlead.createAndSaveLead();
		LeadInformationPage  deletelead= new LeadInformationPage(wu);	
		deletelead.deleteLead();
		
	}	
   @Test
	public void verifyLeadsDelete() {
		LoginPage login=   new LoginPage(wu);
		login.validLogin();
		HomePage home= new HomePage(wu);
		home.gotoleadPage();
		LeadsPage leads= new LeadsPage(wu);
		leads.clickCreateLeadButton();
		CreateNewLeadPage   createlead= new CreateNewLeadPage(wu);		
		createlead.createAndSaveLead();
		LeadInformationPage  deletelead= new LeadInformationPage(wu);	
		deletelead.deleteLead();
		
	}

}
