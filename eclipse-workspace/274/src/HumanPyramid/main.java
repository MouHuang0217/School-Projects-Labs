package HumanPyramid;
import java.util.Scanner;

public class main {
	static int count = 0;

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		int row = 1;
		int column = 1;
		while (row != 0 && column != 0) 
		{
			System.out.println("Please type your selections for Row and Column:");
			String input = userInput.nextLine();
			String[] rAndc = input.split(" ");
			
			row = Integer.parseInt(rAndc[0]);
			column = Integer.parseInt(rAndc[1]);
			
			if( row != 0 && column != 0) {
				double total = getWeight(row,column);
				System.out.printf("Person at (%d,%d) is supporting %d pounds.",row,column,(int)total);
				System.out.println("\n(The recursive function was called " + count+ " time(s))");
			}
			count = 0;
		}
		System.out.print("Thank you for playing Human Pyramid. Don't let me down!");
	
	}
	//recursion
	public static double getWeight(int row, int column) {
		double sum = 0;
		count ++;
		if (row == 0 && column == 0) {
			return 0;
		}
		if (row == 1 && column == 1) { //top of the pyramid
			return sum;
		}
		if(column == 1) { //when its the first of each row
			return(100 + getWeight(row-1, column)/2); //
		}
		if (column == row) {
			return(100 + getWeight(row -1 , column -1 )/2);
		}
		else {
			sum += (200 + getWeight(row-1,column)/2 + getWeight(row -1, column-1)/2);
		}
		return sum;

	}

}
