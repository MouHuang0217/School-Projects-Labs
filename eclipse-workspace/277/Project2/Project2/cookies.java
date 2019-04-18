package Project2;

public class cookies extends DessertItem{
	/**
	 * constructor of the cookie
	 * @param name is the type of cookie
	 * @param quantity is the quantity of the cookie 
	 * @param price is the price for twenty for a cookie
	 */
	public cookies (String name,int quantity,double price) {
		super(name,quantity);
		this.coo_price_dozen = price;
	}
	@Override
	public void display() {
		//String leftAlignFormat = "%s mac %5s %-5d %29s%.2f \n";
		String leftAlignFormat = "\n%s %10s %-5d  %27s%.2f %n";
		System.out.printf(leftAlignFormat,getName(),"x",getQuantity(),"$",getCost());
	}

	@Override
	public double getCost() {
		int quantity = super.getQuantity();
		double price = 0;
		if (quantity == 12) {
			return super.get_coo_price_dozen();
		}
		else if(quantity <12) {
			return (super.get_coo_price_dozen()/12) * quantity;
		}
		else {
			while(quantity > 12) {
				quantity = quantity - 12;
				price += super.get_coo_price_dozen();
			}
			price += (super.get_coo_price_dozen()/12) * quantity;
			return price;
		}
		
	}
	@Override
	public int compareTo(DessertItem other) {
		if (this.getCost() < other.getCost()) {
			return -1;
		}
		else if (this.getCost() > other.getCost()) {
			return 1;
		}
		return 0;
	}

}
