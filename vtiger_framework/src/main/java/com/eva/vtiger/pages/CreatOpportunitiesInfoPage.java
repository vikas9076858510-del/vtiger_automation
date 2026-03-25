package com.eva.vtiger.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.utils.WebUtil;

public class CreatOpportunitiesInfoPage {
	
	@FindBy(xpath="//img[@title='Create Opportunity...']")
	WebElement plusbutton;
	@FindBy(xpath="//input[@name='potentialname']")
	WebElement wefirstname;
    @FindBy(xpath="//input[@title='Save [Alt+S]']")
    WebElement wesave;
    @FindBy(xpath="//input[@title='Edit [Alt+E]']")
    WebElement editbutton;
    @FindBy(xpath="//input[@title='Delete [Alt+D]']")
    WebElement deletebutton;
  
	private WebUtil wu;
	public CreatOpportunitiesInfoPage(WebUtil wu ) {
		PageFactory.initElements(wu.getDriver(), this);
	     this.wu=wu;
	}
	public void CreatAndSaveOpportunities() {
		wu.click(plusbutton, "Plutbutton");	
		wu.sendValue(wefirstname, "Vikas", "wefirstname Textbox");
		wu.click(wesave, "Savebutton");
		wu.alertAccept();
}
	public void deleteOpportunities() {	
 		wu.click(deletebutton, "Deletebutton");
 	}
 	public void ClickEditButton() {
 		wu.click(editbutton, "Editbutton");
 	}
	
	
	
}
