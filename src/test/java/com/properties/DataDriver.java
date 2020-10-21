package com.properties;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import launch.Browsers;
import launch.BrowsersType;

public class DataDriver {
	private WebDriver ffwd=null;
	private String projectpath=System.getProperty("user.dir");
	private ParseProperties data;
	private ParseProperties  locator;
//	private Wait wait =null;
	
	@Parameters({"da","loc"})
	@BeforeClass
	public void startFirefox(@Optional("da") String da,@Optional("loc") String loc){
		data =new ParseProperties(projectpath+da);
		locator =new ParseProperties(projectpath+loc);
		Browsers browser=new Browsers(BrowsersType.firefox);
		this.ffwd=browser.driver;
		//wait=new Wait(ffwd);
		ffwd.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}
	
	@Test
	public void accessMail(){
		ffwd.get(data.getValue("url"));
		ffwd.findElement(By.xpath(locator.getValue("url"))).clear();
		ffwd.findElement(By.xpath(locator.getValue("username"))).sendKeys("HelloWorld");
		ffwd.findElement(By.xpath(locator.getValue("submit"))).click();
		
//		new WebDriverWait(ffwd,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator.getValue("454"))));
		Assert.assertEquals(ffwd.findElement(By.xpath(locator.getValue("sendkey"))).isDisplayed(),true);
		
		Assert.assertEquals(ffwd.findElement(By.xpath(locator.getValue("sendkey"))).isDisplayed(),true);
	}
	public void search(){
		int expect=40;
		String unread;
		unread = ffwd.findElement(By.xpath(locator.getValue("inbox"))).getText();
		
		String str=unread.substring(1, unread.length()-1);
		int i=Integer.parseInt(str);
		System.out.println(i);
		Assert.assertEquals(i, expect);
		}
		@AfterClass
		public void releaseDriver(){
			ffwd.quit();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
