package autoComplete.main;

import java.util.ArrayList;
import java.util.Scanner;

import autoComplete.trie.*;
import autoComplete.trie.trie.trieNode;
import file.fileRead;

public class start {

	public static void main(String[] args) {
		trie t = new trie();
		ArrayList<String> list = new ArrayList<String>();
		list.add("going");
		list.add("go");
		list.add("gone");
		fileRead f = new fileRead();
		for(String str : f.getStringList()) {
			t.insert(str);
		}
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
