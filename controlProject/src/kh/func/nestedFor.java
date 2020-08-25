package kh.func;

import java.util.Scanner;

public class nestedFor {
	public void forTest2() {

		for (int List_i = 1; List_i < 10; ++List_i) {

			for (int Just_j = 2; Just_j < 10; ++Just_j)
				System.out.printf("%1d * %1d = %-2d ", Just_j, List_i, List_i * Just_j); //%-2d -는 왼족으로 정렬해라 2는 공간을 2개 확보해라
			System.out.println();
		}

	}
	
	public void forExam1() {
		for(int List_i=0;List_i<5;++List_i)
			System.out.print('*');
	}
	public void forExam2() {
		for(int List_i=0;List_i<5;++List_i)
			System.out.print('*');
	}
	public void forExam3() {
		for(int List_i=0;List_i<5;++List_i) {
			for(int Just_j=0;Just_j<5;++Just_j)
				System.out.print('*');
			System.out.println();
		}
	}
	public void forExam4() {
		for(int List_i=0;List_i<5;++List_i) {
			for(int Just_j=0;Just_j<5;++Just_j)
				System.out.print(List_i);
			System.out.println();
		}
	}
	public void forExam5() {
		for(int List_i=0;List_i<5;++List_i) {
			for(int Just_j=0;Just_j<5;++Just_j)
				System.out.print(Just_j+1);
			System.out.println();
		}
	}
	public void forExam6() {
		for(int List_i=0;List_i<5;++List_i) {
			for(int Just_j=0;Just_j<5;++Just_j)
				System.out.print(Just_j+List_i);
			System.out.println();
		}
	}
	public void forExam7() {
		for(int List_i=0;List_i<5;++List_i) {
			for(int Just_j=0;Just_j<5;++Just_j)
				System.out.print(5-List_i+Just_j);
			System.out.println();
		}
	}
	public void forExam8() {
		for(int List_i=0;List_i<5;++List_i) {
			for(int Just_j=0;Just_j<5;++Just_j)
				if(List_i-Just_j >= 0)
					System.out.print('*');
			System.out.println();
		}
	}
	public void forExam9() {
		for(int List_i=0;List_i<5;++List_i) {
			for(int Just_j=0;Just_j<5-List_i;++Just_j)
				System.out.print('*');
			System.out.println();
		}
	}
	public void forExam10() {
		for(int List_i=0;List_i<5;++List_i) {
			for(int Just_j=0;Just_j<5;++Just_j)
				if(Just_j - List_i >= 0) {
					System.out.print('*');
				}
				else{
					System.out.print(" ");
				}
			System.out.println();
		}
	}
	public void forExam11() {
		for(int List_i=0;List_i<5;++List_i) {
			for(int Just_j=0;Just_j<5;++Just_j)
				if(Just_j + List_i >= 4) {
					System.out.print('*');
				}
				else{
					System.out.print(" ");
				}
			System.out.println();
		}
	}
	public void forExam12() {
		boolean center = false;
		for(int List_i=0;List_i!=-1;)
		{
			for(int Just_j=0;Just_j<5;++Just_j)
				if(List_i - Just_j >0) {
					System.out.print("*");
				}
				else{
					System.out.print(" ");
				}
			System.out.println();
			if(List_i==5)
				center=true;
			if(center)
				--List_i;
			else
				++List_i;
		}
	}
	public void forExam13() {
		boolean center = false;
		for(int List_i=1;List_i != 0;)
		{
			for (int Just_j = 0; Just_j < 5 ; ++Just_j) {
				if (5-List_i - Just_j < 0) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}

			System.out.println();
			if(List_i==5)
				center=true;
			if(center)
				--List_i;
			else
				++List_i;
		}
	}
	public void forWhileTest1() {
//		for(;;) {
//			System.out.println("e");
//		}
//		
//		while(true) {
//			System.out.println("e");
//		}
		Scanner sc = new Scanner(System.in);
		
		for(int List_i=0;List_i<5;++List_i) {
			System.out.println("Hello");
			System.out.println("숫자입력 (1을 입력하면 그만 출력함): ");
			int sel =  sc.nextInt();
			
			if(sel==1) {
				System.out.println("1입력 break; 실행");
				break;//반복문종료
			}
			else if(sel==2) {
				System.out.println("2 입력 continue; 실행");
				continue;//while문에서는 최상단,for문에서는 증감문으로 이동한다.
			} else
				System.out.println("1,2 둘다 실행되입력하지 않은경우");
			
			System.out.println("for문 제일 하단");
		}
	
	}



	public void forWhileTest2() {
		for (int List_i = 0; List_i < 6; ++List_i) {
			System.out.println(List_i + ". 외부 for문");
			for (int Just_j = 0; Just_j < 6; ++Just_j) {
				if (List_i == 3) {
					break;
				}
				System.out.println(Just_j + ". 내부 for문");
			}

		}

	}
}