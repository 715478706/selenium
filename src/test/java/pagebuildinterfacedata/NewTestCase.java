package pagebuildinterfacedata;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.properties.Do;

import launch.Browsers;
import launch.BrowsersType;

public class NewTestCase {
	private WebDriver driver;
	private Do du;
	private NewHomePage hm;
	private NewRegisterPage nrp;
	@BeforeClass
	public void init(){
		Browsers browser=new Browsers(BrowsersType.firefox);
		driver=browser.driver;
		hm=new NewHomePage(driver);
		nrp=new NewRegisterPage(driver);
	}
	@Test
	public void regAccount(){
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String datev=sdf.format(date);
		System.out.println(datev);
		
		hm.navigateTo().register();
		String.format("%1$s-----%2$s", "欢迎",datev);
		
		nrp.setUserId("zhanghao ").setPassword("mima").register();;
//		nrp.setPassword("mama ").register();
//		nrp.register();
		Assert.assertEquals(du.what(HomeLoc.RR).isDisplayed(), true);
		Assert.assertEquals(nrp.getElement(HomeLoc.RR, "userid").isDisplayed(),true );
	}
	
	@AfterClass
	public void release(){
		driver.quit();
	}

}
