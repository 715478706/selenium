package csvdb.wait;


import launch.Browsers;
import launch.BrowsersType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import properties.ParseProperties;

import java.util.concurrent.TimeUnit;

public class UseWait {
	private WebDriver ffwd=null;
	private String projectpath=System.getProperty("user.dir");
	private ParseProperties data;
	private ParseProperties  locator;
	private Wait wait =null;

	@Parameters({"data","locator"})
	@BeforeClass
	public void startFirefox(@Optional("data") String da,@Optional("locator") String loc){
		data =new ParseProperties(projectpath+da);
		locator =new ParseProperties(projectpath+loc);
		Browsers browser=new Browsers(BrowsersType.chrome);
		this.ffwd=browser.driver;
		wait=new Wait(ffwd);
		ffwd.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}

	@Test
	public void accessMail(){
		ffwd.get(data.getValue("url"));
		ffwd.findElement(By.xpath(locator.getValue("url"))).clear();
		ffwd.findElement(By.xpath(locator.getValue("username"))).sendKeys("HelloWorld");
		ffwd.findElement(By.xpath(locator.getValue("submit"))).click();
		wait.waitForElemenPresent(locator.getValue("element"));

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
