package com.eva.vtiger.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.utils.WebUtil;

public class OrgnizationInformationPage {
     @FindBy(xpath="//input[@title='Edit [Alt+E]']")
     WebElement editbutton;
     @FindBy(xpath="//input[@title='Delete [Alt+D]']")
     WebElement deletebutton;
     private WebUtil wu;
   	public OrgnizationInformationPage(WebUtil wu) {
   		PageFactory.initElements(wu.getDriver(), this);
   		this.wu=wu; 
     }
   	public void EditAndSaveOrg() {
   		wu.click(editbutton, "Editbutton");
   		wu.click(deletebutton, "Deletebutton");
   	}
}
