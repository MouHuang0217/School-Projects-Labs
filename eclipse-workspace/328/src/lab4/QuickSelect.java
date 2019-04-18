package lab4;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class QuickSelect {
	public static void swap(int[] arr, int positionOne, int positionTwo) {
		int temp = arr[positionOne];
		arr[positionOne] = arr[positionTwo];
		arr[positionTwo] = temp;
	}
	public static int findMedian(int[] arr,int start, int end) {
		int middle = (start + end) / 2;
		//sort the first middle and last number
		if (arr[start] > arr[middle]) { 
			swap(arr,start,middle);
		}
		if(arr[start] > arr[end]) {
			swap(arr,start,end);
		}	
		if(arr[middle] > arr[end]) {
			swap(arr,middle,end);
		}
		
		//return the middle number as the pivot

		return arr[middle];
	}
	public static int sort(int[] arr, int start, int end) {
		int pivot = findMedian(arr,start,end);
		while(end - start > 0) {
			//find a number on the left to be bigger than the pivot
			while(arr[start] < pivot) {
				start++;
			}
			//find a number on the right to be less than the pivot
			while (arr[end] > pivot) {
				end--;
			}
			
			//swap it
			if(start < end)
			{
				swap(arr,start,end);
				start++;
				end--;
			}
		}
		return end; //start is the new end where pivot stops at		
	}
	public static void newArray(int[]a) {
		Random random = new Random();
	    int n;
		for (int i = 0; i<a.length; i ++) {
			n = random.nextInt(100 + 100 + 1)-100;
	    	a[i] = n;
	    }
		printA(a);
	}
	public static void printA(int[] a)  {
		for(int i: a) {
			System.out.print(i + " ");

		}
	}
	
	public static int quickSelectSmall(int[] a, int start, int end, int keyPos) {
		if(start >= end) {
			return a[start];
		}
		
		int pivPos = sort(a,start,end);
		
		if (pivPos == keyPos) {
			return a[keyPos];
		}
		else if (keyPos < pivPos) {
			return quickSelectSmall(a, start, pivPos - 1, keyPos);
		} 
		else {
			return quickSelectSmall(a,pivPos+1,end, keyPos);
		}
	}
	
	public static int quickSelectMax(int[] a, int start, int end, int key) {
		if(start >= end || key == a.length) {
			return start;
		}
		int pivPos = sort(a,start,end);
		
		if (a.length-key == pivPos) {
			quickSelectMax(a,pivPos+1,end,key);
			quickSelectMax(a,start,pivPos-1, key);
			return pivPos;
		}
		else if (a.length-key > pivPos) {  
			return pivPos = quickSelectMax(a,pivPos+1,end,key);
		}
		else { 
			return pivPos = quickSelectMax(a,start,pivPos-1, key);
		}
		
	}
	
	public static void main(String[] args) {
//		int[] z = {1,2,4,7,9,17,20};
		//0,1,2,3,4,5,6
		
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("Pick a positive random number");
		int n = userInput.nextInt();
		
		int[] arr = new int[n];
		newArray(arr);
		
		System.out.print("\nPart A(kth least element):\nPick a between 1 to " + n + ": ");
		int k = userInput.nextInt();
		
		int start = 0;
		int end = arr.length-1;
		int keyPos = k - 1;
		
		int y = quickSelectSmall(arr,start,end,keyPos);
		System.out.println("The " + k + "th least number is " + y + "\n");
		
		newArray(arr);
		
		System.out.print("\nPart B(kth max element):\nPick a between 1 to " + n + ": ");
		
		k = userInput.nextInt();
		int x = quickSelectMax(arr,start,end,k);
		int length = arr.length;
		for(int i = x; i < length; i ++) {
			System.out.print(arr[i] + " ");
		}
	}
}
