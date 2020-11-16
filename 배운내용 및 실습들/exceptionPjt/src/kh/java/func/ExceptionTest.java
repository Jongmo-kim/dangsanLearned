package kh.java.func;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번쨰 수 입력: ");
		int num1 = sc.nextInt();
		System.out.println("두번째 수 입력: ");
		int num2 = sc.nextInt();
		try {
			int result = num1/num2;
			System.out.println("결과: " + result);
			
		} catch (Exception e) {
			System.out.println("0으로 나눌수는 없습니다.");
		}
		
	}
	public void menuPrint() {
		System.out.println("1. 안녕하세요. 출력");
		System.out.println("2. 반가워요. 출력");
		System.out.println("1. 잘가요. 출력");
		System.out.print("선택> ");
	}
	public void print(int sel) {
		switch(sel) {
		case 1:
			System.out.println("안녕하세요. ");
			break;
		case 2:
			System.out.println("반가워요. ");
			break;
		case 3:
			System.out.println("잘가요. ");
			break;
			default :
				System.out.println("1~3중 선택해주세요.");
		}
	}
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		int sel = 0;
		boolean exit = true;
		while(true) {
			try {
				
			menuPrint();
			sel = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력해주세요");
				sc.nextLine(); //입력된 숫자 제거
				continue;
			}
			break;

		}
		print(sel);
	}
	public void exam5() {
		//close까지 같이 처리해주는 예외
		try(FileReader fr = new FileReader("test.txt")){
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
