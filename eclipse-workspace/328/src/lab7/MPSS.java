package lab7;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MPSS{

	public static void printA(int[] a)  {
		for(int i: a) {
			System.out.print(i + " ");

		}
	}
	public static double middleMPSS (double[] arr, int start, int end) { 
		int middle = (start + end) / 2;
		double[] sL = new double[middle + 1];
		double[] sR = new double[middle + 1];
		
		for(int i = 0; i <= middle; i++) {
			sL[i] = arr[i] + arr[i+1];
		}
		int count = 0;
		for(int j = middle +1 ; j < end; j++) {
			sR[count] = arr[j];
			count++;
		}
		Arrays.sort(sL);
		Arrays.sort(sR);
		reverseArr(sR);
		
		int i = 0; //marker for sL
		int j = 0; //marker for sR
		double sMin = Double.MAX_VALUE;
		while(i < sL.length - 1  && j < sR.length -1 ) {
			double s = sL[i] + sR[j];
			if(s <= 0) {
				i++;
			}
			else if(s < sMin) {
				j++;
				sMin = s;
			}
			else {
				j++;
			}
		}

		double MPSSmiddle = sMin;
		//System.out.println("MPSSMIDDLE :" + MPSSmiddle );
		return MPSSmiddle;
	}
	public static double mpss(double[] arr, int start, int end) {
		if ( start == end) {
			return arr[start];
		}
		int middle = (start + end) /2;
		double mpssL = mpss(arr,start,middle);
		double mpssR = mpss(arr,middle+1,end);
		double mpssM = middleMPSS(arr,start,end);
		
		if(mpssL <= 0 && mpssR <= 0) {
			return mpssM;
		}
		else if(mpssL <= 0 && mpssR > 0){
			return Math.min(mpssR, mpssM);
		}
		else if(mpssR <= 0 && mpssL > 0) {
			return Math.min(mpssL,mpssM);
		}
		else {
			double min = Math.min(mpssR,mpssL);
			return Math.min(min,mpssM);
		}
	}
	public static void reverseArr(double[] sR) {
		int start = 0;
		int end = sR.length-1;
		while(start < end) 
		{
			double temp = sR[start];
			sR[start] = sR[end];
			sR[end] = temp;
			start++;
			end--;
		}
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
		System.out.println("\nTHE MPSS IS: ");
		System.out.println(mpss(arr,0,arr.length-1));;

	}
}
