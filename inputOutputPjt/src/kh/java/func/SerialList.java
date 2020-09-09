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
			System.out.println("----- ȸ���������α׷� -----");
			System.out.println("1.ȸ�� ���� ���");
			System.out.println("2.ȸ�� ��ü ���� ���");
			System.out.println("3.��ü ȸ�� ���");
			System.out.println("4.����");
			System.out.println("5.�ҷ�����");
			System.out.print("���� > ");
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
		System.out.println("\n---- ȸ�� ���� ��� ----\n");
		System.out.print("�̸� �Է�: ");
		String name = sc.next();
		System.out.print("���� �Է�: ");
		int age = sc.nextInt();
		System.out.print("�ּ� �Է�: ");
		String addr = sc.next();
		UserInfo user = new UserInfo(name,age,addr);
		users.add(user);
		System.out.println("��� �Ϸ�");
	}
	public void deleteUser() {
		System.out.println("\n---- ȸ�� ���� ���� ----\n");
		System.out.println("���� �� ȸ�� �̸� �Է�: ");
		String name = sc.next();
		for(int List_i=0;List_i<users.size();++List_i) {
			if(users.get(List_i).getName().equals(name)) {
				users.remove(List_i);
				System.out.println("���� �Ϸ�");
				return;
			}
		}
		System.out.println("ȸ���� �������� �ʽ��ϴ�.");
	}
	public void printAllUser() {
		System.out.println("\n---- ��ü ȸ�� ��� ----\n");
		System.out.println("�̸�\t����\t�ּ�");
		for(UserInfo user : users) {
			System.out.printf("%s\t%s\t%s",user.getName(),user.getName(),user.getAddr());
		}
		System.out.println();
	}
	public void saveInfo() {
		
		FileOutputStream fos = makeFileOutputStream();
		ObjectOutputStream oos = makeObjectOutputStream(fos);
		oosWriteobject(oos);
		System.out.println("����Ϸ�");
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
		System.out.println("�ҷ����� �Ϸ�!");
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
