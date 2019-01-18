package pagebuildinterfacedata;

import org.openqa.selenium.WebDriver;

import com.properties.Do;

public class NewHomePage {
	private WebDriver driver;
	private Do du;
	
	public NewHomePage(WebDriver driver){
		this.driver=driver;
		du=new Do(driver);
	}
	public NewHomePage navigateTo(){
		driver.get("url");
		return this;
	}
	public void register(){
		du.what(HomeLoc.RR).click();
	}
}
