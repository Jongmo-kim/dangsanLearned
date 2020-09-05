package kh.dgv.model.vo;

public class Food extends Product {

	public Food() {
		super();
		className = "Food";
	}

	public Food(String name, int amount, int price,int index) {
		super(name, amount, price,index);
		className = "Food";
	}
	public String getclassName() {
		return className;
	}
}
