//package kh.or.iei.controller;
//
//import java.util.Scanner;
//
//import kh.point.model.vo.*;
//
///*
//1. 정보입력 시 한명씩 입력받으며, 입력정보는 등급, 이름, 포인트점수를 입력받는다.
//2. 정보 출력 시 등급, 이름, 포인트점수, 보너스포인트 총 4개 정보를 출력한다.
//3. 보너스 포인트는 포인트 점수에 등급별 비율로 적용되며 정보 입력 시 포인트 점수만 입력하면 자동으로 처리되어야 한다.
//	-> 각 등급별 보너스 포인트 비율 - silver : 2%, gold : 5%, vip : 7%
//4. 회원정보출력(1명), 정보수정, 회원탈퇴 기능은 모두 이름을 입력받아서 처리한다.(이름은 중복되지 않는다고 가정한다.)
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
//		System.out.print("회원 이름 입력: ");
//		name = sc.next();
//		System.out.print("회원 등급 입력[silver/gold/vip: ");
//		grade = sc.next();
//		System.out.print("회원 포인트 입력: ");
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
//			System.out.println("회원 저장 정보가 가득 찼습니다.");
//			return;
//		}
//		
//		Grade temp = inputPoint();
//		if(!temp.equals(new Grade())) {
//			System.out.println("회원 등록 완료");
//			arr[idx++] = temp;
//		}
//		
//	}
//
//	public void showAll() {
//		System.out.println("------ 회원 전체 정보 출력 ------");
//		System.out.println("이름\t등급\t포인트\t보너스");
//		for (int List_i = 0; List_i < idx; ++List_i) {
//			arr[List_i].printStuff();
//		}
//	}
//
//	public void showOne() {
//		System.out.println("------ 회원 정보 출력(1명) ------");
//		System.out.print("조회 ");
//		int result = searchIndexByName();
//		if (result == -1) {
//			System.out.println("해당하는 회원이 없습니다.");
//		} else {
//			System.out.println("이름\t등급\t포인트\t보너스");
//			arr[result].printStuff();
//		}
//	}
//
//	private int searchIndexByName() {
//		System.out.print("할 회원 이름 입력: ");
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
//		System.out.println("------ 회원 정보 수정 ------");
//		System.out.print("수정 ");
//		int result = searchIndexByName();
//		if (result == -1) {
//			System.out.println("해당하는 회원이 없습니다.");
//		} else {
//			Grade temp = inputPoint();
//			arr[result] = temp;
//		}
//	}
//
//	public void deletePoint() {
//		System.out.println("------ 회원 정보 삭제 ------");
//		System.out.print("삭제 ");
//		int result = searchIndexByName();
//		if(result == -1) {
//			System.out.println("해당하는 회원이 없습니다.");
//		} else {
//			for(int List_i=result;List_i<idx;++List_i) {
//				arr[List_i] = arr[List_i+1];
//			}
//			idx--;
//		}	
//	}
//}
