package com.eva.vtiger.testscripts;


import org.testng.annotations.Test;
import com.eva.vtiger.pages.CreatOpportunitiesInfoPage;
import com.eva.vtiger.pages.LoginPage;
import com.eva.vtiger.pages.OpportunitiesPage;
import com.eva.vtiger.runner.Base;


public class OpportunitiesTestScript extends Base{
	@Test
	public void verifyNewopportunities() {
		LoginPage login=   new LoginPage(wu);
		login.validLogin();
		OpportunitiesPage opporpage=new OpportunitiesPage(wu);
		opporpage.clickOpportunitiesButton();
		
	}
		@Test
	public void verifyUpdateopportinitius() {
		LoginPage login=   new LoginPage(wu);
		login.validLogin();
		OpportunitiesPage opporpage=new OpportunitiesPage(wu);
		opporpage.clickOpportunitiesButton();
		CreatOpportunitiesInfoPage opporinfopage=new CreatOpportunitiesInfoPage(wu);
		opporinfopage.CreatAndSaveOpportunities();
		
	}
	@Test
	public void verifydeleteopportinitius() {
		LoginPage login=   new LoginPage(wu);
		login.validLogin();
		OpportunitiesPage opporpage=new OpportunitiesPage(wu);
		opporpage.clickOpportunitiesButton();
		CreatOpportunitiesInfoPage opporinfopage=new CreatOpportunitiesInfoPage(wu);
		opporinfopage.CreatAndSaveOpportunities();
		opporinfopage.deleteOpportunities();
	
			
	}	
}
