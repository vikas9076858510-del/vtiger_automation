package com.eva.vtiger.testscripts;
import org.testng.annotations.Test;
import com.eva.vtiger.pages.DashboardPage;
import com.eva.vtiger.pages.LoginPage;
import com.eva.vtiger.runner.Base;


public class DashboardTestScript extends Base{
	    
	@Test
	public void verifyNewDashboardCeation () {
		
		LoginPage login =new LoginPage(wu);
		login.validLogin();
		DashboardPage dashboardpage=new DashboardPage(wu);
		dashboardpage.ClickDashboardButton();
		

		
		
				
	}

}
