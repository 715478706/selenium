package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestChrome {
	private WebDriver cwd=null;
	@Test
	public void startChorme1(){
		System.setProperty("webdriver.chrome.driver","E:/Users/Administrator/workspace/test/libs/chromedriver.exe");
//		caps=DesiredCapabilities.chrome();
//		caps.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
//		caps.setCapability("chrome.switches", Arrays.asList("--proxy-server-http://your-proxy-domain:4443"));
		cwd=new ChromeDriver();
		cwd.get("http://www.baidu.com");
	}
}
