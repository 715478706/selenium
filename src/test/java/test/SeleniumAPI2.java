package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class SeleniumAPI2 {
    public static void main(String[] args) {
    	 WebDriver driver =new FirefoxDriver();
    	 driver.get("http://baidu.com");
    	 WebDriverWait wait =new WebDriverWait(driver ,10,100);
    	 List<WebElement> list=(List<WebElement>)
    	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("//")));
    	 //this.isPrecence(driver,10,true);
    boolean b=	 wait.until(ExpectedConditions.titleContains("hello"));
    //匿名内部类
    wait.until(new ExpectedCondition<WebElement>() {
		@Override
		public WebElement apply(WebDriver driver ) {
			return driver.findElement(By.id("1213"));
		}
	} );
    }
    public boolean isPrecence(WebDriver driver ,long t,int timeoff ){
    	boolean flag=true;
    	WebDriverWait wait =new WebDriverWait( driver ,t,timeoff);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//xpath")));
    	try {
			wait.until(new ExpectedCondition<WebElement>() {
				@Override
				public  WebElement apply(WebDriver driver) {
					return driver.findElement(By.id("1213"));//.isDisplayed();
				}
			});
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			flag=false;
		}
    	
    	return flag;
    }
    boolean isDis(WebDriver driver ,long t){
    WebDriverWait wait =new WebDriverWait( driver ,t);
    boolean b=true;
       try {
    	   //泛型
		b= wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public  Boolean apply(WebDriver driver) {
				return driver.findElement(By.id("1213")).isDisplayed();
			}
		});
		b=true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		b=false;
	}
       return b;
  
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    }
    
}
