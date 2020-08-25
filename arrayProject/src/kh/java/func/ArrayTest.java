package kh.java.func;

import java.util.Random;
import java.util.Scanner;

public class ArrayTest {
	
	public void arrayTest1() {
		//���̰� 3 �� ������ �迭
		int [] arr1 = new int[3];
		
		System.out.println(arr1[0]);
		System.out.println(arr1[1]);
		System.out.println(arr1[2]);
		
		//arr�� ù��° ������100����
		arr1[0]=100;
		System.out.println(arr1[0]);
		//arr1�� �ι�° ������ 1000����
		arr1[1]=1000;
		System.out.println(arr1[1]);
		
		//���̰�5�� ������ �迭�� �����ϰ� ù���� �������� 1 , �ι����� 2... �̷������� �ʱ�ȭ
		
		int [] arr2 = new int[5];
		int [] arr3 = {1,2,3,4,5};//����5¥�� �迭 ������ �ѹ��� �ʱ�ȭ
		int [] arr4 = new int[5];
		
		for(int List_i=0;List_i<5;++List_i)
			arr2[List_i]=List_i+1;
		for(int List_i=0;List_i<5;++List_i)
			System.out.printf("arr2[%d] : %d\n",List_i,arr2[List_i]);
	}

	public void arrTest2() {
		String arr[] = {"����","������","Ű��","���","�ٳ���"};
		
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
		
		String[] strarr = {"����","����","����","�հ�"};
		for(int List_i=0;List_i<3;++List_i) {
			System.out.printf("%s���� �Է� :",strarr[List_i]);
			arr[List_i] = sc.nextInt();
			arr[3] += arr[List_i];
		}
		for(int List_i=0;List_i<4;++List_i) {
			System.out.printf("%s���� : %d\n",strarr[List_i],arr[List_i]);
		}
		System.out.printf("��� : %.2f\n",(float)arr[3]/4);
		
	}
	public void arrTest5() {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		
		for(int List_i=0;List_i<5;++List_i) {
			System.out.printf("%d��° ���� �Է� :",List_i+1);
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
			System.out.println("���� ���� ���α׷� v1.0");
			System.out.println("1.�Խ�\t2.���\t3.�溸��\t4.����");
			System.out.print("���� > ");
			sel =sc.nextInt();
			if( !(sel <= 4 && sel >= 1)) {
				System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
				continue;
			}
				
			if(sel == ENTER) {
				System.out.print("����濡 �Խ��Ͻðڽ��ϱ�?");
				roomSel=sc.nextInt();
				if( !(roomSel <= 4 && roomSel >= 1)) {
					System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
					continue;
				}
				if(existCheck[roomSel-1]==true) {
					System.out.printf("%d������ ���� �մ��� �ֽ��ϴ�.\n",roomSel);
				} else {
					existCheck[roomSel-1]=true;
					System.out.printf("%d���濡 �Խ��ϼ̽��ϴ�.\n",roomSel);
				}
			}
			else if(sel == EXIT_ROOM) {
				System.out.print("����濡�� ����Ͻðڽ��ϱ�?");
				roomSel = sc.nextInt();
				if( !(roomSel <= 4 && roomSel >= 1)) {
					System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
					continue;
				}
				if(existCheck[roomSel-1]==true) {
					System.out.printf("%d���濡�� ��� �ϼ̽��ϴ�.\n",roomSel);
					existCheck[roomSel-1]=false;
				} else {
					System.out.printf("%d������ ���� ����Դϴ�.\n",roomSel);
				}
			}
			else if(sel == ROOMS) {
				for(int List_i=0;List_i<10;++List_i) {
					if(existCheck[List_i]==true) {
						System.out.printf("%d������ ���� �մ��� �ֽ��ϴ�.\n",List_i+1);
					} else {
						System.out.printf("%d������ ���� ����ֽ��ϴ�.\n",List_i+1);
					}
				}
				
			}
			else if(sel == EXIT) {
				System.out.println("���α׷��� �����մϴ�.");
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
			System.out.println("==============�ζ� ���α׷�=================");
			
/////////////////////////////////////////////////////////////////////////////////////////
			//Inputtin users's arr
			for(int List_i=0;List_i<6;++List_i) {
				System.out.printf("%d��° ��ȣ �Է�<1~45> : ",List_i+1);
				int tempToInput = sc.nextInt();
				boolean tempForContinue=false;
				if(!(tempToInput <=45 && tempToInput>=1)) {
					System.out.println("1~45������ ���� �Է��ϼ���.");
					--List_i;
					continue;
				}
				for(int Just_j=0;Just_j<6; ++Just_j) {
					if(tempToInput == users[Just_j]) {
						System.out.println("�̹� �ߺ��� �Է��Դϴ�. �ٽ��Է����ּ���.");
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
			System.out.println("����� ��ȣ");
			for(int List_i=0;List_i<6;++List_i) {
				System.out.printf("%d ",users[List_i]);
			}
			System.out.println();
			System.out.println("��ǻ�� ��ȣ");
			for(int List_i=0;List_i<6;++List_i) {
				System.out.printf("%d ",com[List_i]);
			}
			System.out.println();
			System.out.printf("�������� : %d\n",correctCount);
			
			switch(correctCount) {
			case 0:
			case 1:
			case 2:
			case 3:
				System.out.println("��");
				break;
			case 4:
				System.out.println("3��!");
				break;
			case 5:
				System.out.println("2��!!!");
				break;
			case 6:
				System.out.println("1��!!!!!!");
				break;
			}
//////////////////////////////////////////////////////////////////////////////////////////////////
			//asking start or not
			System.out.printf("�ѹ� �� �Ͻðڽ��ϱ�<1.yes 2.no>? :");
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
