package kh.point.model.vo;

public class Gold extends Grade {
	public Gold() {
		this.name = "";
		this.grade = gold;
		point = 0;
		bonus = GOLD_BONUS;
	}
	public Gold(String name,double point) {
		this.name = name;
		this.point = point;
		bonus = point * GOLD_BONUS;
		this.grade = gold;
	}
}
