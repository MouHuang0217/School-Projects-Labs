package GUI;
public class PastryItem extends Item{
	private boolean isHeated;
	private double HEAT_PRICE = 0.25;
	protected String flavor;
	private String names;
	/**
	 * default constructor for pastryItem
	 */
	public PastryItem() {
		super(name,cost);
		this.names = "";
		this.flavor = "";
		this.isHeated = false;
	}
	/**
	 * is the constructor of the pastry
	 * @param name is the name of the pastry
	 * @param quantity is the quantity of the pastry
	 * @param unitPrice is the unity price of the pastry
	 * @param heat is the heat of the pastry
	 */
	public PastryItem(String name,String flavor, boolean heat) {
		super(name, cost);
		this.names = name;
		this.flavor = flavor;
		this.isHeated = heat;
	}
	//return String.format("-%s Coffee (%s): %30s%.2f \n\tSweetness: %s \n\tMilk: %s \n\tTemp:%s  \n\tSpecial Instructions: %s\n",getFlavor(),getSize(),"$",getCost(),getSweetness(),getMilk(),temperature,specialInstructions);
	/**
	 * gets the String and return it
	 * @return the string of the pastry item
	 */
	public String toString() {
		String heated;
		if(this.isHeated == true) {
			heated = "heated";
		}
		else {
			heated = "not heated";
		}
		return String.format("\n%20s (%s)  \n\t%s \n\t\t\n%120s%.2f\n",this.names,heated,this.flavor,"$",getCost());
	}
	/**
	 * gets the price of heat
	 * @return the Heat price
	 */
	public double getHEAT_PRICE() {
		if (this.isHeated == false) {
			HEAT_PRICE = 0.0;
		}
		return HEAT_PRICE;
	}
	/**
	 * gets the total cost of the item
	 * @return the total cost of the item
	 */
	public double getCost() {
		if(getName().equals("Muffin")) {
			return 2.0 + getHEAT_PRICE();
		}
		if(getName().equals("Cheesecake Slice")) {
			if (this.flavor == "Regular"){
				return 4.0 + getHEAT_PRICE();
			}
			if (this.flavor == "Cherry"){
				return 4.5 + getHEAT_PRICE();
			}
			if (this.flavor == "Blueberry"){
				return 4.5 + getHEAT_PRICE();
			}
		}
		if(getName().equals("Cookie")) {
			return 1.5 + getHEAT_PRICE();
		}
		if(getName().equals("Danish")) {
			return 2.5 + getHEAT_PRICE();
		}
		return 0.0;
	}
	
}
