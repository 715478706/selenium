package test;

import java.util.Iterator;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestiFrame {
	@Test
	public void testiFrame(){
WebDriver driver =new FirefoxDriver();
	    
		driver.get("http://baidu.com");
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("222")));
		
		String parenthandle=driver.getWindowHandle();
		driver.findElement(By.name("name")).click();
		
		Set<String> allhandle=driver.getWindowHandles();
		Iterator<String> iter=allhandle.iterator();
		
		while(iter.hasNext()){
		String temp=iter.next();
			if(!temp.equals(parenthandle))
				driver.switchTo().window(temp);
				
		}
		
		
	}

}

































