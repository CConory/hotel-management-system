package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import type.Room;
public class RoomDao {
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
	public ArrayList<Room> SelectAll(){
		ArrayList<Room> rooms=new ArrayList<Room>();
		try{
			Connect();
			String sql="select * from Room;";
			set=statement.executeQuery(sql);
			while(set.next()){
				Room room=new Room(set.getInt(1),set.getInt(2));
				rooms.add(room);
			}
			set.close();
			Close();
		}catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return rooms;
	}
	//»ñÈ¡Ä³Ò»Êý¾Ý
	public Room SelectOne(String RoomNo){
		Room room = null;
		try{
			Connect();
			String sql="select * from Room where RoomNo="+RoomNo+";";
			set=statement.executeQuery(sql);
			set.next();
			if(set==null)
				return null;
			room=new Room(set.getInt(1),set.getInt(2));
			set.close();
			Close();
		}catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return room;
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
