package com.eva.vtiger.testscripts;
import org.testng.annotations.Test;
import com.eva.vtiger.pages.ContactInformationPage;
import com.eva.vtiger.pages.CreatNewContactPage;
import com.eva.vtiger.pages.HomePage;
import com.eva.vtiger.pages.LoginPage;
import com.eva.vtiger.runner.Base;


public class ContactsTestScript extends Base {
	
	@Test(groups = {"smoke"})
	public void verifyContactCreation() {
		LoginPage login = new LoginPage(wu);
 		login.validLogin();
		HomePage home = new HomePage(wu);
		home.gotoContactsPage();
	}

	@Test(groups = {"smoke"})
	public void verifyUpdateContacts() {
		LoginPage login = new LoginPage(wu);
		login.validLogin();
		HomePage home = new HomePage(wu);
		home.gotoContactsPage();
		CreatNewContactPage contnewpage = new CreatNewContactPage(wu);
		contnewpage.CreatandSaveContact();
	}

	@Test ( groups = {"regression"})
	public void verifyDeleteContacts() {
		LoginPage login = new LoginPage(wu);
		login.validLogin();
		HomePage home = new HomePage(wu);
		home.gotoContactsPage();
		CreatNewContactPage contnewpage = new CreatNewContactPage(wu);
		contnewpage.CreatandSaveContact();
		ContactInformationPage continfopage = new ContactInformationPage(wu);
		continfopage.deleteContact();
		wu.alertAccept();

	}

}
