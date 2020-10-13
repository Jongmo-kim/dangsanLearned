package kh.java.trie;

public class Trie {
	private Node root;
	private int indexOfSingleChild;
	
	public Trie() {
		this.root = new Node("");
	}
	public void insert(String key, int value) {
		Node tempNode = root;
		
		for( int i = 0; i< key.length(); ++i) {
			
			char ch = key.charAt(i);
			int asciiIndex = transformASCIIndex(ch);
			
			if(tempNode.getChild(asciiIndex) ==null) {
				Node node = new Node(String.valueOf(ch));
				tempNode.setChild(asciiIndex, node, value);
				tempNode = node;
			} else {
				tempNode = tempNode.getChilde(asciiIndex);
			}
		}
		tempNode.setLeaf(true);
	}
	private int transformASCIIndex(char ch){
		return c - 'a';
	}
}
