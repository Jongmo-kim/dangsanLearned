package autoComplete.main;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Scanner;

import autoComplete.trie.*;
import autoComplete.trie.trie.trieNode;
import file.hangulWordsRead;
import file.lolWord;
import file.wordsRead;

public class start {

	public static void main(String[] args) {
		trie t = new trie();
		hangulTrie d = new hangulTrie();
		
//		autoCompleteEng(t);
		autoCompleteHan(d);
	}
	private static void trieBFS() {
					
	}
	private static void stringInputTest() {
		hangulWordsRead hangulwords = new hangulWordsRead();
		ArrayList<String> hangulList = hangulwords.getStringList();
		for(String str : hangulList) {
			print(str);
			System.out.println();
			print(Normalizer.normalize(str, Normalizer.Form.NFD));
			System.out.println();
			System.out.println("--------------------------------------------");
		}
		
		
	}
	
	private static void autoCompleteHan(hangulTrie d) {
		hangulWordsRead hangulwords = new hangulWordsRead();
		ArrayList<String> hangulList = hangulwords.getStringList();
		for(String str : hangulList) {
				d.insert(str);
		}
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("자동완성할 문자 입력 종료시 #입력");
			System.out.print(">");
			String input = sc.next();
			if(input.charAt(0)=='#') {
				break;
			}
			ArrayList<autoComplete.trie.hangulTrie.trieNode> finds = d.findAllLeafs(input);
			printHangulNodes(input,finds);
		}
		System.out.println("종료합니다.");
	}
	private static void printHangulNodes(String str, ArrayList<autoComplete.trie.hangulTrie.trieNode> finds) {
		for(autoComplete.trie.hangulTrie.trieNode node : finds) {
			String currStr = node.getCurrString();
			System.out.printf("내용 : %s\n",currStr);
		}		
	}

	private static void autoCompleteEng(trie t) {
		wordsRead f = new wordsRead();
		for(String str : f.getStringList()) {
			t.insert(str);
		}
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("자동완성할 문자 입력 종료시 #입력");
			System.out.print(">");
			String input = sc.next();
			if(input.charAt(0)=='#') {
				break;
			}
			ArrayList<trieNode> finds = t.findAllLeafs(input);
			printNodes(input,finds);
		}
		System.out.println("종료합니다.");
	}
	private static void printNodes(String str,ArrayList<trieNode> finds) {
		for(trieNode node : finds) {
			
			System.out.printf("내용 :%s\n",node.getCurrString());
		}		
	}

	public static void print(String str) {
		char[] arr = new char[str.length()];
		for(int i=0;i<str.length();++i) {
			arr[i] = str.charAt(i);
		}
		for(int i = 0 ; i < arr.length;++i) {
			System.out.print(arr[i]);
		}
		System.out.println();
		for(int i = 0 ; i < arr.length;++i) {
			System.out.print(String.format("U+%04X ", (int)arr[i]));
		}
	}
}
