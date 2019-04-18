package lab1;

import java.util.Random;
import java.util.Scanner;

public class LinBinSearch {

	private static void quickSort(int[] arr, int i, int j) {
		if (i < j) {
			int pos = partition(arr, i, j);
			quickSort(arr, i, pos - 1);
			quickSort(arr, pos + 1, j);
		}
	}

	private static int partition(int[] arr, int i, int j) {
		int pivot = arr[j];
		int small = i - 1;

		for (int k = i; k < j; k++) {
			if (arr[k] <= pivot) {
				small++;
				swap(arr, k, small);
			}
		}
		swap(arr, j, small + 1);
		return small + 1;
	}

	private static void swap(int[] arr, int k, int small) {
		int temp;
		temp = arr[k];
		arr[k] = arr[small];
		arr[small] = temp;
	}

	public static void printA(int[] a) {
		for (int i : a) {
			System.out.println(i);

		}
	}

	public static int linearSearch(int[] a, int key) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == key) {
				return i; // return the position of the array
			}
		}

		return -1;
	}

	public static int binarySearch(int[] a, int key, int start, int last) { // starting is 0, and arry.size
		int middle = (start + last) / 2;
		if (start > last) { // CHECKS SO THAT the index doesn't go out of bounds
			return -1;
		}
		if (a[middle] == key) {
			return 1;
		} else if (a[middle] > key) {
			return binarySearch(a, key, start, middle - 1);
		} else {
			return binarySearch(a, key, middle + 1, last);
		}

	}

	public static void newArray(int[] a) {
		Random random = new Random();
		int n;
		for (int i = 0; i < a.length; i++) {
			n = random.nextInt(1000 + 1 + 1000) - 1000;
			a[i] = n;
		}
	}

	public static double AVGLinearTime(int[] a) {
		double totalTime = 0;

		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			newArray(a);
			quickSort(a, 0, a.length - 1);


			long startTime = System.nanoTime();
			int key = random.nextInt(1000 + 1 + 1000) - 1000;
			linearSearch(a, key);

			long duration = System.nanoTime() - startTime;
			double seconds = (double) duration / 1_000_000_000.0; // convert nanotime to seconds
			totalTime = totalTime + seconds;
		}
		return totalTime;
		// double seconds = (double)duration / 1_000_000_000.0;
	}

	public static double OneLinearTime(int[] a) {
		double totalTime = 0;
		int key = 5000;

		newArray(a);
		quickSort(a, 0, a.length - 1);

		long startTime = System.nanoTime();
		linearSearch(a, key);

		long duration = System.nanoTime() - startTime;
		double seconds = (double) duration / 1_000_000_000.0; // convert nanotime to seconds
		totalTime = totalTime + seconds;
		return totalTime;
		// double seconds = (double)duration / 1_000_000_000.0;
	}

	public static double AVGBinaryTime(int[] a) {
		double totalTime = 0;

		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			newArray(a);
			quickSort(a, 0, a.length - 1);

			long startTime = System.nanoTime();
			int key = random.nextInt(1000 + 1 + 1000) - 1000;
			binarySearch(a, key, 0, a.length - 1);

			long duration = System.nanoTime() - startTime;
			double seconds = (double) duration / 1_000_000_000.0; // convert nanotime to seconds
			totalTime = totalTime + seconds;
		}
		return totalTime;
		// double seconds = (double)duration / 1_000_000_000.0;
	}

	public static double OneBinaryTime(int[] a) {
		double totalTime = 0;
		int key = 5000;

		newArray(a);

		quickSort(a, 0, a.length - 1);

		long startTime = System.nanoTime();
		binarySearch(a, key, 0, a.length - 1);

		long duration = System.nanoTime() - startTime;
		double seconds = (double) duration / 1_000_000_000.0; // convert nanotime to seconds
		totalTime = totalTime + seconds;
		return totalTime;
	}

	public static void main(String[] args) {
		int count = 0;
		Scanner userInput = new Scanner(System.in);
		System.out.println("Pick a positive random number");
		int length = userInput.nextInt();
		Random random = new Random();

		int[] a = new int[length];

		int key = random.nextInt(1000 + 1 + 1000) - 1000;

		double AVGLinearTime = AVGLinearTime(a);
		System.out.println(
				"Average Time for linear search when n = " + a.length + " is " + AVGLinearTime / 100 + " seconds");

		double oneLinearTime = OneLinearTime(a);
		System.out.println("Time for one linear search is " + oneLinearTime + " seconds");
		System.out.println("One single step in linear search takes " + oneLinearTime / length);

		double AVGBinaryTime = AVGBinaryTime(a);
		System.out.println(
				"\nAverage Time for BinarySearch when n = " + a.length + " is " + AVGBinaryTime / 100 + " seconds");
		double oneBinaryTime = OneBinaryTime(a);
		System.out.println("Time for one binary search is " + oneBinaryTime + " seconds");
		System.out.println("One step in binary search takes " + oneBinaryTime + " seconds"); 
		//O(1) = takes the same amount of time to look wether there is a large or small amount in a data
		System.out.println(
				"\nWorst case scenerio for linear search when n = 10^7 is " + oneLinearTime / 10_000_000 + " seconds");
		System.out.println("Worst case scenerio for binary search when n = 10^7 is " + oneBinaryTime + " seconds");
	}

}
