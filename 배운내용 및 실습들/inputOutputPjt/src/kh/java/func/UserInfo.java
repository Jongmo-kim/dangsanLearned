package kh.java.func;

import java.io.Serializable;

public class UserInfo implements Serializable{
	static final long serialVersionUID = 1111111L;
	private String name;
	private transient int age; //transient 직렬화 제외
	private String addr;
	private Score score;
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
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
	public UserInfo(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public UserInfo() {
		super();
	}
	
}
