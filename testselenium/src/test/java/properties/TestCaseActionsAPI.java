package properties;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import csvdb.wait.Wait;

import launch.Browsers;
import launch.BrowsersType;

public class TestCaseActionsAPI implements Locators{


	public WebDriver driver=null;
	public Browsers browser=null;
	public BrowsersType bt=null;
	public Wait wait=null;
	public ParseProperties locator=null;

	@Parameters({"i"})
	@BeforeClass
	public void start(int i){
		if(i==1){
			bt=BrowsersType.firefox;
		}else if(i!=1){
			System.out.println("!1");
		}
		Browsers browser=new Browsers(bt);
		driver=browser.driver;
		wait=new Wait(driver);
	}
	@Test
	public void changeiFrame(){
		driver.get("http://baidu.com");
		wait.waitForElemenPresent(Locators.BAIDU);
		driver.switchTo().frame(driver.findElement(By.xpath(BAIDU)));
//		driver.switchTo().defaultContent();//切换回html
		Point initialPoint= ((WebElement) driver.findElements(By.xpath(BAIDU))).getLocation();
		System.out.println(initialPoint);
		//sendKeys(),click() getLocation(),getTest() size()
		Actions dragger=new Actions(driver);
		dragger.dragAndDropBy(driver.findElement(By.xpath(BAIDU)),initialPoint.getX()+500,initialPoint.getY()).build().perform();
//		dragger.doubleClick().build().perform();
		initialPoint=driver.findElement(By.xpath(BAIDU)).getLocation();
		System.out.println(initialPoint);
		wait.waitThread(1000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath(BAIDU)).clear();
		wait.waitThread(5000);
	}
	@Test
	public void selectItem() throws InterruptedException{
		Select sheng =new Select(driver.findElement(By.xpath("//select[@]")));
		sheng.selectByVisibleText("shanghai");
//		sheng.deselectByValue("@value");//使用属性value
		Thread.sleep(1000);

		Select city=new Select(driver.findElement(By.xpath("//select[@]")));
		List<WebElement> allcity=city.getAllSelectedOptions();
		for(WebElement eachcity:allcity)
			System.out.println(eachcity.getText());
	}

	@Test
	public void changeWindows(){
		Switch s=new Switch(driver);
		s.toWindow("sousuojiemian");
//		s.toWindow(partialtitlename);
		driver.findElement(By.xpath("//input[@class='sousuo']")).sendKeys("eclipse");

		//跳回去
		s.toWindow("Google");
		driver.findElement(By.xpath("//in")).sendKeys("台湾");
	}

	@Test
	//rightClick
	public void rightClick(){
		Actions a=new Actions(driver);
		a.contextClick(driver.findElement(By.xpath("//xpath"))).build().perform();;
	}

	@Test//滚动条的操作
	public void dragAndDrop() {
		driver.get("http://baidu.com");
		Point shanghai =driver.findElement(By.xpath("//xpath")).getLocation();
		System.out.println(shanghai);
		((JavascriptExecutor) driver).executeScript("window.scrollBy("+shanghai.getX(), shanghai.getY()+")");
		wait.waitThread(100);
	}

	@AfterClass
	public void reslse(){
		driver.quit();
	}
}



















