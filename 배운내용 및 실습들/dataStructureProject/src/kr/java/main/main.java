package kr.java.main;

import java.util.Stack;

import kr.java.model.vo.Queue;
//stack ±‚√ 
public class main {
	public static void main(String[] args) {
		Queue queue = new Queue();
		for(int List_i=0;List_i<10;++List_i) {
			queue.Enqueue(List_i+1*10);
		}
		for(int List_i=0;List_i<10;++List_i) {
			System.out.println(queue.Dequeue());
		}

	}
	public void stackTest() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		while(!stack.isEmpty())
			System.out.println(stack.pop());
	}
	public void queueTest() {
		Queue queue = new Queue();
		for(int List_i=0;List_i<10;++List_i) {
			queue.Enqueue(List_i+1*10);
		}
		for(int List_i=0;List_i<10;++List_i) {
			System.out.println(queue.Dequeue());
		}
	}
}
