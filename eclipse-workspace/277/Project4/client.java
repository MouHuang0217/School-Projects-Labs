
public class client {

	public static void main(String[] args) {
		PhoneStore phonestore = new PhoneStore();
		//initialize default models
		iPhone iPhone = new iPhone();
		Samsung Samsung = new Samsung();
		Hwawei Hwawei = new Hwawei();
		
		iPhone clonediPhone = (iPhone) phonestore.clone(iPhone);
		Samsung clonedSamsung = (Samsung) phonestore.clone(Samsung);
		Hwawei clonedHwawei = (Hwawei) phonestore.clone(Hwawei);
		
		System.out.println(iPhone);
		System.out.println(clonediPhone);
		
		System.out.println(Samsung);
		System.out.println(clonedSamsung);
		
		System.out.println(Hwawei);
		System.out.println(clonedHwawei);
		
		System.out.println(clonediPhone.getClass());
		System.out.println(clonedSamsung.getClass());
		System.out.println(clonedHwawei.getClass());

	}

}
