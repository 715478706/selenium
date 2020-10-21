package pagefactory;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.properties.Do;

import launch.Browsers;
import launch.BrowsersType;

public class UsePages {
	private WebDriver driver;
	private Do du;
	@BeforeClass
	public void init(){
		Browsers browser=new Browsers(BrowsersType.firefox);
			driver=browser.driver;
	}
	@Test
	public void regAccount(){
		HomePage hm=new HomePage(driver);
		RegisterPage tp=new RegisterPage(driver);
		
		hm.navigateToJD("url");
		hm.register();
		
		tp.setUserId("zeng@qq.com");
		tp.setPassword("mima");
		tp.register();
		
		Assert.assertEquals("a", true);
	}
	
	@AfterClass
	public void release(){
		driver.quit();
	}

}
















