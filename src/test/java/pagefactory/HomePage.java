package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	@FindBy(xpath="//xpath")
	private WebElement reg;
	
	@FindBy(xpath="//xpath首页")
	private WebElement main;
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void register(){
		reg.click();
	}
	public void navigateToJD(String url){
		driver.get(url);
	}
	

}











