package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
public class SeleniumAPI {
//	this.testFirefox();
	
public static void main(String[] args) {
//	System.setProperty("webdriver.firefox.driver","C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
//    WebDriver driver =new FirefoxDriver();
//    driver.manage().timeouts().pageLoadTimeout(5000,TimeUnit.SECONDS);
//    driver.get("http://baidu.com");
//    driver.findElement(By.id("kw")).sendKeys("loadrunner");
//    driver.quit();
//    assertEquals();
//	WebDriver driver =new FirefoxDriver();
	
//	String IEDriverServer = System.getProperty("user.dir")
//			+ "/libs/IEDriverServer.exe";
// System.setProperty("webdriver.ie.driver", IEDriverServer);
// WebDriver driver = new InternetExplorerDriver();
//	 driver.get("http://baidu.com");
	 
//	String chromedriver = System.getProperty("user.dir")
//			+ "/libs/chromedriver.exe";
//		System.setProperty("webdriver.chrome.driver",chromedriver);
//		System.setProperty("webdriver.chrome.bin", "chrome_dir");
//		caps=DesiredCapabilities.chrome();
//		caps.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
//		caps.setCapability("chrome.switches", Arrays.asList("--proxy-server-http://your-proxy-domain:4443"));
//		driver=new ChromeDriver();
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.baidu.com");
		//driver.manage().timeouts().implicitlyWait(arg0, arg1);
	 driver.findElement(By.cssSelector("#login-fied span a:nth-child(1)")).click();
	 
	 
	 JavascriptExecutor js =(JavascriptExecutor) driver;
	 WebElement username = (WebElement) js.executeScript("document.getElementById('zenggang')");
    username.clear();
    username.click();
    
    
    OutputStream out ;
    TakesScreenshot take =(TakesScreenshot) driver;
    File file = take.getScreenshotAs(OutputType.FILE);
    try {
		out=new FileOutputStream("D:/2seleniumtakescreenshot.jpg");
		FileUtils.copyFile(file, out);
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    Actions act=new Actions(driver);
    WebElement mess=driver.findElement(By.id("message"));
    act.doubleClick(mess).build().perform();
    //拖拽
    act.dragAndDrop(mess, mess).build().perform();
    //下拉框选择
    Select se = new Select(mess);
    List<WebElement> opt=se.getOptions();
    se.selectByIndex(0);
    Iterator<WebElement> iter=opt.iterator();
    while(iter.hasNext()){
    	iter.next().clear();
    }
    
    WebElement radio = driver.findElement(By.xpath("1212"));
    radio.click();
    radio.isSelected();
   
    
    
    
    
    
}

























}
