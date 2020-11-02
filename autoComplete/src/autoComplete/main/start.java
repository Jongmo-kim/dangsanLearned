package autoComplete.main;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Scanner;

import autoComplete.trie.*;
import autoComplete.trie.trie.trieNode;
import file.hangulWordsRead;
import file.wordsRead;

public class start {

	public static void main(String[] args) {
		trie t = new trie();
//		autoCompleteEng(t);
		hangulWordsRead hangulList = new hangulWordsRead();
		hangulList.getStringList();
		String han = "가방";
		print(han);
		System.out.println("1");
		String nfd = Normalizer.normalize(han, Normalizer.Form.NFD);
		print(nfd);
		System.out.println(nfd.charAt(0));
		String nfc = Normalizer.normalize(han, Normalizer.Form.NFC);
		print(nfc);
		System.out.println(nfc);
		
		
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
			
			System.out.printf("내용 : %c%s\n",str.charAt(0),node.getCurrString());
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
