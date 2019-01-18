package com.csvdb;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class CSVRead {
	private String filepath;
	private String nextline[];
	List<String[]> approvalList=new ArrayList<String[]>();

	private CSVReader reader;
	private String value;
	public CSVRead(String filepath){
		this.filepath=filepath;
	}
	
	public String getTestData(String col,String line){
		try {
			reader=new CSVReader(new FileReader(filepath));
				while ((nextline=reader.readNext())!=null){
					approvalList.add(nextline);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获取列
		int count=0 , index=0;
		for(String j:approvalList.get(0)){
			count++;
			if(j.equals(col)){
				index=count-1;
			}
		}
		//获取行
		for(String[] i:approvalList){
			if(i[0].equals(line)){
				value=i[index].toString();
			}
		}
		
		return value;
		
	}
	public static void main(String[] args) {
		CSVRead a =new CSVRead(System.getProperty("user.dir")+"/src/com/csvdb/user.csv");
		for(int i=1;i<=3;i++){
			System.out.println(a.getTestData("username", "zeng")+","+a.getTestData("password", "guang"));
		}
	}
}


























