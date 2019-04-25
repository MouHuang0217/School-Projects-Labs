
public abstract class Phone implements Cloneable {
	protected String phone;
	
	public Object makeCopy() {
		System.out.println("A phone is being made");
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clone;
	}

}
