package autoComplete.main;

import java.util.ArrayList;
import java.util.Scanner;

import autoComplete.trie.*;
import autoComplete.trie.trie.trieNode;

public class start {

	public static void main(String[] args) {
		trie t = new trie();
		ArrayList<String> list = new ArrayList<String>();
		list.add("going");
		list.add("go");
		list.add("gone");
		
		for(String str : list) {
			t.insert(str);
		}
//		list.add("gon");
//		list.add("goingf");
//		list.add("g");
//		list.add("goingsome'where");
//		list.add("efgh");
//		list.add("abcd");
//		list.add("gone");
		for(String str : list) {
			System.out.printf("%s : %s\n",str,t.search(str));
		}
		ArrayList<trieNode> arr = new ArrayList<trieNode>();
		arr = t.findAllLeafs("g");
		
	
		Scanner sc = new Scanner(System.in);
		System.out.println("종료하려면 0 입력 계속 하려면 다른거 입력");

		while(sc.nextInt()!=0) {
			System.out.println("자동완성할 문자 입력");
			System.out.print(">");
			String input = sc.next();
			ArrayList<trieNode> finds = t.findAllLeafs(input);
			printNodes(input,finds);
			System.out.println("종료하려면 0 입력 계속 하려면 다른거 입력");
		}
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
