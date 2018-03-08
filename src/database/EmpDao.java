package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import type.Cipher;
import type.Employee;
public class EmpDao {
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
	public ArrayList<Employee> SelectAll(){
		ArrayList<Employee> emps=new ArrayList<Employee>();
		try{
			Connect();
			String sql="select * from Employee;";
			set=statement.executeQuery(sql);
			while(set.next()){
				String pass=set.getString(13);
				Cipher cipher=new Cipher();
				pass=cipher.Decode(pass);
				
				Employee emp=new Employee(set.getInt(1),set.getInt(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),
						set.getString(7),set.getString(8),set.getString(9),set.getString(10),set.getInt(11),set.getString(12),pass);
				emps.add(emp);
			}
			set.close();
			Close();
		}catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return emps;
	}
	//»ñÈ¡Ä³Ò»Êý¾Ý
	public Employee selectOne(String EmployeeNo){
		Employee emp = null;
		try{
			Connect();
			String sql="select * from Employee where EmployeeNo="+EmployeeNo+";";
			set=statement.executeQuery(sql);
			set.next();
			if(set==null)
				return null;

			String pass=set.getString(13);
			Cipher cipher=new Cipher();
			pass=cipher.Decode(pass);
			emp=new Employee(set.getInt(1),set.getInt(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),
						set.getString(7),set.getString(8),set.getString(9),set.getString(10),set.getInt(11),set.getString(12),pass);
			set.close();
			Close();
		}catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return emp;
	}
	//
	public boolean Change(String sql){
		try {
			Connect();
			statement.executeUpdate(sql);		
			System.out.println("¸Ä±ä³É¹¦");
			statement.close();
			conn.close();
			return true;
		}catch(ClassNotFoundException e) {   
             //Êý¾Ý¿âÇý¶¯ÀàÒì³£´¦Àí
             System.out.println("Sorry,can`t find the Driver!");   
             e.printStackTrace();   
        } catch(SQLException e) {
             //Êý¾Ý¿âÁ¬½ÓÊ§°ÜÒì³£´¦Àí
             e.printStackTrace();  
        }catch (Exception e) {
             // TODO: handle exception
             e.printStackTrace();
        }
		return false;	
	}
	
	// ÅÐ¶ÏµÇÂ¼ÊÇ·ñÕýÈ·
	public boolean CheckLoad(String Empnum,String Pass) {
		try {
			Connect();		
			String string= "select * from Employee where EmployeeNo="+Empnum+";";
			set = statement.executeQuery(string);
			set.next();	
			String password=set.getString("PassWord");
			Cipher cipher=new Cipher();
			password=cipher.Decode(password);
			
			if(password.equals(Pass)) {
				Close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// ²éÕÒÔ±¹¤È¨ÏÞ
	public boolean CheckLimit(String Empnum) {
		try {
			Connect();
			String string= "select * from Employee where EmployeeNo="+Empnum+";";
			set = statement.executeQuery(string);
			set.next();			
			if(set.getString("DeptNo").equals("0")) {
				Close();
				return true;
			}
		} catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return false;
	}
	
	// ÅÐ¶Ï¿É·ñÐÞ¸ÄÃÜÂë£¬ÐÞ¸ÄÃÜÂë
	public boolean ModifyPass(String name,String Empnum,String IDCard,String Pass) {
		try {
			Connect();			
			String string= "select * from Employee where EmployeeNo="+Empnum+";";
			set = statement.executeQuery(string);
			set.next();			
			if(set.getString("EmployeeName").equals(name) && set.getString("ID").equals(IDCard)) {
				Cipher cipher=new Cipher();
				Pass=cipher.Encrypt(Pass);
				
				string = "update employee set PassWord='"+Pass+"' where EmployeeNo="+Empnum+";";
				statement.executeUpdate(string);
				Close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
