package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAlert {
	@Test
	public void test(){
		WebDriver driver =new FirefoxDriver();
	    
		driver.get("http://baidu.com");
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("222")));
		
		WebElement alert =driver.findElement(By.xpath("//"));
		alert.click();
		Alert temp=driver.switchTo().alert();
		//接受
		//temp.accept();
		
		//取消
		temp.sendKeys("wo yaodianjile ");
		temp.dismiss();
		assertEquals("我点击取消", temp.getText()	);	
		
	}

}
