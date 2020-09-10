package kh.wordchain.view;

public class View {
	public void printMainMenu() {
		System.out.println("---- �����ձ� ----");
		System.out.println("1.���ӽ��� ");
		System.out.println("2.����Ȯ�� ");
		System.out.println("3.�ܾ� ���� �ҷ����� ");
		System.out.println("0.���α׷� ���� ");
		System.out.print("���� > ");
	}
	public void printChoiceAttackPostion() {
		System.out.println("---- ����/�İ� ���� ----");
		System.out.println("1.����");
		System.out.println("2.�İ�");
		System.out.print("���� > ");
	}
	public void printGameStart() {
		System.out.println("---- Game Start ----");
		System.out.println("�й踦 �����ϴ� ��� gg�� �Է��ϼ���.");
	}
	public void printNotCurrectWord() {
		System.out.println("�ùٸ��� ���� �ܾ��Դϴ�. �ٽ� �Է����ּ���");
	}
	public void printDefeatMessage() {
		System.out.println("�й��Ͽ����ϴ�.");
	}
	public void printVictoryMessage() {
		System.out.println("�¸��Ͽ����ϴ�.");
	}
	public void printBattleResult(int winCount,int loseCount) {
		System.out.printf("%d �� %d �� �·� %.1f%%\n\n",
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
