package EC2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class EC2 {
	public static void printA(double[] arr)  {
		for(double i: arr) {
			System.out.print(i + " ");

		}
	}
	public static double middleMSS (double[] arr, int start, int end) { 
		int middle = (start + end) / 2;
		double sum = 0;
		double leftsum = Double.MIN_VALUE;
		for(int i = middle; i >= start; i--) {
			sum = sum + arr[i];
			if (sum > leftsum) {
				leftsum = sum;
			}
		}
		sum = 0;
		double rightsum = Double.MIN_VALUE;
		for(int j = middle + 1; j <= end; j++) {
			sum =  sum + arr[j];
			if(sum > rightsum) {
				rightsum = sum;
			}
				
		}
		return leftsum + rightsum;
	}
	public static double mss(double[] arr, int start, int end) {
		if (start == end) {
			return arr[start];
		}
		int middle = (start + end) /2;
		double mssL = mss(arr,start,middle);
		double mssR = mss(arr,middle+1,end);
		double mssM = middleMSS(arr,start,end);
		
//		System.out.println("mssL is: " + mssL);
//
//		System.out.println("mssR is: " + mssR);
//
//		System.out.println("mssM is: " + mssM);
		double mss = Math.max(mssL, mssR);
		mss = Math.max(mss, mssM);
		//System.out.println("returned is: " + mss);
		return mss;
	}
	public static double LinearMSS(double[] arr, int start, int end) {
		double max = arr[0];
		double curr = Double.MIN_VALUE;
		int arrlen = arr.length;
		for(int i = 0; i < arrlen; i++) {
			curr = curr + arr[i];
			//System.out.println("current max is : " + max);
			//System.out.println("current is: " + curr);
			if(curr < 0) {
				curr = 0;
			}
			else if(curr > max) {
				max = curr;
			}
		}
		return max;
	}
	public static void main(String[] arg) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Pick a positive random number");
		int n = userInput.nextInt();

		double[] arr = new double[n];
		for(int i = 0; i < n; i++) {
			Random r = new Random();
			double randomValue =Math.round(( -20 + (40) * r.nextDouble())*100.0)/100.0;
			arr[i] = randomValue;
		}
		printA(arr);
		System.out.print("\nDivide and conqueor MSS is: ");
		System.out.println(mss(arr,0,arr.length-1));;
		
		System.out.print("\nLinear MSS is: ");
		System.out.println(LinearMSS(arr,0,arr.length-1));;
		
		
	}

}
