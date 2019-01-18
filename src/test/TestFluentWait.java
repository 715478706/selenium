package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class TestFluentWait {
	public static void main(String[] args) {
		 WebDriver driver =new FirefoxDriver();
		 FluentWait<WebDriver> wait1=new FluentWait<WebDriver>(driver);
		   wait1.pollingEvery(100,TimeUnit.MILLISECONDS).withTimeout(10, TimeUnit.SECONDS);
		    WebElement e=wait1.until(new Function<WebDriver,WebElement>(){
				@Override
				public WebElement apply(WebDriver driver) {
					// TODO Auto-generated method stub
					return driver.findElement(By.className("222"));
				}
		    });
	   }

	public void testDriver(){
	WebDriver driver =new FirefoxDriver();
	FluentWait<WebDriver> wait1=new FluentWait<WebDriver>(driver);
	  wait1.pollingEvery(100,TimeUnit.MILLISECONDS).withTimeout(10, TimeUnit.SECONDS);
	   WebElement e=wait1.until(new Function<WebDriver,WebElement>(){
			@Override
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return driver.findElement(By.className("222"));
			}
	   });
	}
}

















