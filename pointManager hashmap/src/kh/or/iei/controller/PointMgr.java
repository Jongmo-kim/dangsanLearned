package kh.or.iei.controller;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import kh.point.model.vo.*;

/*
1. �����Է� �� �Ѹ� �Է¹�����, �Է������� ���, �̸�, ����Ʈ������ �Է¹޴´�.
2. ���� ��� �� ���, �̸�, ����Ʈ����, ���ʽ�����Ʈ �� 4�� ������ ����Ѵ�.
3. ���ʽ� ����Ʈ�� ����Ʈ ������ ��޺� ������ ����Ǹ� ���� �Է� �� ����Ʈ ������ �Է��ϸ� �ڵ����� ó���Ǿ�� �Ѵ�.
	-> �� ��޺� ���ʽ� ����Ʈ ���� - silver : 2%, gold : 5%, vip : 7%
4. ȸ���������(1��), ��������, ȸ��Ż�� ����� ��� �̸��� �Է¹޾Ƽ� ó���Ѵ�.(�̸��� �ߺ����� �ʴ´ٰ� �����Ѵ�.)
 */
public class PointMgr {
	String name ;
	String grade;
	double point;

	Scanner sc;
	final int MAX = 30;
	private HashMap<String, Grade> arr;
	private int idx;

	public PointMgr() {
		arr = new HashMap<String, Grade>();
		idx = 0;
		sc = new Scanner(System.in);
	}
	public Grade inputPoint() {
		System.out.print("ȸ�� �̸� �Է�: ");
		name = sc.next();
		System.out.print("ȸ�� ��� �Է�[silver/gold/vip: ");
		grade = sc.next();
		System.out.print("ȸ�� ����Ʈ �Է�: ");
		point = sc.nextDouble();
		if (grade.equals("silver")) {
			return new Silver(name, point);
		} else if (grade.equals("gold")) {
			return new Gold(name, point);
		} else if (grade.equals("vip")) {
			return new Vip(name, point);
		}
		return new Grade();
	}
	public void addPoint() {
		if (idx == MAX) {
			System.out.println("ȸ�� ���� ������ ���� á���ϴ�.");
			return;
		}
		
		Grade temp = inputPoint();
		if(!temp.equals(new Grade())) {
			System.out.println("ȸ�� ��� �Ϸ�");
			arr.put(temp.getName(), temp);
		}
		
	}

	public void showAll() {
		System.out.println("------ ȸ�� ��ü ���� ��� ------");
		System.out.println("�̸�\t���\t����Ʈ\t���ʽ�");
		Set<String> s = arr.keySet();
		for(String name : s) {
			arr.get(name).printStuff();
		}
	}

	public void showOne() {
		System.out.println("------ ȸ�� ���� ���(1��) ------");
		System.out.print("��ȸ �� �̸� �Է� :");
		String result = sc.next();
		if (arr.containsKey(result)) {
			System.out.println("�̸�\t���\t����Ʈ\t���ʽ�");
			arr.get(result).printStuff();
		} else {
			System.out.println("�ش��ϴ� ȸ���� �����ϴ�.");
		}
	}

	public void modifyPoint() {
		System.out.println("------ ȸ�� ���� ���� ------");
		System.out.print("���� ");
		String result = sc.next();
		if (arr.containsKey(result)) {
			arr.remove(result);
			Grade s = inputPoint();
			arr.put(s.getName(),s);
		} else {
			System.out.println("�ش��ϴ� ȸ���� �����ϴ�.");
		}
	}

	public void deletePoint() {
		System.out.println("------ ȸ�� ���� ���� ------");
		System.out.print("���� �� ȸ���� �̸� �Է� :");
		String result = sc.next();
		if(arr.containsKey(result)) {
			arr.remove(result);
		} else {
			System.out.println("�ش��ϴ� ȸ���� �����ϴ�.");
		}	
	}
}
