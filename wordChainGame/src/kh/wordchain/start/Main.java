package kh.wordchain.start;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import kh.wordchain.func.checkWordAndMakeDict;
import kh.wordchain.view.View;

public class Main {
	checkWordAndMakeDict f;
	View view;
	Scanner sc;
	ArrayList<String> dict;
	int winCount, loseCount;

	public Main() {
		f = new checkWordAndMakeDict();
		view = new View();
		sc = new Scanner(System.in);
		dict = f.getDict();
	}

	public void start() {
		while (true) {
			view.printMainMenu();
			int sel = inputIntAndCheck(1, 3);
			switch (sel) {
			case 1:
				view.printGameStart();
				gameStart();
				break;
			case 2:
				view.printBattleResult(winCount, loseCount);
				break;
			case 3:
				view.printNewWords();
				putNewWord();
				break;
			case 0:
				System.exit(0);
			}
		}
	}
	public void putNewWord() {
		f = new checkWordAndMakeDict();
	}
	public void gameStart() {
		view.printChoiceAttackPostion();
		int sel = inputIntAndCheck(1, 2);
		wordChainGame(sel);

	}
	public void wordChainGame(int attack) {
		int status = attack;
		final int USER = 1;
		final int COM = 2;
		final int RESULT = 3;
		int loseCount = 0;
		String currentWord = "";
		boolean exit = true;
		boolean first = true;
		while (exit) {
/////////////////////////////////////////////////
			if (status == USER) {
				view.printUserBattleStart();
				String userStr = inputStringAndDictCheck();
				
				if (userStr.equals("gg") || loseCount == 3) {
					++loseCount;
					view.printDefeatMessage();
					exit = false;
					continue;
				}
				if(first) {
					first=!first;
					currentWord = userStr;
					status = COM;
					loseCount = 0;
					continue;
				}
				else if (areTwoStringChained(currentWord, userStr)) {
					status = COM;
					loseCount = 0;
					currentWord = userStr;
					continue;
				} else // 끝 글자랑 맞지 않는 경우 다시 처음부터.
				{
					++loseCount;
					view.printNotCurrectWord();
				}
			} else if (status == COM) {
				if(first) {
					first=!first;
					currentWord = returnRandomStr(dict);
					view.printComBattleStart();
					System.out.println(currentWord);
					status = USER;
					continue;
				}
				ArrayList<String> arr = searchStartWithAndReturnArr(currentWord);
				if (isComDefeated(arr)) {
					++winCount;
					exit = false;
					view.printVictoryMessage();
					continue;
				}
				view.printComBattleStart();
				currentWord = returnRandomStr(arr);
				System.out.println(currentWord);
				status = USER;
				continue;
			}
		}
	}
	public boolean isComDefeated(ArrayList<String> arr) {
		return arr.size() == 0;
	}
	public String inputStringAndDictCheck() {
		String str = "";
		boolean exit = true;
		while (exit) {
			try {
				str = sc.next();
				if (!isWordExistsInDict(str)) {
					if(str.equals("gg")) {
						exit = false;
					}
					else {
						throw new Exception();
					}
				}
				exit = false;
			} catch (Exception e) {
				view.printNotCurrectWord();
			}
		}
		return str;
	}
	public boolean isWordExistsInDict(String word) {
		
		for (String str : dict) {
			if (str.equals(word)) {
				return true;
			}
		}
		return false;
	}
	public boolean areTwoStringChained(String str1, String str2) { 
		return str1.charAt(str1.length()-1) == str2.charAt(0);
	}
	public ArrayList<String> searchStartWithAndReturnArr(String word) {
		ArrayList<String> arr = new ArrayList<String>();
		for (String str : dict) {
			if (isMatchedFirstAndLastChar(str, word)) {
				arr.add(str);
			}
		}
		return arr;
	}
	public boolean isMatchedFirstAndLastChar(String str1,String str2) {
		return str1.charAt(0) == str2.charAt(str2.length()-1);
	}
	public String returnRandomStr(ArrayList<String> arr) {
		Random rand = new Random();
		int idx = rand.nextInt(arr.size());
		idx = Math.abs(idx);
		return arr.get(idx);
	}
	public int inputIntAndCheck(int min, int max) {
		int sel = 0;
		boolean exit = true;
		while (exit) {
			try {
				sel = sc.nextInt();
				if (!(sel >= min && sel <= max)) {
					throw new Exception(min + "에서 " + max + "사이의 값을 입력해주세요.");
				}
				exit = false;
			} catch (InputMismatchException e) {
				System.out.println("제발 제대로좀 입력해주세요.");
				System.out.print("선택 >");
				sc.nextLine();
				continue;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.print("선택 >");
				sc.nextLine();
				continue;
			}

		}
		return sel;
	}
}
