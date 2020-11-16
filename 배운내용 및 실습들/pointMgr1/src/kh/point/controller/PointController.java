package kh.point.controller;

import java.util.Scanner;

import kh.point.model.vo.Gold;
import kh.point.model.vo.Silver;
import kh.point.model.vo.VIP;

public class PointController {
	Scanner sc;
	Silver[] s;
	int sIndex;
	Gold[] g;
	int gIndex;
	VIP[] v;
	int vIndex;
	int searchResult;	//검색결과가 silver면 1/gold면 2 /vip면 3
	public PointController() {
		sc = new Scanner(System.in);
		s = new Silver[10];
		g = new Gold[10];
		v = new VIP[10];
	}
	public void main() {
		while(true) {
			System.out.println("\n\n---- 회원 관리 프로그램 v1 ----\n");
			System.out.println("1. 회원 등록");
			System.out.println("2. 회원 전체 정보 출력");
			System.out.println("3. 회원 1명 정보 출력");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > ");
			int sel = sc.nextInt();
			switch(sel) {
			case 1:
				insertMember();
				break;
			case 2:
				selectAllMember();
				break;
			case 3:
				selectOneMember();
				break;
			case 4:
				break;
			case 5:
				deleteMember();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
	public void insertMember() {
		System.out.println("\n---- 회원 정보 등록 ----\n");
		System.out.print("회원 이름 입력 : ");
		String name =sc.next();
		System.out.print("회원 등급 입력[silver/gold/vip] : ");
		String grade = sc.next();
		System.out.print("회원 포인트 입력 : ");
		int point = sc.nextInt();
		switch(grade) {
		case "silver":
			s[sIndex] = new Silver(name, grade, point);
			sIndex++;
			break;
		case "gold":
			g[gIndex] = new Gold(name,grade,point);
			gIndex++;
			break;
		case "vip":
			v[vIndex++] = new VIP(name, grade, point);
			break;
		}
	}
	public void selectAllMember() {
		System.out.println("\n---- 전체 회원 정보 출력 ----\n");
		System.out.println("이름\t등급\t포인트\t보너스");
		for(int i=0;i<sIndex;i++) {
			System.out.println(s[i].getName()+"\t"+s[i].getGrade()+"\t"
									+s[i].getPoint()+"\t"+s[i].getBonus());
		}
		for(int i=0;i<gIndex;i++) {
			System.out.println(g[i].getName()+"\t"+g[i].getGrade()+"\t"
									+g[i].getPoint()+"\t"+g[i].getBonus());
		}
		for(int i=0;i<vIndex;i++) {
			System.out.println(v[i].getName()+"\t"+v[i].getGrade()+"\t"
									+v[i].getPoint()+"\t"+v[i].getBonus());
		}
	}
	public void selectOneMember() {
		System.out.println("\n---- 회원 정보 조회 ----\n");
		System.out.print("조회할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchIndex(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보가 없습니다.");
		}else {
			if(searchIndex/100 == 1) {
				searchIndex -= 100;
				System.out.println("이름 : "+s[searchIndex].getName());
				System.out.println("등급 : "+s[searchIndex].getGrade());
				System.out.println("포인트 : "+s[searchIndex].getPoint());
				System.out.println("보너스 : "+s[searchIndex].getBonus());
			}else if(searchIndex/10 == 1) {
				searchIndex -= 10;
				System.out.println("이름 : "+g[searchIndex].getName());
				System.out.println("등급 : "+g[searchIndex].getGrade());
				System.out.println("포인트 : "+g[searchIndex].getPoint());
				System.out.println("보너스 : "+g[searchIndex].getBonus());
			}else {
				System.out.println("이름 : "+v[searchIndex].getName());
				System.out.println("등급 : "+v[searchIndex].getGrade());
				System.out.println("포인트 : "+v[searchIndex].getPoint());
				System.out.println("보너스 : "+v[searchIndex].getBonus());
			}
			/*
			if(searchResult == 1) {
				System.out.println("이름 : "+s[searchIndex].getName());
				System.out.println("등급 : "+s[searchIndex].getGrade());
				System.out.println("포인트 : "+s[searchIndex].getPoint());
				System.out.println("보너스 : "+s[searchIndex].getBonus());
			}else if(searchResult == 2) {
				System.out.println("이름 : "+g[searchIndex].getName());
				System.out.println("등급 : "+g[searchIndex].getGrade());
				System.out.println("포인트 : "+g[searchIndex].getPoint());
				System.out.println("보너스 : "+g[searchIndex].getBonus());
			}else if(searchResult == 3) {
				System.out.println("이름 : "+v[searchIndex].getName());
				System.out.println("등급 : "+v[searchIndex].getGrade());
				System.out.println("포인트 : "+v[searchIndex].getPoint());
				System.out.println("보너스 : "+v[searchIndex].getBonus());
			}
			*/
		}
		
	}
	public int searchIndex(String name) {
		for(int i=0;i<sIndex;i++) {
			if(s[i].getName().equals(name)) {
				//searchResult = 1;
				return 100+i;	//100 ~ 109
			}
		}
		for(int i=0;i<gIndex;i++) {
			if(g[i].getName().equals(name)) {
				//searchResult = 2;
				return 10+i;	//10 ~ 19
			}
		}
		for(int i=0;i<vIndex;i++) {
			
			if(v[i].getName().equals(name)) {
				//searchResult = 3;
				return i;		//0 ~9
			}
		}
		return -1;
	}
	public void deleteMember() {
		System.out.println("\n---- 회원 삭제 ----\n");
		System.out.print("삭제 할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchIndex(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보가 없습니다.");
		}else {
			if(searchIndex/100 == 1) {
				searchIndex -= 100;
				for(int i=searchIndex;i<sIndex-1;i++) {
					s[i] = s[i+1];
				}
				sIndex--;
			}else if(searchIndex/10 == 1) {
				searchIndex -=  10;
				for(int i=searchIndex;i<gIndex-1;i++) {
					g[i] = g[i+1];
				}
				gIndex--;
				
			}else {
				for(int i=searchIndex;i<vIndex-1;i++) {
					v[i] = v[i+1];
				}
				vIndex--;
			}
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
