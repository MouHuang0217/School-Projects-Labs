package GUI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class pastryFrame extends JFrame implements ActionListener {
	private JComboBox<String> typeP;
	private JComboBox<String> selection;
	private JLabel heatedText;
	private JButton saveButton;
	private JButton cancelButton;
	private JCheckBox heated;
	public pastryFrame() {
		createComponents();
		this.setTitle("New Pastry Order");
		this.setSize(1200, 400);
	}

	public void createComponents() {
		String[] type = {"Muffin", "Cheesecake Slice", "Cookie","Danish"};
		typeP = new JComboBox<String>(type);
		selection = new JComboBox<String>();
		saveButton = new JButton("save");
		cancelButton = new JButton("cancel");
		heatedText = new JLabel("heated");
		heated = new JCheckBox();
		typeP.addActionListener(this);

		saveButton.addActionListener(this);
		cancelButton.addActionListener(this);

		JPanel panel = new JPanel();

		panel.add(typeP);
		panel.add(selection);
		panel.add(heatedText);
		panel.add(heated);
		panel.add(saveButton);
		panel.add(cancelButton);
		heatedText.setVisible(false);
		heated.setVisible(false);
		selection.setVisible(false);
		saveButton.setVisible(false);
		this.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		Object selected = typeP.getSelectedItem();
		if(selected.toString().equals("Muffin")) {
			System.out.println("Cookie got selected");
			String[] type2 = {"Banana Nut", "Blueberry", "Chocolate Chip","Coffee Cake"};
			selection.removeAllItems();
			for(String i :type2) {
				selection.addItem(i);
			}
			heatedText.setVisible(true);
			heated.setVisible(true);
			selection.setVisible(true);
			saveButton.setVisible(true);
		}
		if(selected.toString().equals("Cheesecake Slice")) {
			System.out.println("\"Cheesecake Slice\" got selected");
			String[] type2 = {"Regular","Cherry","Blueberry"};
			selection.removeAllItems();
			for(String i :type2) {
				selection.addItem(i);
			}			heatedText.setVisible(true);
			heated.setVisible(true);
			selection.setVisible(true);
			saveButton.setVisible(true);

		}
		if(selected.toString().equals("Cookie")) {
			System.out.println("Cookie got selected");
			String[] type2 = {"Oatmeal", "White Choco & Macadamias", "Chocolate Chip","Double Fudge"};
			selection.removeAllItems();
			for(String i :type2) {
				selection.addItem(i);
			}			heatedText.setVisible(true);
			heated.setVisible(true);
			selection.setVisible(true);
			saveButton.setVisible(true);

		}
		if(selected.toString().equals("Danish")) {
			String[] type2 = {"Apple Cinnamon","Strawberry & Cheese","Double Cheese"};
			
			selection.removeAllItems();
			for(String i :type2) {
				selection.addItem(i);
			}			heatedText.setVisible(true);
			heated.setVisible(true);
			selection.setVisible(true);
			saveButton.setVisible(true);
		
		}
		//public PastryItem(String name,String flavor, boolean heat) {

		if (event.getSource() == saveButton) {
			String name = (String)typeP.getSelectedItem();
			String flavor = selection.getSelectedItem().toString();
			System.out.println(flavor);

			boolean heat = (boolean)heated.isSelected();
			PastryItem x = new PastryItem(name,flavor,heat);
			System.out.println(x.toString());
			Component b = (Component) event.getSource(); //e.getSource() returns Object
			JFrame c = (JFrame) SwingUtilities.getRoot(b);
			c.setVisible(false);
			PurchaseFrame.addItem(x);
			PurchaseFrame newFrame = new PurchaseFrame();
			newFrame.setVisible(true);
			
			Component b1 = (Component) event.getSource(); //e.getSource() returns Object 

			JFrame c1 = (JFrame) SwingUtilities.getRoot(b1);
			c1.setVisible(false);
		}
		if (event.getSource() == cancelButton) {
			PurchaseFrame newFrame = new PurchaseFrame();
			newFrame.setVisible(true);
			Component b = (Component) event.getSource(); //e.getSource() returns Object 

			JFrame c = (JFrame) SwingUtilities.getRoot(b);
			c.setVisible(false);
		}


	}




}