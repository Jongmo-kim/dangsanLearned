package kr.java.model.vo;

import java.util.ArrayList;

public class Queue {
	private int[] items;
	private int tail, head;
	static final int MAX = 10;
	
	public Queue() {
		tail = 0;
		head = 0;
		items = new int[MAX];
	}

	public void Enqueue(int item) {
		if (isFull()) {
			System.out.println("큐가 가득찼습니다.");
		} else {
			tail= (++tail)%MAX;
			items[tail] = item;
		}
	}
	public int Dequeue() {
		if (isEmpty()) {
			System.out.println("큐가 비었습니다.");
			return -1;
		} else {
			head = ((++head)%MAX);
			return items[head];
		}
	}
	public boolean isFull() {
		return ((1+tail)%MAX)==head;
	}
	public boolean isEmpty() {
		return tail==head;
	}
}
