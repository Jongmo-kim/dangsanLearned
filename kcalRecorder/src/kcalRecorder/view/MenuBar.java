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

		menu.add(menuFileSave = new JMenuItem("파일 저장"));
		menu.add(menuFileLoad = new JMenuItem("파일 불러오기"));
		menu.add(menuServerSave = new JMenuItem("서버 저장"));
		menu.add(menuServerLoad = new JMenuItem("서버에 동기화"));
		menu.add(menuLoginStatus = new JMenuItem("로그인"));
		menu.addSeparator();
		menu.add(menuExit = new JMenuItem("나가기"));
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
