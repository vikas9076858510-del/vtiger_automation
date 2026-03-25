package com.eva.vtiger.runner;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.eva.vtiger.pages.HomePage;
import com.eva.vtiger.pages.LoginPage;
import com.eva.vtiger.utils.WebUtil;


public class Base {

	private static ExtentReports er;
	public ExtentTest esr;
	protected WebUtil wu;
	String mtName;
	
	@BeforeSuite(alwaysRun = true)
	public void parentMethod() {
		String dateTime=currentDateAndTime();
		er= new ExtentReports();
		ExtentSparkReporter esr=new ExtentSparkReporter("TestCaseReports\\report  "+dateTime+ " .html");
		er.attachReporter(esr);	
	}
	@AfterSuite(alwaysRun = true)
	public void afterSuit() {
		er.flush();
	}
	
	@BeforeMethod(alwaysRun = true)
	@Parameters({"browser","url"})
	public void common(Method mt,String browser,String url) {
		mtName =mt.getName();
		esr=er.createTest(mtName);
		wu=new WebUtil();
		wu.launchBrowser(browser);
		wu.openLoginPage(url);
		LoginPage lp=new LoginPage(wu);
		lp.validLogin();
	}
	@AfterMethod(alwaysRun = true)
	public void ClosePage(ITestResult result,Method mt) {
		if(result.isSuccess()==false) {
			wu.takeScreenShot(mt.getName());
		} 
		
		er.flush();
		wu.Close();
	}
     public String currentDateAndTime() {
    	 LocalDateTime dateandtime=LocalDateTime.now();
    		DateTimeFormatter formt=DateTimeFormatter.ofPattern("yyyy/MM/dd_ HHmmss");
    		String currentdateandtime=dateandtime.format(formt);
    	return currentdateandtime;
     }





	//		LeadsTestScripts 	lts=new LeadsTestScripts();
	//			lts.verifyLeadNewCreation();
	//			lts.verifyUpdateLead();
	//				lts.verifyLeadsDelete();
	//
	//			OrgnizationTestScript org=new OrgnizationTestScript();
	//		org.verifyNewOrgnizationsCreation();
	//				//org.verifyUpdateOrgnization();
	//				org.verifyDeleteOrganization();
	//
	//
	//		ContactsTestScript con=new ContactsTestScript();
	//		   con.verifyContactscreation();
	//			con.verifyUpdateContacts();
	//			con.verifyDeleteContacts();
	//
	//				OpportunitiesTestScript opp=new OpportunitiesTestScript();
	//				opp.verifyNewopportunities();
	//				opp.verifyUpdateopportinitius();
	//				opp.verifydeleteopportinitius();
	//
	//		     ProductTestScript pro=new ProductTestScript();
	//				  pro.verifyNewproductscreation();
	//				pro.verifyUpdateProducts();
	//		       pro.verifyDeleteProducts();
	//
	//		DocumentTestScript doc=new DocumentTestScript();
	//		     doc.verifyNewDocumentsCreation();
	//	      	    doc.verifyUpdateDocuments();
	//				doc.verifyDeleteDocuments();
	//
	//		
	//				DashboardTestScript das=new DashboardTestScript();
	//				das.verifyNewDashboardCeation();


}







