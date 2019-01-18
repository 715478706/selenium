package com.properties;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.csvdb.DBOp;
import com.wait.Wait;

/**
 * @author Blithe
 *找元素的工具
 */
public class Do {
	public WebDriver driver;
	public ParseProperties pro=new ParseProperties(System.getProperty("user.dir")+"/src/com/properties/test.properties");
	private Wait wait;
	private DBOp test;
	public Do(WebDriver driver){
		this.driver=driver;
		wait =new Wait(driver);
	}
	
	public WebElement what(String keyname){
		WebElement we = null;
		we=	 driver.findElement(By.xpath(pro.getValue(keyname)));
		return we;
	}
	
	public WebElement whatCSS(String locatorname){
		WebElement we = null;
		test=new DBOp(locatorname);
		test.conn();
		String css=test.getLocatorCSS(locatorname);
		return driver.findElement(By.cssSelector(css));
		
		
	}
	
	public List<WebElement> whats(String keyname) throws UnsupportedEncodingException{
		return driver.findElements(By.xpath(pro.getValue(keyname)));
	}
	/**
	 * 
	 * @param keyname
	 * @throws UnsupportedEncodingException
	 */
	public void waitForElementPresent(String keyname) throws UnsupportedEncodingException{
		wait.waitForElemenPresent(pro.getValue(keyname));
	}
	public void waitForElementIsEnable(String keyname) throws UnsupportedEncodingException{
		wait.waitForElemenEnable(pro.getValue(keyname));}
	public void waitFor(long timeout){
		wait.waitThread(timeout);
	}
}






















