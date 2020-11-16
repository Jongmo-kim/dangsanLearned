package kh.java.model.vo;

public class Student {
	private String name;
	private int age;
	private String addr;
	
	Student(String name,int age, String addr){
		this.name = name;
		this.age = age;
		this.addr= addr;
	}
	public Student(){
		name = new String();
		addr = new String();
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
	public void setStudent(String name,int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
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
	public void showStudent() {
		System.out.printf("%s\t%d\t\t%s\t",name,age,addr);
	}
}
