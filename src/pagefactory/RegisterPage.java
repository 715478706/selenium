package pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
   private WebDriver driver;
   @FindBy(xpath="//xpath")
   private WebElement usename;
  //密码框  两个
   @FindBys(@FindBy(xpath="//xpath | //xpath"))
   private List<WebElement> pw;
   
   @FindBy(xpath="//xpath")
   private WebElement regbt;
   
   @FindBy(xpath="//xpath")
   private WebElement regaccount;
public RegisterPage(WebDriver driver) {
	this.driver = driver;
	//初始化FindBy
	PageFactory.initElements(driver, this);
}

public void setUserId(String zhanghao){
	   this.usename.sendKeys(zhanghao );
	}
public void setPassword(String mima ){
	for(WebElement pws:pw){
		   pws.sendKeys(mima );}
	}
public void register(){
	regbt.click();
}
public WebElement getRegisterUser(){
	return regaccount;
	
}
   
}














