package type;

public class Employee {
	int EmployeeNo;
	int DeptNo;
	String EmployeeName;
	String ID;
	String Sex;
	String Birth;
	String Tel;
	String Address;
	String Job;
	String EmployeeDate;
	int Sal;
	String PassWord;
	String Remark;
	public Employee(int p1,int p2,String p3,String p4,String p5,String p6,String p7,String p8,String p9,String p10,int p11,String p12,String p13){
		EmployeeNo=p1;
		DeptNo=p2;
		EmployeeName=p3;
		ID=p4;
		Sex=p5;
		Birth=p6;
		Tel=p7;
		Address=p8;
		Job=p9;
		EmployeeDate=p10;
		Sal=p11;
		PassWord=p13;
		Remark=p12;
	}
	public int getEmployeeNo() {
		return EmployeeNo;
	}
	public void setEmployeeNo(int employeeNo) {
		EmployeeNo = employeeNo;
	}
	public int getDeptNo() {
		return DeptNo;
	}
	public void setDeptNo(int deptNo) {
		DeptNo = deptNo;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
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
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}
	public String getEmployeeDate() {
		return EmployeeDate;
	}
	public void setEmployeeDate(String employeeDate) {
		EmployeeDate = employeeDate;
	}
	public int getSal() {
		return Sal;
	}
	public void setSal(int sal) {
		Sal = sal;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
}
