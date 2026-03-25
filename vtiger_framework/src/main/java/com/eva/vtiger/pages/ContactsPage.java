package com.eva.vtiger.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.utils.WebUtil;

public class ContactsPage {
	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	WebElement contact;
	private WebUtil wu;
	public ContactsPage(WebUtil wu ) {
		PageFactory.initElements(wu.getDriver(), this);
	     this.wu=wu;
	}
	public void ClickContactButton() {
		wu.click(contact, "ContactButton");
	}

}
