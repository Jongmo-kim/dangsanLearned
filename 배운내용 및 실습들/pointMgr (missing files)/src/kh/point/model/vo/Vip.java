package kh.point.model.vo;

public class Vip extends Grade {
	public Vip() {
		this.name = "";
		this.grade = vip;
		point = 0;
		bonus = point * VIP_BONUS;
	}
	public Vip(String name,double point) {
		this.name = name;
		this.point = point;
		bonus = point * VIP_BONUS;
		this.grade = vip;
	}
}
