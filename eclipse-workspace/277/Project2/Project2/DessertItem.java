package Project2;

public abstract class DessertItem implements Comparable<DessertItem>{
	private String name;
	private int quantity;
	protected String heat;
	protected double pas_price;
	protected double coo_price_dozen;
	protected double mac_price;
	protected double mac_price_three;

	/**
	 * default constructor for dessertItem
	 */
	public DessertItem() {
	}
	/**
	 * DessertItem constuctor
	 * @param name is the pastry's name
	 * @param quantity is the amount of dessert item
	 */
	public DessertItem(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}
	
	/**
	 * set the pastries price
	 * @param pas_price is the pastries price
 	 */
	public void set_pas_price(int pas_price) {
		this.pas_price = pas_price;
	}
	/**
	 * gets the pastry's price
	 * @return the pastry's price
	 */
	public double get_pas_price() {
		return pas_price;
	}
	/**
	 * set the cookie price for a dozen
	 * @param coo_price_dozen is the price for a dozen of cookie
	 */
	public void set_coo_price_dozen(int coo_price_dozen) {
		this.coo_price_dozen = coo_price_dozen;
	}
	/**
	 * get the cookie's price per dozen
	 * @return the price per dozen
	 */
	public double get_coo_price_dozen() {
		return coo_price_dozen;
	}
	/**
	 * sets the price of the macaroon
	 * @param mac_price is the price of the macaroon
	 */
	public void set_mac_price(double mac_price) {
		this.mac_price = mac_price;
	}
	/**
	 * gets the price of the macaroon
	 * @return the price of the macaroon
	 */
	public double get_mac_price() {
		return mac_price;
	}
	/**
	 * sets the price for three macaroons
	 * @param mac_price_three is the price for 3 macaroons
	 */
	public void set_mac_price_three(double mac_price_three) {
		this.mac_price_three = mac_price_three;
	}
	/**
	 * gets the price for three macaroons
	 * @return the price for three macaroons 
	 */
	public double get_mac_price_three() {
		return mac_price_three;
	}
	/**
	 * sets the name of the dessert item
	 * @param name is the name of the dessert item
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * gets the name of the dessert item
	 * @return the name of the dessert item
	 */
	public String getName() {
		return name;
	}
	/**
	 * sets the quantity of the dessert item
	 * @param quantity is the quantity of the dessert item
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * gets the quantity of the dessert item
	 * @param quantity is the quantity of the dessert item
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * sets the heat of the pastry
	 * @param heat is the heat of the pastry
	 */
	public void setHeat(String heat) {
		this.heat = heat;
	}
	/**
	 * gets the heat of the pastry
	 * @return the heat of the pastry
	 */
	public String getHeat() {
		return heat;
	}
	/**
	 * display the object in a receipt form
	 */
	public abstract void display();
	/**
	 * calculates the cost of the drink 
	 * @return the cost of the drink
	 */
	public abstract double getCost();
	/**
	 * compares the object dessert items with each other
	 */
	public abstract int compareTo(DessertItem other);
}
