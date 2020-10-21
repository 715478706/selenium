package gridjson;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.wait.Wait;

public class BrowsersType {
	public  WebDriver driver=null;
	private static DesiredCapabilities caps =null;
	private static FirefoxProfile firefoxprofile=null;
	private String projectpath=System.getProperty("user.dir");
	private Wait wait;
	
	public static String nodeurl="";
	
	
	public WebDriver setFirefox(String nodeurl){
		caps=DesiredCapabilities.firefox();
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		File firebug=new File(projectpath+"/tool/firebug@software.joehewitt.com.xpi");
		File firefinder=new File(projectpath+"/tool/firefinder@robertnyman.com.xpi");
		firefoxprofile=new FirefoxProfile();
		try {
			firefoxprofile.addExtension(firebug);
			firefoxprofile.addExtension(firefinder);
			firefoxprofile.setPreference("webdriver.accept.untrusted.certs", "true");
			firefoxprofile.setPreference("extensions.firebug.currentVersion", "2.0.18");
			caps.setCapability(FirefoxDriver.PROFILE,firefoxprofile );
//			firefoxprofile.setPreference("network.proxy.type",0);
//			firefoxprofile.setPreference("network.proxy.http","127.0.0.1");
//			firefoxprofile.setPreference("network.proxy.http_port",3128);
			driver =new RemoteWebDriver(new URL(nodeurl),caps);
			wait=new Wait(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	public WebDriver setIE(String nodeurl){
		System.setProperty("WebDriver.ie.driver",projectpath+"/tool/IEDriverServer.exe");
		caps=DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		caps.setCapability(InternetExplorerDriver.IE_SWITCHES,"-private");
		caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		try {
			driver =new RemoteWebDriver(new URL(nodeurl),caps);
			wait=new Wait(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	public WebDriver setChrome(String nodeurl){
		System.setProperty("WebDriver.chrome.driver",projectpath+"tool/chromedriver.exe");
		caps=DesiredCapabilities.chrome();
		caps.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
		caps.setCapability("chrome.switches", Arrays.asList("--proxy-server-http://your-proxy-domain:4443"));
		try {
			driver =new RemoteWebDriver(new URL(nodeurl),caps);
		
		wait=new Wait(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	
	/*public WebDriver setWebDriver(String nodeurl,String bt){
		switch(bt){
		case "firefox":
			System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			File firebug=new File(projectpath+"/tool/firebug@software.joehewitt.com.xpi");
			File firefinder=new File(projectpath+"/tool/firefinder@robertnyman.com.xpi");
			firefoxprofile=new FirefoxProfile();
			
			try {
				firefoxprofile.addExtension(firebug);
				firefoxprofile.addExtension(firefinder);
				firefoxprofile.setPreference("webdriver.accept.untrusted.certs", "true");
				firefoxprofile.setPreference("extensions.firebug.currentVersion", "2.0.18");
//				firefoxprofile.setPreference("network.proxy.type",0);
//				firefoxprofile.setPreference("network.proxy.http","127.0.0.1");
//				firefoxprofile.setPreference("network.proxy.http_port",3128);
				driver =new RemoteWebDriver(new URL(nodeurl),caps);
				wait=new Wait(driver);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "ie":
			System.setProperty("WebDriver.ie.driver",projectpath+"/tool/IEDriverServer.exe");
			caps=DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			caps.setCapability(InternetExplorerDriver.IE_SWITCHES,"-private");
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			try {
				driver =new RemoteWebDriver(new URL(nodeurl),caps);
				wait=new Wait(driver);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			 
				break;
				
		case "chrome":
			System.setProperty("WebDriver.chrome.driver",projectpath+"tool/chromedriver.exe");
			caps=DesiredCapabilities.chrome();
			caps.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
			caps.setCapability("chrome.switches", Arrays.asList("--proxy-server-http://your-proxy-domain:4443"));
			try {
				driver =new RemoteWebDriver(new URL(nodeurl),caps);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			wait=new Wait(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			break;
			
		}
		return driver;
	}*/

	
}
