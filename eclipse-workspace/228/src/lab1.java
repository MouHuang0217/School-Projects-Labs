
public class lab1 {

	public static void main(String[] args) {
		System.out.print("p \t q \t r \t s \t t");
		boolean p = true;
		boolean q = true;
		boolean r = true;
		boolean s = true;
		boolean t = true;
		int line = 1;
		int count = 0;
		int maxlines = 32;
		
		for (int i = 0; i < maxlines; i++) {
			System.out.printf("\n%b \t %b \t %b \t %b \t %b \t line %d", p,q,r,s,t,line);
			line += 1;
			count += 1;
			if (line % 16 == 1) { //lines after 16 p is false
				p = false;
			if (line % 2 == 0) { //odd lines
				t = false;
			}
			if (line % 2 == 1) { //even lines
				t = true;
			}
			
			
		}
	}
}
}
	/*public static String implication (boolean p , boolean q) {
		if (p == true) {
			if (q == true) {
				return "true";
			}
			return "false"; 
		}
		if (p == false) {
			if (q == true) {
				return "true";
			}
			return "true";
		}
		return null;
	}*/
		
		