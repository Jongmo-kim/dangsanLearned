package kcalRecorder.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar {
	public JMenuBar mb; 
	public MenuBar() {
		JMenuItem fileSave,fileLoad,serverSave,serverLoad,exit;
		mb = new JMenuBar();

		JMenu file;
		mb.add(file = new JMenu("File"));
		mb.add(new JMenu("Option"));
		
		file.add(fileSave = new JMenuItem("파일 저장"));
		fileSave.addActionListener(actionListenerFileSave());
		
		file.add(fileLoad = new JMenuItem("파일 불러오기"));
		fileLoad.addActionListener(actionListenerFileLoad());
		
		file.add(serverSave = new JMenuItem("서버 저장"));
		serverSave.addActionListener(actionListenerServerSave());
		
		file.add(serverLoad = new JMenuItem("서버에 동기화"));
		serverLoad.addActionListener(actionListenerServerLoad());
		
		file.addSeparator();
		file.add(exit = new JMenuItem("나가기"));
		exit.addActionListener(actionListenerExit());
	}
	public ActionListener actionListenerFileSave() {
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		return actionListener;
	}
	public ActionListener actionListenerFileLoad() {
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		};
		return actionListener;
	}
	public ActionListener actionListenerServerSave() {
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		};
		return actionListener;
	}
	public ActionListener actionListenerServerLoad() {
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		};
		return actionListener;
	}
	public ActionListener actionListenerExit() {
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		return actionListener;
	}
}
