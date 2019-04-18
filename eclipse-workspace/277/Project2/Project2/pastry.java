package Project2;
public class pastry extends DessertItem{
	/**
	 * is the constructor of the pastry
	 * @param name is the name of the pastry
	 * @param quantity is the quantity of the pastry
	 * @param unitPrice is the unity price of the pastry
	 * @param heat is the heat of the pastry
	 */
	public pastry(String name, int quantity,double unitPrice, String heat) {
		super(name,quantity);
		this.pas_price = unitPrice;
		this.heat = heat;
	}
	@Override
	public double getCost() {
		if (super.getHeat().equalsIgnoreCase("Hot"))
			return super.get_pas_price()*super.getQuantity() + (super.getQuantity()*0.25);
		return (super.get_pas_price()*super.getQuantity());
	}

	@Override
	public void display() {
		String leftAlignFormat = "\n%-18s x %-5d %29s%.2f \n";
		System.out.printf(leftAlignFormat,getName(),getQuantity(),"$",getCost());
		System.out.printf("\t  -%s",getHeat());
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
