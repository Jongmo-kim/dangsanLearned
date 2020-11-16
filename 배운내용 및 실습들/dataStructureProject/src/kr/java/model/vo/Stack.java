package kr.java.model.vo;

public class Stack<T> {
	int top;
	static final int STACK_MAX=10;
	private T[] data;
	public Stack() {
		top = 0;
	}
	public void push(T data) {
		this.data[top++] = data;
	}
	public T pop() {
		return data[top--];
	}
	public boolean isFull() {
		return top == STACK_MAX;
	}
	public boolean isEmpty() {
		return top == 0;
	}
	
}
