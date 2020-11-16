package kh.java.start;

import java.util.Scanner;

import kh.java.controller.StudentController;

public class Start {
	public static void main(String[] args) {
		StudentController f = new StudentController();
		Scanner sc = new Scanner(System.in);
		while(true) {
			
			System.out.println("1. �л� ���� �Է�");
			System.out.println("2. �л� ���� ���");
			System.out.println("3. �л� ���� ���(1��)");
			System.out.println("4. �л� ���� ����");
			System.out.println("5. �л� ���� ����");
			System.out.println("6. ���α׷� ����");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				if(!f.addStudent()) {
					System.out.println("��������� �����մϴ�.");
				} else {
					System.out.println("�����Ͽ����ϴ�.");
				}
				break;
			case 2:
				f.showStudents();
				break;
			case 3:
				System.out.println("����� �Է��� �л��� ����մϱ�?");
				int TempforPrint = sc.nextInt();
				f.showOneStudent(TempforPrint);
				break;
			case 4:
				System.out.println("����� �л��� �����ұ��?");
				int TempforModify = sc.nextInt();
				System.out.println("�̸���(��) �Է����ּ��� ");
				String tempforname = sc.next();
				System.out.println("������(��) �Է����ּ��� ");
				int tempforage = sc.nextInt();
				System.out.println("�ּ���(��) �Է����ּ��� ");
				String tempforaddr=sc.next();
				f.modifyStudent(TempforModify, tempforname, tempforage, tempforaddr);
				break;
			case 5:
				System.out.println("����� �л��� ������?");
				int TempforDelete = sc.nextInt();
				if(f.deleteStudent(TempforDelete)) {
					System.out.println("���������� ���� �߽��ϴ�.");
				} else {
					System.out.println("������ ���߽��ϴ�.");
				}
				break;
			case 6:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default:
				System.out.println("�߸��Ȱ� �Է�.");
			}
		}
	}
}
