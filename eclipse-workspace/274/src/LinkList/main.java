package LinkList;
import java.util.Random;
import java.util.Scanner;
	
public class main {
	public static char menu(LinkedList myList) {
		int size = myList.size();
		int avg = myList.avg();
		myList.display();
		System.out.printf("\n\n(R)emove   (N)ew \t (F)ind \t Size: %d \t Avg: %d (Q)uit :",size,avg);
		Scanner userInput = new Scanner(System.in);
		char choice = userInput.next().charAt(0);
		return choice;
	}
	
	public static void main(String[] args) 
	{
		Scanner userInput = new Scanner(System.in);
		Random rand = new Random ();
		LinkedList myList = new LinkedList();
		for (int i = 0; i < 200; i ++) {
			int randomNumber = rand.nextInt(90000) + 10000;
			myList.add(randomNumber);
		}
		
		char choice = menu(myList);
		while (choice != 'Q') {
			switch (choice) {
			case ('R'):
				int randomPosition = rand.nextInt(myList.size());
				int x = myList.remove(randomPosition);
				System.out.printf("\n%d is removed from position %d\n\n",x,randomPosition+1);
				choice = menu(myList);
				break;
			case('N'):
				int num = rand.nextInt(90000) + 10000;
				myList.add(num);
				System.out.printf("\n%d was added to location %d\n\n",num, myList.find(num));
				choice = menu(myList);
				break;
			case('F'):
				System.out.print("What number do you want to find?:");
				int number = userInput.nextInt();
				if (myList.find(number) != -1) {
					System.out.printf("\n%d is found in position %d\n\n",number,myList.find(number));
				}
				else {
					System.out.print(number + " is not found\n\n");
				}
				choice = menu(myList);
				break;
			}
		}
	}
}


