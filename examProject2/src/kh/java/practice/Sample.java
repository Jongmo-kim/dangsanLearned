package kh.java.practice;

import java.util.Scanner;

public class Sample {
	
	
	public void sample1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 입력 :");
		String str = sc.next();
		char ch = str.charAt(0);
		
		System.out.printf("%c의 유니코드값 :",ch);
		System.out.println((int)ch);
	}
	public void sample2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수 입력: ");
		int kor = sc.nextInt();
		
		System.out.print("수학 점수 입력: ");
		int math = sc.nextInt();
		System.out.print("영어 점수 입력: ");
		int eng = sc.nextInt();
		
		System.out.println("==========결과============");
		System.out.printf("총점 : %d \n",kor+math+eng);
		System.out.printf("평균 : %d",(int)((kor+math+eng)/3.0));
	}
}
