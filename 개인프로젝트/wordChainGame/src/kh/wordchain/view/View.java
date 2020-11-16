package kh.wordchain.view;

public class View {
	public void printMainMenu() {
		System.out.println("---- 끝말잇기 ----");
		System.out.println("1.게임시작 ");
		System.out.println("2.전적확인 ");
		System.out.println("3.단어 새로 불러오기 ");
		System.out.println("0.프로그램 종료 ");
		System.out.print("선택 > ");
	}
	public void printChoiceAttackPostion() {
		System.out.println("---- 선공/후공 선택 ----");
		System.out.println("1.선공");
		System.out.println("2.후공");
		System.out.print("선택 > ");
	}
	public void printGameStart() {
		System.out.println("---- Game Start ----");
		System.out.println("패배를 인정하는 경우 gg를 입력하세요.");
	}
	public void printNotCurrectWord() {
		System.out.println("올바르지 않은 단어입니다. 다시 입력해주세요");
	}
	public void printDefeatMessage() {
		System.out.println("패배하였습니다.");
	}
	public void printVictoryMessage() {
		System.out.println("승리하였습니다.");
	}
	public void printBattleResult(int winCount,int loseCount) {
		System.out.printf("%d 승 %d 패 승률 %.1f%%\n\n",
				winCount,loseCount,(double)winCount/(winCount+loseCount)*100);
	}
	public void printNewWords() {
		
	}
	public void printUserBattleStart() {
		System.out.print("[User] :");
	}
	public void printComBattleStart() {
		System.out.print("[Com] :");
	}
}
