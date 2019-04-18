package GUI;
/**
 * Mou Huang
 * @author Mou Huang
 * @since 3/21/2019
 *
 */
public class Item {
	protected static String name;
	public static double cost;
	/**
	 * default constructor for item
	 */
	public Item() {
		this.name = "";
		Item.cost = 0.0;
	}
	/**
	 * constructor for Item
	 * @param name a String that represents the name of the item
	 * @param cost is a double that represents the cost of the item
	 */
	public Item(String name,double cost) {
		this.name = name;
		Item.cost = cost;
	}
	/**
	 * method that returns the name of the the item
	 * @return the name of the item
	 */
	public String getName() {
		return name;
	}
	/**
	 * sets the name of the item
	 * @param name is the name that will be set for the object Item
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * method that gets the cost of the item
	 * @return the cost of the item
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * method that sets the cost of the item
	 * @param cost is the cost that will be set for the object Item
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
