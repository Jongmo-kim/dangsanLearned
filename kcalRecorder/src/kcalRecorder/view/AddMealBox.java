package kcalRecorder.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kcalRecorder.model.vo.Food;


public class AddMealBox extends JFrame{
	ArrayList<Food> addedFood;
	nameInputPanel nameInputPanel;
	kcalPer100GramInputPanel kcalPer100GramInputPanel;
	sizeInputPanel sizeInputPanel; 
	public AddMealBox() {
		addedFood = new ArrayList<Food>();
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
			add(nameInputPanel = new nameInputPanel());
			add(kcalPer100GramInputPanel = new kcalPer100GramInputPanel());
			add(sizeInputPanel = new sizeInputPanel());
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
			ActionListener e = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addFoodFromTextField();
					updateAddedPanel();
				}
			};
			return e;
		}
	}
	public void updateAddedPanel() {
		
	}
	
	public void addFoodFromTextField() {
		String name = nameInputPanel.getText();
		String kcalPerGram = kcalPer100GramInputPanel.getText();
		String size = sizeInputPanel.getText();
		int kcal = Integer.parseInt(kcalPerGram);
		double size_ = Double.parseDouble(size);

		Food f = new Food(kcal, size_, name);
		addedFood.add(f);
	}
	public class addedFoodPanel extends JPanel{
		public addedFoodPanel(Food f) {
			setLayout(new FlowLayout());
			add(new JLabel(f.getName()));
			add(new JLabel(Double.toString(f.getSize())));
			add(new JLabel(Integer.toString(f.getTotalKcal())));
		}
	}
	public class confirmButton extends JButton{
		confirmButton(String s){
			super(s);
			addActionListener(confirmButtonActionListener());
		}
		public ActionListener confirmButtonActionListener() {
			return null;
		}
	}
	public class nameInputPanel extends JPanel{
		JLabel nameInputLabel;
		JTextField nameInputField;
		nameInputPanel(){
			add(nameInputLabel = new JLabel("* Name\t"));
			add(nameInputField = new JTextField(10));
		}
		public JLabel getLabel() {
			return nameInputLabel;
		}
		public String getText() {
			String s =nameInputField.getText();
			nameInputField.setText("");
			return s;
		}
	}
	public class kcalPer100GramInputPanel extends JPanel{
		JLabel kcalPer100GramLabel;
		JTextField kcalPer100GramField;
		kcalPer100GramInputPanel(){
			add(kcalPer100GramLabel = new JLabel("* Kcal Per 100 Gram\t"));
			add(kcalPer100GramField = new JTextField(10));
		}
		public JLabel getLabel() {
			return kcalPer100GramLabel;
		}
		public String getText() {
			String s =kcalPer100GramField.getText();
			kcalPer100GramField.setText("");
			return s;
		}
		
	}
	public class sizeInputPanel extends JPanel{
		JLabel sizeLabel;
		JTextField sizeField;
		sizeInputPanel(){
			add(sizeLabel = new JLabel("* Size \t"));
			add(sizeField = new JTextField(10));
		}
		public JLabel getSizeLabel() {
			return sizeLabel;
		}
		public String getText() {
			String s =sizeField.getText();
			sizeField.setText("");
			return s;
		}
		
	}
	public class addedPanel extends JPanel{
		public addedPanel() {
			setBorder(BorderFactory.createLineBorder(Color.black));
			add(new JLabel("* 먹은 음식들"));
		}
	}
}
