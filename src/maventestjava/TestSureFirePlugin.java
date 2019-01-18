package maventestjava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.properties.ParseProperties;

import launch.Browsers;
import launch.BrowsersType;

public class TestSureFirePlugin {
	public WebDriver driver=null;
	public Browsers browser=null;
	public BrowsersType bt=null;
	public ParseProperties locator=null;
	@BeforeClass
	public void start(){
		Browsers browser=new Browsers(BrowsersType.firefox);
		driver=browser.driver;
	}
	
	@Parameters({"url"})
	@Test
	public void login(@Optional String url){
		driver.get("http://www.baidu.com");
		locator=new ParseProperties(System.getProperties()+url);//通过文件名找到path
		driver.findElement(By.xpath(locator.getValue("name"))).click();
	}
	@AfterClass
	public void quit(){
		driver.quit();
	}
}
