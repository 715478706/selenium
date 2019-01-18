package gridjson;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.properties.Do;
import com.wait.Wait;

public class LoginJDTestNodeBrowser extends MutipleTasks {
   private WebDriver driver;
   private Wait wait;
   private Do du;
   
   @Parameters({"node","browser"})
   public void beforeClass(String node ,String browser){
	   //String node=map.get("node1");
	   BrowsersType bt=new BrowsersType();
	   switch(browser){
	   case"ff":
		   driver=bt.setFirefox(node);
		   break;
	   case"chrome":
		   driver=bt.setChrome(node);
		   break;
	   case"ie":
		   driver=bt.setIE(node);
		   break;
	   }
	 du=new Do(driver);
	 wait=new Wait(driver);		
   }
   
   @Test
   public void accessJD(){
	   driver.get("http://jingdong.com");
	   wait.waitForElemenEnable("//a[text()='µÇÂ¼']");
	   du.what("//a[text()='µÇÂ¼']").click();
   }
   
   @AfterClass
	public void releaseDriver(){
		driver.quit();
	}
}
