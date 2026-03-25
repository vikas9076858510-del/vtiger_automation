package com.eva.vtiger.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.utils.WebUtil;



public class LoginPage {

	@FindBy(xpath="//input[@name='user_name']")
	public WebElement weusername;
	@FindBy(xpath="//input[@name='user_password']")
	public	WebElement	wePassword;
	@FindBy(xpath="//input[@id='submitButton']")
	public  WebElement loginbutton;

	private WebUtil wu;
	public LoginPage( WebUtil wu) {
		PageFactory.initElements(wu.getDriver(), this);
		this.wu=wu;
	}
	public void validLogin( ) {	 
		wu.sendValue(weusername,"admin", "Username Textbox");		
		wu.sendValue(wePassword,"admin", "Password Textbox");		
		wu.click(loginbutton, " loginbutton");
	}

	public void invalidLogin( ) { 
		wu.sendValue(weusername,"frgyfxss", "Username Textbox");		
		wu.sendValue(wePassword,"fxstrss", "Password Textbox");	
		loginbutton.click();
	}
}
