package com.eva.vtiger.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.utils.WebUtil;

public class DashboardPage {
	@FindBy(xpath="//a[text()='Dashboard']")
	WebElement dashboard;
	private WebUtil wu;
	public DashboardPage(WebUtil wu ) {
		PageFactory.initElements(wu.getDriver(), this);
	     this.wu=wu;
}
	public void ClickDashboardButton() {
		wu.click(dashboard, "ContactButton");
}
}