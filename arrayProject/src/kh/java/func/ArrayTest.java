package kh.java.func;

import java.util.Random;
import java.util.Scanner;

public class ArrayTest {
	
	public void arrayTest1() {
		//길이가 3 인 정수형 배열
		int [] arr1 = new int[3];
		
		System.out.println(arr1[0]);
		System.out.println(arr1[1]);
		System.out.println(arr1[2]);
		
		//arr의 첫번째 공간에100대입
		arr1[0]=100;
		System.out.println(arr1[0]);
		//arr1의 두번째 공간에 1000대입
		arr1[1]=1000;
		System.out.println(arr1[1]);
		
		//길이가5인 정수형 배열을 선언하고 첫번재 공간에는 1 , 두번쨰는 2... 이런식으로 초기화
		
		int [] arr2 = new int[5];
		int [] arr3 = {1,2,3,4,5};//길이5짜리 배열 선언후 한번에 초기화
		int [] arr4 = new int[5];
		
		for(int List_i=0;List_i<5;++List_i)
			arr2[List_i]=List_i+1;
		for(int List_i=0;List_i<5;++List_i)
			System.out.printf("arr2[%d] : %d\n",List_i,arr2[List_i]);
	}

	public void arrTest2() {
		String arr[] = {"딸기","복숭아","키위","사과","바나나"};
		
		System.out.println(arr[4]);
		for(int List_i=0;List_i<5;++List_i)
			System.out.println(arr[List_i]);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
	}
	public void arrTest3() {
		int[] arr = new int[100];
		for(int List_i=0;List_i<100;++List_i)
			arr[List_i]=List_i+1;
		for(int List_i=0;List_i<100;++List_i)
			System.out.printf("arr[%d] :%d",List_i,arr[List_i]);
	}
	public void arrTest4() {
		Scanner sc = new Scanner(System.in);
		int[] arr =new int[4];
		
		String[] strarr = {"국어","영어","수학","합계"};
		for(int List_i=0;List_i<3;++List_i) {
			System.out.printf("%s점수 입력 :",strarr[List_i]);
			arr[List_i] = sc.nextInt();
			arr[3] += arr[List_i];
		}
		for(int List_i=0;List_i<4;++List_i) {
			System.out.printf("%s점수 : %d\n",strarr[List_i],arr[List_i]);
		}
		System.out.printf("평균 : %.2f\n",(float)arr[3]/4);
		
	}
	public void arrTest5() {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		
		for(int List_i=0;List_i<5;++List_i) {
			System.out.printf("%d번째 숫자 입력 :",List_i+1);
			arr[List_i] = sc.nextInt();
		}
		
		for(int List_i=0;List_i<5;++List_i) {
			for (int Just_j = 0; Just_j < 4-List_i; ++Just_j) {
				if (arr[Just_j] >= arr[Just_j+1]) {
					int temp = arr[Just_j];
					arr[Just_j] = arr[Just_j+1];
					arr[Just_j + 1] = temp;
				}
			}
		}
		
		for(int List_i=0;List_i<5;++List_i) {
			System.out.printf("%d ",arr[List_i]);
		}
		
	}
	public void arrTest6() {
		Scanner sc = new Scanner(System.in);
		boolean[] existCheck = new boolean[10];
		int sel= 0,roomSel;
		final int ENTER = 1;
		final int EXIT_ROOM = 2; 
		final int ROOMS = 3;
		final int EXIT = 4;
		while(true) {		
			System.out.println("모텔 관리 프로그램 v1.0");
			System.out.println("1.입실\t2.퇴실\t3.방보기\t4.종료");
			System.out.print("선택 > ");
			sel =sc.nextInt();
			if( !(sel <= 4 && sel >= 1)) {
				System.out.println("잘못 입력 하셨습니다.");
				continue;
			}
				
			if(sel == ENTER) {
				System.out.print("몇번방에 입실하시겠습니까?");
				roomSel=sc.nextInt();
				if( !(roomSel <= 4 && roomSel >= 1)) {
					System.out.println("잘못 입력 하셨습니다.");
					continue;
				}
				if(existCheck[roomSel-1]==true) {
					System.out.printf("%d번방은 현재 손님이 있습니다.\n",roomSel);
				} else {
					existCheck[roomSel-1]=true;
					System.out.printf("%d번방에 입실하셨습니다.\n",roomSel);
				}
			}
			else if(sel == EXIT_ROOM) {
				System.out.print("몇번방에서 퇴실하시겠습니까?");
				roomSel = sc.nextInt();
				if( !(roomSel <= 4 && roomSel >= 1)) {
					System.out.println("잘못 입력 하셨습니다.");
					continue;
				}
				if(existCheck[roomSel-1]==true) {
					System.out.printf("%d번방에서 퇴실 하셨습니다.\n",roomSel);
					existCheck[roomSel-1]=false;
				} else {
					System.out.printf("%d번방은 현재 빈방입니다.\n",roomSel);
				}
			}
			else if(sel == ROOMS) {
				for(int List_i=0;List_i<10;++List_i) {
					if(existCheck[List_i]==true) {
						System.out.printf("%d번방이 현재 손님이 있습니다.\n",List_i+1);
					} else {
						System.out.printf("%d번방이 현재 비어있습니다.\n",List_i+1);
					}
				}
				
			}
			else if(sel == EXIT) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
			
		}
	}
	public void arrTest7() {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		int users[] = new int[6];
		int com[] = new int [6];
		while(true) {
			System.out.println("==============로또 프로그램=================");
			
/////////////////////////////////////////////////////////////////////////////////////////
			//Inputtin users's arr
			for(int List_i=0;List_i<6;++List_i) {
				System.out.printf("%d번째 번호 입력<1~45> : ",List_i+1);
				int tempToInput = sc.nextInt();
				boolean tempForContinue=false;
				if(!(tempToInput <=45 && tempToInput>=1)) {
					System.out.println("1~45사이의 값을 입력하세요.");
					--List_i;
					continue;
				}
				for(int Just_j=0;Just_j<6; ++Just_j) {
					if(tempToInput == users[Just_j]) {
						System.out.println("이미 중복된 입력입니다. 다시입력해주세요.");
						tempForContinue=true;
						break;
					}
				}
				if(tempForContinue) {
					--List_i;
					continue;
				}
				users[List_i] = tempToInput;
			}
			//bubble sort
			for(int List_i=0;List_i<5;++List_i) {
				for(int Just_j=0;Just_j<5-List_i;Just_j++) {
					if(users[Just_j]>=users[Just_j+1]) {
						int temp = users[Just_j];
						users[Just_j]=users[Just_j+1];
						users[Just_j+1]= temp;
					}
				}
			}
///////////////////////////////////////////////////////////////////////////////////
			//Inputting com's arr
			for(int List_i=0;List_i<6;++List_i) {
				int tempToInput =rand.nextInt(45)+1;//1~45
				boolean tempForContinue=false;
				for(int Just_j=0;Just_j<6; ++Just_j) {
					if(tempToInput == com[Just_j]) {
						tempForContinue=true;
						break;
					}
				}
				if(tempForContinue) {
					--List_i;
					continue;
				}
				com[List_i] = tempToInput;
			}
			//com's bubble sort
			for(int List_i=0;List_i<5;++List_i) {
				for(int Just_j=0;Just_j<5-List_i;Just_j++) {
					if(com[Just_j]>=com[Just_j+1]) {
						int temp = com[Just_j];
						com[Just_j]=com[Just_j+1];
						com[Just_j+1]= temp;
					}
				}
			}
///////////////////////////////////////////////////////////////////////////////////////
			//correct Check
			int correctCount=0;
			for(int List_i=0;List_i<6;++List_i) {
				for(int Just_j=0;Just_j<6;++Just_j) {
					if(users[List_i] == com[Just_j]) {
						++correctCount;
						break;
					}
				}
			}
//////////////////////////////////////////////////////////////////////////////
			//print result
			System.out.println("사용자 번호");
			for(int List_i=0;List_i<6;++List_i) {
				System.out.printf("%d ",users[List_i]);
			}
			System.out.println();
			System.out.println("컴퓨터 번호");
			for(int List_i=0;List_i<6;++List_i) {
				System.out.printf("%d ",com[List_i]);
			}
			System.out.println();
			System.out.printf("맞은갯수 : %d\n",correctCount);
			
			switch(correctCount) {
			case 0:
			case 1:
			case 2:
			case 3:
				System.out.println("꽝");
				break;
			case 4:
				System.out.println("3등!");
				break;
			case 5:
				System.out.println("2등!!!");
				break;
			case 6:
				System.out.println("1등!!!!!!");
				break;
			}
//////////////////////////////////////////////////////////////////////////////////////////////////
			//asking start or not
			System.out.printf("한번 더 하시겠습니까<1.yes 2.no>? :");
			int sel  = sc.nextInt();
			if(sel == 2) {
				System.exit(0);
			}
//////////////////////////////////////////////////////////////////////////////////////////////////
			//for initialize to start
			for(int List_i=0;List_i<6;++List_i) {
				users[List_i]=0;
				com[List_i] =0;
			}
		}
		
	}
}
