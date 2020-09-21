package kcalRecorder.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class addMealBox extends JFrame{
	public addMealBox() {
		setDefaultOptions();
		setGridBagConstraintsLayout();
	}
	private void setGridBagConstraintsLayout() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill=GridBagConstraints.BOTH;
		gbc.weightx = 0.3;
		gbc.weighty = 0;
		addPanel ap = new addPanel();
		ap.setPreferredSize(new Dimension(100,150));
		add(ap,gbc);
		
		addedPanel addedPanel = new addedPanel();
		addedPanel.setPreferredSize(new Dimension(200,150));
		gbc.weightx = 0.1; 
		gbc.weighty = 0;
		add(addedPanel,gbc);
	}
	
	private void setDefaultOptions() {
		setSize(700,400);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new GridLayout(1,2));
	}
	public class addPanel extends JPanel{
		public addPanel() {
			setLayout(new FlowLayout());
			add(new JLabel("* 정보"));
			add(new JTextField());
			add(new JLabel("* 정보"));
			add(new JTextField());
			add(new JLabel("* 정보"));
			add(new JTextField());
		}
	}
	public class addedPanel extends JPanel{
		public addedPanel() {
			add(new JLabel("* 정보"));
		}
	}
}
