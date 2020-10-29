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
		System.out.println("0���� �׿ܰ� �Է� ����");
		System.out.printf("> ");
		while(sc.nextInt() != 0) {
			System.out.println("---���� �Էµ� ����---");
			int count = 1;
			for(String str : trie.getAllString()) {
				System.out.printf("%d :%s\n",count++,str);
			}
			System.out.printf("�ڵ��ϼ��� ���� �Է� :");
			String input = sc.next();
			ArrayList<trieNode> list = trie.findAllLeafs(input);
			count = 1;
			System.out.println("---�ڵ��ϼ��� ���ڿ���---");
			for(trieNode node : list) {
				System.out.printf("%d :%s\n",count++,node.getCurrStr());
			}
			System.out.println("-------------------");
			System.out.println("0���� �׿ܰ� �Է� ����");
			System.out.printf("> ");
		}
	}
}