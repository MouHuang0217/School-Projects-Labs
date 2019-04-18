package Project2;
import java.util.ArrayList;

public class BobaDrink extends DrinkItem{

	protected ArrayList<String> bobaList;
	/***
	 * creates a bobaDrink 
	 * @param name is the name of the drink
	 * @param size is the size of the drink
	 * @param milk is the base of the drink
	 * @param sweetness is how sweet the drink will be 
 	 * @param topping is the amount of toppings
 	 * @param bobaList is the list of boba created for the drink
	 */
	public BobaDrink(String name,  String size, String milk, String sweetness,int topping,ArrayList<String> bobaList) {
		super(name, size, sweetness);
		this.milk = milk;
		this.topping = topping;
		this.bobaList = bobaList;
	}	
	/**
	 * prints all the toppings used to create the drink
	 */
	public void topOrders() {
		ArrayList <String> bobaOrder = getBobaList();
		for (String i: bobaOrder) {
			System.out.print("\n\t   -" + i);
		}
	}
	/**
	 * returns the boba arraylist
	 * @return the boba arraylist
	 */
	public ArrayList<String> getBobaList() {
		return bobaList;
	}
	/**
	 * set the arraylist of these specific drink
	 * @param bobaList is the list of bobas that the drink creates.
	 */
	public void setBobaList(ArrayList<String> bobaList) {
		this.bobaList = bobaList;
	}
	@Override
	public void display() {
		//String leftAlignFormat = "%-20s %-5s (%s) %-8s sweet %-22s%.2f %n";
		String leftAlignFormat = "\n%-20s %-5s %5d topping(s) %12s%.2f %n";
		System.out.printf(leftAlignFormat,getDrink(),getSize(),getTopping(),"$",getCost());
		System.out.printf("\t -%s base\n\t -%s sweetness",getMilk(),getSweet(),getTopping());
		topOrders();
	}
	@Override 
	public double getCost() {
		if (super.getSize().equals("S")) {
			return (4.00 + (super.getTopping() * .50));
		}
		else if (super.getSize().equals("M")) {
			return (4.50 + (super.getTopping() * .50));
		}
		else {
			return (5.00 + (super.getTopping() * .50));
		}
	}
	@Override
	public int compareTo(DrinkItem other) {
		if (this.getCost() < other.getCost()) {
			return -1;
		}
		else if (this.getCost() > other.getCost()) {
			return 1;
		}
		return 0;
	}
}
