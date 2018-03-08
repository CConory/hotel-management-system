package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import type.RoomBook;
public class RoomBookDao {
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
	public ArrayList<RoomBook> SelectAll(){
		ArrayList<RoomBook> descs=new ArrayList<RoomBook>();
		try{
			Connect();
			String sql="select * from RoomBook;";
			set=statement.executeQuery(sql);
			while(set.next()){
				RoomBook desc=new RoomBook(set.getInt(1),set.getInt(2));
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
	//¸ù¾ÝBookNo»ñÈ¡RoomNo¼äÊý¾Ý
	public ArrayList<RoomBook> SelectRoomNo(String BookNo){
		ArrayList<RoomBook> descs=new ArrayList<RoomBook>();
		try{
			Connect();
			String sql="select * from RoomBook where BookNo="+BookNo+";";
			set=statement.executeQuery(sql);
			while(set.next()){
				RoomBook desc=new RoomBook(set.getInt(1),set.getInt(2));
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
}
