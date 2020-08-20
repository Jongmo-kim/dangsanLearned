package kh.func;

import java.util.Scanner;

public class IfSwitch {
	public void ifTest() {
		// 키보드로 값을 입력 받기 위한 스캐너
		Scanner sc = new Scanner(System.in);

		System.out.println("=============숫자 구별 프로그램=============");
		System.out.print("임의의 정수를 입력 하세요 :");
		int num = sc.nextInt();

		if (num > 0) {
			System.out.printf("입력한 수 %d는 양수입니다.", num);
		}
		if (num == 0) {
			System.out.printf("입력한 수 %d는 0입니다.", num);
		}
		if (num < 0) {
			System.out.printf("입력한 수 %d는 음수입니다.", num);
		}
	}

	public void ifTest2() {
		// 키보드로 값을 입력 받기 위한 스캐너
		Scanner sc = new Scanner(System.in);

		System.out.println("=============두수 비교 프로그램=============");
		System.out.print("첫번째 임의의 정수를 입력 하세요 :");
		int num1 = sc.nextInt();

		System.out.print("두번째 임의의 정수를 입력 하세요 :");
		int num2 = sc.nextInt();

		if (num1 > num2) {
			System.out.printf("첫번째 수가 더큽니다.");
		}
		if (num1 < num2) {
			System.out.printf("두번째 수가 더 큽니다.");
		}
		if (num1 == num2) {
			System.out.printf("두 수가 같습니다");
		}
	}

	public void ifTest3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=============계산기=============");

		System.out.print("연산자를 입력하세요:");
		char operator = sc.next().charAt(0);
		System.out.print("첫번째 임의의 정수를 입력 하세요 :");
		int num1 = sc.nextInt();
		System.out.print("두번째 임의의 정수를 입력 하세요 :");
		int num2 = sc.nextInt();

