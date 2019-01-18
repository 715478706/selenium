package launch;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchFF {
	private WebDriver ffwd=null;
	private FirefoxProfile firefoxprofile=null;
	private String projectpath=System.getProperty("user.dir");
	
	@BeforeClass
	public void startFire() throws IOException{
		System.setProperty
		("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		File firebug=new File(projectpath+"/tool/firebug@software.joehewitt.com.xpi");
		
		firefoxprofile=new FirefoxProfile();
		firefoxprofile.addExtension(firebug);
		firefoxprofile.setPreference("webdriver.accept.untrusted.certs", true);
		firefoxprofile.setPreference("extensions.firebug.currentVersion", "2.0.18");
//			firefoxprofile.setPreference("network.proxy.type",0);
//			firefoxprofile.setPreference("network.proxy.http","127.0.0.1");
//			firefoxprofile.setPreference("network.proxy.http_port",3128);
		ffwd =new FirefoxDriver(firefoxprofile);
	}
	@Test
	public void searchBaidu(){
		ffwd.manage().window().maximize();
		ffwd.get("http://www.baidu.com");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public void releaseDriver(){
		ffwd.quit();
	}
}
