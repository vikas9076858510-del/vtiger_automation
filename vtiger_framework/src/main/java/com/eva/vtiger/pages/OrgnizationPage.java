package com.eva.vtiger.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.utils.WebUtil;

public class OrgnizationPage {
     @FindBy(xpath="//a[text()='Organizations']")
     WebElement orgmodule;
     private WebUtil wu;
   	public OrgnizationPage(WebUtil wu) {
   		PageFactory.initElements(wu.getDriver(), this);
   		this.wu=wu; 
   	}

   	public void clickOrgnizationButton() {
   		wu.click(orgmodule, "Leadbutton");
   	}
}
