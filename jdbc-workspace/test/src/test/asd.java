package test;

import java.util.Scanner;

public class asd {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		sc.nextInt();
		String temp1 = inputBoardTitle();
		String temp2 = inputBoardContent();
		
		System.out.println(temp1);
		System.out.println(temp2);
	}
	static String inputBoardTitle() {
		Scanner sc = new Scanner(System.in);	
		System.out.print("게시물 제목 입력 : ");
		sc.next();
		return sc.nextLine();
	}
	
	static String inputBoardContent() {
		Scanner sc = new Scanner(System.in);
		System.out.print("게시물 내용 입력 : ");
		return sc.nextLine();
	}
}
