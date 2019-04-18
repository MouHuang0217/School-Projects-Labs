package Project2;
import java.util.ArrayList;

public abstract class DrinkItem implements Comparable<DrinkItem> {
	private String drink;
	private String size;
	protected String milk;
	private String sweetness;
	protected String base;
	protected int topping;
	protected ArrayList<String> bobaOrder;
	/**
	 * default constructor 
	 */
	public DrinkItem() {
	}
	/**
	 * creates a constructor of a drink
	 * @param drink is the name of the drink
	 * @param size is the size of the drink
	 * @param sweetness is the sweetness of the drink
	 */
	public DrinkItem(String drink, String size, String sweetness) {
		this.setDrink(drink);
		this.setSize(size);
		this.setSweet(sweetness);
	}
	
	/**
	 * gets the name of the drink
	 * @return the name of the drink
	 */
	public String getDrink() {
		return drink;
	}
	/**
	 * sets the name of the object drink
	 * @param drink is the name of the drink
	 */
	public void setDrink(String drink) {
		this.drink = drink;
	}
	/**
	 * gets the size of the drink 
	 * @return returns the size of the drink
	 */
	public String getSize() {
		return size;
	}
	/**
	 * sets the size of the drink
	 * @param size is the size of the drink 
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * gets the base of the drink
	 * @return the base of the drink
	 */
	public String getMilk() {
		return milk;
	}
	/**
	 * sets the base of the drink 
	 * @param milk is the base of the drink
	 */
	public void setMilk(String milk) {
		this.milk = milk;
	}
	/**
	 * gets the sweetness of the drink
	 * @return the sweetness level of the drink
	 */
	public String getSweet() {
		return sweetness;
	}
	/**
	 * sets the sweetness level for a drink
	 * @param sweetness is the sweetness level 
	 */
	public void setSweet(String sweetness) { 
		this.sweetness = sweetness;
	}
	/**
	 * gets the count of toppings of a drink
	 * @return the number of toppings
	 */
	public int getTopping() {
		return topping;
	}
	/**
	 * sets the number of the topping
	 * @param topping is the number of toppings for the drink
	 */
	public void setTopping(int topping) {
		this.topping = topping;
	}
	/**
	 * gets the base of the drink
	 * @return the base of the drink
	 */
	public String getBase() {
		return base;
	}
	/**
	 * sets the base of the drink 
	 * @param base is the base of the drink
	 */
	public void setBase(String base) { 
		this.base = base;
	}
	/**
	 * display the drink 
	 */
	public void display () {
		System.out.printf("%-15 %s %s (%s) %s sweet + %d toppings \n",getDrink(),getSize(),getMilk(),getSweet(),getTopping());
	}
	/**
	 * abstract getCost for the subclasses
	 * @return null
	 */
	public abstract double getCost();
	/**
	 * abstract compareTo inherited for the subclasses
	 * @return null
	 */
	public abstract int compareTo(DrinkItem other);


}
