package kr.test.func;

import java.util.ArrayList;

public class AutoComplete {
	final int TRIE_NODE = 26;
	private ArrayList<String> list;
	private class trie{
		trie[] next;
		boolean isFinished;
		boolean hasNextChild;
		
		public trie() {
			next = new trie[TRIE_NODE];
			isFinished = false;
			hasNextChild = false;
		}
		void insert(String str) {
			if(str.equals("\0")) {
				isFinished = true;
			}
			else { 
				char firstChar = str.charAt(0);
				int idx = charToInt(firstChar);
				if(next[idx]==null) {
					next[idx] = new trie();
				}
				String subStr = str.substring(1);
				next[idx].insert(subStr);
			}
		}
		private int charToInt(char ch) {
			return 'a'-ch;
		}
		trie find(String str) {
			if()
		}
	}
	public AutoComplete(ArrayList<String> list) {
		this.list = list;
	}
	public ArrayList<String> find(String str) {
		ArrayList<String> strArr = new ArrayList<String>();
		
		return strArr;
	}
}
