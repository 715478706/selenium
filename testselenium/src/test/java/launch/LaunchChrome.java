package launch;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchChrome {

	private WebDriver cwd=null;
	private DesiredCapabilities caps=null;
	private String projectpath=System.getProperty("user.dir");
	@BeforeClass
	public void startChorme(){
		System.setProperty("webdriver.chrome.driver",projectpath+"/tool/chromedriver.exe");
		caps=DesiredCapabilities.chrome();
		caps.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
		caps.setCapability("chrome.switches", Arrays.asList("--proxy-server-http://your-proxy-domain:4443"));
		cwd=new ChromeDriver(caps);
	}

	@Test
	public void searchBaidu(){
		cwd.manage().window().maximize();
		cwd.get("http://www.baidu.com");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public void releaseDriver(){
		cwd.quit();
	}
}
