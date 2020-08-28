package kh.point.controller;

import java.util.Scanner;

import kh.point.model.vo.Gold;
import kh.point.model.vo.Silver;
import kh.point.model.vo.VIP;

public class PointController {

	private Silver[] s;
	private Gold[] g;
	private VIP[] v;
	private int sIndex;
	private int gIndex;
	private int vIndex;
	private Scanner sc;
	PointController() {
		sc = new Scanner(System.in);
		s = new Silver[3];
		g = new Gold[3];
		v = new VIP[3];
		sIndex = s.length;
		gIndex = g.length;
		vIndex = v.length;
		String sel;
		
		switch(sel) {
		
		}
		System.out.println("\n-----ȸ�� ���� ���α׷� -----\n");

		System.out.println("ȸ�� ��� �Է� [Silver/Gold/Vip[");
		System.out.println("ȸ�� ��� �Է� [Silver/Gold/Vip[");
		System.out.println("ȸ�� ��� �Է� [Silver/Gold/Vip[");
	}

	public void selectAllMember() {

		System.out.println("\n-----��ü ȸ�� ���� ��� -----\n");
		System.out.println("�̸�\t���\t����Ʈ\t���ʽ�");
		for (int List_i = 0; List_i < sIndex; ++List_i) {
			System.out.printf("%d\t%d\t%d\t%d\n", s[List_i].getName(), s[List_i].getGrade(), s[List_i].getPoint(),
					s[List_i].getBonus());
		}
		for (int List_i = 0; List_i < gIndex; ++List_i) {
			System.out.printf("%d\t%d\t%d\t%d\n", g[List_i].getName(), g[List_i].getGrade(), g[List_i].getPoint(),
					s[List_i].getBonus());
		}
		for (int List_i = 0; List_i < vIndex; ++List_i) {
			System.out.printf("%d\t%d\t%d\t%d\n", v[List_i].getName(), v[List_i].getGrade(), v[List_i].getPoint(),
					v[List_i].getBonus());
		}
	}
	
	public void selectOneMember() {

		System.out.println("\n-----��ü ȸ�� ���� ��� -----\n");
		System.out.println("��ȸ�� ȸ�� �̸� �Է� :");
		String name = sc.next();
		int searchIndex = searchIndex(name);
		if(searchIndex ==-1) {
			System.out.println("ȸ�� ������ �����ϴ�.");
		} else {
			System.out.printf("�̸� : %d",g[searchIndex].getName());
		}
	}
	public int searchIndex(String name) {
		for(int List_i=0;List_i<sIndex;++List_i) {
			if(s[List_i].getName().contentEquals(name)) {
			return List_i;
			}
		}
		for(int List_i=0;List_i<gIndex;++List_i) {
			if(g[List_i].getName().contentEquals(name)) {
				return List_i;
			}
		}
		for(int List_i=0;List_i<vIndex;++List_i) {
			if(v[List_i].getName().contentEquals(name)) {
			return List_i;
			}
		}
		return -1;
	}
}
