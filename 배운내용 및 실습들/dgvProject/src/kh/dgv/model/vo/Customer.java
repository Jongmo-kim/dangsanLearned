package kh.dgv.model.vo;

import java.util.Random;

public class Customer {
	int Id;
	int width,length;
	/*
	 * 차라리 Point { int x , int y}처럼 Seat객체를 만들어서 관리하는게 보다 효율적이였을듯.
	 * 
	 * 
	 */
	Random rand;
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Customer(){
		rand = new Random();
		this.Id = Math.abs(rand.nextInt() % 10000000);
	}
	public int getId() {
		return Id;
	}
	public void setNewRandomId() {
		this.Id = rand.nextInt() % 10000000;
	}
	
}
