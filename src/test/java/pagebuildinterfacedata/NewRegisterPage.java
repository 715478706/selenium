package pagebuildinterfacedata;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.properties.Do;

public class NewRegisterPage {
	private Do du=null;
   private WebDriver driver;
   @FindBy(xpath="//input[@value=\"Google 搜索\" and ancestor::div[@class=\"FPdoLc VlcLAe\"]]")
   private WebElement usename;
  //密码框  两个
   @FindBys(@FindBy(xpath="//xpath | //xpath"))
   private List<WebElement> pw;
   
   @FindBy(xpath="//xpath")
   private WebElement regbt;
   
   @FindBy(xpath="//input[@value=\\\"Google 搜索\\\" and ancestor::div[@class=\\\"FPdoLc VlcLAe\\\"]]")
   private WebElement regaccount;
public NewRegisterPage(WebDriver driver) {
	this.driver = driver;
	//初始化FindBy
	PageFactory.initElements(driver, this);
}

public NewRegisterPage setUserId(String zhanghao){
	   this.usename.sendKeys(zhanghao );
	   return this;
	}
public NewRegisterPage setPassword(String mima ){
	for(WebElement pws:pw){
		  pws.sendKeys(mima );}
	return this;	
}

public void register(){
	regbt.click();
}
public WebElement getRegisterUser(){
	return regaccount;
	
}
public WebElement getElement(String wn,String userid){
	
	return du.what((String.format(wn, userid)));
  }
   
}














