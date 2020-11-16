package kh.java.func;

import java.util.Random;
import java.util.Scanner;

public class RandomTest {
	public void randomTest1() {
		Random r = new Random();

		int num2 = r.nextInt(10); // 0~10
		int num3 = r.nextInt(15); // 0~14
		int num4 = r.nextInt(2); // 0~1

		int num5 = r.nextInt(10) + 1; // 1���� 10 ������ �������ڸ� ������ ������ ����
		int num6 = r.nextInt(16) + 20; // 20~35

		System.out.println(num5);

	}

	public void guessCoin() {
		Random r = new Random();
		Scanner d = new Scanner(System.in);
		System.out.println("===���� �� �� ���߱� ===");
		System.out.print("���ڸ� �Է����ּ���(1.�ո�/2.�޸�): ");
		int sel = d.nextInt();

		if ((r.nextInt(2) + 1) == sel) {
			System.out.println("�¾ҽ��ϴ�.");
		} else {
			System.out.println("�� ! Ʋ�Ƚ��ϴ�");
		}
	}

	public void rockScissorsPaper() {
		final int SCISSORS = 1;
		final int ROCK = 2;
		final int PAPER = 3;
		Random r = new Random();
		Scanner d = new Scanner(System.in);
		String User = "����";
		while (true) {
			System.out.println("===���������� ����===");
			System.out.print("���ڸ����� �ϼ���(1.����2.����3.��) :");
			int user = d.nextInt();
			int versus = r.nextInt(3) + 1;
			// ���� > ��, ��> �ָ�, �ָ� > ����
			// ����� �� 9�� �� 3���� ������� �ָ�,����,��
			// ������ 6��
			// (����, ����), (����, ��)
			// (����, ��), (����,����)
			// (��, ����),(��, ����),
			if (user == ROCK) {
				System.out.println("����ڴ� �ָ��� �½��ϴ�.");
			} else if (user == PAPER) {
				System.out.println("����ڴ� ���� �½��ϴ�.");
			} else if (user == SCISSORS) {
				System.out.println("����ڴ� ������ �½��ϴ�");
			} else {
				System.out.println("����ڴ� �߸��� ���� �Է��߽��ϴ�.");
			}

			if (versus == ROCK) {
				System.out.println("��ǻ�ʹ� �ָ��� �½��ϴ�.");
			} else if (versus == PAPER) {
				System.out.println("��ǻ�ʹ� ���� �½��ϴ�.");
			} else if (versus == SCISSORS) {
				System.out.println("��ǻ�ʹ� ������ �½��ϴ�");
			}

			if (user == versus) {
				System.out.println("���º�");
			} else if ((user == SCISSORS && versus == ROCK) || (user == ROCK && versus == PAPER)
					|| user == PAPER && versus == SCISSORS) { // user�� �����
				System.out.println("����� �����ϴ�.");

			} else if ((user == SCISSORS && versus == PAPER) || (user == ROCK && versus == SCISSORS)
					|| (user == PAPER && versus == ROCK)) { // user�� �̱���
				System.out.println("����� �̰���ϴ�.");
			}
			System.out.println("�ٽ� �Ͻðڽ��ϱ�? (1. ���, 2. ����) :");
			if (d.nextInt() == 2) {
				break;
			}
		}
	}

	public void DiceGame() {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		final int START = 1;
		final int SCORE = 2;
		final int END = 3;
		int wallet = 10000;
		int bet = 0;
		int sel = 0;
		int winCount = 0, loseCount = 0, drawCount = 0;
		String Sel;
		int dice, totalDice = 0;
		int comTotalDice = 0;
		while (true) {
			System.out.println("==DICE GAME==");
			System.out.println("1.Game Start");
			System.out.println("2.Game Score");
			System.out.println("3.End Game");
			System.out.print(">");
			sel = sc.nextInt();

			if (sel == START) {
				while (true) {
					if (wallet <= 0) {
						System.out.println("�ܾ��� �����ϴ�. bye");
						break;
					}
					for (int List_i = 0; List_i < 3; ++List_i) {
						dice = rand.nextInt(6) + 1;
						System.out.printf("%d ���� �ֻ��� �� : %d\n", List_i + 1, dice);
						totalDice += dice;
					}
					System.out.printf("�� �ֻ��� �� : %d \n", totalDice);
					System.out.print("������ �Ͻðڽ��ϱ�? (y/n)");
					if (sc.next().charAt(0) == 'y') {
						System.out.printf("�󸶸� �����Ͻðڽ��ϱ�? (���� �� ������ %d ��): ", wallet);
						bet = sc.nextInt();
						for (int List_i = 0; List_i < 3; ++List_i) {
							dice = rand.nextInt(6) + 1;
							System.out.printf("��ǻ�� %d ���� �ֻ��� �� : %d\n", List_i + 1, dice);
							comTotalDice += dice;
						}
						System.out.printf("��ǻ���� �ֻ��� ���� %d \n", comTotalDice);
						System.out.println("<< ��� >>");
						if (comTotalDice > totalDice) {
							++loseCount;
							System.out.println("�й�!");
							wallet -= bet;
							System.out.printf("-%d��!!\n", bet);
						} else if (comTotalDice < totalDice) {
							++winCount;
							System.out.println("�¸�!!!");

							System.out.printf("+%d��!!\n", bet);
							wallet += bet;
						} else {
							++drawCount;
							System.out.println("���º�");
						}
						if (wallet <= 0) {
							System.out.println("���� bye");
							break;
						}

						totalDice = 0;
					} else if (sc.next().charAt(0) == 'n') {
						System.out.println("�޴��� ���ư��ϴ�.");
						break;
					} else {
						System.out.println("�߸��� �Է�");
					}
					System.out.println("�ѹ� ���Ͻðڽ��ϱ� ? (y/n");
					if (sc.next().charAt(0) == 'n')
						break;
				}
			} else if (sel == SCORE) {
				System.out.println("<<����� ����>>");
				System.out.printf("Win :%d\n", winCount);
				System.out.printf("Lose :%d\n", loseCount);
				System.out.printf("Draw :%d\n", drawCount);
				System.out.printf("���� �ܾ� :%d ��\n", wallet);
			} else if (sel == END) {
				System.out.println("�����մϴ�.");

			}

		}

	}

