package com.eva.vtiger.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.utils.WebUtil;

public class CreatDocumentInfoPage {
     @FindBy(xpath="//img[@title='Create Document...']")
     WebElement plusbutton;
     @FindBy(xpath="//input[@name='notes_title']")
     WebElement product;
     @FindBy(xpath="//input[@title='Save [Alt+S]']")
     WebElement savebutton;
     @FindBy(xpath="//input[@title='Edit [Alt+E]']")
     WebElement editbutton;
     @FindBy(xpath="//input[@title='Delete [Alt+D]']")
     WebElement deletebutton;
     private WebUtil wu;
 	public CreatDocumentInfoPage(WebUtil wu ) {
 		PageFactory.initElements(wu.getDriver(), this);
 	     this.wu=wu;
 	}
 	
 	public void ClickAndsaveDocument() {
 		wu.click(plusbutton, "Plustbutton");
 		wu.sendValue(product, "Nike", "Textbox");
 		wu.click(savebutton, "Savebutton");
 	}
 	public void deleteDocument() {	
 		wu.click(deletebutton, "deletebutton");
 	}
 	public void ClickEditButton() {
 		wu.click(editbutton, "Editbutton");
 	}
}
