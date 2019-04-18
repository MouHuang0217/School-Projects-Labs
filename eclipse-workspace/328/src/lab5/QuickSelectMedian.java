package lab5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class QuickSelectMedian {
	public static int quickSelect(int[] arr, int start, int end,int pos) {
		if(start == end && start == pos) { //makes sure theres elements still to be sorted
			return arr[start];
		}
		int arrangedPiv = partition(arr, start, end,pos);	
		
		if (arrangedPiv == pos) {
			
			return arr[arrangedPiv];
		}
		else if(arrangedPiv < pos) {
			return quickSelect(arr,arrangedPiv+1,end,pos);
		}
		else {
			return quickSelect(arr,start,arrangedPiv-1,pos);
		}
	}

	public static void swap(int[] arr, int positionOne, int positionTwo) {
		int temp = arr[positionOne];
		arr[positionOne] = arr[positionTwo];
		arr[positionTwo] = temp;
	}
	private static int partition(int[] array, int left, int right, int pos) {
		int pivot = array[left];
		int position = left;
		for (int i = left + 1; i <= right; i++) {
			if (array[i] <= pivot) {
				position++;
				swap(array, i, position);
				}
			}
		swap(array, left, position);
		return position;
		}
	public static void newArray(int[]a) {
		Random random = new Random();
	    int n;
		for (int i = 0; i<a.length; i ++) {
			n = random.nextInt(100 +100 + 1)-100;
	    	a[i] = n;
	    }
		printA(a);
	}
	public static void printA(int[] a)  {
		for(int i: a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public static int[] saveDifference(int[] arr, int median) {
		int length = arr.length;
		int[] newArr = new int[length];
		for (int i=0;i<length;i++) {
			newArr[i]=Math.abs(arr[i]-median);
		}
		System.out.println("The difference array is :" );
		printA(newArr);
		return newArr;
	}
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Pick a positive random number");
		int n = userInput.nextInt();
		
		int[] arr = new int[n];
		newArray(arr);
		
		System.out.println("\nPick a positive random number from 1 to " + n);
		int k = userInput.nextInt();
		int pos = n / 2;		
		int length = arr.length-1;
		
		//find the median position
		int median = quickSelect(arr,0,length,pos); //find medianPos
		System.out.print("median is " + median + "\n");
		
		System.out.println();
		//calculate the difference from the median then swap the value of 0 to the end
		int[] diff = saveDifference(arr,median);
		printA(diff);
		
		int closest[]=new int[k];
		
		for ( int i=0;i<k;i++) {
			closest[i]=quickSelect(diff,0,diff.length-1,i) + median;
		}
		printA(closest);
		
		
	}

}
