package kh.student.view;

import java.util.ArrayList;
import java.util.Scanner;

import kh.student.model.vo.Student;

public class StudentView {
	Scanner sc;
	
	public StudentView() {
		sc = new Scanner(System.in);
	}
	
	public int showMenu() {
		System.out.println("\n--- �л� ���� ���α׷� ---\n");
		System.out.println("1. �л� ���� ���");
		System.out.println("2. ��ü �л� ���� ���");
		System.out.println("3. �л� ���� ��� (1��)");
		System.out.println("4. �л� ���� ����");
		System.out.println("5. �л� ���� ����");
		System.out.print("���� > ");
		return sc.nextInt();
	}
	
	public Student insertStudent() {
		System.out.println("\n---- �л� ���� ��� ----\n");
		System.out.print("�л� �̸� �Է�: ");
		String name = sc.next();
		System.out.print("�л� ���� �Է�: ");
		int age = sc.nextInt();
		System.out.print("�л� �ּ� �Է�: ");
		String addr =  sc.next();
		
		return new Student(name,age,addr);
	}
	
	public void printAllStudents(ArrayList<Student> students) {
		System.out.println("\n---- ��ü �л� ���� ��� ----\n");
		System.out.println("�̸�\t����\t�ּ�\t\t");
		for(Student List_i : students) {
			System.out.printf("%s\t%d\t%s\t\t\n",List_i.getName()
					,List_i.getAge(),List_i.getAddr());
		}
	}
	
	public void printOneStudent(Student student) {
		System.out.println("\n---- �л� ���� ��� (1��) ----\n");
		System.out.println("�̸�\t����\t�ּ�\t\t");
		System.out.printf("%s\t%d\t%s\t\t\n",student.getName()
					,student.getAge(),student.getAddr());	
	}
	
	public void modifyOneStudent(Student students) {
		System.out.print("�л� �̸� �Է�: ");
		students.setName(sc.next());
		System.out.print("�л� ���� �Է�: ");
		students.setAge(sc.nextInt());
		System.out.print("�л� �ּ� �Է�: ");
		students.setAddr(sc.next());
		
	}
	
	public String getName(String str) {
		System.out.printf("%s ��ȸ�� �̸� �Է� : ",str);
		return sc.next();
	}
	
	public void noSearch() {
		System.out.println("ȸ�� ������ �����ϴ�.");
	}
	
}
