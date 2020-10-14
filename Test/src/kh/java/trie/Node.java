package kh.java.trie;

public class Node {
	private String character;
	private int value;
	private Node[] children;
	private boolean leaf;
	public Node(String character) {
		this.character = character;
		this.children = new Node[Constants.ALPHABET_SIZE];
	}
	public String getCharacter() {
		return character;
	}
	public Node getChild(int index) {
		return children[index];
	}
	public void setCharacter(String character) {
		this.character = character;
		this.children = new Node[Constants.ALPHABET_SIZE];
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node[] getChildren() {
		return children;
	}
	public void setChildren(Node[] children) {
		this.children = children;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	@Override
	public String toString() {
		return "Node [character=" + character + "]";
	}
	public void setChild(int index, Node node,int value) {
		node.setValue(value);
		this.children[index] = node;
	}
	
	
	
}
