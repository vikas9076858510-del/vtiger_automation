package com.eva.vtiger.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.utils.WebUtil;

public class HomePage {
	
	@FindBy(xpath="//a[text()='Leads']")
	WebElement Leadspage;
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contact;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	WebElement logout;
	private WebUtil wu;
	public HomePage(WebUtil wu ) {
		PageFactory.initElements(wu.getDriver(), this);
	     this.wu=wu;
	}
	public void gotoleadPage() {			
		wu.click(Leadspage, " Leadbutton");
	}
	public void gotoContactsPage() {	
		wu.click(contact, "Contactbutton");
	}
	public void Logout() {	
		wu.click(logout, "Singout button");
	}
}
