package kh.java.trie;

public class Node {
	private String character; 
	private int value; 
	private Node[] next;
	private boolean hasNext;
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node[] getNext() {
		return next;
	}
	public void setNext(Node[] next) {
		this.next = next;
	}
	public boolean isHasNext() {
		return hasNext;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	public Node(String character) {
		super();
		this.character = character;
	}
	@Override
	public String toString() {
		return "Node [character=" + character + "]";
	}
	
}
