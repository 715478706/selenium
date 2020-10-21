package com.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
  
	private WebDriver driver;
	private int timeout=10;
	public Wait(WebDriver driver){
		this .driver=driver;
	}
	
	public void waitForElemenPresent(String locator){
		new WebDriverWait(driver,timeout).until
		      (ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
	public void waitForElemenEnable(String locator){
		new WebDriverWait(driver,timeout).until
		      (ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}
	public void waitThread(long timeout){
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
