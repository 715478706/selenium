package autoit;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import properties.Do;
import properties.Switch;
import csvdb.wait.Wait;

import gridjson.extendbasepage.LoginBaidu;

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
		sw.toWindow("登录 - 支付宝");
		wait.waitThread(1000);
		du=new Do(driver);
		du.what("name").click();
		wait.waitThread(1000);
		try {//执行.exe文件
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
