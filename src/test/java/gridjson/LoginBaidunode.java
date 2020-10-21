package gridjson;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import launch.BrowsersType;

public class LoginBaidunode {
	private WebDriver driver;
	private BaiduHomePage baiduhomepage;
	
	@BeforeClass
	public void initalModule(){
		Browsers.nodeurl="http://localhost:5555/wd/hub";
		Browsers browser=new Browsers();
		browser.setFirefox(Browsers.nodeurl);
		driver=browser.driver;
		baiduhomepage=new BaiduHomePage(driver);
	}
	@Test
	public void doLogin(){
		driver.get("http://www.baidu.com");
		baiduhomepage.login("zeng", "123");
	}
	@AfterClass
	public void release(){
		driver.quit();
	}
}
