package kh.java.func;

import java.util.Random;
import java.util.Scanner;

public class RandomTest {
	public void randomTest1() {
		Random r = new Random();

		int num2 = r.nextInt(10); // 0~10
		int num3 = r.nextInt(15); // 0~14
		int num4 = r.nextInt(2); // 0~1

		int num5 = r.nextInt(10) + 1; // 1부터 10 까지의 랜덤숫자를 정수형 변수에 대입
		int num6 = r.nextInt(16) + 20; // 20~35

		System.out.println(num5);

	}

	public void guessCoin() {
		Random r = new Random();
		Scanner d = new Scanner(System.in);
		System.out.println("===동전 앞 뒤 맞추기 ===");
		System.out.print("숫자를 입력해주세요(1.앞면/2.뒷면): ");
		int sel = d.nextInt();

		if ((r.nextInt(2) + 1) == sel) {
			System.out.println("맞았습니다.");
		} else {
			System.out.println("땡 ! 틀렸습니다");
		}
	}

	public void rockScissorsPaper() {
		final int SCISSORS = 1;
		final int ROCK = 2;
		final int PAPER = 3;
		Random r = new Random();
		Scanner d = new Scanner(System.in);
		String User = "내용";
		while (true) {
			System.out.println("===가위바위보 게임===");
			System.out.print("숫자를선택 하세요(1.가위2.바위3.보) :");
			int user = d.nextInt();
			int versus = r.nextInt(3) + 1;
			// 가위 > 보, 보> 주먹, 주먹 > 가위
			// 경우의 수 9개 중 3개는 같은경우 주먹,가위,보
			// 나머지 6개
			// (가위, 바위), (가위, 보)
			// (바위, 보), (바위,가위)
			// (보, 가위),(보, 바위),
			if (user == ROCK) {
				System.out.println("사용자는 주먹을 냈습니다.");
			} else if (user == PAPER) {
				System.out.println("사용자는 보를 냈습니다.");
			} else if (user == SCISSORS) {
				System.out.println("사용자는 가위를 냈습니다");
			} else {
				System.out.println("사용자는 잘못된 값을 입력했습니다.");
			}

			if (versus == ROCK) {
				System.out.println("컴퓨터는 주먹을 냈습니다.");
			} else if (versus == PAPER) {
				System.out.println("컴퓨터는 보를 냈습니다.");
			} else if (versus == SCISSORS) {
				System.out.println("컴퓨터는 가위를 냈습니다");
			}

			if (user == versus) {
				System.out.println("무승부");
			} else if ((user == SCISSORS && versus == ROCK) || (user == ROCK && versus == PAPER)
					|| user == PAPER && versus == SCISSORS) { // user가 진경우
				System.out.println("당신이 졌습니다.");

			} else if ((user == SCISSORS && versus == PAPER) || (user == ROCK && versus == SCISSORS)
					|| (user == PAPER && versus == ROCK)) { // user가 이긴경우
				System.out.println("당신이 이겼습니다.");
			}
			System.out.println("다시 하시겠습니까? (1. 계속, 2. 종료) :");
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
						System.out.println("잔액이 없습니다. bye");
						break;
					}
					for (int List_i = 0; List_i < 3; ++List_i) {
						dice = rand.nextInt(6) + 1;
						System.out.printf("%d 번쨰 주사위 값 : %d\n", List_i + 1, dice);
						totalDice += dice;
					}
					System.out.printf("총 주사위 합 : %d \n", totalDice);
					System.out.print("배팅을 하시겠습니까? (y/n)");
					if (sc.next().charAt(0) == 'y') {
						System.out.printf("얼마를 배팅하시겠습니까? (현재 내 소지금 %d 원): ", wallet);
						bet = sc.nextInt();
						for (int List_i = 0; List_i < 3; ++List_i) {
							dice = rand.nextInt(6) + 1;
							System.out.printf("컴퓨터 %d 번쨰 주사위 값 : %d\n", List_i + 1, dice);
							comTotalDice += dice;
						}
						System.out.printf("컴퓨터의 주사위 총합 %d \n", comTotalDice);
						System.out.println("<< 결과 >>");
						if (comTotalDice > totalDice) {
							++loseCount;
							System.out.println("패배!");
							wallet -= bet;
							System.out.printf("-%d원!!\n", bet);
						} else if (comTotalDice < totalDice) {
							++winCount;
							System.out.println("승리!!!");

							System.out.printf("+%d원!!\n", bet);
							wallet += bet;
						} else {
							++drawCount;
							System.out.println("무승부");
						}
						if (wallet <= 0) {
							System.out.println("거지 bye");
							break;
						}

						totalDice = 0;
					} else if (sc.next().charAt(0) == 'n') {
						System.out.println("메뉴로 돌아갑니다.");
						break;
					} else {
						System.out.println("잘못된 입력");
					}
					System.out.println("한번 더하시겠습니까 ? (y/n");
					if (sc.next().charAt(0) == 'n')
						break;
				}
			} else if (sel == SCORE) {
				System.out.println("<<당신의 전적>>");
				System.out.printf("Win :%d\n", winCount);
				System.out.printf("Lose :%d\n", loseCount);
				System.out.printf("Draw :%d\n", drawCount);
				System.out.printf("현재 잔액 :%d 원\n", wallet);
			} else if (sel == END) {
				System.out.println("종료합니다.");

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
			System.out.print("선택 > ");
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
									System.out.println("패배 ㅜㅠ");
									++loseCount;
									continue;
								}//if(CurrentNum ==31)
							}//for(int List_i=0; List_i<3;++List_i)
						} // (sel <= 3 && sel >= 1 )
						else {
							System.out.println("1~3 의 값을 입력하세요.");
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
									System.out.println("승리 !!");
									++winCount;
									continue;
								}
							}
							STATUS = USER;
						}//else (STATUS == COM)
				}//while(true) for GAME START
	
			}//sel == START 
			else if (sel == SCORE) {
				System.out.println("<<당신의 전적>>");
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
			System.out.print("선택 > ");
			sel = sc.nextInt();
			
			switch(sel) {
			case START:
				goalNum=rand.nextInt(99)+1;
				System.out.println(goalNum);
				System.out.println("<< GAME START >>");
				while(true) {
					System.out.printf("%d 회차 번호 입력\n",tryCount+1);
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
						System.out.println("정답");
						break;
					}//else
				}//while(true)
				break;
			case SCORE:
				double d = Double.MAX_VALUE;
				if(bestCount==Integer.MAX_VALUE) {
					System.out.printf("현재 최고기록은 없습니다\n");
				}
				else { 
					System.out.printf("현재 최고기록은 %d 입니다.\n",bestCount);
				}
				break;
			case END:
				System.exit(0);
				break;
			}//switch(sel)
		}//while(true)
	}
}

