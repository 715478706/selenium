package launch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchIE {
	private static WebDriver iewd=null;
	private static DesiredCapabilities caps =null;
	private String projectpath=System.getProperty("user.dir");

	
	@BeforeClass
	public   void startIE() {
		System.setProperty("webdriver.ie.driver",projectpath+"/tool/IEDriverServer.exe");
		caps=DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);

		caps.setCapability(InternetExplorerDriver.IE_SWITCHES,"-private");
		caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		 iewd=new InternetExplorerDriver(caps);
	}

	@Test
	 public void searchOnBaidu(){
		iewd.manage().window().maximize();
			iewd.get("http://www.baidu.com");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	@AfterClass
	public void releaseDriver(){
		iewd.quit();
	}
}
