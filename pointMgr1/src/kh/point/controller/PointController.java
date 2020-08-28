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
		System.out.println("\n-----회원 관리 프로그램 -----\n");

		System.out.println("회원 등급 입력 [Silver/Gold/Vip[");
		System.out.println("회원 등급 입력 [Silver/Gold/Vip[");
		System.out.println("회원 등급 입력 [Silver/Gold/Vip[");
	}

	public void selectAllMember() {

		System.out.println("\n-----전체 회원 정보 출력 -----\n");
		System.out.println("이름\t등급\t포인트\t보너스");
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

		System.out.println("\n-----전체 회원 정보 출력 -----\n");
		System.out.println("조회할 회원 이름 입력 :");
		String name = sc.next();
		int searchIndex = searchIndex(name);
		if(searchIndex ==-1) {
			System.out.println("회원 정보가 없습니다.");
		} else {
			System.out.printf("이름 : %d",g[searchIndex].getName());
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
