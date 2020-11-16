package kh.point.model.vo;

public class Silver extends Grade{
	public Silver() {
		this.name = "";
		this.grade = silver;
		point = 0;
		bonus = SILVER_BONUS;
	}
	public Silver(String name,double point) {
		this.name = name;
		this.point = point;
		bonus = point * SILVER_BONUS;
		this.grade = silver;
	}
	
}
