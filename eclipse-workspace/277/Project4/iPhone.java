
public class iPhone extends Phone{
	public iPhone() {
		this.phone = "Samsung";
	}
	
	public Object makeCopy() {
		System.out.println("An iphone is being made");
		Object clone = null;
		try {
			clone = (iPhone) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clone;
	}
}
