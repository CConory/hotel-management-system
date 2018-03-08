package type;

public class Client {
	String ClientNo;
	String ClientName;
	String Sex;
	String Birth;
	String ID;
	String Tel;
	String Remark;
	public Client(String p1,String p2,String p3,String p4,String p5,String p6,String p7){
		ClientNo=p1;
		ClientName=p2;
		Sex=p3;
		Birth=p4;
		ID=p5;
		Tel=p6;
		Remark=p7;
	}
	public String getClientNo() {
		return ClientNo;
	}
	public void setClientNo(String clientNo) {
		ClientNo = clientNo;
	}
	public String getClientName() {
		return ClientName;
	}
	public void setClientName(String clientName) {
		ClientName = clientName;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getBirth() {
		return Birth;
	}
	public void setBirth(String birth) {
		Birth = birth;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}

}
