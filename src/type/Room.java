package type;

public class Room {
	int RoomNo;
	int TypeNo;
	
	public Room(int RoomNo,int TypeNo){
		this.RoomNo=RoomNo;
		this.TypeNo=TypeNo;
	}
	public int getRoomNo() {
		return RoomNo;
	}
	public void setRoomNo(int roomNo) {
		RoomNo = roomNo;
	}
	public int getTypeNo() {
		return TypeNo;
	}
	public void setTypeNo(int typeNo) {
		TypeNo = typeNo;
	}
}
