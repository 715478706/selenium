package test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestFF {
	public static void main(String[] args) {
		WebDriver driver =new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		
		driver.manage().window().maximize();;
		driver.get("http://baidu.com");
		
		driver.navigate().back();
		driver.navigate().forward();
		
		List<WebElement> list =driver.findElements(By.xpath("//"));
		for(WebElement l:list){
			l.clear();
		}
		
		
		Iterator<WebElement> iter=list.iterator();
		while (iter.hasNext()){
			iter.next().click();
		}
	}
	

}
