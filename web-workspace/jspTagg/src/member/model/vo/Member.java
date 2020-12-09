package member.model.vo;

public class Member {
	private String name;
	private int age;
	private String addr;
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
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public Member() {
		super();
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	public String getTest() {
		return "Member [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
}
