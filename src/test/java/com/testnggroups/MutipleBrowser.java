package com.testnggroups;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import launch.Browsers;
import launch.BrowsersType;

public class MutipleBrowser {
	private WebDriver driver=null;
	private Browsers browser=null;
	@Parameters({"selectBrowser"})
	@BeforeClass(groups="browser")
	public void beforeClass(@Optional("aaa") String selectbrowser ){
		switch(selectbrowser){
		case "ff":
		     browser=new Browsers(BrowsersType.firefox);
		    break;
		case "ie":
			 browser=new Browsers(BrowsersType.ie);
			break;
		case "chrome":
			browser=new Browsers(BrowsersType.chrome);
		   break;
		}
		this.driver =browser.driver;
	}
	@Test(groups="submodule1")
	public void startIE(){
		driver.get("http://www.baidu.com");
	}
	@Test(groups="submodule2")
	public void startChrome(){
		driver.get("http://www.baidu.com");
	}
	@Test(groups="submodule3")
	public void startFirefox(){
		driver.get("http://www.baidu.com");
	}
	@AfterClass(groups="browser")
	public void releaseDriver(){
		driver.quit();
	}

}
