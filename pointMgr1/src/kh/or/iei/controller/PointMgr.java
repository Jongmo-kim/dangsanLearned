//package kh.or.iei.controller;
//
//import java.util.Scanner;
//
//import kh.point.model.vo.*;
//
///*
//1. �����Է� �� �Ѹ� �Է¹�����, �Է������� ���, �̸�, ����Ʈ������ �Է¹޴´�.
//2. ���� ��� �� ���, �̸�, ����Ʈ����, ���ʽ�����Ʈ �� 4�� ������ ����Ѵ�.
//3. ���ʽ� ����Ʈ�� ����Ʈ ������ ��޺� ������ ����Ǹ� ���� �Է� �� ����Ʈ ������ �Է��ϸ� �ڵ����� ó���Ǿ�� �Ѵ�.
//	-> �� ��޺� ���ʽ� ����Ʈ ���� - silver : 2%, gold : 5%, vip : 7%
//4. ȸ���������(1��), ��������, ȸ��Ż�� ����� ��� �̸��� �Է¹޾Ƽ� ó���Ѵ�.(�̸��� �ߺ����� �ʴ´ٰ� �����Ѵ�.)
// */
//public class PointMgr {
//	String name ;
//	String grade;
//	double point;
//
//	Scanner sc;
//	final int MAX = 30;
//	private Grade[] arr;
//	private int idx;
//
//	public PointMgr() {
//		arr = new Grade[MAX];
//		idx = 0;
//		sc = new Scanner(System.in);
//		for(int List_i=0;List_i<MAX;++List_i) {
//			arr[List_i] = new Grade();
//		}
//	}
//	public Grade inputPoint() {
//		System.out.print("ȸ�� �̸� �Է�: ");
//		name = sc.next();
//		System.out.print("ȸ�� ��� �Է�[silver/gold/vip: ");
//		grade = sc.next();
//		System.out.print("ȸ�� ����Ʈ �Է�: ");
//		point = sc.nextDouble();
//		if (grade.equals("silver")) {
//			return new Silver(name, point);
//		} else if (grade.equals("gold")) {
//			return new Gold(name, point);
//		} else if (grade.equals("vip")) {
//			return new Vip(name, point);
//		}
//		return new Grade();
//	}
//	public void addPoint() {
//		if (idx == MAX) {
//			System.out.println("ȸ�� ���� ������ ���� á���ϴ�.");
//			return;
//		}
//		
//		Grade temp = inputPoint();
//		if(!temp.equals(new Grade())) {
//			System.out.println("ȸ�� ��� �Ϸ�");
//			arr[idx++] = temp;
//		}
//		
//	}
//
//	public void showAll() {
//		System.out.println("------ ȸ�� ��ü ���� ��� ------");
//		System.out.println("�̸�\t���\t����Ʈ\t���ʽ�");
//		for (int List_i = 0; List_i < idx; ++List_i) {
//			arr[List_i].printStuff();
//		}
//	}
//
//	public void showOne() {
//		System.out.println("------ ȸ�� ���� ���(1��) ------");
//		System.out.print("��ȸ ");
//		int result = searchIndexByName();
//		if (result == -1) {
//			System.out.println("�ش��ϴ� ȸ���� �����ϴ�.");
//		} else {
//			System.out.println("�̸�\t���\t����Ʈ\t���ʽ�");
//			arr[result].printStuff();
//		}
//	}
//
//	private int searchIndexByName() {
//		System.out.print("�� ȸ�� �̸� �Է�: ");
//		String tempForName = sc.next();
//		for (int List_i = 0; List_i < idx; ++List_i) {
//			if (arr[List_i].getName().contentEquals(tempForName)) {
//				return List_i;
//			}
//		}
//		return -1;
//	}
//
//	public void modifyPoint() {
//		System.out.println("------ ȸ�� ���� ���� ------");
//		System.out.print("���� ");
//		int result = searchIndexByName();
//		if (result == -1) {
//			System.out.println("�ش��ϴ� ȸ���� �����ϴ�.");
//		} else {
//			Grade temp = inputPoint();
//			arr[result] = temp;
//		}
//	}
//
//	public void deletePoint() {
//		System.out.println("------ ȸ�� ���� ���� ------");
//		System.out.print("���� ");
//		int result = searchIndexByName();
//		if(result == -1) {
//			System.out.println("�ش��ϴ� ȸ���� �����ϴ�.");
//		} else {
//			for(int List_i=result;List_i<idx;++List_i) {
//				arr[List_i] = arr[List_i+1];
//			}
//			idx--;
//		}	
//	}
//}
