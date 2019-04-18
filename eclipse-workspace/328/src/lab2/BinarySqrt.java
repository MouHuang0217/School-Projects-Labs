package lab2;

import java.util.Scanner;
public class BinarySqrt {
	public static double sqrt(int num,double start, double last) {
		double middle = (start +last) / 2;
		if(Math.abs(middle*middle - num) < 0.1) {
			return middle;
		}
		else if(middle*middle > num) {
			 return sqrt(num,0,middle-1);
		}
		else {
			return sqrt(num,middle+1,last);
		}
	}
	public static int ASplit(int[] x , int start, int last) {
		int middle = (start + last ) / 2;
		if(x[middle] == 0) {
			if(x[middle+1] == 1) 
				return middle+1;
			else 
				return ASplit(x, middle+1,last);
		}
		if (x[middle] == 1) {
			if (x[middle-1] == 0)
				return middle;
			else 
				return ASplit(x,0,middle-1);
		}
		return -1;
	}
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.println("Part A: ");
	System.out.println("Enter an integer to take the sqrt root of: ");
	int num = input.nextInt();
	double ans = sqrt(num,0,num);
	System.out.println("the answer is aproximately " + (int)Math.ceil(ans));
	
	System.out.println("\nPart B:");
	System.out.println("Enter a random binary array starting with 0: ");
	input.nextLine(); //breaks so nextLine can be used
	
	String binaryArray = input.nextLine();
	String[] x= binaryArray.split(" ");
	int[] x2 = new int[x.length];
	for (int i = 0; i < x.length; i++) {
	    x2[i] = Integer.parseInt(x[i]);
	    }
	int position = ASplit(x2, 0, x2.length-1);
	System.out.println("The position where it splits is at " + position);
	}
}
