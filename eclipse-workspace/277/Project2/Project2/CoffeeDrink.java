package Project2;

public class CoffeeDrink extends DrinkItem{
	/**
	 * creates a coffee drink with the paramenters
	 * @param name is the name of the drink 
	 * @param size is the size of the drink 
	 * @param sweet is the sweetness of the drink
	 * @param milk is the milk base of the drink.
	 */
	public CoffeeDrink(String name,String size, String sweet,String base) {
		super(name,size,sweet);
		this.base = base;
	}
	@Override
	public void display() {
		String leftAlignFormat = "\n%-20s %-5s  %28s%.2f %n";
		System.out.printf(leftAlignFormat,"Coffee",getSize(),"$",getCost());
		//System.out.printf("\t -%s \n\t -%s sweetness \n\t -%s",getMilk(),getSweet(),getTopping());

		System.out.printf("\t -%s sweetness \n\t -%s base",getSweet(),getBase());
	}
	@Override
	public double getCost() {
		if (super.getSize().equals("S")) {
			return 4.0;
		}
		else if (super.getSize().equals("M")) {
			return 4.5;
		}
		else {
			return 5.0;
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
