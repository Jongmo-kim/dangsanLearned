package kcalRecorder.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddMealBox extends JFrame{
	public AddMealBox() {
		setDefaultOptions();
		setGridBagConstraintsLayout();
	}
	private void setGridBagConstraintsLayout() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill=GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		addPanel ap = new addPanel();
		
		add(ap,gbc);
		
		addedPanel addedPanel = new addedPanel();
		//addedPanel.setPreferredSize(new Dimension(200,150));
		gbc.weightx = 0.6; 
		gbc.weighty = 1;
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
			setBorder(BorderFactory.createLineBorder(Color.black));
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			add(new JLabel("먹을것 추가하기"));
			add(new nameInputPanel());
			add(new kcalPer100GramInputPanel());
			add(new sizeInputPanel());
			JPanel temp = new JPanel();
			temp.add(new addButton("추가"));
			temp.add(new confirmButton("완료"));
			add(temp);
//			add(new confirmButton("완료"));
//			add(new addButton("추가"));
			
		}
	}
	public class addButton extends JButton{
		addButton(String s){
			super(s);
			addActionListener(addButtonActionListener());
		}
		public ActionListener addButtonActionListener() {
			//TODO right now
		}
	}
	public class confirmButton extends JButton{
		confirmButton(String s){
			super(s);
			addActionListener(confirmButtonActionListener());
		}
		public ActionListener confirmButtonActionListener() {
			//TODO too
		}
	}
	public class nameInputPanel extends JPanel{
		nameInputPanel(){
			JLabel firstLabel;
			JTextField firstField;
			add(firstLabel = new JLabel("* Name\t"));
			add(firstField = new JTextField(10));
		}
	}
	public class kcalPer100GramInputPanel extends JPanel{
		kcalPer100GramInputPanel(){
			JLabel kcalPer100GramLabel;
			JTextField kcalPer100GramField;
			add(kcalPer100GramLabel = new JLabel("* Kcal Per 100 Gram\t"));
			add(kcalPer100GramField = new JTextField(10));
		}
	}
	public class sizeInputPanel extends JPanel{
		sizeInputPanel(){
			JLabel sizeLabel;
			JTextField sizeField;
			add(sizeLabel = new JLabel("* Size \t"));
			add(sizeField = new JTextField(10));
		}
	}
	public class addedPanel extends JPanel{
		public addedPanel() {
			setBorder(BorderFactory.createLineBorder(Color.black));
			add(new JLabel("* 정보"));
		}
	}
}
