package kh.func;

import java.util.Scanner;

public class Variable {
	public void exam1() {
		//이름 , 나이 , 주소, 키, 몸무게, 성별
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요: ");
		String name = sc.next();
		
		System.out.print("나이을 입력하세요: ");
		int age = sc.nextInt();
		
		System.out.print("주소을 입력하세요: ");
		sc.nextLine();//버퍼 개행문자 제거
		String addr = sc.nextLine();

		System.out.print("키를 입력하세요: ");
		double height = sc.nextDouble();
		
		System.out.print("몸무게을 입력하세요: ");
		double weight = sc.nextDouble();
		
		System.out.println("성별 입력 (남/여) : ");
		char gender = sc.next().charAt(0);
		
		System.out.println("===============출력================");
		System.out.println("이름 :" + name);
		System.out.println("나이 :" + age);
		System.out.println("주소 :" + addr);
		System.out.println("키 :" + (int)height);
		System.out.printf("몸무게 : %.1f \n", weight);
		System.out.println("성별 :" + gender);
	}
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수 입력: ");
		int kor = sc.nextInt();
		
		System.out.print("수학 점수 입력: ");
		int math = sc.nextInt();
		System.out.print("영어 점수 입력: ");
		int eng = sc.nextInt();
		
		System.out.printf("당신 성적의 총 합은 %d 이고 평균은 %.2f 입니다!",kor+math+eng,(((double)kor+math+eng)/3.0));
	}
	
	
	public void test2() {
		String name = "김종모";
		int age = 25;
		String gender = "남자";
		String adress = "서울시 중랑구";
		String phoneNumber = "010-5906-6845";
		String email = "wa1358@naver.com";
		
		System.out.println("이름\t나이\t성별\t지역\t\t전화번호\t\t이메일");
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.printf("%s\t%d\t%s\t%s\t%s\t%s\n",name,age,gender,adress,phoneNumber,email);
	
		name = "이한석";
		age = 30;
		gender = "남자";
		adress = "서울시 관악구";
		phoneNumber = "010-1111-1111";
		email = "test@example.com";
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.printf("%s\t%d\t%s\t%7s\t%13s\t%13s\n",name,age,gender,adress,phoneNumber,email);
		
		int num = 1;
		
	}
	
	
	public void test1() {
		int num0 = 100;
		long num1 = 9999000000000L;
		float num2 = 486.520f;
		double num3 = 5697.890123;
		char num4 = 'A';
		String num5 = "Hello JAVA";
		boolean num6 = true;
		System.out.println(num0);
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(num5);
		System.out.println(num6);
	}
	public void func1() {
		boolean bool1=true;
		boolean bool2=false;
		
		char ch1 ='a';
		System.out.println(ch1);
		
		ch1 = 'b';
		System.out.println(ch1);
		
		int num = 10;
		System.out.println(num);
		
		num = 20;
		System.out.println(num);
		
		num += 10;
		System.out.println(num);
		
		double d = 3.14;
		System.out.println(d);
		
		double d2;
		//변수를 선언 후 초기화 하지 않고 사용시 에러 발생
		//	System.out.println(d2);
		d2 = 5.12;
		System.out.println(d2);
		
		long lnum = 10000000000L;
		float fNum = 3.14f;
		
		final double PI = 3.14;
		//상수형 변수는 최초 초기화 이후 값변경 불가능
		//PI = 5.12
		
		String str = "abcdef";
		System.out.println(str);
		System.out.println(str.charAt(0)); //a
		System.out.println(str.charAt(4)); //e
		char ch = str.charAt(2);
		System.out.println(ch);
		
		int num1  = 2147483647;
		long result = (long)num1 +1;//강제로 형변환 하는 케이스 1
		System.out.println(result);
		
		byte b1 = 10;
		byte b2 = 20;
		byte b3 = (byte)(b1 + b2); // 예2
		int b4 = b1 + b2 ;
		
		System.out.println("1111");
		System.out.println("2222");
		System.out.print("1111");
		System.out.print("2222");
		
	}
	public void func2() {
		//1.문자열 변수 name을 선언하여 본인 이름 대입
		String name = "김종모";
		//2.정수형 변수(age)를 선언하여 본인 나이 입력
		int age = 25;
		
		System.out.println("제 이름은 " + name + "이고 나이는 " + age +"입니다.");
		
		System.out.print("제 이름은 ");
		System.out.print(name);
		System.out.print("이고 나이는 ");
		System.out.print(age);
		System.out.println("입니다.");
		
		System.out.printf("제 이름은 %s이고 나이는 %d입니다.\n",name,age);
		
		System.out.println("제이름은 \t 김종모");
		System.out.println("제 이름은 \n 김종모");
		System.out.println("역슬레쉬 출력 \\");
		System.out.println("역슬레쉬 출력 \\");
		System.out.println("외따옴표 출력 \'");
		System.out.println("쌍따옴표 출력 \"");
	}
	
	public void scan() {
		//1. scnanner 사용방법
		//1. import java.util.Scanner
		Scanner sc = new Scanner(System.in);
		//1) 정수 입력받기
		System.out.print("정수를 입력하세요 : ");
		int temp =sc.nextInt();
		System.out.print("입력하신 값은  " +temp+"입니다.\n");

		//2) 실수 입력받기
		System.out.print("실수를 입력하세요 : ");
		float temp1 = sc.nextFloat();
		System.out.print("입력하신 값은  " +temp1+"입니다. \n");
		
		System.out.print("실수를 입력하세요 : ");
		double temp2 =sc.nextDouble();
		System.out.print("입력하신 값은  " +temp2+"입니다. \n");
		
		//3 -1 ) 문자열 입력받기
		System.out.print("문자열을 입력하세요.");
		String temp3 = sc.next();
		System.out.println("입력하신 문자열은 \"" + temp3 +"\"입니다. " );
		
		//3 -2 ) 문자열 입력받기
		System.out.println("문자열 입력하세요 : ");
		sc.nextLine();
		String temp4 = sc.nextLine();
		System.out.println("입력하신 문자열은 \"" + temp4 +"\"입니다. \n" );
		
		
		//4 ) 문자 입력받기
		System.out.print("문자를 입력하세요: ");
		char temp5 = sc.next().charAt(0);
		System.out.println(temp5);
		
		
	}
}
