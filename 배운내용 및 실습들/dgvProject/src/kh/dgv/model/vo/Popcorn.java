package kh.dgv.model.vo;

public class Popcorn extends Product {
	private String flavor;
	public class FlavorType{
		static final String SWEET = ("�����Ѹ�");
		static final String SALTY = ("¬©�Ѹ�");
		static final String CHESSES = ("ġ���");
	}
	
	public Popcorn(String name,int amount, int price,int index, String flavor) {
		super(name,amount,price,index);
		this.flavor = FlavorType.SALTY;
	}

	public Popcorn() {
		super();
	}

	public Popcorn(String name, int amount, int price,int index) {
		super(name, amount, price,index);
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	
}
