package kh.java.func;
/*
 * �������ǹ�
 * �Ǿ� 3 
 * ex  2->c����
 * 		3-> java��
 * major ��ȭ �̷��� ���� �� �̹ٲ�
 * 3.2.1245
 * 
 * 2 �� ���� �Ƚ�
 * 45�� �����Ѵ���
 * major�� 3�����µǾ� �ȸ��� ����Ʈ����
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
