package com.eva.vtiger.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.utils.WebUtil;

public class CreatnewOrgnizationPage {
	@FindBy(xpath="//img[@title='Create Organization...']")
	WebElement plusbuttonorg;
	@FindBy(xpath="//input[@name='accountname']")
	WebElement orgname;
	@FindBy(xpath="//input[@class='detailedViewTextBox']")
	WebElement website;
	@FindBy(xpath="//input[@name='tickersymbol']")
	WebElement ticker;
	@FindBy(xpath="//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	WebElement savebutton;
	private WebUtil wu;
	public CreatnewOrgnizationPage(WebUtil wu ) {
		PageFactory.initElements(wu.getDriver(), this);
	     this.wu=wu;
	}
		
	public void ClickAndSaveOrg() {
	wu.click(plusbuttonorg, "Plusbutton");
	wu.sendValue(orgname, "EVA", "Textbox");
	wu.sendValue(website, "www.eva.com", "Textbox");
	wu.sendValue(phone, "7445336326", "Textbox");
	wu.click(savebutton, "Savebutton");
	
	}
	

}
