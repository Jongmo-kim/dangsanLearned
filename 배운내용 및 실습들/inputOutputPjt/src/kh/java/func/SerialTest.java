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
			System.out.println("1. 유저 정보 입력 후 내보내기");
			System.out.println("2. 유저 정보 읽어 오기");
			System.out.println("3. 현재 유저 정보 출력");
			System.out.print("선택 > ");
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
		System.out.print("유저 이름 입력");
		String name = sc.next();
		System.out.print("유저 나이 입력");
		int age = sc.nextInt();
		System.out.print("유저 주소 입력");
		String addr = sc.next();
		System.out.print("국어점수 입력");
		int kor = sc.nextInt();
		System.out.print("영어점수 입력");
		int eng = sc.nextInt();
		System.out.print("수학점수 입력");
		int math = sc.nextInt();
		UserInfo u = new UserInfo(name, age, addr);
		u.setScore(new Score(kor,eng,math));
		ObjectOutputStream oos = null;
		FileOutputStream fos = methodFileOutputStream();
		oos =methodObjectOutputStream(fos);
		oosWriteObject(oos,u);
		System.out.println("저장완료");
	}
	public void inputUser() {
		FileInputStream fis = methodFileInputStream();
		ObjectInputStream ois = methodObjectInputStream(fis);
		this.user = (UserInfo)objectInputStreamReadObject(ois);
		System.out.println("불러오기 완료");
	}
	public void readUser() {
		System.out.printf("이름: %s\n",user.getName());
		System.out.printf("나이: %d\n",user.getAge());
		System.out.printf("주소: %s\n",user.getAddr());
		System.out.printf("국어점수: %d\n",user.getScore().getKor());
		System.out.printf("영어점수: %d\n",user.getScore().getEng());
		System.out.printf("수학점수: %d\n",user.getScore().getMath());
		
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
