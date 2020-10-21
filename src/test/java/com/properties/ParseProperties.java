package com.properties;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ParseProperties {
	private Properties pro=new Properties();
    String value=null;
    
    public ParseProperties(String propertiespath){
    	this.loadProperties(propertiespath);
    }
    
    public void loadProperties(String propertiespath){
    	try {
			InputStream in =new FileInputStream(propertiespath);
//			InputStreamReader inr=new InputStreamReader(in);
//			BufferedReader br=new BufferedReader(inr);
			pro.load(in);//上传到properties对象
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public String getValue(String keyname) {
    	value=pro.getProperty(keyname).trim();
    	try {
			value=new String(value.getBytes("UTF-8"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return value;
    }
    public static void main(String[] args){
    	ParseProperties a=new ParseProperties(System.getProperty("user.dir")+"\\src\\com\\properties\\test.properties");
    	System.out.println(a.getValue("url"));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
