package com.eva.vtiger.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.utils.WebUtil;

public class DocumentPage {
      @FindBy(xpath="//a[text()='Documents']")
      WebElement documentpage;
      private WebUtil wu;
  	public DocumentPage(WebUtil wu ) {
  		PageFactory.initElements(wu.getDriver(), this);
  	     this.wu=wu;      
}
  	public void clickDocumentButton() {
		wu.click(documentpage, "Plusbutton");	
}
}