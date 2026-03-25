package com.eva.vtiger.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.utils.WebUtil;

public class CreateNewLeadPage {
			
		@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
		WebElement Plusbutton;
		@FindBy(xpath="//select[@name='salutationtype']")
		WebElement wedrop;
		@FindBy(xpath="//input[@name='firstname']")
		WebElement firstname;
		@FindBy(xpath="//input[@name='lastname']")
		WebElement welastname;
		@FindBy(xpath="//input[@name='company']")
		WebElement companyname;
		@FindBy(xpath="//input[@id='mobile']")
		WebElement wemobile;
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		WebElement wesave;
		private WebUtil wu;
		public CreateNewLeadPage(WebUtil wu ) {
			PageFactory.initElements(wu.getDriver(), this);
		     this.wu=wu;
		
		}
		public void createAndSaveLead() {
		wu.Click(Plusbutton);
		wu.selectFromDropdownByText(wedrop, "Mr.", "textbox");
		wu.sendValue(firstname, "Vikas", "firstName Textbox");
		wu.sendValue(welastname, "Paswan", "LastName  Textbox");
		wu.sendValue(companyname, "NST", "Textbox");
		wu.sendValue(wemobile, "9219374876", " Textbox");
		wu.click(wesave, "Savebutton");
		
	}
      public void verifyFirstName() {
    	  
      }
}