package csvdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBOp {
	private Statement stat=null;
	private ResultSet rsq=null;
	private String tablename;
	List<String> list;
	//private String sql="select * from "+tablename+"where WebElement="+locatorname+";";
	public DBOp(String tablename){
		this.tablename=tablename;
	}
	public void conn(String databasepath){

		try {
			Class.forName("org.sqlite.JDBC");//注册驱动
			Connection conn =DriverManager.getConnection(databasepath);
			stat=conn.createStatement();
		} catch (SQLException  e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void conn(){
		try {
			Class.forName("org.sqlite.JDBC");//注册驱动
			Connection conn =DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("user.dir")+
					"/testselenium/src/test/java/csvdb/Mail126Page.sqlite");
			stat=conn.createStatement();
		} catch (SQLException  e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//  返回集合
	public List<String> getLocatorXpath(){
		//String xpath=null;
		list=new ArrayList<String>();
		String sql="select * from mailpage ;";
		//"select * from "+tablename+"where guang='"+locatorname+"';";
		try {
			rsq=stat.executeQuery(sql);
			while(rsq.next()){
				String xpath=rsq.getString("username");
				list.add(xpath);
			}
			rsq.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
	public String getLocatorXpath(String locatorname){
		String xpath=null;
		String sql="select * from "+tablename+"where username='"+locatorname+"';";
		try {
			rsq=stat.executeQuery(sql);
			while(rsq.next()){
				xpath=rsq.getString("xpath");
			}
			rsq.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return xpath;

	}

	public String getLocatorCSS(String locatorname){
		String css=null;
		String sql="select * from "+tablename+"where username='"+locatorname+"';";
		try {
			rsq=stat.executeQuery(sql);
			while(rsq.next()){
				css=rsq.getString("password");
			}
			rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return css;

	}

	public static void main(String[] args) {
		DBOp test=new DBOp("mailpage");
		test.conn();
		System.out.println(test.getLocatorXpath());
		for(String str : test.getLocatorXpath()) {
			System.out.println(str);
		}

	}
}






























