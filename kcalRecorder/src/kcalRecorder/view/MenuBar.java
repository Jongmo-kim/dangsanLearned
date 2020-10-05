package kcalRecorder.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar {
	public JMenuBar JMenuBar; 
	private JMenuItem menuFileSave,menuFileLoad,menuServerSave,menuServerLoad,menuLoginStatus,menuExit;
	
	public MenuBar() {
		JMenuBar = new JMenuBar();

		JMenu menu;
		JMenuBar.add(menu = new JMenu("File"));
		JMenuBar.add(new JMenu("Option"));

		menu.add(menuFileSave = new JMenuItem("���� ����"));
		menu.add(menuFileLoad = new JMenuItem("���� �ҷ�����"));
		menu.add(menuServerSave = new JMenuItem("���� ����"));
		menu.add(menuServerLoad = new JMenuItem("������ ����ȭ"));
		menu.add(menuLoginStatus = new JMenuItem("�α���"));
		menu.addSeparator();
		menu.add(menuExit = new JMenuItem("������"));
	}
	
	public JMenuBar getJMenuBar() {
		return JMenuBar;
	}

	public JMenuItem getMenuLoginStatus() {
		return menuLoginStatus;
	}

	public JMenuItem getMenuFileSave() {
		return menuFileSave;
	}

	public JMenuItem getMenuFileLoad() {
		return menuFileLoad;
	}
	public JMenuItem getMenuServerSave() {
		return menuServerSave;
	}

	public JMenuItem getMenuServerLoad() {
		return menuServerLoad;
	}
	public JMenuItem getMenuExit() {
		return menuExit;
	}

}
