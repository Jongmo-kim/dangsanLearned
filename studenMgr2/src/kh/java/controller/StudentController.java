package kh.java.controller;

import java.util.Scanner;

import kh.java.model.vo.Student;

public class StudentController {
	private Student[] arr;
	private int idx,top;
	private Scanner sc;
	final int MAX = 50;
	public StudentController(){
		arr = new Student[MAX];
		for(int List_i=0;List_i<MAX;++List_i) {
			arr[List_i] = new Student();
		}
		sc = new Scanner(System.in);
		idx = 0;
		top = 0;
	}
	public boolean addStudent() {
		if(idx == MAX) {
			return false;
		} else {
			String tempforname,tempforaddr;
			int tempforage;
			System.out.println("�̸���(��) �Է����ּ��� ");
			tempforname = sc.next();
			System.out.println("������(��) �Է����ּ��� ");
			tempforage = sc.nextInt();
			System.out.println("�ּ���(��) �Է����ּ��� ");
			tempforaddr=sc.next();
			arr[idx++].setStudent(tempforname, tempforage, tempforaddr);
			return true;
		}
	}
	public void showStudents() {
		System.out.println("�̸�\t����\t\t�ּ�");
		for(int List_i=0;List_i<idx;++List_i) {
			System.out.println("----------------------------------------");
			arr[List_i].showStudent();
			System.out.println("\n----------------------------------------");
		}
	}
	public void showOneStudent(int idx_) {
		System.out.println("�̸�\t����\t\t�ּ�");
		arr[idx_].showStudent();
	}
	public void modifyStudent(int idx_,String name,int age, String addr) {
		arr[idx_].setStudent(name, age, addr);
	}
	public boolean deleteStudent(int idx_) {
		if(idx_ == MAX || idx_ < 0) {
			System.out.println("������ ���� �ε��� ���� �ʹ� �۽��ϴ�.");
			return false;
		}
		for(int List_i=idx_;List_i<=idx;++List_i) {
			arr[List_i].setStudent(arr[List_i+1].getName(), arr[List_i+1].getAge(), arr[List_i+1].getAddr());
		}
		return true;
	}
	
}
