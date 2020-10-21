package launch;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browsers {
	public  WebDriver driver=null;
	private static DesiredCapabilities caps =null;
	private static FirefoxProfile firefoxprofile=null;
	private String projectpath=System.getProperty("user.dir");
	
	public Browsers(BrowsersType bt){
		switch(bt){
		case firefox:
			caps=DesiredCapabilities.firefox();
			System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			File firebug=new File(projectpath+"/tool/firebug@software.joehewitt.com.xpi");
			File firefinder=new File(projectpath+"/tool/firefinder@robertnyman.com.xpi");
			firefoxprofile=new FirefoxProfile();
			firefoxprofile.addExtension(firebug);
			firefoxprofile.addExtension(firefinder);
			firefoxprofile.setPreference("webdriver.accept.untrusted.certs", "true");
			firefoxprofile.setPreference("extensions.firebug.currentVersion", "2.0.18");
			caps.setCapability(FirefoxDriver.PROFILE,firefoxprofile );
//				firefoxprofile.setPreference("network.proxy.type",0);
//				firefoxprofile.setPreference("network.proxy.http","127.0.0.1");
//				firefoxprofile.setPreference("network.proxy.http_port",3128);
			driver =new FirefoxDriver(firefoxprofile);
			break;
		case ie:
			System.setProperty("webdriver.ie.driver",projectpath+"/tool/IEDriverServer.exe");
			caps=DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			caps.setCapability(InternetExplorerDriver.IE_SWITCHES,"-private");
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			 driver=new InternetExplorerDriver(caps);
			 
				break;
		case chrome:
			System.setProperty("webdriver.chrome.driver",projectpath+"/tool/chromedriver.exe");
			caps=DesiredCapabilities.chrome();
			caps.setCapability("chrome.switches", Arrays.asList("--start-maximized"));//最大化browser
//			caps.setCapability("chrome.switches", Arrays.asList("--proxy-server-http://your-proxy-domain:4443"));
			driver=new ChromeDriver(caps);
			
			break;
		}
	}

	
}
