package GUI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class teaFrame extends JFrame implements ActionListener{
	private JLabel instructions;
	private JLabel Finstructions;
	private JLabel Sinstructions;
	private JLabel SWinstructions;
	private JLabel Minstructions;
	private JLabel Tinstructions;
	private JComboBox<String> flavor;
	private JComboBox<String> sizes;
	private JComboBox<String> teaspoons;
	private JComboBox<String> milkBase;
	private JComboBox<String> blended;
	private JCheckBox boba;
	private JCheckBox poppingboba;
	private JCheckBox grassjelly;
	private JCheckBox lychee;
	private JCheckBox coconut;
	private JCheckBox minimochi;
	private JButton saveButton;
	private JButton cancelButton;
	public teaFrame() {
		createComponents();
		this.setTitle("New Tea Order");
		this.setSize(1070, 400);
	}
	private void createComponents() {
		cancelButton = new JButton("Cancel");
		instructions = new JLabel("Specify the tea order : ");
		Finstructions = new JLabel("flavor: ");
		Sinstructions = new JLabel("size: ");
		SWinstructions = new JLabel("sugar: ");
		Minstructions = new JLabel("milk "); 
		Tinstructions = new JLabel("type: "); 
		saveButton = new JButton("Save Order");
		
		String[] flavors = {"green tea","black tea", "jasmine green tea", "rose tea","oolong tea"};
		flavor = new JComboBox<String>(flavors);
		
		String[] size = {"S","M","L"};
		sizes = new JComboBox<String> (size);
		
		String[] sweetness = {"full","3/4 sweet", "1/2 sweet","1/4 sweet", "unsweetended"};
		teaspoons = new JComboBox<String> (sweetness);
		
		String[] bases = {"whole milk", "half-and-half","no milk"};
		milkBase = new JComboBox<String>(bases);
		
		boba = new JCheckBox("boba");
		
		saveButton.addActionListener(this); 
		cancelButton.addActionListener(this);
		
		boba = new JCheckBox("Boba");
		poppingboba = new JCheckBox("popping boba");
		grassjelly = new JCheckBox("grass jelly");
		lychee = new JCheckBox("lychee-jelly");
		coconut = new JCheckBox("coconut jelly");
		minimochi = new JCheckBox("mini mochi");
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

		panel.add(saveButton);
		panel.add(cancelButton);
		panel.add(boba);
		panel.add(poppingboba);
		panel.add(grassjelly);
		panel.add(lychee);
		panel.add(coconut);
		panel.add(minimochi);
		
		this.add(panel);
	}

	@Override

	public void actionPerformed(ActionEvent click) {
		if (click.getSource() == saveButton) {
			String selectedFlavor = (String)flavor.getSelectedItem();
			String selectedSize = (String)sizes.getSelectedItem();
			String selectedSweet = (String)teaspoons.getSelectedItem();
			String selectedBase = (String)milkBase.getSelectedItem();
			
			TeaItem drink = new TeaItem(selectedSize,selectedFlavor,selectedSweet,selectedBase);
			
			if(boba.isSelected()) {
				drink.addTopping("boba");
			}
			if(poppingboba.isSelected()) {
				drink.addTopping("popping boba");
			}
			if(grassjelly.isSelected()) {
				drink.addTopping("grass jelly");
			}
			if(lychee.isSelected()) {
				drink.addTopping("lychee jelly");
			}
			if(coconut.isSelected()) {
				drink.addTopping("coconut jelly");
			}
			if(minimochi.isSelected()) {
				drink.addTopping("mini mochi");
			}
			PurchaseFrame.addItem(drink);
			PurchaseFrame newFrame = new PurchaseFrame();
			newFrame.setVisible(true);
		}
		if (click.getSource() == cancelButton) {
			PurchaseFrame newFrame = new PurchaseFrame();
			newFrame.setVisible(true);
		}
		Component b = (Component) click.getSource(); //e.getSource() returns Object 

		JFrame c = (JFrame) SwingUtilities.getRoot(b);
		c.setVisible(false);

		

		
	}
	

}
