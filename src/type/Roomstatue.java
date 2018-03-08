package type;

public class Roomstatue {
	int RoomNo;
	String CheckInDate;
	String CheckOutDate;
	public Roomstatue(int Room,String Date1,String Date2){
		this.RoomNo=Room;
		CheckInDate=Date1;
		CheckOutDate=Date2;
	}
	public int getRoom() {
		return RoomNo;
	}
	public void setRoom(int room) {
		RoomNo = room;
	}
	public String getCheckInDate() {
		return CheckInDate;
	}
	public void setCheckInDate(String checkInDate) {
		CheckInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return CheckOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		CheckOutDate = checkOutDate;
	}

}
