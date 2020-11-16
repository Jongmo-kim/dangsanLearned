package kh.java.func;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class SerialList {
	ArrayList<UserInfo> users;
	Scanner sc;
	public SerialList() {
		super();
		users = new ArrayList<UserInfo>();
		sc = new Scanner(System.in);
		//loadInfo();
	}
	public void main() {
		while(true) {
			System.out.println("----- 회원관리프로그램 -----");
			System.out.println("1.회원 정보 등록");
			System.out.println("2.회원 전체 정보 출력");
			System.out.println("3.전체 회원 출력");
			System.out.println("4.저장");
			System.out.println("5.불러오기");
			System.out.print("선택 > ");
			int sel =sc.nextInt();
			switch(sel) {
			case 1:
				insertUser();
				break;
			case 2:
				printAllUser();
				break;
			case 3:
				break;
			case 4:
				saveInfo();
				break;
			case 5:
				loadInfo();
				break;
				
			}
		}
	}
	public void insertUser() {
		System.out.println("\n---- 회원 정보 등록 ----\n");
		System.out.print("이름 입력: ");
		String name = sc.next();
		System.out.print("나이 입력: ");
		int age = sc.nextInt();
		System.out.print("주소 입력: ");
		String addr = sc.next();
		UserInfo user = new UserInfo(name,age,addr);
		users.add(user);
		System.out.println("등록 완료");
	}
	public void deleteUser() {
		System.out.println("\n---- 회원 정보 삭제 ----\n");
		System.out.println("삭제 할 회원 이름 입력: ");
		String name = sc.next();
		for(int List_i=0;List_i<users.size();++List_i) {
			if(users.get(List_i).getName().equals(name)) {
				users.remove(List_i);
				System.out.println("삭제 완료");
				return;
			}
		}
		System.out.println("회원이 존재하지 않습니다.");
	}
	public void printAllUser() {
		System.out.println("\n---- 전체 회원 출력 ----\n");
		System.out.println("이름\t나이\t주소");
		for(UserInfo user : users) {
			System.out.printf("%s\t%s\t%s",user.getName(),user.getName(),user.getAddr());
		}
		System.out.println();
	}
	public void saveInfo() {
		
		FileOutputStream fos = makeFileOutputStream();
		ObjectOutputStream oos = makeObjectOutputStream(fos);
		oosWriteobject(oos);
		System.out.println("저장완료");
	}
	public void oosWriteobject(ObjectOutputStream oos) {
		try {
			oos.writeObject(users);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ObjectOutputStream makeObjectOutputStream(FileOutputStream fos) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(fos);
		} catch (IOException e) {
			
		}
		return oos;
	}
	public FileOutputStream makeFileOutputStream() {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("userList.txt");
		} catch (FileNotFoundException e) {
			
		}
		return fos;
	}
	
	public void loadInfo() {
		FileInputStream fis = makeFileInputStream();
		ObjectInputStream ois = makeObjectInputStream(fis);
		users = (ArrayList<UserInfo>)oisReadObject(ois);
		System.out.println("불러오기 완료!");
	}
	public Object oisReadObject(ObjectInputStream ois){
		Object r = null;
		try {
			r=ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	public ObjectInputStream makeObjectInputStream(FileInputStream fis) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(fis);
		} catch (IOException e) {
			
		}
		return ois;
	}
	public FileInputStream makeFileInputStream() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("userList.txt");
		} catch (FileNotFoundException e) {
			
		}
		return fis;
	}

}
