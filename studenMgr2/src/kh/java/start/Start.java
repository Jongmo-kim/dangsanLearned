package kh.java.start;

import java.util.Scanner;

import kh.java.controller.StudentController;

public class Start {
	public static void main(String[] args) {
		StudentController f = new StudentController();
		Scanner sc = new Scanner(System.in);
		while(true) {
			
			System.out.println("1. 학생 정보 입력");
			System.out.println("2. 학생 정보 출력");
			System.out.println("3. 학생 정보 출력(1명)");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 학생 정보 삭제");
			System.out.println("6. 프로그램 종료");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				if(!f.addStudent()) {
					System.out.println("저장공간이 부족합니다.");
				} else {
					System.out.println("저장하였습니다.");
				}
				break;
			case 2:
				f.showStudents();
				break;
			case 3:
				System.out.println("몇번에 입력한 학생을 출력합니까?");
				int TempforPrint = sc.nextInt();
				f.showOneStudent(TempforPrint);
				break;
			case 4:
				System.out.println("몇번쨰 학생을 수정할까요?");
				int TempforModify = sc.nextInt();
				System.out.println("이름을(를) 입력해주세요 ");
				String tempforname = sc.next();
				System.out.println("나이을(를) 입력해주세요 ");
				int tempforage = sc.nextInt();
				System.out.println("주소을(를) 입력해주세요 ");
				String tempforaddr=sc.next();
				f.modifyStudent(TempforModify, tempforname, tempforage, tempforaddr);
				break;
			case 5:
				System.out.println("몇번쨰 학생을 지울까요?");
				int TempforDelete = sc.nextInt();
				if(f.deleteStudent(TempforDelete)) {
					System.out.println("성공적으로 삭제 했습니다.");
				} else {
					System.out.println("지우지 못했습니다.");
				}
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못된값 입력.");
			}
		}
	}
}
