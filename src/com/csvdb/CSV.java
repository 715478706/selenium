package com.csvdb;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class CSV {
	private String filepath;
	private String nextline[];
	List<String[]> approvalList=new ArrayList<String[]>();

	private CSVReader reader;
	private String value;
	
	String[] s={"a","b"};
	
	public CSV(String filepath){
		this.filepath=filepath;
	}
	public String getTestData(String line,String col){
			try {
				reader=new CSVReader(new FileReader(filepath));
				approvalList=	reader.readAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			for(int i=0;i<approvalList.get(0).length;i++){
				if(approvalList.get(0)[i].equals(col)){
					System.out.println(i);
					for(int j=1;j<approvalList.size();j++){
						if(approvalList.get(j)[0].equals(line)){
							System.out.println(j);
							value=approvalList.get(j)[i];
							break;
						}
					}
				}
			}
			
			return value;
	}
	public static void main(String[] args) {
		CSV csv=new CSV(System.getProperty("user.dir")+"/src/com/csvdb/user.csv");
	    
	    System.out.println(csv.getTestData("zeng", "password"));
	}
}
















