package kh.java.test.function;

import java.util.Scanner;

public class Example {
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수 입력: ");
		int kor = sc.nextInt();
		
		System.out.print("수학 점수 입력: ");
		int math = sc.nextInt();
		System.out.print("영어 점수 입력: ");
		int eng = sc.nextInt();
		
		int sum = kor+math+eng;
		double ave = ((kor+math+eng)/3.0);
		System.out.println("==========결과============");
		System.out.printf("총점 : %d \n",sum);
		System.out.printf("평균 : %.2f",ave);
		System.out.println(((ave>=60) && (kor >= 40) && (math >= 40) && (eng >= 40)) ? "\n합격" : "\n불합격");
		
	}
	
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 :");
		int num = sc.nextInt();
		
		System.out.println(((num%2)==0)?"짝수" : "홀수");
	}
}
