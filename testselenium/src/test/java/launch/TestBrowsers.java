package launch;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestBrowsers {
	private WebDriver driver;
	@Parameters({"browsername"})
	@BeforeClass
	public void beforeClass(@Optional("") String browsername){
		Browsers browser = null;

		if(browsername.equals("ff")){
			browser=new Browsers(BrowsersType.firefox);
		}else if(browsername.equals("ie")){
			browser=new Browsers(BrowsersType.ie);
		}else if(browsername.equals("chrome")){
			browser=new Browsers(BrowsersType.chrome);
		}
		driver=browser.driver;
	}

	@Test
	public void searchBaidu(){
		driver.manage().window().maximize();
		driver.get("http://www.baidu.com");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void releaseDriver(){
		driver.quit();
	}
}
