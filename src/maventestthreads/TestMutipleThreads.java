package maventestthreads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.properties.ParseProperties;

import launch.Browsers;
import launch.BrowsersType;

public class TestMutipleThreads {

	public WebDriver driver=null;
	public BrowsersType bt=null;
	public ParseProperties locator=null;
	@BeforeClass
	public void start(){
		
	}
	@Parameters({"url"})
	@Test
	public void login(@Optional String url){
		Browsers browser=new Browsers(BrowsersType.chrome);
		driver=browser.driver;
		driver.get("http://baidu.com");
		locator=new ParseProperties(System.getProperties()+url);//通过文件名找到path
		driver.findElement(By.xpath(locator.getValue("name"))).click();
	}
	@Parameters({"url"})
	@Test
	public void getJD(@Optional String url){
		Browsers browser=new Browsers(BrowsersType.chrome);
		driver=browser.driver;
		driver.get("http://jingdong.com");
		locator=new ParseProperties(System.getProperties()+url);//通过文件名找到path
		driver.findElement(By.xpath(locator.getValue("name"))).click();
	}
	@AfterClass
	public void quit(){
		driver.quit();
	}
}
