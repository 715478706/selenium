package autoit;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.properties.Do;
import com.properties.Switch;
import com.wait.Wait;

import gridjson.LoginBaidu;

public class DownMusic {
	private LoginBaidu lb;
	private WebDriver driver;
	private Switch sw;
	private Wait wait;
	private Do du;
	
	@BeforeClass
	public void loginBaidu(){
	lb=new 	LoginBaidu();
	lb.doLogin();
	driver=new FirefoxDriver();
	sw=new Switch(driver);
	wait.waitThread(1000);
	}
	
	@Test
	public void testAutoit(){
		sw.toWindow("µÇÂ¼ - Ö§¸¶±¦");
		wait.waitThread(1000);
		du=new Do(driver);
		du.what("name").click();
		wait.waitThread(1000);
		try {
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"/src/autoit/download.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void release(){
		driver.quit();
	}
}
