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
public class newOrderFrame extends JFrame implements ActionListener {
	public static ArrayList<String> purchased = new ArrayList<String>();
	private JLabel instructions;
	private JButton coffeeButton;
	private JButton teaButton;
	private JButton pastryButton;
	private JButton doneButton;
	private JPanel p; 
	
	public JPanel getP() {
		return p;
	}

	public newOrderFrame() {
		createComponents();
		this.setTitle("New Order");
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
        p = new JPanel();
		p.add(instructions);
		p.add(coffeeButton);
		p.add(teaButton);
		p.add(pastryButton);
		
		p.add(doneButton);
		doneButton.setVisible(false);
		this.add(p);
		
	}

	@Override
	public void actionPerformed(ActionEvent click) {
		coffeeFrame coffee = new coffeeFrame();
			if (click.getSource() == coffeeButton) {
				coffee = new coffeeFrame();
				coffee.setVisible(true);
				coffee.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				doneButton.setVisible(true);
				JFrame c = (JFrame) SwingUtilities.getRoot(coffeeButton);
				c.revalidate();
				c.repaint();
			}
			if (click.getSource() == teaButton) {
				teaFrame tea = new teaFrame();
				tea.setVisible(true);
				tea.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				doneButton.setVisible(true);
				JFrame c = (JFrame) SwingUtilities.getRoot(teaButton);
				c.revalidate();
				c.repaint();
			}
			if (click.getSource() == pastryButton) {
				pastryFrame pastry = new pastryFrame();
				pastry.setVisible(true);
				pastry.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				doneButton.setVisible(true);
				JFrame c = (JFrame) SwingUtilities.getRoot(pastryButton);
				c.revalidate();
				c.repaint();
			}
			Component b = (Component) click.getSource(); //e.getSource() returns Object 

			JFrame c = (JFrame) SwingUtilities.getRoot(b);
			c.setVisible(false);
			
	}

	
}
