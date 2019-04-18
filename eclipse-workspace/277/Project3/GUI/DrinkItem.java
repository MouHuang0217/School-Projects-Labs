package GUI;
import java.util.ArrayList;

public abstract class DrinkItem extends Item {
	protected String size;
	protected String flavor;
	protected String sweetness;
	protected String milk;
	/**
	 * default constructor 
	 */
	public DrinkItem() {
		this.size = "";
		this.flavor = "";
		this.sweetness = "";
		this.milk = "";
	}
	/**
	 * create a Drink Item with these parameters
	 * @param name is the name of the drink
	 * @param size is the size of the drink
	 * @param flavor is the flavor of the drink
	 * @param sweetness is the sweetness of the drink
	 * @param milk is the milk of the drink
	 * @param cost is the cost of the drink
	 */
	public DrinkItem(String name,String size, String flavor, String sweetness, String milk) {
		super(name,cost);
		this.size = size;
		this.flavor = flavor;
		this.sweetness = sweetness;
		this.milk = milk;
	}
	/**
	 * gets the flavor of the drink
	 * @return the flavor of the drink
	 */
	public String getFlavor() {
		return flavor;
	}
	/**
	 * sets the flavor of the drink
	 * @param flavor is the flavor of the drink 
	 */
	public void setFlavor(String flavor) {
		this.flavor = flavor;
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
	 * gets the sweetness of the drink
	 * @return the sweetness of the drink
	 */
	public String getSweetness() {
		return sweetness;
	}
	/**
	 * sets the sweetness of the drink
	 * @param sweetness is the sweetness of the drink
	 */
	public void setSweetness(String sweetness) {
		this.sweetness = sweetness;
	}
	/**
	 * gets the toString of an item
	 * @return the string of the item
	 */
	public String toString () {
		return String.format("%-15%s (%s) %s sweet %s \n",getFlavor(),getSize(),getSweetness(),getMilk());
	}


}
