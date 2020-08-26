package kh.java.func;

import java.util.Random;
import java.util.Scanner;

public class ArrayTest {

	public void arrayTest1() {
		// ���̰� 3 �� ������ �迭
		int[] arr1 = new int[3];

		System.out.println(arr1[0]);
		System.out.println(arr1[1]);
		System.out.println(arr1[2]);

		// arr�� ù��° ������100����
		arr1[0] = 100;
		System.out.println(arr1[0]);
		// arr1�� �ι�° ������ 1000����
		arr1[1] = 1000;
		System.out.println(arr1[1]);

		// ���̰�5�� ������ �迭�� �����ϰ� ù���� �������� 1 , �ι����� 2... �̷������� �ʱ�ȭ

		int[] arr2 = new int[5];
		int[] arr3 = { 1, 2, 3, 4, 5 };// ����5¥�� �迭 ������ �ѹ��� �ʱ�ȭ
		int[] arr4 = new int[5];

		for (int List_i = 0; List_i < 5; ++List_i)
			arr2[List_i] = List_i + 1;
		for (int List_i = 0; List_i < 5; ++List_i)
			System.out.printf("arr2[%d] : %d\n", List_i, arr2[List_i]);
	}

	public void arrTest2() {
		String arr[] = { "����", "������", "Ű��", "���", "�ٳ���" };

		System.out.println(arr[4]);
		for (int List_i = 0; List_i < 5; ++List_i)
			System.out.println(arr[List_i]);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
	}

	public void arrTest3() {
		int[] arr = new int[100];
		for (int List_i = 0; List_i < 100; ++List_i)
			arr[List_i] = List_i + 1;
		for (int List_i = 0; List_i < 100; ++List_i)
			System.out.printf("arr[%d] :%d", List_i, arr[List_i]);
	}

	public void arrTest4() {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[4];

		String[] strarr = { "����", "����", "����", "�հ�" };
		for (int List_i = 0; List_i < 3; ++List_i) {
			System.out.printf("%s���� �Է� :", strarr[List_i]);
			arr[List_i] = sc.nextInt();
			arr[3] += arr[List_i];
		}
		for (int List_i = 0; List_i < 4; ++List_i) {
			System.out.printf("%s���� : %d\n", strarr[List_i], arr[List_i]);
		}
		System.out.printf("��� : %.2f\n", (float) arr[3] / 4);

	}

	public void arrTest5() {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];

		for (int List_i = 0; List_i < 5; ++List_i) {
			System.out.printf("%d��° ���� �Է� :", List_i + 1);
			arr[List_i] = sc.nextInt();
		}

		for (int List_i = 0; List_i < 5; ++List_i) {
			for (int Just_j = 0; Just_j < 4 - List_i; ++Just_j) {
				if (arr[Just_j] >= arr[Just_j + 1]) {
					int temp = arr[Just_j];
					arr[Just_j] = arr[Just_j + 1];
					arr[Just_j + 1] = temp;
				}
			}
		}

