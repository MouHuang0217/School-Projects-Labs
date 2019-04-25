
public class Hwawei extends Phone{
	public Hwawei() {
		this.phone = "Hwawei";
	}
	public Object makeCopy() {
		System.out.println("A hwawei phone is being made");
		Object clone = null;
		try {
			clone = (Hwawei) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clone;
	}
}
