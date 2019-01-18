package launch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.properties.ParseProperties;

public class ParameterSelectBrowsers {
	public WebDriver driver=null;
	public Browsers browser=null;
	public BrowsersType bt=null;
	public ParseProperties locator=null;
	
	@Parameters({"select"})
	@BeforeClass
	public void start(int select){
		if(select==1){
			bt=BrowsersType.chrome;
		}else if(select!=1){
			System.out.println("!1");
		}
		Browsers browser=new Browsers(bt);
		driver=browser.driver;
	}
	
	@Parameters({"url","password"})
	@Test
	public void login(@Optional("") String url,@Optional("") String password){
		driver.get("http://baidu.com");
		locator=new ParseProperties(System.getProperty("user.dir")+url);//通过文件名找到path
		driver.findElement(By.xpath(locator.getValue(password))).click();
		new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated
				(By.xpath(locator.getValue("shijian"))));
	}

}
