package gridjson;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;

public class MutipleTasks {
   private String seleniumserverstandalone;
   private String hubjson;
   private String projectpath;
   private String starthub;
   
   private String startnode1chrome;
   private String startnode2ff; 
   
   private String chromedriverpath;
   private String ffdriverpath;
   @BeforeSuite
   public void beforesuite(){
	   projectpath=System.getProperty("user.dir");
	   seleniumserverstandalone=projectpath+"/tool/selenium-server-standalone-2.40.0.jar";
	   hubjson=projectpath+"\\src\\gridjson\\hub.json";
	   starthub=projectpath+"\\src\\gridjson\\starthub.bat";
	   
	   startnode1chrome=projectpath+"\\src\\gridjson\\startnode1chrome.bat";
	   startnode2ff=projectpath+"\\src\\gridjson\\startnode2ff.bat";
	   
	   chromedriverpath="E:\\Users\\Administrator\\workspace\\selenium\\tool\\chromedriver.exe";
	   ffdriverpath="C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
	   try {
		Runtime.getRuntime().exec("cmd /c start "+starthub+" "+seleniumserverstandalone+" "+hubjson);
		Thread.sleep(5000);
		Runtime.getRuntime().exec("cmd /c start "+startnode1chrome+" "+seleniumserverstandalone+" "+chromedriverpath);
		Thread.sleep(5000);
		Runtime.getRuntime().exec("cmd /c start "+startnode2ff+" "+seleniumserverstandalone+" "+ffdriverpath);
		Thread.sleep(5000);
	} catch (Exception e) {
		e.printStackTrace();
	}
   }
}
