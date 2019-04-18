package lab3;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
	public static void quickSort(int[] arr, int start, int end) {
		if(end - start > 0) { //makes sure theres elements still to be sorted
			int arrangedPiv = sort(arr, start, end);	
			//System.out.println("\narrangedPiv is " + arr[arrangedPiv]);
			//printA(arr);
			//System.out.println("\n");
//			if (start - arrangedPiv>=0)
			quickSort(arr, start, arrangedPiv);
//			if (arrangedPiv-end>=0)
			quickSort(arr,arrangedPiv+1, end);
		}
	}
	public static int sort(int[] arr, int start, int end) {
		int pivot = findMedian(arr,start,end);
		//int pivot = arr[start];
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
		//swap(arr,start,end);
		//printA(arr);
		//System.out.println(start);
		//System.out.println(end);
		return end; //start is the new end where pivot stops at
				
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
		//System.out.println("\n in findMedian");
		//printA(arr);
		//System.out.println("\narrangedPiv is " + arr[middle]);
		
		//return the middle number as the pivot
		return arr[middle];
	}
	
	public static void swap(int[] arr, int positionOne, int positionTwo) {
		int temp = arr[positionOne];
		arr[positionOne] = arr[positionTwo];
		arr[positionTwo] = temp;
	}
	public static void InsertionSort(int[] arr) {
		for (int i = 0; i < arr.length; i ++) {
			int current = arr[i];
			int position = i;
			while (position > 0 && arr[position-1] > current) { //position checker, moves number to the right until its in the right spot
				arr[position] = arr[position-1];
				position -= 1;

			}
			arr[position] = current;
		}
	}
	public static void printA(int[] a)  {
		for(int i: a) {
			System.out.print(i + " ");

		}
	}
	public static void newArray(int[]a) {
		Random random = new Random();
	    int n;
		for (int i = 0; i<a.length; i ++) {
			n = random.nextInt(5000 + 1 + 5000) - 5000;
	    	a[i] = n;
	    }
	}
	public static void main(String[] args) {
		//int[] arr = {7,-7,-1,8,1,4,6,2,19};
		Scanner userInput = new Scanner(System.in);
		System.out.println("Pick a positive random number");
		double totalTime = 0;
		int length = userInput.nextInt();
		int n = 100; //100 times
		int[] a = new int[length];
		for (int i = 0; i < n; i++ ) {
			newArray(a);
			long startTime = System.nanoTime();
			InsertionSort(a);
			long duration = System.nanoTime() - startTime;
			double seconds = (double)duration/1_000_000_000.0;
			totalTime = totalTime + seconds;
		}
		double insAvgTime = totalTime/n;
		System.out.println("AverageTime for InsertionSort is " + insAvgTime + " seconds" );
		
		totalTime = 0; //reset the totaltime
		for (int i = 0; i < n; i++ ) {
			newArray(a);
			long startTime = System.nanoTime();
			quickSort(a,0,a.length-1);
			long duration = System.nanoTime() - startTime;
			double seconds = (double)duration/1_000_000_000.0;
			totalTime = totalTime + seconds;
		}

		System.out.println("\nAverage for Quicksort is " + totalTime/n + " seconds" );
		System.out.println("One seconds can run " + 1/(insAvgTime) / (length^2) + " instructions on this machine"); 
	}

}
