package kh.java.func;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class SerialTest {
	UserInfo user;
	Scanner sc;

	public SerialTest() {
		super();
		sc = new Scanner(System.in);
		user = new UserInfo("default", 0, "default");
		Score score = new Score(50,50,50);
		user.setScore(score);
	}

	public void main() {
		while (true) {
			System.out.println("1. ���� ���� �Է� �� ��������");
			System.out.println("2. ���� ���� �о� ����");
			System.out.println("3. ���� ���� ���� ���");
			System.out.print("���� > ");
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				outputUser();
				break;
			case 2:
				inputUser();
				break;
			case 3:
				readUser();
				break;
			default:
				break;
			}

		}
	}

	public void outputUser() {
		System.out.print("���� �̸� �Է�");
		String name = sc.next();
		System.out.print("���� ���� �Է�");
		int age = sc.nextInt();
		System.out.print("���� �ּ� �Է�");
		String addr = sc.next();
		System.out.print("�������� �Է�");
		int kor = sc.nextInt();
		System.out.print("�������� �Է�");
		int eng = sc.nextInt();
		System.out.print("�������� �Է�");
		int math = sc.nextInt();
		UserInfo u = new UserInfo(name, age, addr);
		u.setScore(new Score(kor,eng,math));
		ObjectOutputStream oos = null;
		FileOutputStream fos = methodFileOutputStream();
		oos =methodObjectOutputStream(fos);
		oosWriteObject(oos,u);
		System.out.println("����Ϸ�");
	}
	public void inputUser() {
		FileInputStream fis = methodFileInputStream();
		ObjectInputStream ois = methodObjectInputStream(fis);
		this.user = (UserInfo)objectInputStreamReadObject(ois);
		System.out.println("�ҷ����� �Ϸ�");
	}
	public void readUser() {
		System.out.printf("�̸�: %s\n",user.getName());
		System.out.printf("����: %d\n",user.getAge());
		System.out.printf("�ּ�: %s\n",user.getAddr());
		System.out.printf("��������: %d\n",user.getScore().getKor());
		System.out.printf("��������: %d\n",user.getScore().getEng());
		System.out.printf("��������: %d\n",user.getScore().getMath());
		
	}
	public Object objectInputStreamReadObject(ObjectInputStream ois) {
		Object r = null;
		try {
			 r = ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	public void oosWriteObject(ObjectOutputStream oos,Object u) {
		try {
			oos.writeObject(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ObjectOutputStream methodObjectOutputStream(FileOutputStream fos) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(fos);
		} catch (IOException e) {
			
		}
		return oos;
	}
	public ObjectInputStream methodObjectInputStream(FileInputStream fis) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(fis);
		} catch (IOException e) {
		
		}
		return ois;
	}
	public FileOutputStream methodFileOutputStream() {
		FileOutputStream fos = null;
		try{
			fos =new FileOutputStream("object.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return fos;
	}
	public FileInputStream methodFileInputStream() {
		FileInputStream fos = null;
		try{
			fos =new FileInputStream("object.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fos;
	}

}
