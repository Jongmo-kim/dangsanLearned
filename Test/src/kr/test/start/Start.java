package kr.test.start;

import java.util.ArrayList;
import java.util.Set;


import kr.test.func.trie;

public class Start{
	public static void main(String args[]) {
		ArrayList<String> words = new ArrayList<String>(); 
		words.add("gone");
		words.add("go");
		words.add("golf");
		trie t = new trie();
		for(String str : words) {
			t.insert(str);
		}
		if(t.find("gone") != null) {
			System.out.println("exist");
		}
		
	}
}