		for (int List_i = 0; List_i < 5; ++List_i) {
			System.out.printf("%d ", arr[List_i]);
		}

	}

	public void arrTest6() {
		Scanner sc = new Scanner(System.in);
		boolean[] existCheck = new boolean[10];
		int sel = 0, roomSel;
		final int ENTER = 1;
		final int EXIT_ROOM = 2;
		final int ROOMS = 3;
		final int EXIT = 4;
		while (true) {
			System.out.println("���� ���� ���α׷� v1.0");
			System.out.println("1.�Խ�\t2.���\t3.�溸��\t4.����");
			System.out.print("���� > ");
			sel = sc.nextInt();
			if (!(sel <= 4 && sel >= 1)) {
				System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
				continue;
			}

			if (sel == ENTER) {
				System.out.print("����濡 �Խ��Ͻðڽ��ϱ�?");
				roomSel = sc.nextInt();
				if (!(roomSel <= 4 && roomSel >= 1)) {
					System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
					continue;
				}
				if (existCheck[roomSel - 1] == true) {
					System.out.printf("%d������ ���� �մ��� �ֽ��ϴ�.\n", roomSel);
				} else {
					existCheck[roomSel - 1] = true;
					System.out.printf("%d���濡 �Խ��ϼ̽��ϴ�.\n", roomSel);
				}
			} else if (sel == EXIT_ROOM) {
				System.out.print("����濡�� ����Ͻðڽ��ϱ�?");
				roomSel = sc.nextInt();
				if (!(roomSel <= 4 && roomSel >= 1)) {
					System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
					continue;
				}
				if (existCheck[roomSel - 1] == true) {
					System.out.printf("%d���濡�� ��� �ϼ̽��ϴ�.\n", roomSel);
					existCheck[roomSel - 1] = false;
				} else {
					System.out.printf("%d������ ���� ����Դϴ�.\n", roomSel);
				}
			} else if (sel == ROOMS) {
				for (int List_i = 0; List_i < 10; ++List_i) {
					if (existCheck[List_i] == true) {
						System.out.printf("%d������ ���� �մ��� �ֽ��ϴ�.\n", List_i + 1);
					} else {
						System.out.printf("%d������ ���� ����ֽ��ϴ�.\n", List_i + 1);
					}
				}

			} else if (sel == EXIT) {
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}

		}
	}

	public void arrTest7() {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		int users[] = new int[6];
		int com[] = new int[6];
		while (true) {
			System.out.println("==============�ζ� ���α׷�=================");

/////////////////////////////////////////////////////////////////////////////////////////
			// Inputtin users's arr
			for (int List_i = 0; List_i < 6; ++List_i) {
				System.out.printf("%d��° ��ȣ �Է�<1~45> : ", List_i + 1);
				int tempToInput = sc.nextInt();
				boolean tempForContinue = false;
				if (!(tempToInput <= 45 && tempToInput >= 1)) {
					System.out.println("1~45������ ���� �Է��ϼ���.");
					--List_i;
					continue;
				}
				for (int Just_j = 0; Just_j < 6; ++Just_j) {
					if (tempToInput == users[Just_j]) {
						System.out.println("�̹� �ߺ��� �Է��Դϴ�. �ٽ��Է����ּ���.");
						tempForContinue = true;
						break;
					}
				}
				if (tempForContinue) {
					--List_i;
					continue;
				}
				users[List_i] = tempToInput;
			}
			// bubble sort
			for (int List_i = 0; List_i < 5; ++List_i) {
				for (int Just_j = 0; Just_j < 5 - List_i; Just_j++) {
					if (users[Just_j] >= users[Just_j + 1]) {
						int temp = users[Just_j];
						users[Just_j] = users[Just_j + 1];
						users[Just_j + 1] = temp;
					}
				}
			}
///////////////////////////////////////////////////////////////////////////////////
			// Inputting com's arr
			for (int List_i = 0; List_i < 6; ++List_i) {
				int tempToInput = rand.nextInt(45) + 1;// 1~45
				boolean tempForContinue = false;
				for (int Just_j = 0; Just_j < 6; ++Just_j) {
					if (tempToInput == com[Just_j]) {
						tempForContinue = true;
						break;
					}
				}
				if (tempForContinue) {
					--List_i;
					continue;
				}
				com[List_i] = tempToInput;
			}
			// com's bubble sort
			for (int List_i = 0; List_i < 5; ++List_i) {
				for (int Just_j = 0; Just_j < 5 - List_i; Just_j++) {
					if (com[Just_j] >= com[Just_j + 1]) {
						int temp = com[Just_j];
						com[Just_j] = com[Just_j + 1];
						com[Just_j + 1] = temp;
					}
				}
			}
///////////////////////////////////////////////////////////////////////////////////////
			// correct Check
			int correctCount = 0;
			for (int List_i = 0; List_i < 6; ++List_i) {
				for (int Just_j = 0; Just_j < 6; ++Just_j) {
					if (users[List_i] == com[Just_j]) {
						++correctCount;
						break;
					}
				}
			}
//////////////////////////////////////////////////////////////////////////////
			// print result
			System.out.println("����� ��ȣ");
			for (int List_i = 0; List_i < 6; ++List_i) {
				System.out.printf("%d ", users[List_i]);
			}
			System.out.println();
			System.out.println("��ǻ�� ��ȣ");
			for (int List_i = 0; List_i < 6; ++List_i) {
				System.out.printf("%d ", com[List_i]);
			}
			System.out.println();
			System.out.printf("�������� : %d\n", correctCount);

			switch (correctCount) {
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
			// asking start or not
			System.out.printf("�ѹ� �� �Ͻðڽ��ϱ�<1.yes 2.no>? :");
			int sel = sc.nextInt();
			if (sel == 2) {
				System.exit(0);
			}
//////////////////////////////////////////////////////////////////////////////////////////////////
			// for initialize to start
			for (int List_i = 0; List_i < 6; ++List_i) {
				users[List_i] = 0;
				com[List_i] = 0;
			}
		}

	}

	public void arrCopy() {
		int[] arr = { 1, 2, 3, 4, 5 };
		int[] arr1 = arr; // ��������
		int[] arr2 = new int[5]; // �������縦 �ϱ����� ����
		for (int List_i = 0; List_i < arr2.length; ++List_i) {
			arr2[List_i] = arr[List_i];
		}
		int[] arr3 = new int[5];
		arr3 = arr.clone(); // clone�� ���� ���� ���� �迭 ��ä������

		int[] arr4 = new int[5];
		System.arraycopy(arr, 0, arr4, 0, arr.length);// arrraycopy�� ���� ��������

		for (int List_i = 0; List_i < arr.length; ++List_i) {
			System.out.println(arr[List_i] + "\t");
		}

		for (int List_i = 0; List_i < arr1.length; ++List_i) {
			System.out.println(arr[List_i] + "\t");
		}
	}

	public void arrTest8() {
		String originNumber;
		char[] coveredNumber = new char[13];
		char[] cover = { '*', '*', '*', '*' };
		Scanner sc = new Scanner(System.in);
		System.out.print("��ȭ��ȣ�� �Է����ּ���");
		originNumber = sc.next();

		for (int List_i = 0; List_i < originNumber.length(); ++List_i) {
			coveredNumber[List_i] = originNumber.charAt(List_i);
		}

		System.arraycopy(cover, 0, coveredNumber, 4, cover.length);
		System.out.print("originNumber :" + originNumber);
		System.out.println();
		System.out.print("coveredNumber :");
		for (int List_i = 0; List_i < coveredNumber.length; ++List_i) {
			System.out.print(coveredNumber[List_i]);
		}
		System.out.println();
	}

	public void arrTest9() {
		String originNumber;
		char[] coveredNumber = new char[14];
		char[] cover = { '*', '*', '*', '*', '*', '*' };
		Scanner sc = new Scanner(System.in);
		System.out.print("�ֹι�ȣ�� �Է����ּ���");
		originNumber = sc.next();

		for (int List_i = 0; List_i < originNumber.length(); ++List_i) {
			coveredNumber[List_i] = originNumber.charAt(List_i);
		}

		System.arraycopy(cover, 0, coveredNumber, 8, cover.length);
		System.out.print("originNumber :" + originNumber);
		System.out.println();
		System.out.print("coveredNumber :");
		for (int List_i = 0; List_i < coveredNumber.length; ++List_i) {
			System.out.print(coveredNumber[List_i]);
		}
		System.out.println();
	}

	public void arrTest10() {
		int[][] arr = new int[2][2];
		arr[0][0] = 4;
		arr[0][1] = 3;
		arr[1][0] = 2;
		arr[1][1] = 1;
		for (int List_i = 0; List_i < arr.length; ++List_i) {
			for (int Just_j = 0; Just_j < arr[List_i].length; ++Just_j) {
				System.out.print(arr[List_i][Just_j] + " ");
			}
			System.out.println();
		}
	}

	public void arrExam1() {
		int[][] arr = new int[5][5];
		int k = 1;
		for (int List_i = 0; List_i < arr.length; ++List_i) {
			for (int Just_j = 0; Just_j < arr[List_i].length; ++Just_j) {
				arr[List_i][Just_j] = 5 * (List_i + 1) - Just_j;
			}
		}

		for (int List_i = 0; List_i < arr.length; ++List_i) {
			for (int Just_j = 0; Just_j < arr[List_i].length; ++Just_j) {
				System.out.print(arr[List_i][Just_j] + "\t");
			}
			System.out.println();
		}
	}

	public void arrExam2() {
		int[][] arr = new int[5][5];
		int k = 1;
		for (int List_i = 0; List_i < arr.length; ++List_i) {
			for (int Just_j = 0; Just_j < arr[List_i].length; ++Just_j) {
				arr[List_i][Just_j] = List_i + 1 + (Just_j) * 5;
			}
		}

		for (int List_i = 0; List_i < arr.length; ++List_i) {
			for (int Just_j = 0; Just_j < arr[List_i].length; ++Just_j) {
				System.out.print(arr[List_i][Just_j] + "\t");
			}
			System.out.println();
		}
	}

	public void arrExam3() {
		int[][] arr = new int[5][5];
		int k = 1;
		for (int List_i = 0; List_i < arr.length; ++List_i) {
			for (int Just_j = 0; Just_j < arr[List_i].length; ++Just_j) {
				arr[List_i][Just_j] = (5 - List_i) + (Just_j) * 5;
			}
		}

		for (int List_i = 0; List_i < arr.length; ++List_i) {
			for (int Just_j = 0; Just_j < arr[List_i].length; ++Just_j) {
				System.out.print(arr[List_i][Just_j] + "\t");
			}
			System.out.println();
		}
	}

	public void arrExam4() {
		int[][] arr = new int[5][5];
		int k = 1;
		boolean check = false;
		for (int List_i = 0; List_i < arr.length; ++List_i) {
			for (int Just_j = 0; Just_j < arr[List_i].length; ++Just_j) {
				if (check) {
					arr[List_i][Just_j] = 10 * (List_i - List_i / 2) - Just_j;

				} else {
					arr[List_i][Just_j] = 10 * (List_i - List_i / 2) + Just_j + 1;

				}
			}
			check = !check;
		}

		for (int List_i = 0; List_i < arr.length; ++List_i) {
			for (int Just_j = 0; Just_j < arr[List_i].length; ++Just_j) {
				System.out.print(arr[List_i][Just_j] + "\t");
			}
			System.out.println();
		}
	}

	public void arrExam5() {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int arrVerSize, arrHorSize;

		while (true) {
			System.out.print("�������� ������ �Է��ϼ���(1~10) ==>");
			arrVerSize = sc.nextInt();
			if ((arrVerSize <= 10 && arrVerSize >= 1)) {
				break;
			}
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
		while (true) {
			System.out.print("���ο��� ������ �Է��ϼ���(1~10) ==>");
			arrHorSize = sc.nextInt();
			if (arrHorSize <= 10 && arrHorSize >= 1) {
				break;
			}
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
		char[][] table = new char[arrVerSize][arrHorSize];
		for (int List_i = 0; List_i < arrVerSize; ++List_i) {
			for (int Just_j = 0; Just_j < arrHorSize; ++Just_j) {
				int tempForRand = rand.nextInt(97);
				if (Character.isAlphabetic((char) tempForRand)) {
					table[List_i][Just_j] = Character.toLowerCase((char) tempForRand);
				} else {
					--Just_j;
					continue;
				}
			}
		}

		for (int List_i = 0; List_i < arrVerSize; ++List_i) {
			for (int Just_j = 0; Just_j < arrHorSize; ++Just_j) {
				System.out.print(table[List_i][Just_j] + " ");
			}
			System.out.println();
		}
	}

	public void arrExam6LeftStart() {
		Scanner sc = new Scanner(System.in);
		/*
		 * 2���� �迭�� ������ ������ �����Ͽ� 1���� �÷��̾ ���������θ� �����δٰ� �����Ѵ�. �׸��� �������⿡�� ���̳� ������ �� �����ٸ�
		 * 90���� ���� �����Ѵ�. ���������� �������� 1�� �����ؼ� �迭�� �Է��Ѵ�.
		 */
		System.out.println("2���� �迭 ũ�� �Է�(������)");
		int arrSize = sc.nextInt();
		int[][] arr = new int[arrSize][arrSize];
		/*
		 * arrSize�� ������ �� �迭�� ���� �̰� �迭�� ��� �ɾ�� �ϹǷ� arrSize ������ŭ �����Ѵ�
		 */
		final int DEGREE_UP = 1;
		final int DEGREE_DOWN = 2;
		final int DEGREE_LEFT = 3; // ���� ����
		final int DEGREE_RIGHT = 4; // ������ ����
		final int LIMIT_UP_LINE = -1;
		final int LIMIT_DOWN_LINE = arrSize;
		final int LIMIT_LEFT_LINE = -1;
		final int LIMIT_RIGHT_LINE = arrSize;
		int status = DEGREE_UP;
		int X_AXIS = 0;
		int Y_AXIS = 0;
		boolean UpStop = false;
		boolean LeftStop = false;
		boolean RightStop = false;
		boolean DownStop = false;
/////////////////////////////////////////////////////////////////////////////
		// STATUS�� ���� �����̴� ����
		for (int List_i = 0; List_i < arr.length * arr.length; ++List_i) {
			// ����� �������̸� �� �ڸ��� ������ �ڸ� �̹Ƿ� ���� �ְ� ���� ����
			if (RightStop && LeftStop && UpStop && DownStop) {
				arr[Y_AXIS][X_AXIS] = List_i + 1;
				break;
			}
			// �� �Ǵ� ������ ������ üũ�ϰ� �´ٸ� ���� �ִºκ�
			if (status == DEGREE_UP) {
				if (Y_AXIS - 1 == LIMIT_UP_LINE) {
					status = DEGREE_RIGHT;
					--List_i;
					UpStop = true;
					continue;

				}
				if (!(arr[Y_AXIS - 1][X_AXIS] == 0)) {
					status = DEGREE_RIGHT;
					--List_i;
					UpStop = true;
					continue;
				}
				arr[Y_AXIS--][X_AXIS] = List_i + 1;
			} else if (status == DEGREE_DOWN) {
				if (Y_AXIS + 1 == LIMIT_DOWN_LINE) {
					status = DEGREE_LEFT;
					--List_i;
					DownStop = true;
					continue;
				}
				if (!(arr[Y_AXIS + 1][X_AXIS] == 0)) {
					status = DEGREE_LEFT;
					--List_i;
					DownStop = true;
					continue;
				}
				arr[Y_AXIS++][X_AXIS] = List_i + 1;
			} else if (status == DEGREE_LEFT) {
				if (X_AXIS - 1 == LIMIT_LEFT_LINE) {
					status = DEGREE_UP;
					--List_i;
					LeftStop = true;
					continue;
				}
				if (!(arr[Y_AXIS][X_AXIS - 1] == 0)) {
					status = DEGREE_UP;
					--List_i;
					LeftStop = true;
					continue;
				}
				arr[Y_AXIS][X_AXIS--] = List_i + 1;
			}

			else if (status == DEGREE_RIGHT) {
				if (X_AXIS + 1 == LIMIT_RIGHT_LINE) {
					status = DEGREE_DOWN;
					--List_i;
					RightStop = true;
					continue;
				}
				if (!(arr[Y_AXIS][X_AXIS + 1] == 0)) {
					status = DEGREE_DOWN;
					--List_i;
					RightStop = true;
					continue;
				}
				arr[Y_AXIS][X_AXIS++] = List_i + 1;
			}

			// �߰����� �Ű������� ���� ���� �ʱ�ȭ
			RightStop = false;
			LeftStop = false;
			DownStop = false;
			UpStop = false;
		}
///////////////////////////////////////////////////////////////////////

		for (int List_i = 0; List_i < arr.length; ++List_i) {
			for (int Just_j = 0; Just_j < arr.length; ++Just_j) {
				System.out.print(arr[List_i][Just_j] + "\t");
			}
			System.out.println();
		}
	}

	public void arrExam6RightStart() {
		Scanner sc = new Scanner(System.in);
		/*
		 * 2���� �迭�� ������ ������ �����Ͽ� 1���� �÷��̾ ���������θ� �����δٰ� �����Ѵ�. �׸��� �������⿡�� ���̳� ������ �� �����ٸ�
		 * 90���� ���� �����Ѵ�. ���������� �������� 1�� �����ؼ� �迭�� �Է��Ѵ�.
		 */
		System.out.println("2���� �迭 ũ�� �Է�(������)");
		int arrSize = sc.nextInt();
		int[][] arr = new int[arrSize][arrSize];
		/*
		 * arrSize�� ������ �� �迭�� ���� �̰� �迭�� ��� �ɾ�� �ϹǷ� arrSize ������ŭ �����Ѵ�
		 */
		final int DEGREE_UP = 1;
		final int DEGREE_DOWN = 2;
		final int DEGREE_LEFT = 3; // ���� ����
		final int DEGREE_RIGHT = 4; // ������ ����
		final int LIMIT_UP_LINE = -1;
		final int LIMIT_DOWN_LINE = arrSize;
		final int LIMIT_LEFT_LINE = -1;
		final int LIMIT_RIGHT_LINE = arrSize;
		int status = DEGREE_LEFT;
		int X_AXIS = arrSize - 1;
		int Y_AXIS = 0;
		boolean UpStop = false;
		boolean LeftStop = false;
		boolean RightStop = false;
		boolean DownStop = false;
/////////////////////////////////////////////////////////////////////////////
		// STATUS�� ���� �����̴� ����
		for (int List_i = 0; List_i < arr.length * arr.length; ++List_i) {
			// ����� �������̸� �� �ڸ��� ������ �ڸ� �̹Ƿ� ���� �ְ� ���� ����
			if (RightStop && LeftStop && UpStop && DownStop) {
				arr[Y_AXIS][X_AXIS] = List_i + 1;
				break;
			}
			// �� �Ǵ� ������ ������ üũ�ϰ� �´ٸ� ���� �ִºκ�
			if (status == DEGREE_UP) {
				if (Y_AXIS - 1 == LIMIT_UP_LINE) {
					status = DEGREE_RIGHT;
					--List_i;
					UpStop = true;
					continue;

				}
				if (!(arr[Y_AXIS - 1][X_AXIS] == 0)) {
					status = DEGREE_RIGHT;
					--List_i;
					UpStop = true;
					continue;
				}
				arr[Y_AXIS--][X_AXIS] = List_i + 1;
			} else if (status == DEGREE_DOWN) {
				if (Y_AXIS + 1 == LIMIT_DOWN_LINE) {
					status = DEGREE_LEFT;
					--List_i;
					DownStop = true;
					continue;
				}
				if (!(arr[Y_AXIS + 1][X_AXIS] == 0)) {
					status = DEGREE_LEFT;
					--List_i;
					DownStop = true;
					continue;
				}
				arr[Y_AXIS++][X_AXIS] = List_i + 1;
			} else if (status == DEGREE_LEFT) {
				if (X_AXIS - 1 == LIMIT_LEFT_LINE) {
					status = DEGREE_UP;
					--List_i;
					LeftStop = true;
					continue;
				}
				if (!(arr[Y_AXIS][X_AXIS - 1] == 0)) {
					status = DEGREE_UP;
					--List_i;
					LeftStop = true;
					continue;
				}
				arr[Y_AXIS][X_AXIS--] = List_i + 1;
			}

			else if (status == DEGREE_RIGHT) {
				if (X_AXIS + 1 == LIMIT_RIGHT_LINE) {
					status = DEGREE_DOWN;
					--List_i;
					RightStop = true;
					continue;
				}
				if (!(arr[Y_AXIS][X_AXIS + 1] == 0)) {
					status = DEGREE_DOWN;
					--List_i;
					RightStop = true;
					continue;
				}
				arr[Y_AXIS][X_AXIS++] = List_i + 1;
			}

			// �߰����� �Ű������� ���� ���� �ʱ�ȭ
			RightStop = false;
			LeftStop = false;
			DownStop = false;
			UpStop = false;
		}
///////////////////////////////////////////////////////////////////////

		for (int List_i = 0; List_i < arr.length; ++List_i) {
			for (int Just_j = 0; Just_j < arr.length; ++Just_j) {
				System.out.print(arr[List_i][Just_j] + "\t");
			}
			System.out.println();
		}
	}
	public void arrTest11() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�� ũ�� �Է� :");
		int mapSize = sc.nextInt();
		int [][] map1 =new int[mapSize][mapSize];
		int [][] map2 =new int[mapSize][mapSize];
		char[][] map = new char[mapSize][mapSize];
		
////////////////////////////////////////////////////////////////////////////////
		//ù��° �迭 �Է�
		System.out.println("ù��° �迭 ���� �Է�");
		for(int List_i=0;List_i<map1.length;++List_i) {
			System.out.printf("%d��° �� ���� �Է�(����0~%d) :",List_i+1,(int)Math.pow(2, mapSize-1)-1);
			int inputNumber = sc.nextInt();
			for(int Just_j=0;Just_j<map1[List_i].length;++Just_j) {
				map1[List_i][(mapSize-1)-Just_j] = inputNumber%2;
				inputNumber /= 2;
			}
		}
		for(int List_i=0;List_i<map1.length;++List_i) {
			for(int Just_j=0;Just_j<map1[List_i].length;++Just_j) {
				System.out.print(map1[List_i][Just_j]+"");
			}
			System.out.println();
		}
////////////////////////////////////////////////////////////////////////////////////
		//�ι�° �迭 �Է�
		System.out.println();
		System.out.println("�ι�° �迭 ���� �Է�");
		for(int List_i=0;List_i<map2.length;++List_i) {
			System.out.printf("%d��° �� ���� �Է�(����0~%d) :",List_i+1,(int)Math.pow(2, mapSize-1)-1);
			int inputNumber = sc.nextInt();
			for(int Just_j=0;Just_j<map2[List_i].length;++Just_j) {
				map2[List_i][(mapSize-1)-Just_j] = inputNumber%2;
				inputNumber /= 2;
			}
		}
		for(int List_i=0;List_i<map2.length;++List_i) {
			for(int Just_j=0;Just_j<map2[List_i].length;++Just_j) {
				System.out.print(map2[List_i][Just_j]+"");
			}
			System.out.println();
		}
////////////////////////////////////////////////////////////////////////////
		for(int List_i=0; List_i<map.length;++List_i) {
			for(int Just_j = 0 ; Just_j<map.length;++Just_j) {
				if(map1[List_i][Just_j]==1 || map2[List_i][Just_j]==1) {
					map[List_i][Just_j]='#';
				}else {
					map[List_i][Just_j]=' ';
				}
			}
		}
		for(int List_i=0;List_i<map.length;++List_i) {
			for(int Just_j=0;Just_j<map.length;++Just_j) {
				System.out.print(map[List_i][Just_j]+" ");
			}
			System.out.println();
		}
	}
	public void arrTest12() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�� ũ�� �Է� :");
		int mapSize = sc.nextInt();
		boolean [][] map1 =new boolean[mapSize][mapSize];
		boolean [][] map2 =new boolean[mapSize][mapSize];
		char[][] map = new char[mapSize][mapSize];
		
////////////////////////////////////////////////////////////////////////////////
		//ù��° �迭 �Է�
		System.out.println("ù��° �迭 ���� �Է�");
		for(int List_i=0;List_i<map1.length;++List_i) {
			System.out.printf("%d��° �� ���� �Է�(����0~%d) :",List_i+1,(int)Math.pow(2, mapSize-1)-1);
			int inputNumber = sc.nextInt();
			for(int Just_j=0;Just_j<map1[List_i].length;++Just_j) {
				map1[List_i][(mapSize-1)-Just_j] = ((inputNumber%2)==0) ? false : true;
				inputNumber /= 2;
			}
		}
		for(int List_i=0;List_i<map1.length;++List_i) {
			for(int Just_j=0;Just_j<map1[List_i].length;++Just_j) {
				System.out.print(map1[List_i][Just_j]+"");
			}
			System.out.println();
		}
////////////////////////////////////////////////////////////////////////////////////
		//�ι�° �迭 �Է�
		System.out.println();
		System.out.println("�ι�° �迭 ���� �Է�");
		for(int List_i=0;List_i<map2.length;++List_i) {
			System.out.printf("%d��° �� ���� �Է�(����0~%d) :",List_i+1,(int)Math.pow(2, mapSize-1)-1);
			int inputNumber = sc.nextInt();
			for(int Just_j=0;Just_j<map2[List_i].length;++Just_j) {
				map2[List_i][(mapSize-1)-Just_j] = (inputNumber%2==0) ? false: true;
				inputNumber /= 2;
			}
		}
		for(int List_i=0;List_i<map2.length;++List_i) {
			for(int Just_j=0;Just_j<map2[List_i].length;++Just_j) {
				System.out.print(map2[List_i][Just_j]+"");
			}
			System.out.println();
		}
////////////////////////////////////////////////////////////////////////////
		for(int List_i=0; List_i<map.length;++List_i) {
			for(int Just_j = 0 ; Just_j<map.length;++Just_j) {
				map[List_i][Just_j] = (map1[List_i][Just_j] | map2[List_i][Just_j]) ? '#' : ' '; 
			}
		}
		for(int List_i=0;List_i<map.length;++List_i) {
			for(int Just_j=0;Just_j<map.length;++Just_j) {
				System.out.print(map[List_i][Just_j]+" ");
			}
			System.out.println();
		}
	}
}
