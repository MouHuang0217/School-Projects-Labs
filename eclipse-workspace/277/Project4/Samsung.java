
public class Samsung extends Phone {
	public Samsung() {
		this.phone = "Samsung";
	}
	public Object makeCopy() {
		System.out.println("A samsung phone is being made");
		Object clone = null;
		try {
			clone = (Samsung) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clone;
	}

}
