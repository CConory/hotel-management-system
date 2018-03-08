package type;

public class Department {
	int DeptNo;
	String DeptName;
	String Tel;
	String Loc;
	int ManagerNo;
	public Department(int p1,String p2,String p3,String p4,int p5){
		DeptNo=p1;
		DeptName=p2;
		Tel=p3;
		Loc=p4;
		ManagerNo=p5;
	}
	public int getDeptNo() {
		return DeptNo;
	}
	public void setDeptNo(int deptNo) {
		DeptNo = deptNo;
	}
	public String getDeptName() {
		return DeptName;
	}
	public void setDeptName(String deptName) {
		DeptName = deptName;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getLoc() {
		return Loc;
	}
	public void setLoc(String loc) {
		Loc = loc;
	}
	public int getManagerNo() {
		return ManagerNo;
	}
	public void setManagerNo(int managerNo) {
		ManagerNo = managerNo;
	}
}
