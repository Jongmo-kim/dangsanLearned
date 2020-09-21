package kcalRecorder.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class MainFrame extends JFrame {
	public MainFrame(String s){
		super(s);
		setDefaultOptions();
		MenuBar f = new MenuBar();
		setJMenuBar(f.mb);
		makeMainButton();
	}
	private void makeMainButton() {
		JButton addMeal,showMeal;
		add(addMeal = new JButton("¸ÔÀº°Í Ãß°¡"));
		addMeal.addActionListener(actionListenerAddMeal());
		
		add(showMeal = new JButton("¸Ô¾ú´ø °Íµé"));
		showMeal.addActionListener(actionListenerShowMeal());
	}
	public ActionListener actionListenerAddMeal() {
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMealBox f = new addMealBox();
				setInvisible();
			}
		};
		return actionListener;
	}
	public ActionListener actionListenerShowMeal() {
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		};
		return actionListener;
	}
	private void setInvisible() {
		setVisible(false);
		setEnabled(false);
	}
	private void setDefaultOptions() {
		setSize(700,400);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new GridLayout(1,2));
	}
}
