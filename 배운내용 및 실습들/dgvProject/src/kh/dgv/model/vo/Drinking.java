package kh.dgv.model.vo;

public class Drinking extends Product{
	String className;
	public Drinking() {
		super();
		className = "Drinking";
	}
	public Drinking(String name, int amount, int price,int index) {
		super(name, amount, price, index);
		className = "Drinking";
	}
	public String getclassName() {
		return className;
		
	}
}
