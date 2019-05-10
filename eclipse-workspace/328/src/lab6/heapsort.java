package lab6;

import java.util.Random;
import java.util.Scanner;

public class heapsort {
	public static void build_MaxHeap(int[] a) {
		int n = a.length;
		for (int i = n / 2 ; i >= 0; i--){
	            maxHeapify(a,n,i);
	       }
		
	}
	public static void maxHeapify(int[] a, int n,int index) {
		int Tparent = index;

		int leftChild = 2*index+1;
		int rightChild = 2*index +2;
		/*System.out.println("Tparent: " + Tparent);
		System.out.println("left: " + leftChild);
		System.out.println("right: " + rightChild);
		*/
		if(n > leftChild && a[leftChild] > a[Tparent]) {
			Tparent = leftChild;
		}
		if(n > rightChild && a[rightChild] > a[Tparent] ) {
			Tparent = rightChild;
		}
		if(Tparent != index) {
			//System.out.println(index + " and" + Tparent +"swap");
			int temp = a[index];
			a[index] = a[Tparent];
			a[Tparent] = temp;
			
			maxHeapify(a,n,Tparent);
		}
	}
	public static void heapSort(int[] a) {
		int n = a.length;
		build_MaxHeap(a);
		for(int i = n-1; i >= 0; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			maxHeapify(a,i,0);
		}
		
	}
	public static void selectionSort(int[] a) {
		int length = a.length;
		for(int i = 0; i < length-1; i++) {
			int index = i;
			for(int x = i + 1; x < length; x++ ) {
				if(a[index] < a[x]) {
					index = x;
				}
				int temp = a[index];
				a[index] = a[x];
				a[x] = temp;	
			}
		}
	}
	public static void printA(int[] a)  {
		for(int i: a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public static void newArray(int[]a) {
		Random random = new Random();
	    int n;
		for (int i = 0; i<a.length; i ++) {
			n = random.nextInt(10000 +10000 + 1)-10000;
	    	a[i] = n;
	    }
	}
	public static void main(String[] arg) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Pick a positive random number");
		int n = userInput.nextInt();
		
		int[] arr = new int[n];
		newArray(arr);
		heapSort(arr);
		int num_times = 100;
		double totalTime = 0;
		
		
		//avg runtime for heapsort
		for(int i = 0; i < num_times; i++) {
			newArray(arr);
			long startTime = System.nanoTime();
			heapSort(arr);
			long duration = System.nanoTime() - startTime;
			double seconds = (double)duration/1_000_000_000.0;
			totalTime = totalTime + seconds;
		}
		System.out.println("\nAverage for HeapSort is " + totalTime/n + " seconds" );
		
		totalTime = 0;
		for(int i = 0; i < num_times; i++) {
			newArray(arr);
			long startTime = System.nanoTime();
			selectionSort(arr);
			long duration = System.nanoTime() - startTime;
			double seconds = (double)duration/1_000_000_000.0;
			totalTime = totalTime + seconds;
		}
		System.out.println("\nAverage for SelectionSort is " + totalTime/n + " seconds" );
		
		System.out.println("\nPart B: ");
		int ArrSize = 10;
		int[] A2 = new int[ArrSize];
		newArray(A2);
		System.out.println("Unsorted: ");
		printA(A2);
		heapSort(A2);
		System.out.println("Sorted: ");
		printA(A2);

		
		
		
	}
	
}
