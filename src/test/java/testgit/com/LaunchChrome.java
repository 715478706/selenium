package testgit.com;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchChrome {

	private WebDriver cwd=null;
	private final DesiredCapabilities caps=null;
	private final String projectpath=System.getProperty("user.dir");
	@BeforeClass
	public void startChorme(){
		System.setProperty("webdriver.chrome.driver",projectpath+"/tool/chromedriver.exe");
		cwd=new ChromeDriver();
	}
	
	@Test
	public void searchBaidu(){
		cwd.manage().window().maximize();
		cwd.get("https://www.baidu.com");
		try {
			System.out.println(cwd.getTitle());
			assertEquals(cwd.getTitle(), "百度一下，你就知道");
			cwd.findElement(By.id("kw")).sendKeys("无双");
			Thread.sleep(10000);
			
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
