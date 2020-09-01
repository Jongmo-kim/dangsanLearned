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
	int searchResult;	//�˻������ silver�� 1/gold�� 2 /vip�� 3
	public PointController() {
		sc = new Scanner(System.in);
		s = new Silver[10];
		g = new Gold[10];
		v = new VIP[10];
	}
	public void main() {
		while(true) {
			System.out.println("\n\n---- ȸ�� ���� ���α׷� v1 ----\n");
			System.out.println("1. ȸ�� ���");
			System.out.println("2. ȸ�� ��ü ���� ���");
			System.out.println("3. ȸ�� 1�� ���� ���");
			System.out.println("4. ȸ�� ���� ����");
			System.out.println("5. ȸ�� ����");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� > ");
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
				System.out.println("���α׷��� �����մϴ�.");
				return;
			}
		}
	}
	public void insertMember() {
		System.out.println("\n---- ȸ�� ���� ��� ----\n");
		System.out.print("ȸ�� �̸� �Է� : ");
		String name =sc.next();
		System.out.print("ȸ�� ��� �Է�[silver/gold/vip] : ");
		String grade = sc.next();
		System.out.print("ȸ�� ����Ʈ �Է� : ");
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
		System.out.println("\n---- ��ü ȸ�� ���� ��� ----\n");
		System.out.println("�̸�\t���\t����Ʈ\t���ʽ�");
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
		System.out.println("\n---- ȸ�� ���� ��ȸ ----\n");
		System.out.print("��ȸ�� ȸ�� �̸� �Է� : ");
		String name = sc.next();
		int searchIndex = searchIndex(name);
		if(searchIndex == -1) {
			System.out.println("ȸ�� ������ �����ϴ�.");
		}else {
			if(searchIndex/100 == 1) {
				searchIndex -= 100;
				System.out.println("�̸� : "+s[searchIndex].getName());
				System.out.println("��� : "+s[searchIndex].getGrade());
				System.out.println("����Ʈ : "+s[searchIndex].getPoint());
				System.out.println("���ʽ� : "+s[searchIndex].getBonus());
			}else if(searchIndex/10 == 1) {
				searchIndex -= 10;
				System.out.println("�̸� : "+g[searchIndex].getName());
				System.out.println("��� : "+g[searchIndex].getGrade());
				System.out.println("����Ʈ : "+g[searchIndex].getPoint());
				System.out.println("���ʽ� : "+g[searchIndex].getBonus());
			}else {
				System.out.println("�̸� : "+v[searchIndex].getName());
				System.out.println("��� : "+v[searchIndex].getGrade());
				System.out.println("����Ʈ : "+v[searchIndex].getPoint());
				System.out.println("���ʽ� : "+v[searchIndex].getBonus());
			}
			/*
			if(searchResult == 1) {
				System.out.println("�̸� : "+s[searchIndex].getName());
				System.out.println("��� : "+s[searchIndex].getGrade());
				System.out.println("����Ʈ : "+s[searchIndex].getPoint());
				System.out.println("���ʽ� : "+s[searchIndex].getBonus());
			}else if(searchResult == 2) {
				System.out.println("�̸� : "+g[searchIndex].getName());
				System.out.println("��� : "+g[searchIndex].getGrade());
				System.out.println("����Ʈ : "+g[searchIndex].getPoint());
				System.out.println("���ʽ� : "+g[searchIndex].getBonus());
			}else if(searchResult == 3) {
				System.out.println("�̸� : "+v[searchIndex].getName());
				System.out.println("��� : "+v[searchIndex].getGrade());
				System.out.println("����Ʈ : "+v[searchIndex].getPoint());
				System.out.println("���ʽ� : "+v[searchIndex].getBonus());
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
		System.out.println("\n---- ȸ�� ���� ----\n");
		System.out.print("���� �� ȸ�� �̸� �Է� : ");
		String name = sc.next();
		int searchIndex = searchIndex(name);
		if(searchIndex == -1) {
			System.out.println("ȸ�� ������ �����ϴ�.");
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
	
	
	
	
	
	
	
	
	
	
	
	
