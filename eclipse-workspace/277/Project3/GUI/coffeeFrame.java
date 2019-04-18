package GUI;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
public class coffeeFrame extends JFrame implements ActionListener{
	
	protected String drink;
	private JLabel instructions;
	private JLabel Finstructions;
	private JLabel Sinstructions;
	private JLabel SWinstructions;
	private JLabel Minstructions;
	private JLabel Tinstructions;
	private JLabel text;
	
	private JComboBox<String> flavor;
	private JComboBox<String> sizes;
	private JComboBox<String> teaspoons;
	private JComboBox<String> milkBase;
	private JComboBox<String> blended;
	
	private JButton cancelButton;
	private JButton saveButton;
	
	private JTextField textField;

	public coffeeFrame() {
		createComponents();
		this.setTitle("New Coffee Order");
		this.setSize(800, 400);
		this.drink = "sadsad";
	}
	public void setCoffee(String coffee) {
		this.drink = coffee;
	}
	public String getCoffee() {
		return drink;
	}
	private void createComponents() {
		cancelButton = new JButton("Cancel");
				
		instructions = new JLabel("Specify the coffee order : ");
		Finstructions = new JLabel("flavor: ");
		Sinstructions = new JLabel("size: ");
		SWinstructions = new JLabel("sugar: ");
		Minstructions = new JLabel("milk "); 
		Tinstructions = new JLabel("type: "); 
		saveButton = new JButton("Save Order");
		text = new JLabel("special Instructions: ");
		String[] flavors = {"regular","mocha","hazelnut","vanilla"};
		flavor = new JComboBox<String>(flavors);
		
		String[] size = {"S","M","L"};
		sizes = new JComboBox<String> (size);
		
		String[] sweetness = {"1","2","3","4","5","6","7","8","9","10"};
		teaspoons = new JComboBox<String> (sweetness);
		
		String[] bases = {"whole milk", "half-and-half", "no milk"};
		milkBase = new JComboBox<String>(bases);
		
		String[] blends = {"Blended", "Hot", "Iced"};
		blended = new JComboBox<String>(blends);
		
		saveButton.addActionListener(this); //adding reaction instructions
		
		cancelButton.addActionListener(this);
		
		textField = new JTextField(50);
		
		JPanel panel = new JPanel();
		panel.add(instructions);
		panel.add(Finstructions);
		panel.add(flavor);
		panel.add(Sinstructions);
		panel.add(sizes);
		panel.add(SWinstructions);
		panel.add(teaspoons);
		panel.add(Minstructions);
		panel.add(milkBase);
		panel.add(Tinstructions);
		panel.add(blended);
		panel.add(text);
		panel.add(textField);
		panel.add(saveButton);
		panel.add(cancelButton);
		this.add(panel);
		
	}

		@Override
		public void actionPerformed(ActionEvent click) {
			if (click.getSource() == saveButton) {
				String selectedFlavor = (String)flavor.getSelectedItem();
				String selectedSize = (String)sizes.getSelectedItem();
				String selectedSweet = (String)teaspoons.getSelectedItem();
				String selectedBase = (String)milkBase.getSelectedItem();
				String selectedBlend = (String)blended.getSelectedItem();
				String special = (String)textField.getText();
				CoffeeItem drink = new CoffeeItem(selectedSize,selectedFlavor,selectedSweet,selectedBase,selectedBlend,special);
				PurchaseFrame.addItem(drink);
				PurchaseFrame newFrame = new PurchaseFrame();
				newFrame.setVisible(true);
			}
			if(click.getSource() == cancelButton) {
				PurchaseFrame newFrame = new PurchaseFrame();
				newFrame.setVisible(true);
			}
			Component b = (Component) click.getSource(); //e.getSource() returns Object 
			JFrame c = (JFrame) SwingUtilities.getRoot(b);
			c.setVisible(false);
			
		}
	
}
