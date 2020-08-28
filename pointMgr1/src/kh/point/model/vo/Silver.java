package kh.point.model.vo;

public class Silver {
	// ������ name
	// ������ grade
	// ������ point
	private String name;
	private String grade;
	private int point;
	private double bonus;
	
	final double SILVER_BONUS_RATIO = 0.2;
	public Silver(String name_, String grade_, int point_) {
		name = name_;
		grade = grade_;
		point = point_;
		bonus = SILVER_BONUS_RATIO;
	}

	// getter /setter
	public void setName(String name_) {
		name = name_;
	}

	public void setGrade(String grade_) {
		grade = grade_;
	}

	public void setPoint(int point_) {
		point = point_;
	}

	public String getName() {
		return name;
	}

	public String getGrade() {
		return grade;
	}

	public int getPoint() {
		return point;
	}
	public double getBonus() {
		return bonus;
	}
}
