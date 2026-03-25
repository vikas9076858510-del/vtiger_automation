package com.eva.vtiger.testscripts;
import org.testng.annotations.Test;
import com.eva.vtiger.pages.CreatDocumentInfoPage;
import com.eva.vtiger.pages.DocumentPage;
import com.eva.vtiger.pages.LoginPage;
import com.eva.vtiger.runner.Base;


public class DocumentTestScript extends Base {
	@Test
	public void verifyNewDocumentsCreation() {
		LoginPage login =new LoginPage(wu);
		login.validLogin();
		DocumentPage docutpage=new DocumentPage(wu);
		docutpage.clickDocumentButton();

	}
	@Test
	public void verifyUpdateDocuments() {
		LoginPage login =new LoginPage(wu);
		login.validLogin();
		DocumentPage docutpage=new DocumentPage(wu);
		docutpage.clickDocumentButton();
		CreatDocumentInfoPage ducutinfopage=new CreatDocumentInfoPage(wu);
		ducutinfopage.ClickAndsaveDocument();
		ducutinfopage.ClickEditButton();

	}
	@Test
	public void verifyDeleteDocuments() {
		LoginPage login =new LoginPage(wu);
		login.validLogin();
		DocumentPage docutpage=new DocumentPage(wu);
		docutpage.clickDocumentButton();
		CreatDocumentInfoPage ducutinfopage=new CreatDocumentInfoPage(wu);
		ducutinfopage.ClickAndsaveDocument();
		//ducutinfopage.ClickEditButton();
		ducutinfopage.deleteDocument();


	}

}
