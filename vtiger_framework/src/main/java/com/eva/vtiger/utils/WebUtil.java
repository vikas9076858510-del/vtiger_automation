package com.eva.vtiger.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class WebUtil {
	private WebDriver driver;
	private ExtentTest extentTest;
//	public WebUtil(ExtentTest extTest) {
//		extentTest=extTest;
//	}
	public WebDriver getDriver() {
		return driver;
	}

	/*  this generic method is launching the chrome browser
	 *  and after launching the browser it is storing ChromeDriver
	 *  Object on non static variable driver so that any method from this class
	 *  can use  it directly
	 *  @parameter : no params   
	 *  @return type : void 
	 *  @Author      : Vikas Paswan
	 *  Created Date : 17/11/2025
	 *  Modified Date : NA 
	 *             */

	public void openLoginPage(String url) {
		maximize();
		openUrl(url);
	}


	public void launchBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("fireFox")) {
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
	}


	/*  this generic method is opening the url
	 *  
	 *  @parameter :  url as String   
	 *  @return type : void 
	 *  @Author      : Vikas Paswan
	 *  Created Date : 17/11/2025
	 *  Modified Date : NA 
	 *             */
	public void openUrl(String url) {
		driver.get(url);
//		extentTest.log(Status.INFO,url+"=====>open successfully");
	}


	/*  getTitle method is fetching the title of opened page
	 *  
	 *  @parameter :  no param  -   because it is fetching page title and to fetch page title driver
	 *                              is required and it is a nonstatiuc variable and it is available for
	 *                              all methods of WebUtil class
	 *  @return type : Page Title as String - because this method is fetching page title and if 
	 *                   we will not return it then it will be destroyed
	 *  @Author      : Vikas Paswan
	 *  Created Date : 17/11/2025
	 *  Modified Date : NA 
	 *             */

	public  String getTitle() {
		String  title;
		try {
			title=driver.getTitle();
		}catch(Exception e) {
			extentTest.log(Status.INFO,"Unplanned exception occured");
			throw e;
		}	
		return title;

	}



	public  String getCurrenturl() {
		String  url;
		try {
			url=driver.getCurrentUrl();
		}catch(Exception e) {
			extentTest.log(Status.INFO,"Unplanned exception occured");
			throw e;
		}	
		return url;	 
	}
	///============================close method===========================>
	public  void Close() {

		try {
			driver.close();
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"Unplanned exception occured");
			throw e;
		}	 
	}




	/*
	 *   searchElement method is searching the element on the html page (html dom) and
	 *    produce object of WebElement Interface 
	 *    @param : xpath as String
	 *    @return : Object of WebElement which it searched
	 *    Exception Handling:
	 *    NoSuchElementException : here we can get NoSuchElementException due to synchronization problem so for this
	 *                              exception in catch block we are waiting for the element for 60 seconds
	 *                              and this is explicit wait and it is dynamic in nature
	 *    InvalidSelectorException: this exception will come when our xpath syntax is wrong and we have no 
	 *                              solution of it that's why we have thrown it 
	 *
	 *
	 *
	 *
	 * */

	public synchronized WebElement searchElement( String xpathValue) {
		WebElement element=null;

		try {
			element=driver.findElement(By.xpath(xpathValue));
			synchronized (element) {
				extentTest.log(Status.INFO, "element found on the page successfully.");
			}
		}catch(NoSuchElementException e) {
			WebDriverWait	wait=new WebDriverWait(driver, Duration.ofSeconds(60));
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue)));

		}catch(InvalidSelectorException e) {
			extentTest.log(Status.INFO,"xpath syntax is incorrect");
			throw e;
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception came.");
			throw e;
		}	
		return element;
	}

	/*
	 *   sendKeys method is typing the value in textbox
	 *    @param : value to input as String
	 *    @return :no
	 *    Exception Handling:
	 *    StaleElementReferenceException : here we can get StaleElementReferenceException 
	 *                                    due to page refresh or change after webelement object creation
	 *                                    when we are getting this exception then we should call
	 *                                     searchElement method again and searchElement method will get fresh
	 *                                     reference of webelement and it will work
	 *                                      then we will do sendkeys on this fresh element
	 *    ElementNotInteractableException: this exception will come when your element is hidden 
	 *                                      and its solution is use javascriptexecutor to sendKeys
	 *                                      because javascript doesn't work on UI it works directly on html code
	 *                                      
	 *         Exception - this will handle all the other exceptionexcept above 2
	 *                    but we don't know which exception will come that's why we are throwing it 
	 * */


	public  void sendValue( WebElement element,String value,String elementName) {
		try {
			element.sendKeys(value);
			extentTest.log(Status.INFO,value+" entered successfully in "+ elementName);
		}catch(StaleElementReferenceException e) {

			element.sendKeys(value);
			extentTest.log(Status.INFO,value+" entered successfully in "+ elementName);

		}catch(ElementNotInteractableException e) {
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("arguments[0].value='+value+'", element);
			extentTest.log(Status.INFO,value+" entered successfully using javascript in "+ elementName);
		}catch(Exception e) {
			extentTest.log(Status.INFO,"unplanned exception occurred for "+ elementName);
			throw e;
		}	
	}

	public String getXPath(WebElement element) {
		String elementStr=element.toString();
		String[] arr=elementStr.split("xpath:");
		String xp=arr[1];
		String xpath=xp.replaceAll("]]", "]").trim();
		return xpath;
	}

	////===============================click method====================================>

	public  void click( WebElement element, String elementname) {
		try {

			element.click();
			extentTest.log(Status.INFO,"- clicked successfully on element -"+elementname);
			//}catch(NoSuchElementException e) {
			//waitforElementTovisible(element, 10);
			//element.click();
			extentTest.log(Status.INFO,"- clicked successfully on element -"+elementname);
		}catch(ElementNotInteractableException e) {
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", element);
			extentTest.log(Status.FAIL,"- clicked successfully on element -"+elementname);
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"- unplanned exception occurred. while clicking"+ e);
			String filePath=takeScreenShot( elementname);
			extentTest.addScreenCaptureFromPath(filePath);
			throw e;
		}

	}
	
	///============================clear method==============================>

	public  void clear( WebElement element,String elemenetName) {
		try {
			element.clear();

			extentTest.log(Status.INFO,"click successfully on element");
		}catch(StaleElementReferenceException e) {

			element.clear();
			extentTest.log(Status.INFO,"clear successfully on element");

		}catch(ElementNotInteractableException e) {
			extentTest.log(Status.INFO,"clear successfully on element");
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception occurred");
			throw e;
		}	
	}

	////==========================getText method================================>

	public  String getinnerText(WebElement weusername,String elementname) {

		String	print;
		try {
			print=weusername.getText();


		}catch(NoSuchElementException e) {

			String pri=weusername.getText();
			extentTest.log(Status.INFO,pri+"print value");
			throw e;

		}catch(InvalidSelectorException e) {
			extentTest.log(Status.INFO,"value print any text");
			throw e;
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception is occered");
			throw e;
		}	
		return print;
	}

	///=============================getSize method===================================>

	public  Dimension getSize(WebElement weusername,String elementName) {
		Dimension   siz;
		try {
			siz=weusername.getSize();
		}catch(NoSuchElementException e) {


			Dimension size=weusername.getSize();
			extentTest.log(Status.INFO,size+"print value");
			throw e;
		}catch(InvalidSelectorException e) {
			extentTest.log(Status.INFO,"value print any text");
			throw e;
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception is occered");
			throw e;
		}
		return siz;

	}

	///================================getLocation method=====================================>

	public  Point getLocation(WebElement weusername,String elementName) {

		Point	location;
		try {
			location=weusername.getLocation();
		}catch(NoSuchElementException e) {

			Point loca=weusername.getLocation();
			extentTest.log(Status.INFO,loca+"print value");
			throw e;
		}catch(InvalidSelectorException e) {
			extentTest.log(Status.INFO,"value print any text");
			throw e;
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception is occered");
			throw e;
		}	
		return location;

	}

	///===============================isDisplayed method================================>

	public  boolean isDisplayed(WebElement weusername,String elementName) {

		boolean	display;
		try {
			display=weusername.isDisplayed();
		}catch(NoSuchElementException e) {

			boolean locas=weusername.isDisplayed();
			extentTest.log(Status.INFO,locas+"print value");
			throw e;
		}catch(InvalidSelectorException e) {
			extentTest.log(Status.INFO,"value print any text");
			throw e;
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception is occered");
			throw e;
		}	
		return display;

	}
	///======================================isEnabled method================================>

	public  boolean isEnabled(WebElement weusername,String elementName) {

		boolean	enable;
		try {
			enable=weusername.isEnabled();
		}catch(NoSuchElementException e) {

			boolean enab=weusername.isEnabled();
			extentTest.log(Status.INFO,enab+"print value");
			throw e;
		}catch(InvalidSelectorException e) {
			extentTest.log(Status.INFO,"value print any text");
			throw e;
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception is occered");
			throw e;
		}	
		return enable;

	}
	///================================isSelected method===================================>		

	public  boolean isSelected(WebElement weusername,String xpath) {

		boolean	select;
		try {
			select=weusername.isSelected();
		}catch(NoSuchElementException e) {



			boolean sele=weusername.isSelected();
			extentTest.log(Status.INFO,sele+"print value");
			throw e;
		}catch(InvalidSelectorException e) {
			extentTest.log(Status.INFO,"value print any text");
			throw e;
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception is occered");
			throw e;
		}	
		return select;		
	}

	///=============================getAttribute method===========================>

	public  void getAttribut( WebElement weusername,String value,String elementName) {

		try {

			weusername.getAttribute(value);
			extentTest.log(Status.INFO,"admin entered successfully in textbox");
		}catch(StaleElementReferenceException e) {

			String va=weusername.getAttribute(value);
			extentTest.log(Status.INFO,va+"admin entered successfully in textbox");

		}catch(ElementNotInteractableException e) {
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("arguments[0].value='+value+'", weusername);
			extentTest.log(Status.INFO,value+"admin entered successfully using javascript in textbox");
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception occurred");
			throw e;
		}	
	}
	///=============================MoveToElement method==============================>
	public  void moveToElement(WebElement wevalue,String elementName) {
		Actions act=new Actions(driver);

		try {

			act.moveToElement(wevalue).build().perform();;
		}catch(NoSuchElementException e) {

			extentTest.log(Status.INFO,"any element to move");
			throw e;
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception occured");
			throw e;
		}



	}

	///======================doubleClick method=========================================>
	public  void doubleClick(WebElement wevalue,String elementName) {
		Actions act=new Actions(driver);

		try {

			act.doubleClick(wevalue).build().perform();
		}catch(NoSuchElementException e) {

			extentTest.log(Status.INFO,"any element to move");
			throw e;
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception occured");
			throw e;
		}

	}
	///============================contactClick method=====================================>
	public  void contextClick(WebElement wevalue,String elementName) {
		Actions act=new Actions(driver);

		try {

			act.contextClick(wevalue).build().perform();

		}catch(NoSuchElementException e) {


			extentTest.log(Status.INFO,"any element to move");
			throw e;
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception occured");
			throw e;
		}


	}
	///=========================DragAnddrop method==============================>
	public  void dragAndDrop(WebElement wevalue,WebElement targetvalue,String elementName) {
		Actions act=new Actions(driver);

		try {

			act.dragAndDrop(wevalue, targetvalue).build().perform();
		}catch(NoSuchElementException e) {

			extentTest.log(Status.INFO,"any element to move");
			throw e;
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception occured");
			throw e;
		}

	}
	///========================ClickAndhold method========================================>
	public  void clickAndHold(WebElement wevalue,String elementName) {
		Actions act=new Actions(driver);

		try {

			act.clickAndHold(wevalue).build().perform();
		}catch(NoSuchElementException e) {

			extentTest.log(Status.INFO,"any element to move");
			throw e;
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception occured");
			throw e;
		}

	}
	///=========================ScrollByAmount method=================================>
	public  void scrollByAmount(int x,int y,String elementName) {
		Actions act=new Actions(driver);
		try {

			act.scrollByAmount(0, 700).build().perform();
		}catch(NoSuchElementException e) {

			extentTest.log(Status.INFO,"any element to move");
			throw e;
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception occured");
			throw e;
		}
	}
	////========================ScrollToElement method==========================================>

	public  void scrollToElement(WebElement wevalue,String elementName) {

		Actions act=new Actions(driver);

		try {

			act.scrollToElement(wevalue).build().perform();
		}catch(NoSuchElementException e) {

			extentTest.log(Status.INFO,"any element to move");
			throw e;
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception occured");
			throw e;
		}

	}
	///==============================ActionClick method===============================>	
	public void actClick(WebElement element) {
		Actions act=new Actions(driver);
		try {
			act.click(element).build().perform();

		}catch(ElementClickInterceptedException e) {
			extentTest.log(Status.INFO,"Element on click");
			throw e;
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception occured");
			throw e;
		}

	}
	public void Click(WebElement element) {
		element.click();
	}




	///====================ActionSendkeys method============================>	
	public void sendKeys(WebElement element,String value) {
		Actions act=new Actions(driver);
		try {
			act.sendKeys(element, value).build().perform();
		}catch(NoSuchElementException e) {
			extentTest.log(Status.INFO,"xpath is wrong");
			throw e;
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception occured");

		}

	}
	///==========================switchToFrame method===============================>	
	public void switchToFrame(int a) {
		try {
			driver.switchTo().frame(a);
		}catch(NoSuchElementException e) {
			extentTest.log(Status.INFO,"xpath is wrong");
			throw e;
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception occured");
			throw e;
		}
	}
	///======================windowhandleTitle method=========================>	
	public void windowhandleTitle() {
		try {
			Set<String>	hand=driver.getWindowHandles();
			for(String handle:hand) {
				driver.switchTo().window(handle)	;
				String title=driver.getTitle();
				if(title.equalsIgnoreCase("")) {
					break;	
				}
			}
			extentTest.log(Status.INFO,"windowhandle done successfully");
		}catch(StaleElementReferenceException e) {
			Set<String>	hand=driver.getWindowHandles();
			for(String handle:hand) {
				driver.switchTo().window(handle)	;
				String title=driver.getTitle();
				if(title.equalsIgnoreCase("")) {
					break;	
				}
			}
			throw e;

		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception occured");
			throw e;
		}
	}

	///======================windowhandleURL method=========================>	
	public void switchToWindowByURL(String windowURL) {
		Set<String> allhandle = driver.getWindowHandles();
		try {
			allhandle = driver.getWindowHandles();
			for (String handanlcode : allhandle) {
				allhandle = driver.getWindowHandles();
				driver.switchTo().window(handanlcode);
				String haldleString = driver.getCurrentUrl();
				if (haldleString.equalsIgnoreCase(windowURL)) {
					break;
				}
			}
			extentTest.log(Status.INFO, "window by Url match succesfully...");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Exception Occurred......");
		}	
	}

	/* WindowMaximize   :  this method works window maximize 
	 * @  params         :   no params 
	 * return            :    NA 
	 * Author            : Mr. Vikas Paswan
	 * Created Date      :   22-11-2025
	 * Modifier Date     :   NA 
	 */	

	public void maximize() {
		try {
			driver.manage().window().maximize();
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception occured");
			throw e;

		}
	}

	/* this method of alert class and it handle popup if we want to accept  button then we use accept 
	 * @  params         :   no params 
	 * return            :    NA 
	 * Anthor            : Mr. Vikas Paswan
	 * Created Date      :   22-11-2025
	 * Modifier Date     :   NA 
	 */


	public void alertAccept() {
		Alert ale = driver.switchTo().alert();
		try {
			ale.accept();
		}catch(StaleElementReferenceException e) {
			extentTest.log(Status.INFO,"Alert window is handle");
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception occured");
		}

	}
	/* this method of alert class and it handle popup if we want to cancle button then we use dismiss
	 * @  params         :   no params 
	 * return            :    NA 
	 * Anthor            : Mr. Vikas Paswan
	 * Created Date      :   22-11-2025
	 * Modifier Date     :   NA 
	 */
	public void alertDismiss() {
		Alert	ale = driver.switchTo().alert();
		try {
			ale.dismiss();
		}catch(StaleElementReferenceException e) {
			extentTest.log(Status.INFO,"Alert window is handle");
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception occured");
		}

	}
	/*   selectFromDropdownByText     :   this method of select class and this method select any dropdown Text
	 *    @   params                   :     String
	 * return                          : NA
	 * Created  Date   : 22-11-2025
	 * Modifier Date   :  NA 
	 */	 

	public void selectFromDropdownByText(WebElement element,String text,String elementName) {
		try {	

			Select	se=new Select(element);
			se.selectByVisibleText(text);
			extentTest.log(Status.INFO,text+"=====>selected in dropdown successfully from"+elementName);
		}catch(StaleElementReferenceException e) {


			Select	se=new Select(element);
			se.selectByVisibleText(text);
			extentTest.log(Status.INFO,text+"=====>selected in dropdown successfully from"+elementName);	
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"Exception occurred");
			throw e;
		}
	}

	/*   selectFromDropdownByvalue     :   this method of select class and this method select any dropdown value
	 *    @   params                   :     String
	 * return      NA
	 * Created  Date   : 22-11-2025
	 * Modifier Date   :  NA
	 */	 

	public void selectFromDropdownByValue(WebElement element,String value,String elementName) {
		try {	
			Select	se=new Select(element);
			se.selectByValue(value);
			extentTest.log(Status.INFO,value+"=====>selected in dropdoun successfully"+elementName);
		}catch(StaleElementReferenceException e) {

			Select	se=new Select(element);
			se.selectByValue(value);
			extentTest.log(Status.INFO,value+"=====>selected in dropdoun successfully"+elementName);	
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"Exception occurred");
			throw e;
		}
	}
	/*   selectFromDropdownByIndex     :   this method of select class and this method select any dropdown number
	 *    @   params                   :     int 
	 * return      NA
	 * Created  Date   : 22-11-2025
	 * Modifier Date   :  NA*/	 
	public void selectFromDropdownByIndex(WebElement element,int num,String elementName) {
		try {	
			Select	se=new Select(element);
			se.selectByIndex(num);
			extentTest.log(Status.INFO,num+"=====>selected in dropdoun successfully");
		}catch(StaleElementReferenceException e) {

			Select	se=new Select(element);
			se.selectByIndex(num);
			extentTest.log(Status.INFO,num+"=====>selected in dropdoun successfully");	
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"Exception occurred");
			throw e;
		}
	}
	/* this method print any value
	 * @params     : String 
	 * return      NA
	 * Created  Date   : 22-11-2025
	 * Modifier Date   :  NA
	 */	

	public void Print(String massage) {
		try {
			extentTest.log(Status.INFO,massage);
		}catch(Exception e){
			extentTest.log(Status.FAIL,"unplanned exception occured");
			throw e;
		}
	}
	/*   getSelectedValueFromDropdown    :  this method fetch selected value  from dropdown 
	 *    * @params            :            no params 
	 * return             :                  NA
	 *  Author            :          Vikas Paswan
	 *  Created Date       :          22-11-2025
	 *Modifier Date        :          NA
	 */	 	

	public String getSelectedValueFromDropdown(WebElement element) {
		String firstvalue=null;
		try {
			Select	 select    = new Select(element);
			WebElement   selectedvalue          =select.getFirstSelectedOption();
			firstvalue         =selectedvalue.getText();
			extentTest.log(Status.INFO,firstvalue+"is selected dropdown");

		}catch (Exception e) {
			extentTest.log(Status.FAIL,"unplanned exception occured");
		}
		return firstvalue;
	}
	/* getAllElmentsFromDropdown    : this method select all values from dropdown
	 * @params            :  no params 
	 * return             :    NA
	 *  Author            :         Vikas Paswan
	 *  Created Date       :      22-11-2025
	 *Modifier Date        :          NA
	 */	

	public List<WebElement> getAllElmentsFromDropdown(WebElement element) {

		Select	 select    = new Select(element);
		List<WebElement> options =  select.getOptions();

		return options;

	}
	/* scrollToElement    :  scrollToElement method of javascriuptExecuter and it scroll page by element
	 * @params            :  no params 
	 * return             :    NA
	 *  Author            :          Vikas Paswan
	 *  Created Date       :      22-11-2025
	 *Modifier Date        :          NA
	 */	

	public void scrollToElementByjavaScript(WebElement element) {
		try {
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			jse.executeScript("arguments[0].ScrollIntoview(True)", element);
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"Unknown Exception occured");

		}
	}
	/* scrollIntoHeight       :   scrollIntoHeight  method of javascriptExecuter it scroll to up from down page  
	 *  *  @params                          :  no param 
	 *  return                           :  NA
	 *  Author                           : Vikas Paswan
	 *  Created Date                     :  22-11-2025
	 * Modifier Date                    : NA
	 */  



	public void scrollIntoHeightjavaScript(WebElement element) {
		try {
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			jse.executeScript("window.ScrollTo(0.dacument.body.ScrollHeight)");
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"Unknown Exception occured");

		}
	}
	/*  scrollByAmountByjavaScript      :   it scroll the page by numbres this method of javascriptExxecuter
	 * 
	 *  @params                          :  int 
	 *  return                           :  NA
	 *  Author                           : Vikas Paswan
	 *  Created Date                     :  22-11-2025
	 * Modifier Date                    : NA
	 */  

	public void scrollByAmountByjavaScript(WebElement element,int a,int b) {
		try {
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			jse.executeScript("window.ScrollBy(a,b)");
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"Unknown Exception occured");

		}
	}
	/* click    : this method of javascriptExecurter and it works it send  any textbox
	 * return   :  String
	 *  Author   : Vikas Paswan
	 *  Created Date :22-11-2025
	 * Modifier Date : NA
	 */

	public void javaScriptInputValue(WebElement element,String value) {
		try {
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			jse.executeScript("arguments[0].value='value'",element);
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"Unknown Exception occured");

		}
	}
	/* click    : this method of javascriptExecurter and it works it click  any element
	 * return   :  NA
	 *  Author   : Vikas Paswan
	 *  Created Date :22-11-2025
	 * Modifier Date : NA
	 */

	public void javaScriptClick(WebElement element) {
		try {
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()",element);
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"Unknown Exception occured");

		}
	}
	/* takesScreenShot  method of take screenshot  of any page
	 *     and it is the child of WebDriver
	 * @params  :  no params 
	 *  return  : NA
	 *  Author   : Vikas Paswan
	 *  Created Date :22-11-2025
	 *  Modifier Date : NA
	 */
	public String takeScreenShot(String Filename)  {
		try {
			TakesScreenshot tss= (TakesScreenshot) driver;
			File photo= tss.getScreenshotAs(OutputType.FILE);
			Filename="C:\\Users\\admin\\Desktop\\eva_works\\vtiger_framework\\TestCaseReports\\"+Filename+".png";
			File FilePlace=new File(Filename);
			FileUtils.copyFile(photo , FilePlace );
//			extentTest.log(Status.PASS,"33- Take ScreenShot on element");
		} catch (WebDriverException e) {
			e.printStackTrace();
//			extentTest.log(Status.FAIL,"33- Take ScreenShot on element");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Filename;
	}
	//======================================================================

	/*WebDriverWait     :  visibilityOfElement  this method of WebDriver and it needs 
	 *                      a by Locater 
	 * @params  :  int 
	 *  return  : NA
	 *  Author   : Vikas Paswan
	 *  Created Date :22-11-2025
	 *  Modifier Date : NA
	 *   */


	public WebElement waitforElementTovisible(WebElement element, int Timeouts) {
		WebElement we=null;
		try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Timeouts));
			wait.until(ExpectedConditions.visibilityOf(element));
			extentTest.log(Status.PASS,"52- wait visibility successfully");
		} catch (Exception e) {
			extentTest.log(Status.FAIL,"52- waitvisibility is throw unexpected exception occurred");
		}
		return we;
	}

	//=======================================================================

	/*WebDriverWait     :  visibilityOfElement  this method of WebDriver and it needs 
	 *                      a by Locater 
	 * @params  :  int 
	 *  return  : NA
	 *  Author   : Vikas Paswan
	 *  Created Date :22-11-2025
	 *  Modifier Date : NA
	 *   */

	public void visibilityOfElementLocated(String xpath,int num) {
		try {
			WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(num));
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned Exception came");  
		}

	}

	/*WebDriverWait     :  invisibilityOfElement  this method of WebDriver and it needs a ByLocater it 
	 *                    waits till element disappear
	 *                       
	 * @params  :  int 
	 *  return  : NA
	 *  Author   : Vikas Paswan
	 *  Created Date :22-11-2025
	 *  Modifier Date : NA
	 *   */
	public void invisibilityOfElementLocated(String xpath,int num) {
		try {
			WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(num));
			wt.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
		}catch(Exception e) {
			extentTest.log(Status.FAIL,"unplanned Exception came");  
		}

	}

	/* this is static wait it waits according to given time 
	 * @params  :  int 
	 *  return  : NA
	 *  Author   : Vikas Paswan
	 *  Created Date :22-11-2025
	 *  Modifier Date : NA
	 *   */
	public void staticWait(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			extentTest.log(Status.FAIL,"Interrupted  Exception Occured");
		}

	}
	//=============================  closeAllBrowser=========================================================================

	public void closeAllBrowser() {			
		driver.quit();


	}




}





















