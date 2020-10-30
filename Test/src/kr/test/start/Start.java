package kr.test.start;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import kh.java.trie.Hanoi;
import kh.java.trie.Trie;
import kh.java.trie.Trie.trieNode;



public class Start{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Hanoi h = new Hanoi();
		System.out.println("하노이의 탑");
		System.out.print("원반 개수 :");
		int n = sc.nextInt();
		
		h.move(n, 1, 3);
	}
	
}