package kr.test.start;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import kh.java.trie.Trie;
import kh.java.trie.Trie.trieNode;



public class Start{
	public static void main(String args[]) {
		Trie trie = new Trie();
		Scanner sc = new Scanner(System.in);
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("go");
		strList.add("gone");
		strList.add("going");
		strList.add("good");
		strList.add("glory");
		strList.add("gondolier");
		strList.add("godparent");
		strList.add("goodnight");
		strList.add("goal");
		strList.add("goddesses");
		strList.add("gossiping");
		strList.add("governing");
		for(String str :strList) {
			trie.insert(str);
		}
		
		for(String str : strList) {
			System.out.printf("%s : %s\n",str,trie.search(str));
		}
		System.out.println("0종료 그외값 입력 시작");
		System.out.printf("> ");
		while(sc.nextInt() != 0) {
			System.out.println("---현재 입력된 문자---");
			int count = 1;
			for(String str : trie.getAllString()) {
				System.out.printf("%d :%s\n",count++,str);
			}
			System.out.printf("자동완성할 문자 입력 :");
			String input = sc.next();
			ArrayList<trieNode> list = trie.findAllLeafs(input);
			count = 1;
			System.out.println("---자동완성된 문자열들---");
			for(trieNode node : list) {
				System.out.printf("%d :%s\n",count++,node.getCurrStr());
			}
			System.out.println("-------------------");
			System.out.println("0종료 그외값 입력 시작");
			System.out.printf("> ");
		}
	}
}