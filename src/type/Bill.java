package type;

public class Bill {
	int BillNo;
	int EmployeeNo;
	int ClientNo;
	int RoomCost;
	int OtherCost;
	public Bill(int p1,int p2,int p3,int p4,int p5){
		BillNo=p1;
		EmployeeNo=p2;
		ClientNo=p3;
		RoomCost=p4;
		OtherCost=p5;
	}
	public int getBillNo() {
		return BillNo;
	}
	public void setBillNo(int billNo) {
		BillNo = billNo;
	}
	public int getEmployeeNo() {
		return EmployeeNo;
	}
	public void setEmployeeNo(int employeeNo) {
		EmployeeNo = employeeNo;
	}
	public int getClientNo() {
		return ClientNo;
	}
	public void setClientNo(int clientNo) {
		ClientNo = clientNo;
	}
	public int getRoomCost() {
		return RoomCost;
	}
	public void setRoomCost(int roomCost) {
		RoomCost = roomCost;
	}
	public int getOtherCost() {
		return OtherCost;
	}
	public void setOtherCost(int otherCost) {
		OtherCost = otherCost;
	}
}
