package kh.member.model.vo;

import java.sql.Date;

public class Member {
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private int age;
	private char gender;
	private String phone;
	private Date enrollDate;
	public Member(int memberNo, String memberId, String memberPw, String memberName, int age, char gender, String phone,
			Date enrollDate) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.enrollDate = enrollDate;
	}
	public void printMember() {
		Member e = this;
		System.out.println("번호\t아이디\t비밀번호\t이름\t성별\t전화번호\t가입일자");
		System.out.printf("%s", e.getMemberNo());
		System.out.printf("\t%s", e.getMemberId());
		System.out.printf("\t%s", e.getMemberPw());
		System.out.printf("\t%s", e.getMemberName());
		System.out.printf("\t%s", e.getPhone());
		System.out.printf("\t%c", e.getGender());
		System.out.printf("\t%s", e.getEnrollDate());
		System.out.println();
	}
	public Member() {

	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
}
