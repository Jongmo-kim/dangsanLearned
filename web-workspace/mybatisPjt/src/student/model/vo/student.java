package student.model.vo;

public class student {
	private int studentNo;
	private String studentName;
	private String studentPhone;
	private String email;
	private String addr;
	public int getStudentNo() {
		return studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public String getStudentPhone() {
		return studentPhone;
	}
	public String getEmail() {
		return email;
	}
	public String getAddr() {
		return addr;
	}
	
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "studen [studentNo=" + studentNo + ", studentName=" + studentName + ", studentPhone=" + studentPhone
				+ ", email=" + email + ", addr=" + addr + "]";
	}
	public student(int studentNo, String studentName, String studentPhone, String email, String addr) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentPhone = studentPhone;
		this.email = email;
		this.addr = addr;
	}
	public student() {
		super();
	}
	
}
