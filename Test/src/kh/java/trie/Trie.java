package kh.java.trie;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
	public class trieNode{
		private char data;
		private trieNode parentNode;
		private HashMap<Character, trieNode> children;
		private boolean isLeaf;
		public trieNode(char ch) {
			this.data = ch;
			parentNode = this;
			children = new HashMap<Character, Trie.trieNode>();
			isLeaf = false;
		}
		public char getData() {
			return data;
		}
		public void setData(char data) {
			this.data = data;
		}
		public trieNode getParentNode() {
			return parentNode;
		}
		public void setParentNode(trieNode parentNode) {
			this.parentNode = parentNode;
		}
		public HashMap<Character, trieNode> getChildren() {
			return children;
		}
		public void setChildren(HashMap<Character, trieNode> children) {
			this.children = children;
		}
		public boolean isLeaf() {
			return isLeaf;
		}
		public void setLeaf(boolean isLeaf) {
			this.isLeaf = isLeaf;
		}
		public trieNode getChild(char ch) {
			trieNode tempNode = this.getChildren().get(ch);
			return tempNode;
		}
		public trieNode putChild(char ch) {
			trieNode tempNode = new trieNode(ch);
			getChildren().put(ch, tempNode);
			return tempNode;
		}
		public ArrayList<trieNode> getAllLeaf(){
			ArrayList<trieNode> list = new ArrayList<trieNode>();
			for(trieNode node : getChildren().values()) {
				if(node.isLeaf) {
					list.add(node);
				}
				list.addAll(node.getAllLeaf());
			}
			return list;
		}
		public String getCurrStr() {
			String str = "";
			
			trieNode currNode = this;
			while(currNode.getData() != ' ') {
				char ch = currNode.getData();
				str += Character.toString(currNode.getData());
				currNode = currNode.getParentNode();
			}
			
			StringBuilder sb = new StringBuilder(str);
			sb.reverse();
			return sb.toString();
		}
		public boolean search(String word) {
			trieNode currNode = this;
			for(char ch : word.toCharArray()) {
				if(currNode.getChild(ch) != null) {
					currNode = currNode.getChild(ch);
				} else {
					return false;
				}
			}
			return true;
		}
	}//trieNode
	private trieNode rootNode;
	public Trie() {
		rootNode = new trieNode(' '); 
	}
	public void insert(String str) {
		trieNode currNode = rootNode;
		for(char ch : str.toCharArray()) {
			if(currNode.getChild(ch) != null) {
				currNode = currNode.getChild(ch);
			} else {
				trieNode tempNode = currNode.putChild(ch);
				tempNode.setParentNode(currNode);
				currNode = tempNode;
			}
		}
		currNode.setLeaf(true);
	}
	public ArrayList<trieNode> findAllLeafs(String word){
		ArrayList<trieNode> list = new ArrayList<trieNode>();
		trieNode currNode = rootNode;
		for(char ch :  word.toCharArray()) {
			if(currNode.getChild(ch)!= null) {
				currNode = currNode.getChild(ch);
			}else {
				list.clear();
				return list;
			}
		}
		if(currNode.isLeaf()){
			list.add(currNode);
		}
		list.addAll(currNode.getAllLeaf());
		return list;
	}
	public ArrayList<String> getAllString(){
		ArrayList<trieNode> trieList = new ArrayList<trieNode>();
		ArrayList<String> strList = new ArrayList<String>();
		trieList.addAll(rootNode.getAllLeaf());
		for(trieNode node : trieList) {
			strList.add(node.getCurrStr());
		}
		return strList;
	}
	public boolean search(String word) {
		trieNode currNode = rootNode;
		for(char ch : word.toCharArray()) {
			if(currNode.getChild(ch) != null) {
				currNode = currNode.getChild(ch);
			} else {
				return false;
			}
		}
		return currNode.isLeaf;
	}
}