	public void baskinRobbin() {
		int currentNum = 0, userNum = 0, winCount = 0, loseCount = 0, comNum = 0, sel = 0;

		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		final int COM = 1;
		final int USER = 2;
		final int START = 1;
		final int SCORE = 2;
		final int EXIT = 3;
		int STATUS = USER;
		while (true) {
			System.out.println("==== Baskin Robbins31 Game ====");
			System.out.println("1.Game Start");
			System.out.println("2.Game Score");
			System.out.println("3.End Game");
			System.out.print("���� > ");
			sel = sc.nextInt();
			if (sel == START) {
				System.out.println("Game Start");
				while (true) {
					if (currentNum == 31) {
						sel=0;
						currentNum=0;
						break;
					}//if(CurrentNum ==31)
					if (STATUS == USER) {
						System.out.println("<< Your Turn >>");
						System.out.print("Input Number :");
						sel = sc.nextInt();
						if (sel <= 3 && sel >= 1) {
							for (int List_i = 0; List_i < sel; ++List_i) {
								++currentNum;
								System.out.printf("%d!!\n", currentNum);
								if (currentNum == 31) {
									System.out.println("�й� �̤�");
									++loseCount;
									continue;
								}//if(CurrentNum ==31)
							}//for(int List_i=0; List_i<3;++List_i)
						} // (sel <= 3 && sel >= 1 )
						else {
							System.out.println("1~3 �� ���� �Է��ϼ���.");
							continue;
						}//else
						STATUS = COM;
					}//STATUS == USER
						else {
							int temp = rand.nextInt(3) + 1;
							System.out.println("<< Computer Turn >>");
							for (int List_i = 0; List_i < temp; ++List_i) {
								System.out.printf("%d!!\n", ++currentNum);
								if (currentNum == 31) {
									System.out.println("�¸� !!");
									++winCount;
									continue;
								}
							}
							STATUS = USER;
						}//else (STATUS == COM)
				}//while(true) for GAME START
	
			}//sel == START 
			else if (sel == SCORE) {
				System.out.println("<<����� ����>>");
				System.out.printf("Win :%d\n", winCount);
				System.out.printf("Lose :%d\n", loseCount);
			} //else if (sel == SCORE) 
			else if (sel == EXIT) {
				System.exit(0);
			}//else if (sel ==EXIT)
		}
		
	
	}
	public void upAndDown() {
		int sel =0;
		int inputCount=0;
		int goalNum=0;
		int bestCount=Integer.MAX_VALUE,tryCount=0;
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		final int START = 1;
		final int SCORE = 2;
		final int END = 3;
		
		while(true) {
			System.out.println("===== Up & Down Game =====");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print("���� > ");
			sel = sc.nextInt();
			
			switch(sel) {
			case START:
				goalNum=rand.nextInt(99)+1;
				System.out.println(goalNum);
				System.out.println("<< GAME START >>");
				while(true) {
					System.out.printf("%d ȸ�� ��ȣ �Է�\n",tryCount+1);
					System.out.print("Input Number :");
					inputCount = sc.nextInt();
					++tryCount;
					if(inputCount < goalNum) {
						System.out.println("<<< U   P >>>");
					}//(inputCount > goalNum)
					else if (inputCount > goalNum) {
						System.out.println("<<< D O W N >>>");
					}//(inputCount > goalNum) 
					else {
						bestCount = Integer.min(tryCount,bestCount);
						System.out.println("����");
						break;
					}//else
				}//while(true)
				break;
			case SCORE:
				double d = Double.MAX_VALUE;
				if(bestCount==Integer.MAX_VALUE) {
					System.out.printf("���� �ְ����� �����ϴ�\n");
				}
				else { 
					System.out.printf("���� �ְ����� %d �Դϴ�.\n",bestCount);
				}
				break;
			case END:
				System.exit(0);
				break;
			}//switch(sel)
		}//while(true)
	}
}

