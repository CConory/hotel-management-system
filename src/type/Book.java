package type;

public class Book {
	int BookNo;
	String ClientNo;
	String CheckInDate;
	String CheckOutDate;
	String PayStatus;
	int Pay;
	String Remark;
	public Book(int p1,String p2,String p3,String p4,String p5,int p6,String p7){
		BookNo=p1;
		ClientNo=p2;
		CheckInDate=p3;
		CheckOutDate=p4;
		PayStatus=p5;
		Pay=p6;
		Remark=p7;
	}
	public int getBookNo() {
		return BookNo;
	}
	public void setBookNo(int bookNo) {
		BookNo = bookNo;
	}
	public String getClientNo() {
		return ClientNo;
	}
	public void setClientNo(String clientNo) {
		ClientNo = clientNo;
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
	public String getPayStatus() {
		return PayStatus;
	}
	public void setPayStatus(String payStatus) {
		PayStatus = payStatus;
	}
	public int getPay() {
		return Pay;
	}
	public void setPay(int pay) {
		Pay = pay;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
}
