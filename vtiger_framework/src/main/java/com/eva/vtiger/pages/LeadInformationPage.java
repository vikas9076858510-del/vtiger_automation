package com.eva.vtiger.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.utils.WebUtil;

public class LeadInformationPage {
	
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	WebElement Delete;
	@FindBy(xpath="//input[@title='Edit [Alt+E]']")
    WebElement editbutton;
	private WebUtil wu;
	public LeadInformationPage(WebUtil wu ) {
		PageFactory.initElements(wu.getDriver(), this);
	     this.wu=wu;
	}
	public void deleteLead() {	
		wu.click(Delete, "deletebutton");
	}
	public void ClickEditButton() {
		wu.click(editbutton, "Editbutton");
	}
}
