package testmail126;

import java.io.UnsupportedEncodingException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import properties.Do;
import properties.ParseProperties;

import launch.Browsers;
import launch.BrowsersType;

public class Mail126Keys {
	private WebDriver driver;
	private ParseProperties data;
	private Do du;

	@BeforeClass
	public void inital(){
		data=new ParseProperties(System.getProperty("user.dir")+"/tool/test.properties");
		Browsers browser=new Browsers(BrowsersType.firefox);
		driver=browser.driver;
		du=new Do(driver);
	}

	@Test
	public void login() throws UnsupportedEncodingException,Exception{
		driver.get("http://126.com");
		du.what("username").sendKeys("715478706");
//	 du.what("username").sendKeys("715478706",Keys.TAB);
		du.what("passwd").sendKeys("123");
//	 du.what("passwd").sendKeys("123",Keys.ENTER);
		du.what("submit").click();
		du.waitForElementIsEnable("inbox");
		du.waitFor(10000);
	}

	@Test(dependsOnMethods={"login"})//依赖login方法
	public void restriveMailsIn(){
		int actualunread=0;
		int totalPagesNum=0;
		String strnum=du.what("unread").getText();
		int inbox=Integer.parseInt(strnum.substring(1, strnum.length()-1));

		du.what("inbox").click();
		try {
			du.waitForElementPresent("unreadlink");
			du.what("unreadlink").click();
			du.waitForElementIsEnable("totalPage");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		totalPagesNum=Integer.parseInt(du.what("totalPages").getText().split("/")[1]);
		while(totalPagesNum>=1){
			try {
				actualunread=actualunread+du.whats("unreadmail").size();
				du.what("nextbt").click();
				du.waitFor(5000);
			} catch (Exception e) {
				break;
			}
			totalPagesNum--;
		}
		System.out.println("1--"+inbox);
		System.out.println("2--"+actualunread);

	}
	@Test
	public void upload(){
		du.what("sendbox").click();
		du.what("att").sendKeys("c:/terry.txt");
		du.waitFor(5000);
	}

	@AfterClass
	public void reslse(){
		driver.quit();
	}
}



























