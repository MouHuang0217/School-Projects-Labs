package GUI;
import java.util.ArrayList;

public class TeaItem extends DrinkItem{
	protected ArrayList<String> bobaList = new ArrayList<String>();
	/**
	 * default constructor for teaItem
	 */
	public TeaItem() {
		super("","","","","");
	}
	/***
	 * creates a bobaDrink 
	 * @param name is the name of the drink
	 * @param size is the size of the drink
	 * @param milk is the base of the drink
	 * @param sweetness is how sweet the drink will be 
	 * @param bobaList 
 	 * @param topping is the amount of toppings
 	 * @param bobaList is the list of boba created for the drink
	 */
	public TeaItem(String size, String flavor, String sweetness,String milk) {
		super(name, size, flavor, sweetness, milk);
	}	
	/**
	 * gets the baseprice of the drink
	 * @return is the base price of the drink
	 */
	public double getBasePrice() {
		if (super.getSize().equals("S")) {
			return (2.50);
		}
		else if (super.getSize().equals("M")) {
			return (3.00);
		}
		else {
			return (3.50);
		}
	}
	/**
	 * add toppings to array
	 * @param x is the arraylist of bobas
	 */
	public void addTopping (String x) {
		bobaList.add(x);
	}
	/**
	 * gets the total cost of the drink
	 * @return the total cost of the drink
	 */
	public double getCost() {
		double toppingCost = 0.0;
		for(String i: bobaList) {
			toppingCost += 0.25;
		}
		double milk = 0.0;
		if(super.getMilk().equals("whole milk") ||  super.getMilk().equals("half-and-half")) {
			milk = 0.25;
		}
		else {
			milk = 0.0;
		}
		if (super.getSize().equals("S")) {
			return getBasePrice() + milk + toppingCost;
		}
		if (super.getSize().equals("M")) {
			return getBasePrice() + milk + toppingCost;
		}
		if (super.getSize().equals("L")) {
			return getBasePrice() + milk + toppingCost;
		}
		return 0;
	}
	/**
	 * returns thhe string format
	 * @return the string format
	 */
	public String toString() {
		String bobaLists = "";
		for (String i : bobaList) {
			bobaLists += (i + " ");
		}
		return String.format("\n%22s Tea (%s):\n\t    Sweetness: %s \n\t    Milk: %s \n\t    Toppings: %s\n\t\t\n%120s%.2f\n",getFlavor(),getSize(),getSweetness(),getMilk(),bobaLists,"$",getCost());
	}
}
