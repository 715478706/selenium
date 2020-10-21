package gridjson;

import org.openqa.selenium.WebDriver;

import com.wait.Wait;

public class BaiduHomePage extends PageBase {

	private WebDriver driver;
	private Wait wait;
	
//	public BaiduHomePage(WebDriver driver, String tablename, WebDriver driver, Wait wait) {
//		super(driver, tablename);
//		driver = driver;
//		this.wait = wait;
//	}

	public BaiduHomePage(WebDriver driver) {
		super(driver, "BaiduHomePage");
		
		this.driver=driver;
		wait=new Wait(driver);
	}
	public void login(String username ,String password){
		wait.waitForElemenEnable(getLocValue("Login"));
		this.getLoc("Login").click();
//		getLoc("Login").click();
		wait.waitForElemenEnable(getLocValue("password"));
		getLoc("username").sendKeys(username);
		getLoc("password").sendKeys(username);
		getLoc("submit").click();
	}
}
























