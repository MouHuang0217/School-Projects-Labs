package SolitairePrime;
//Moulue Huang
//Class 274 - 05
//Project #2- Solitaire Prime
//Due October 2,2018
import java.util.Scanner;

public class Main 
{
	public static boolean isPrime(int checkNumber) {
		if (checkNumber < 2){ //if the number is 1 or 2 then its a prime already
			return false;
		}
		for (int i = 2; i <= checkNumber/2; i++) { //start from 2 and increment and if any of the i until the number gives a remainder of 0 then prime
			if (checkNumber % i == 0) {
				return false;
			}
		}
		return true;
		
	}
	public static void playSolitaire(Deck myDeck) {
		int sum = 0; //sum the counts 
		int count = 0; //count the amount of prime piles
		int count2 = 0; // when its 52 then its the last game
		
		while (myDeck.notEmpty()) 
		{	
			Card myCard;
			myCard = myDeck.deal();
			count2 += 1;
			myCard.display();	
			int x = myCard.getValue();
			sum += x;
			
			if (isPrime(sum) && count2 == 51) { //if its the last card, then use this if statement
				System.out.println("Prime : "+ sum );
				System.out.print("Winner in " + count +" stacks!");
			}
			else if (isPrime(sum)) {
				System.out.println("Prime : "+ sum );
				sum = 0;
				count += 1;
			}
		}
		if (isPrime(sum) == false) {
			System.out.print("\nLoser ");
		}
	}
	public static int menu () {
		System.out.println("\n\nWelcome to Solitaire Prime! \n 1) New Deck \n 2) Display Deck "
				+ "\n 3) Shuffle Deck \n 4) Play Solitaire Prime \n 5) Exit");
		Scanner userInput = new Scanner(System.in);
		int choice = userInput.nextInt();
		return choice;
	}
	public static void main(String[] args) 
	{		
		Deck myDeck = new Deck();

		int choice = menu();
	
		while (choice != 5) 
		{
			switch (choice) {
				case 1: 
					myDeck = new Deck();
					break;
				case 2: 
					myDeck.display();
					break;
				case 3:
					myDeck.shuffle();
					break;
				case 4:
					playSolitaire(myDeck);
					break;
				default:
					System.out.println("");
		}
			choice = menu();
		}
	}

}
