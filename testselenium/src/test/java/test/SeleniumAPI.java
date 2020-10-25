package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import com.google.common.base.Function;
import org.apache.commons.io.FileUtils;//
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SeleniumAPI {
//	this.testFirefox();
	
public static void main(String[] args) {
//    //ff
//    System.setProperty("webdriver.firefox.driver","C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
//    WebDriver driver =new FirefoxDriver();
//    driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
//    driver.get("http://baidu.com");
//    driver.findElement(By.id("kw")).sendKeys("loadrunner");
//    driver.quit();
//    Assert.assertEquals(1,1);
//    //ie
//    System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ "/libs/IEDriverServer.exe");
//    WebDriver driver = new InternetExplorerDriver();
//    driver.get("http://baidu.com");
    //chrome
    System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/libs/chromedriver.exe");
    System.setProperty("webdriver.chrome.bin", "chrome_dir");
    DesiredCapabilities caps = DesiredCapabilities.chrome();
    caps.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
    caps.setCapability("chrome.switches", Arrays.asList("--proxy-server-http://your-proxy-domain:4443"));
    ChromeDriver driver = new ChromeDriver();
    driver.get("http://www.baidu.com");
    //driver.manage().timeouts().implicitlyWait(arg0, arg1);
    driver.findElement(By.cssSelector("#login-fied span a:nth-child(1)")).click();
//js执行器
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
    //radio
    WebElement radio = driver.findElement(By.xpath("1212"));
    radio.click();
    radio.isSelected();
    //alert
    WebElement alert =driver.findElement(By.xpath("//alert"));
    alert.click();
    Alert temp=driver.switchTo().alert();
    //接受
    temp.accept();
    //取消
    temp.sendKeys("wo yaodianjile ");
    temp.dismiss();
    assertEquals("我点击取消", temp.getText());
//    iframe操作
    driver.switchTo().frame(driver.findElement(By.xpath("BAIDU")));
    driver.switchTo().defaultContent();//切换回html

}
    //window操作
    public void testiFrame(){
        WebDriver driver =new FirefoxDriver();
        driver.get("http://baidu.com");
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("222")));
        String parenthandle=driver.getWindowHandle();
        driver.findElement(By.name("name")).click();//新生成了标签页
        Set<String> allhandle=driver.getWindowHandles();
        Iterator<String> iter=allhandle.iterator();
        while(iter.hasNext()){
            String temp=iter.next();
            if(!temp.equals(parenthandle))//跳转到新标签页
                driver.switchTo().window(temp);
        }
    }
    public void testWait() {//都是其他类合并来的
        WebDriver driver =new FirefoxDriver();
        driver.get("http://baidu.com");
        WebDriverWait wait =new WebDriverWait(driver ,10,100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("//")));
        boolean bool = isPrecence(driver,10,10);
        boolean b= wait.until(ExpectedConditions.titleContains("hello"));
    }

    public boolean isPrecence(WebDriver driver ,long t,int timeoff ){
        boolean flag=true;
        WebDriverWait wait =new WebDriverWait( driver ,t,timeoff);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//xpath")));
        try {//匿名内部类
            wait.until(new ExpectedCondition<WebElement>() {
                @Override
                public  WebElement apply(WebDriver driver) {
                    return driver.findElement(By.id("1213"));
                }
            });
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
            flag=false;
        }
        return flag;
    }
    public boolean isDisplay(WebDriver driver ,long t){
        WebDriverWait wait =new WebDriverWait( driver ,t);
        boolean flag=true;
        try {
            //泛型
            flag= wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public  Boolean apply(WebDriver driver) {
                    return driver.findElement(By.id("1213")).isDisplayed();
                }
            });
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
            flag=false;
        }
        return flag;
    }
    public void fluentWait(){
        WebDriver driver =new FirefoxDriver();
        FluentWait<WebDriver> wait1=new FluentWait<WebDriver>(driver);
        wait1.pollingEvery(100,TimeUnit.MILLISECONDS).withTimeout(10, TimeUnit.SECONDS);
        WebElement e=wait1.until(new Function<WebDriver,WebElement>(){
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.className("222"));
            }
        });
    }

}
