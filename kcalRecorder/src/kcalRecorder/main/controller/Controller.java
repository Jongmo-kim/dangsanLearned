package kcalRecorder.main.controller;

import kcalRecorder.model.vo.Meal;

public class Controller{
	private Meal[] mealArr;
	private final int MEALMAX = 10;
	public Controller() {
		mealArr = new Meal[MEALMAX];
	}
}
