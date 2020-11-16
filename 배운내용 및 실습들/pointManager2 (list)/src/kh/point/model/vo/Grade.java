package kh.point.model.vo;

public class Grade{
	protected String name;
	protected int grade;
	protected double point;
	protected double bonus;
	
	final int notInitalized = 0;
	final int silver = 1;
	final int gold = 2;
	final int vip = 3;
	
	final double NO_BONUS = 0;
	final double VIP_BONUS = 0.07;
	final double GOLD_BONUS = 0.05;
	final double SILVER_BONUS = 0.02;
	public Grade() {
		name = "";
		grade = notInitalized;
		point = 0;
		bonus = NO_BONUS;
	}
	public void printStuff() {
		System.out.printf("%s\t%s\t%.1f\t%.1f\t\n",name,printGrade(grade),point,bonus);
	}
	public String printGrade(int idx) {
				if(idx == silver) {
					return "Silver";
				}
				if( idx == gold) {
					return "Gold";
				}
				if( idx == vip) {
					return "Vip";
				}
			return "";
	}
	
	public String getGrade() {
		return printGrade(grade);
	}

	
	public double getPoint() {
		return point;
	}
	public String getName() {
		return name;
	}

	
	public double getBonus() {
		
		return bonus;
	}
	public void setGrade(String grade) {
		if(grade.equals("silver")) {
			this.grade = silver;
		}
		if( grade.equals("gold")) {
			this.grade = gold;
		}
		if( grade.equals("vip")) {
			this.grade = vip;
		}
	}
	public void setPoint(double point) {
		this.point=point;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
}
