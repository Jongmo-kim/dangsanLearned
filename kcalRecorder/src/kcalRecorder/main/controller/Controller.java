package kcalRecorder.main.controller;

import kcalRecorder.model.vo.Meal;
import kcalRecorder.view.MainFrame;

public class Controller{
	private Meal[] mealArr;
	private final int MEALMAX = 10;
	public Controller() {
		mealArr = new Meal[MEALMAX];
	}
	public void main() {
		MainFrame f = new MainFrame("temp");
		
	}
}
