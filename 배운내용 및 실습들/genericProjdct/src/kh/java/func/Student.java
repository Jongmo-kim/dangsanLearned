package kh.java.func;
/*
 * 버전명의미
 * 맨앞 3 
 * ex  2->c언어로
 * 		3-> java로
 * major 변화 이럴땐 제일 앞 이바뀜
 * 3.2.1245
 * 
 * 2 는 버그 픽스
 * 45는 자잘한느낌
 * major는 3정도는되야 팔만한 소프트웨어
 * 
 */
public class Student {
	private String name;
	private int age;
	private String addr;
	
	public Student(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	public Student() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
