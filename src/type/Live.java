package type;

public class Live {
	int RoomNO;
	String name;
	String date;
	String ID;
	
	public Live(int roomNO, String iD, String date, String name) {
		RoomNO = roomNO;
		this.name = name;
		this.date = date;
		ID = iD;
	}
	public int getRoomNO() {
		return RoomNO;
	}
	public void setRoomNO(int roomNO) {
		RoomNO = roomNO;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	
}
