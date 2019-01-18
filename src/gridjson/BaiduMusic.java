package gridjson;

import org.openqa.selenium.WebDriver;

import com.csvdb.DBOp;
import com.wait.Wait;

public class BaiduMusic extends PageBase {
	private WebDriver driver;
	private Wait wait;
 
 public BaiduMusic(WebDriver driver){
	 super(driver, "baidumusic");
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
 
