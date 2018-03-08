package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import type.Department;
public class DepartmentDao {
	Connection conn = null;
	Statement statement = null;
	ResultSet set = null;
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/my_database";
	String user = "root";
	String password = "123456";
	
	// Á¬½ÓÊý¾Ý¿â
	private void Connect() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url,user,password);
		if(!conn.isClosed())
			System.out.println("Êý¾Ý¿âÁ´½Ó³É¹¦£¡");
		statement=conn.createStatement();
	}
	// ¶Ï¿ªÁ¬½Ó
	private void Close() throws SQLException {
		statement.close();
		conn.close();
	}
	
	//»ñÈ¡ËùÓÐÊý¾Ý
	public ArrayList<Department> SelectAll(){
		ArrayList<Department> departments=new ArrayList<Department>();
		try{
			Connect();
			String sql="select * from Department;";
			set=statement.executeQuery(sql);
			while(set.next()){
				Department department=new Department(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getInt(5));
				departments.add(department);
			}
			set.close();
			Close();
		}catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return departments;
	}
	//»ñÈ¡Ä³Ò»¼äÊý¾Ý
	public Department selectOne(String DeptNo){
		Department department = null;
		try{
			Connect();
			String sql="select * from Department where DeptkNo="+DeptNo+";";
			set=statement.executeQuery(sql);
			set.next();
			if(set==null)
				return null;
			department=new Department(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getInt(5));
			set.close();
			Close();
		}catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return department;
	}
}