		if (operator == '+') {
			System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
		}
		if (operator == '-') {
			System.out.printf("%d - %d = %d", num1, num2, num1 - num2);
		}
		if (operator == '*') {
			System.out.printf("%d * %d = %d", num1, num2, num1 * num2);
		}
		if (operator == '/') {
			System.out.printf("%d / %d = %f", num1, num2, (double) num1 / num2);
		}
	}

	public void ifElseTest1() {

		Scanner sc = new Scanner(System.in);
		System.out.println("=============놀이공원 프로그램=============");

		System.out.print("입장하실 총 인원은 몇명입니까? :");
		int TotalPeople = sc.nextInt();
		System.out.print("어른은 몇명입니까? (어른 인당 15000원):");
		int Adult = sc.nextInt();
		System.out.print("아이는 몇명입니까? (아이 인당 5000원) :");
		int Child = sc.nextInt();
		if (Adult + Child == TotalPeople)
			System.out.printf("지불하실 총 금액은 %d 입니다. \n", (Adult * 15000) + (Child * 5000));
		else
			System.out.println("인원수가 맞지 않습니다.");
	}

	public void ifElseTest2() {

		Scanner sc = new Scanner(System.in);
		int correctAnswerCount = 0;
		System.out.println("=============퀴즈 프로그램=============");

		System.out.print("사과는 영어로 무엇일까요? (1.apple 2. 스티븐잡스) :");
		int appleAnswer = sc.nextInt();

		if (appleAnswer == 1) {
			System.out.println("정답!");
			correctAnswerCount = correctAnswerCount + 1;

		} else
			System.out.println("땡!!");

		System.out.print("바나나는 길어 길으면 기차 기차는 ? (1. 비싸 , 2. 빨라):");
		int bananaAnswer = sc.nextInt();
		if (bananaAnswer == 2) {
			System.out.println("정답!");
			++correctAnswerCount;
		} else
			System.out.println("땡!!");

		System.out.printf("총 %d 문제를 맞췄습니다.\n", correctAnswerCount);

	}

	public void ifElseTest3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=============심리테스트=============");

		System.out.print("당신은 술을 좋아하십니까?(1.yes, 2. no) :");
		int alcoholCheck = sc.nextInt();

		if (alcoholCheck == 1) {
			System.out.print("당신은 담배를 피웁니까?(1.yes, 2. no) :");
			int cigaretteCheck = sc.nextInt();
			if (cigaretteCheck == 1)
				System.out.println("담배는 건강에 좋지 않습니다.");
			else
				System.out.println("술은 간에 좋지 않습니다.");
		} else {
			System.out.print("당신은 이성 친구가 있습니까? (1.yes, 2.no) :");
			int dateCheck = sc.nextInt();
			if (dateCheck == 1)
				System.out.println("올,");
			else
				System.out.println("힘내요");
		}
	}

	public void ifElseElseExam1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=============대/소문자 변환 프로그램=============");
		System.out.print("문자 입력 :");
		char ch = sc.next().charAt(0);
		System.out.println("==========결과=========");
		if (Character.isLowerCase(ch)) {
			System.out.println("소문자를 입력하셨습니다.");
			System.out.printf("대문자로 변환 %c \n", Character.toUpperCase(ch));
		} else if (Character.isUpperCase(ch)) {

			System.out.println("대문자를 입력하셨습니다.");
			System.out.printf("소문자로 변환 %c \n", Character.toLowerCase(ch));
		} else
			System.out.println("잘못 입력하셨습니다.");

	}

	public void isElseElseExam2() {
		// 3의 배수 이면서 4의 배수
		// 3의 배수
		// 4의 배수
		// 둘다 아님
		// 0
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 :");
		int num = sc.nextInt();
		System.out.println("==========결과=========");
		if(num==0)
			System.out.printf("[%d]은(는) 3의 배수도아니고 4의 배수도 아닙니다", num);
		else if ((num % 3) == 0 && (num % 4) == 0)
			System.out.printf("[%d]은(는) 3의 배수 이면서 4의 배수 입니다.", num);
		else if (num % 3 == 0)
			System.out.printf("[%d]은(는) 3의 배수 입니다.", num);
		else if (num % 4 == 0)
			System.out.printf("[%d]은(는) 4의 배수 입니다.", num);
		else if (num != 0)
			System.out.printf("[%d]은(는) 3의 배수도아니고 4의 배수도 아닙니다", num);
			
	}
	public void switchTest() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1~3사이의 정수를 입력하세요 :");
		int num = sc.nextInt();
		
		switch(num) {
		case 1:
			System.out.println("1을 입력했습니다.");
			break;
		case 2:
			System.out.println("2를 입력했습니다.");
			break;
		case 3:
			System.out.println("3를 입력했습니다.");
			break;
		default :
			System.out.println("잘못 입력했습니다.");
		}
	}
	public void switchTest1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("일수를 알고싶은 달을 입력하세요 :");
		int num = sc.nextInt();
		
		switch(num) {

		case 2:
			System.out.printf("%d월 은(는)%d까지 있습니다.",num,29);
			break;
		case 3:
		case 4:
		case 1:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.printf("%d월 은(는)%d까지 있습니다.",num,31);
			break;
		case 6:
			System.out.printf("%d월 은(는)%d까지 있습니다.",num,30);
			break;
		case 9:
			System.out.printf("%d월 은(는)%d까지 있습니다.",num,30);
			break;
		case 11:
			System.out.printf("%d월 은(는)%d까지 있습니다.",num,30);
			break;
	
			
		default :
			System.out.println("잘못 입력했습니다.");
		}
	}
	public void switchTest2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("장학금 지불 시스템입니다. \n학점을 입력하세요 (A,B,C,D,F:)");
		char ch = sc.next().charAt(0);
		
		switch(ch) {
		case 'A':
			System.out.println("수고하셨습니다. 장학금을 100% 지급해드리겠습니다.");
			break;
		case 'B':
			System.out.println("아쉽군요 장학금을 50% 지급해드리겠습니다.");
			break;
		case 'C':
			System.out.println("장학금을 바라시면 좀더 열심히 해주세요");
			break;
		case 'D':
			System.out.println("크흠.");
			break;
		case 'F':
			System.out.println("학사경고입니다.");
			break;
		}
	}
	public void switchTest3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=============계산기=============");

		System.out.print("연산자를 입력하세요:");
		char operator = sc.next().charAt(0);
		System.out.print("첫번째 임의의 정수를 입력 하세요 :");
		int num1 = sc.nextInt();
		System.out.print("두번째 임의의 정수를 입력 하세요 :");
		int num2 = sc.nextInt();
		
		switch (operator) {
		case '+':
			System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
			break;
		case '-':
			System.out.printf("%d - %d = %d", num1, num2, num1 - num2);
			break;
		case '*':
			System.out.printf("%d * %d = %d", num1, num2, num1 * num2);
			break;
		case '/':
			System.out.printf("%d / %d = %f", num1, num2, (double) num1 / num2);
			break;
		}
		
	}
	public void switchTest4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 입력 : ");
		int num = sc.nextInt();
		char ch = 0;
		if ( !(num>100 || num < 0))
			if(90< num)
				ch = 'A';
			else if(80 < num)
				ch ='B';
			else if(70 < num)
				ch ='C';
			else if(60 < num)
				ch ='D';
			else if(60 > num)
				ch ='F';
		
		
		switch(ch) {
		case 'A':
			System.out.printf("%d점 ==> %c등급",num,ch);
			break;
		case 'B':
			System.out.printf("%d점 ==> %c등급",num,ch);
			break;
		case 'C':
			System.out.printf("%d점 ==> %c등급",num,ch);
			break;
		case 'D':
			System.out.printf("%d점 ==> %c등급",num,ch);
			break;
		case 'F':
			System.out.printf("%d점 ==> %c등급",num,ch);
			break;
		default :
			System.out.println("잘못된 입력 (0~100)사이 입력");
	/*	switch(num/10){
	 * case 9:
	 * ...
	 * 이런식으로 나누어서 사용가능
	 * 
	 * default : 
	 * if(score ==100){
	 * sysout(score +"점 ==> A등급");
	 * ...
	 * switch 안에 if문 혼합사용가능
	* 
	 */
		}
	}
	
}
