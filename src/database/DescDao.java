package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import type.Desc;
public class DescDao {
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
	public ArrayList<Desc> SelectAll(){
		ArrayList<Desc> descs=new ArrayList<Desc>();
		try{
			Connect();
			String sql="select * from Description;";
			set=statement.executeQuery(sql);
			while(set.next()){
				Desc desc=new Desc(set.getInt(1),set.getString(2),set.getInt(3),set.getInt(4));
				descs.add(desc);
			}
			set.close();
			Close();
		}catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return descs;
	}
	
	//»ñÈ¡ËùÓÐÊý¾Ý
	public ArrayList<Integer> GetPrice(){
		ArrayList<Integer> price=new ArrayList<Integer>();
		try{
			Connect();
			String sql="select price from Description;";
			set=statement.executeQuery(sql);
			while(set.next())
				price.add(set.getInt("price"));
			set.close();
			Close();
		}catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return price;
	}

	//»ñÈ¡Ä³Ò»¼äÊý¾Ý
	public Desc selectOne(String typeNo){
		Desc desc = null;
		try{
			Connect();
			String sql="select * from Description where TypeNo="+typeNo+";";
			set=statement.executeQuery(sql);
			set.next();
			if(set==null)
				return null;
			desc=new Desc(set.getInt(1),set.getString(2),set.getInt(3),set.getInt(4));
			set.close();
			Close();
		}catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return desc;
	}
	
	// ¸üÐÂ»òÌí¼Ó
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
}
