package kcalRecorder.main.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JTextField;

import kcalRecorder.model.vo.Food;
import kcalRecorder.model.vo.Meal;
import kcalRecorder.view.MainFrame;
import kcalRecorder.view.ShowMealFrame;
import kcalRecorder.view.AddMealFrame;
import kcalRecorder.view.AddMealFrame.*;
import kcalRecorder.view.ShowMealFrame.*;

public class Controller {
	private ArrayList<Meal> mealArr;
	private MainFrame mainFrame;
	private kcalRecorder.view.AddMealFrame AddMealFrameInstance;
	private kcalRecorder.view.ShowMealFrame ShowMealFrameInstance;
	addMealFrameConfirmButton addMealFrameConfirmButton;
	JButton consonantSearchButton;
	JButton nameSearchButton;
	JButton dateSearchButton;

	public Controller() {
		mealArr = new ArrayList<Meal>();
		setTestValues();
	}

	public void setTestValues() {
		ArrayList<Food> list = new ArrayList<Food>();
		Calendar calendar = Calendar.getInstance();

		list.add(new Food(500, 1, "제육볶음"));
		list.add(new Food(200, 1, "소시지 야채볶음"));
		list.add(new Food(300, 1, "공기밥"));
		list.add(new Food(250, 1, "소고기 무국"));
		list.add(new Food(100, 1, "미역줄기 볶음"));
		Meal temp = new Meal(list);
		Date date1 = new Date();
		temp.setDate(date1);
		mealArr.add(temp);

		list.clear();

		list.add(new Food(650, 1, "돈까스"));
		list.add(new Food(200, 1, "마카로니 샐러드"));
		list.add(new Food(150, 0.5, "공기밥"));
		list.add(new Food(250, 1, "카레"));
		list.add(new Food(200, 1, "콩나물 무침"));
		temp = new Meal(list);

		calendar.set(Calendar.YEAR, 2019);
		calendar.set(Calendar.MONTH, 3);
		calendar.set(Calendar.DAY_OF_MONTH, 20);

		Date date2 = new Date(calendar.getTimeInMillis());
		temp.setDate(date2);
		mealArr.add(temp);

		list.clear();
		list.add(new Food(700, 1, "카레 돈까스"));
		list.add(new Food(200, 1, "두부 무침"));
		list.add(new Food(150, 0.5, "공기밥"));
		list.add(new Food(250, 1, "된장찌개"));
		list.add(new Food(300, 1, "조기구이"));
		temp = new Meal(list);

		calendar.set(Calendar.YEAR, 2017);
		calendar.set(Calendar.MONTH, 7);
		calendar.set(Calendar.DAY_OF_MONTH, 2);
		Date date3 = new Date(calendar.getTimeInMillis());
		temp.setDate(date3);
		mealArr.add(temp);

	}

	public void main() {
		mainFrame = new MainFrame("temp");
		setMainFrameActionListener();
	}

	public void setMainFrameActionListener() {
		JButton addMealButton = mainFrame.getAddMeal();
		addMealButton.addActionListener(actionListenerAddMeal());

		JButton showMealButton = mainFrame.getShowMeal();
		showMealButton.addActionListener(actionListenerShowMeal());
	}
	public ActionListener actionListenerAddMeal() {
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setInvisible();
				AddMealFrameInstance = new AddMealFrame();

				JButton confirmButton = AddMealFrameInstance.getAddMealFrameConfirmButton();
				confirmButton.addActionListener(actionListenerAddMealConfirmButton());

			}
		};
		return actionListener;
	}
	public ActionListener actionListenerShowMeal() {

		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setInvisible();

				ShowMealFrameInstance = new ShowMealFrame("temp", mealArr);
				ShowMealFrameInstance.getShowMealConfirmButton().addActionListener(actionListenerShowMealReturnMain());

				consonantSearchButton = ShowMealFrameInstance.getConsonantSearchButton();
				consonantSearchButton.addActionListener(actionListenerConsonantSearchButton());

				nameSearchButton = ShowMealFrameInstance.getNameSearchButton();
				nameSearchButton.addActionListener(actionListenerNameSearchButton());

				dateSearchButton = ShowMealFrameInstance.getDateSearchButton();
				dateSearchButton.addActionListener(actionListenerDateSearchButton());

			}
		};
		return actionListener;
	}
	
	
	public ActionListener actionListenerAddMealConfirmButton() {
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible();
				AddMealFrameInstance.setInvisible();
				insertNewMeals();
			}
		};
		return actionListener;
	}

	public void insertNewMeals() {
		ArrayList<Food> list = AddMealFrameInstance.getFoodList();
		mealArr.add(new Meal(list));
		list.clear();
	}
	public ActionListener actionListenerShowMealReturnMain() {
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowMealFrameInstance.setInvisible();
				mainFrame.setVisible();
			}
		};
		return actionListener;
	}

	public ActionListener actionListenerConsonantSearchButton() {
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		};
		return actionListener;
	}

	public ActionListener actionListenerNameSearchButton() {
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateFoodListWithSearchedName();
			}
		};
		return actionListener;
	}

	public void updateFoodListWithSearchedName() {
		JTextField textField = ShowMealFrameInstance.getNameSearchTextField();
		String valueBeIncluded = textField.getText();
		ArrayList<Meal> list = new ArrayList<Meal>();
		textField.setText("");
		for (Meal meal : mealArr) {
			if (meal.isFoodNameIncluded(valueBeIncluded)) {
				list.add(meal);
			}
		}
		ShowMealFrameInstance.updateFoodListTextArea(list);
	}

	public ActionListener actionListenerDateSearchButton() {
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateFoodListWithSearchedDate();
			}
		};
		return actionListener;
	}

	public void updateFoodListWithSearchedDate() {
		showMealDateSearchPanel tempPanel = ShowMealFrameInstance.getShowMealDateSearchPanel();
		Date date = tempPanel.getDateFromTextField();
		tempPanel.clearTimeFields();
		ArrayList<Meal> list = new ArrayList<Meal>();
		for (Meal meal : mealArr) {

			if (isEqualDateInYearMonthDay(meal.getDate(), date)) {
				list.add(meal);
			}
		}

		ShowMealFrameInstance.updateFoodListTextArea(list);

	}

	public boolean isEqualDateInYearMonthDay(Date d1, Date d2) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d1);
		int firstYear = calendar.get(Calendar.YEAR);
		int firstMonth = calendar.get(Calendar.MONTH);
		int firstDay = calendar.get(Calendar.DAY_OF_MONTH);

		calendar.setTime(d2);
		int secondYear = calendar.get(Calendar.YEAR);
		int secondMonth = calendar.get(Calendar.MONTH);
		int secondDay = calendar.get(Calendar.DAY_OF_MONTH);

		if (firstYear == secondYear && firstMonth == secondMonth && firstDay == secondDay) {
			return true;
		}
		return false;
	}
}
