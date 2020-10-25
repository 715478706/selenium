package properties;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Switch {
	private WebDriver driver;
	private String currentwindow;
	
	public Switch(WebDriver driver){
		this.driver=driver;
		currentwindow=driver.getWindowHandle();
		//PageFactory.initElements(driver, this);
	}
	public void toWindow(String  partialtitlename ){
		Set<String> handles=driver.getWindowHandles();
		String titlename = null;
		for(String allhandle:handles){
			titlename=driver.switchTo().window(allhandle).getTitle();
			if(titlename.contains(partialtitlename)){
				break;
			}
		}
	}
	
	public void backToCurrentWindow(){
		driver.switchTo().window(currentwindow);
	}

}











