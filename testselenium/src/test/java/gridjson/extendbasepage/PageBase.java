package gridjson.extendbasepage;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import csvdb.DBOp;
import properties.Do;

public class PageBase {
	private WebDriver driver;
	private Do du;
	private DBOp db;
	private Map<String ,String > sf =new HashMap();
	public PageBase(WebDriver driver,String tablename ){
		this.driver=driver;
		du=new Do(driver);
		
		db=new DBOp(tablename);
		db.conn(System.getProperty("user.dir")+"/src/test.BaiduDB.sqlite");
	}
	//通过元素名字找元素
	public WebElement getLoc(String loc){
		WebElement we=null;
		if (db.getLocatorXpath(loc)!=null&&!db.getLocatorXpath(loc).equals("")){
			try {
				we=du.what(db.getLocatorXpath(loc));
			} catch (Exception e) {
				if(db.getLocatorCSS(loc)!=null){
					we=du.whatCSS(db.getLocatorXpath(loc));}
			}
		}else{
			we=du.whatCSS(db.getLocatorXpath(loc));
		}
		return we;
	}
	//通过名字找对应的xpath，CSS的值
	public String getLocValue(String loc){
//		return db.getLocatorXpath(loc);
		
		sf.clear();
		if(db.getLocatorXpath(loc)!=null){
			sf.put(loc, db.getLocatorXpath(loc));
		}else{sf.put(loc, db.getLocatorCSS(loc));}
		return sf.get(loc);
	}
}


































