package GUI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
public class PurchaseFrame extends JFrame implements ActionListener {
	public static ArrayList<Item> purchased = new ArrayList<Item>();
	private JLabel instructions;
	private JButton coffeeButton;
	private JButton teaButton;
	private JButton pastryButton;
	private JButton doneButton;

	private JTextArea textArea;
	private JScrollPane scrollableTextArea;
	private JPanel p; 
	private double total;
	private double tax;

	public PurchaseFrame() {
		createComponents();
		this.setTitle("New Order");
		this.setSize(500, 800);
		if (total == 0.0) {
			this.setSize(500,300);
        	scrollableTextArea.setVisible(false);
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void addItem(Item i) {
		purchased.add(i);
	}
	private void createComponents() {
		instructions = new JLabel("Select an item to purchase: ");
		coffeeButton = new JButton("Coffee");
		teaButton = new JButton("Tea");
		pastryButton = new JButton("Pastry");
		doneButton = new JButton("done");
		
		coffeeButton.addActionListener(this);
		teaButton.addActionListener(this);
		pastryButton.addActionListener(this);
		doneButton.addActionListener(this);
		
		textArea = new JTextArea(40, 40);
		textArea.setEditable(false);
		textArea.append("----------------------------------------------Current Order-----------------------------------------------\n");
        for (Item x : purchased) {
        	textArea.append(x.toString());
        	total = total + x.getCost();
        }
        tax = total * 0.1;
        textArea.append(String.format("\n\n\n%13s subtotal: %.2f ","", total));
        textArea.append(String.format("\n%13s tax: $%.2f "," ", tax));
        textArea.append(String.format("\n%13s grandTotal: $%.2f ","", total + tax));

       
		scrollableTextArea = new JScrollPane(textArea);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
        
        p = new JPanel();
		p.add(instructions);
		p.add(coffeeButton);
		p.add(teaButton);
		p.add(pastryButton);
		
		p.add(scrollableTextArea);
		p.add(doneButton);
		
		this.add(p);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent click) {
		if (click.getSource() == coffeeButton) {
				coffeeFrame coffee = new coffeeFrame();
				coffee.setVisible(true);
				coffee.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				
				JFrame c = (JFrame) SwingUtilities.getRoot(coffeeButton);
				c.revalidate();
				c.repaint();
		}
		if (click.getSource() == teaButton) {
				teaFrame tea = new teaFrame();
				tea.setVisible(true);
				tea.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

				JFrame c = (JFrame) SwingUtilities.getRoot(teaButton);
				c.revalidate();
				c.repaint();
		}
		if (click.getSource() == pastryButton) {
				pastryFrame pastry = new pastryFrame();
				pastry.setVisible(true);
				pastry.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

				JFrame c = (JFrame) SwingUtilities.getRoot(pastryButton);
				c.revalidate();
				c.repaint();
		}
		if (click.getSource() == doneButton) {
			finalizeFrame finalFrame = new finalizeFrame();
			finalFrame.setVisible(true);
			JFrame c = (JFrame) SwingUtilities.getRoot(pastryButton);
			c.revalidate();
			c.repaint();
		}
		Component b = (Component) click.getSource(); //e.getSource() returns Object 
		JFrame c = (JFrame) SwingUtilities.getRoot(b);
		c.setVisible(false);
	}
	public static ArrayList<Item> getPurchased() {
		return purchased;
	}

	

}
