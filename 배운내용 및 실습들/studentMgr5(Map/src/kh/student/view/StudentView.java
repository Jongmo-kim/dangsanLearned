package kh.student.view;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.View;

import kh.student.model.vo.Student;

public class StudentView {
	Scanner sc;
	public StudentView() {
		sc =new Scanner(System.in);
	}
	public int ShowMenu() {
		System.out.println("1. �л� ���� ���");
		System.out.println("2. �л� ��ü ���� ��ȸ");
		System.out.println("3. �л� ���� ��ȸ(1��)");
		System.out.println("4. �л� ���� ����");
		System.out.println("5. �л� ���� ����");
		System.out.print("���� > ");
		int sel = sc.nextInt();
		return sel;
	}
	public Student insertStudent() {
		System.out.println("\n---- �л� ���� ��� ----\n");
		System.out.println("�л� �̸� �Է�: ");
		String name = sc.next();
		System.out.println("�л� ���� �Է�: ");
		int age = sc.nextInt();
		System.out.println("�л� �ּ� �Է�: ");
		String addr =  sc.next();

		
		return new Student(name,age,addr);
	}
	
	public void printAllStudents(HashMap<String,Student> students) {
		System.out.println("\n---- ��ü �л� ���� ��� ----\n");
		System.out.println("�̸�\t����\t�ּ�\t\t");
		Set<String> names = students.keySet();
		for(String name : names) {
			System.out.printf("%s\t%d\t%s\t\t\n",students.get(name).getName()
					,students.get(name).getAge(),students.get(name).getAddr());
		}
	}
	
	public void printOneStudent(Student student) {
		System.out.println("\n---- �л� ���� ��� (1��) ----\n");
		System.out.println("�̸�\t����\t�ּ�\t\t");
		System.out.printf("%s\t%d\t%s\t\t\n",student.getName()
					,student.getAge(),student.getAddr());	
	}
	
	public void doneMessage(String msg) {
		System.out.printf("\n%s �Ϸ�\n",msg);
	}
	
	
	public String getName(String str) {
		System.out.printf("%s ��ȸ�� �̸� �Է� : ",str);
		return sc.next();
	}
	
	public void noSearch() {
		System.out.println("ȸ�� ������ �����ϴ�.");
	}

	
}
