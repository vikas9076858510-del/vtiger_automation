package com.eva.vtiger.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.utils.WebUtil;

public class LeadsPage {
	@FindBy(xpath="//a[text()='Leads']")
	WebElement leadpage;
	private WebUtil wu;
	public LeadsPage(WebUtil wu) {
		PageFactory.initElements(wu.getDriver(), this);
		this.wu=wu; 
	}

	public void clickCreateLeadButton() {
		wu.click(leadpage, "Plusbutton");
	}



}
