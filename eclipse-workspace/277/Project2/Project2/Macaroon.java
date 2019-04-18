package Project2;

public class Macaroon extends DessertItem{
	/**
	 * is the constructor of the macaroon 
	 * @param name is the name of the macaroon 
	 * @param quantity is the quantity of the macaroons bought 
	 * @param mac_price is the price of the macaroon 
	 * @param mac_price_three is the price for three for the macaroon
	 */
	public Macaroon(String name, int quantity, double mac_price,double mac_price_three) {
		super(name, quantity);
		this.mac_price = mac_price;
		this.mac_price_three = mac_price_three;
	}

	@Override
	public void display() {
		String leftAlignFormat = "\n%s mac %5s %-5d %29s%.2f \n";
		System.out.printf(leftAlignFormat,getName(),"x",getQuantity(),"$",getCost());
	}

	@Override
	public double getCost() {
		int quantity = super.getQuantity();
		double price = 0;
		if (quantity % 3 == 0) {
			return super.get_mac_price_three()*(quantity/3);
		}
		else if (quantity < 3) {
			return (super.get_mac_price()*quantity);
		}
		else {
			while (quantity > 3) {
				price += super.get_mac_price_three();
				quantity = quantity - 3;
			}
			price += (super.get_mac_price()*quantity);
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
