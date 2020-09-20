package kcalRecorder.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

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
		makeMenuBar();
		add(new JButton("먹은것 추가"));
		add(new JButton("먹었던 것들"));
	}
	private void makeMenuBar() {
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		
		JMenu file;
		mb.add(file = new JMenu("File"));
		mb.add(new JMenu("Option"));
		file.add(new JMenuItem("파일 저장"));
		file.add(new JMenuItem("파일 불러오기"));
		file.add(new JMenuItem("서버 저장"));
		file.add(new JMenuItem("서버에 동기화"));
		file.addSeparator();
		file.add(new JMenuItem("나가기"));
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
