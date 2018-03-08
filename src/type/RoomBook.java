package type;

public class RoomBook {
	int RoomNo;
	int BookNo;
	public RoomBook(int p1,int p2){
		RoomNo=p1;
		BookNo=p2;
	}
	public int getRoomNo() {
		return RoomNo;
	}
	public void setRoomNo(int roomNo) {
		RoomNo = roomNo;
	}
	public int getBookNo() {
		return BookNo;
	}
	public void setBookNo(int bookNo) {
		BookNo = bookNo;
	}

}
