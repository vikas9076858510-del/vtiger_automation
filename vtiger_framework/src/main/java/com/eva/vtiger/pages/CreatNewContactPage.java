package com.eva.vtiger.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.utils.WebUtil;

public class CreatNewContactPage {
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	WebElement plusbutton;
	@FindBy(xpath="//select[@name='salutationtype']")
	WebElement wedrop;
	@FindBy(xpath="//input[@name='firstname']")
	WebElement wefirstname;
	@FindBy(xpath="//input[@name='lastname']")
	WebElement welastname;
	@FindBy(xpath="//input[@id='mobile']")
	WebElement wemobile;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	WebElement wesave;
	private WebUtil wu;
	public CreatNewContactPage(WebUtil wu ) {
		PageFactory.initElements(wu.getDriver(), this);
	     this.wu=wu;
	}
	
	public void CreatandSaveContact() {
		wu.click(plusbutton, "Plutbutton");
		wu.selectFromDropdownByText(wedrop, "Mr.", "Textbox");
		wu.sendValue(wefirstname, "Vikas", "FirstName Textbox");
		wu.sendValue(welastname, "Paswan", "LastName Textbox");
		wu.sendValue(wemobile, "7323257348", "Textbox");
		wu.click(wesave,"Savebutton");
		
		
		
	}
	
	
	
	
}
