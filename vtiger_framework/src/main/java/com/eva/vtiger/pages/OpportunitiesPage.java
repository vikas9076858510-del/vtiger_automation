package com.eva.vtiger.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.utils.WebUtil;

public class OpportunitiesPage {
      @FindBy(xpath="//a[text()='Opportunities']")
      WebElement OpportunitiesPage;
      private WebUtil wu;
  	public OpportunitiesPage(WebUtil wu) {
  		PageFactory.initElements(wu.getDriver(), this);
  		this.wu=wu; 
  	}

  	public void clickOpportunitiesButton() {
  		wu.click(OpportunitiesPage, "Leadbutton");
  	}

}
