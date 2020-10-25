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
   private String nodejson;
   @BeforeSuite
   public void beforesuite(){
	   projectpath=System.getProperty("user.dir");
	   seleniumserverstandalone=projectpath+"/tool/selenium-server-standalone-2.40.0.jar";
	   hubjson=projectpath+"\\src\\gridjson\\hub.json";
	   starthub=projectpath+"\\src\\gridjson\\starthub.bat";
	   nodejson = projectpath+"\\src\\gridjson\\node.json";
	   startnode1chrome=projectpath+"\\src\\gridjson\\startnode1chrome.bat";
	   chromedriverpath="E:\\Users\\Administrator\\workspace\\selenium\\tool\\chromedriver.exe";
	   startnode2ff=projectpath+"\\src\\gridjson\\startnode2ff.bat";
	   ffdriverpath="C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
	   try {
		Runtime.getRuntime().exec("cmd /c start "+starthub+" "+seleniumserverstandalone+" "+hubjson);
		Thread.sleep(5000);
		Runtime.getRuntime().exec("cmd /c start "+startnode1chrome+" "+seleniumserverstandalone+" "+nodejson+" "+chromedriverpath);
		Thread.sleep(5000);
//		java -jar %1 -role node -Dwebdriver.firefox.driver=%3 -nodeConfig %2
//		Runtime.getRuntime().exec("cmd /c start "+startnode2ff+" "+seleniumserverstandalone+" "+nodejson+" "+ffdriverpath);
		Runtime.getRuntime().exec(String.format("cmd /c start %1$s %2$s %3$s %4$s", startnode2ff,seleniumserverstandalone,nodejson,ffdriverpath));
		Thread.sleep(5000);
	} catch (Exception e) {
		e.printStackTrace();
	}
   }
}
