package kh.dgv.model.vo;

public class Product {
	private String name;
	private int amount;
	private int price;
	private int Index;
	
	public int getIndex() {
		return Index;
	}
	public void setIndex(int index) {
		Index = index;
	}
	public Product() {
		super();
	}
	public Product(String name, int amount, int price) {
		super();
		this.name = name;
		this.amount = amount;
		this.price = price;

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
