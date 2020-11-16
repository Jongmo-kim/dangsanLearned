package kh.point.start;

import java.util.Scanner;

import kh.or.iei.controller.PointMgr;
import kh.point.model.vo.*;

/*
1. 정보입력 시 한명씩 입력받으며, 입력정보는 등급, 이름, 포인트점수를 입력받는다.
2. 정보 출력 시 등급, 이름, 포인트점수, 보너스포인트 총 4개 정보를 출력한다.
3. 보너스 포인트는 포인트 점수에 등급별 비율로 적용되며 정보 입력 시 포인트 점수만 입력하면 자동으로 처리되어야 한다.
	-> 각 등급별 보너스 포인트 비율 - silver : 2%, gold : 5%, vip : 7%
4. 회원정보출력(1명), 정보수정, 회원탈퇴 기능은 모두 이름을 입력받아서 처리한다.(이름은 중복되지 않는다고 가정한다.)
 */
public class Start {
	public static void main(String[] args) {
		PointMgr f = new PointMgr();
		int choice;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("------ 포인트 관리 프로그램 ------");
			System.out.println("1. 회원 정보 등록");
			System.out.println("2. 회원 전체 정보 출력");
			System.out.println("3. 회원 정보 출력(1명)");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 정보 삭제");
			System.out.print("선택 >");choice = sc.nextInt();
			switch(choice) {
			case 1:
				f.addPoint();
				break;
			case 2:
				f.showAll();
				break;
			case 3:
				f.showOne();
				break;
			case 4:
				f.modifyPoint();
				break;
			case 5:
				f.deletePoint();
				break;
			default:
				return;
			}
		}
	}
}
