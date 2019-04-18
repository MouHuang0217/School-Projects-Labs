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
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
public class finalizeFrame extends JFrame implements ActionListener {
	private JPanel p;
	private JLabel AmountDue;
	private JLabel payment;
	private JTextArea textArea;
	private JScrollPane scrollableTextArea;
	private JButton payButton;
	private JButton exitButton;
	private double total;
	private double tax;
	private static double paid;
	private JTextField textField;
	private static int count;
	
	public finalizeFrame() {
		createComponents();
		this.setTitle("Finalize Order");
		this.setSize(500,800);
//		this.setTitle("New Coffee Order");
//		this.setSize(1070, 400);
	}

	/**
	 * 
	 */
	private void createComponents() 
	{
		p = new JPanel();
		textArea = new JTextArea(40, 40);
		textArea.setEditable(false);
		
		ArrayList<Item> purchased = PurchaseFrame.getPurchased();
		textArea.append("----------------------------------------------Current Order-----------------------------------------------\n");
		for (Item x : purchased) {
			textArea.append(x.toString());
			total = total + x.getCost();
		}
        tax = total * 0.1;
		String totalString = String.format("Amount due: $%.2f", total+tax-paid);
		AmountDue = new JLabel(totalString);
	

        textArea.append(String.format("\n\n\n%13ssubtotal: $%.2f ","", total));
        textArea.append(String.format("\n%13stax: $%.2f ","", tax));
        textArea.append(String.format("\n%13sgrandTotal: $%.2f ","", total + tax));
		scrollableTextArea = new JScrollPane(textArea);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
        payment = new JLabel("Payment: $");
		textField = new JTextField(10);
		payButton = new JButton("Pay");
		payButton.addActionListener(this);
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		exitButton.setVisible(false);
		if(paid < (total + tax) && count > 0) {
			String totalString1 = String.format("Insufficient amount still due: $%.2f", total+tax-paid);
			AmountDue = new JLabel(totalString1);
		}
		if(paid > (total+tax)) {
			AmountDue = new JLabel("Thanks");
			payment.setVisible(false);
			textField.setVisible(false);
			payButton.setVisible(false);
			exitButton.setVisible(true);
			textArea.append(String.format("\n\n\n%13sPayment: $%.2f","", paid));
			textArea.append(String.format("\n%13sChange due: $%.2f","", paid- (total+tax)));
			textArea.append("\n\n\n                     \t~~~~~~~~~~~~~Thank You~~~~~~~~~~~~~");
		}
        p.add(AmountDue);
        p.add(scrollableTextArea);
        p.add(payment);
        p.add(textField);
        p.add(payButton);
        p.add(exitButton);
        count ++;
		this.add(p);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == payButton) {
			String amountPaid = (String)textField.getText();
			paid += Double.parseDouble(amountPaid);
			
			finalizeFrame x = new finalizeFrame();
			x.setVisible(true);
			
		}
		Component b = (Component) event.getSource(); //e.getSource() returns Object 
		JFrame c = (JFrame) SwingUtilities.getRoot(b);
		c.setVisible(false);
		
	}
}
