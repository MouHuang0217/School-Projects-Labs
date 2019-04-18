package GUI;

public class CoffeeItem extends DrinkItem{
	protected String temperature;
	protected String specialInstructions;
	/**
	 * default constructor for coffee
	 */
	public CoffeeItem() {
		super("","","","","");
		this.temperature = "";
		this.specialInstructions = "";
	}
	/**
	 * creates a coffee drink with the paramenters
	 * @param name is the name of the drink 
	 * @param size is the size of the drink 
	 * @param sweet is the sweetness of the drink
	 * @param milk is the milk base of the drink.
	 */
	public CoffeeItem(String size, String flavor, String sweetness, String milk,String temperature,String specialInstructions) {
		super(name, size,flavor,sweetness,milk);
		this.temperature = temperature;
		this.specialInstructions = specialInstructions;
	}
	
	/**
	 * display the CoffeItem drink
	 */
	public String toString() {
		//return String.format("\n%-20s %s \n\t%s \n\t%s \n\t%s \n\t%d",getName(),getSize(),getFlavor(),getSweetness(),getMilk(),getCost());

	return String.format("\n%20s Coffee (%s):  \n\t    Sweetness: %s \n\t    Milk: %s \n\t    Temp:%s  \n\t    Special Instructions: %s \n%120s%.2f\n",getFlavor(),getSize(),getSweetness(),getMilk(),temperature,specialInstructions,"$",getCost());
	}
	/**
	 * returns the cost of the item
	 * @return the cost of the item
	 */
	public double getCost() {
		double milk = 0.0;
		if(super.getMilk().equals("whole milk") ||  super.getMilk().equals("half-and-half")) {
			milk = 0.25;
		}
		else {
			milk = 0.0;
		}
		
		if (super.getSize().equals("S")) {
			if(temperature == "Hot" || temperature == "Iced") 
				return 1.0 + milk;
			return 1.25 + milk;
		}
		if (super.getSize().equals("M")) {
			if(temperature == "Hot" || temperature == "Iced") 
				return 1.5 + milk;
			return 1.75 + milk;
		}
		if (super.getSize().equals("L")) {
			if(temperature == "Hot" || temperature == "Iced") 
				return 2.0 + milk;
			return 2.25 + milk;
		}
		return 0;
	}

}
