package WarGame;
import java.util.ArrayList;

/** 
 * creates an object of a card with certain functions
 * @author Moulue Huang
 * @since 2019-01-24
 */

public class Card {
	//instance variables
	private char rank;
	private char suit;

	/**
	 * constructor of the object Card
	 * @param r is the rank of the card
	 * @param s is the suite of the card
	 */
	public Card(char r, char s)
	{
		rank = r;
		suit = s;
	}
	/**
	 * print the object card
	 * @return the Object Card's rank and suit in terms of a String 
	 */
	public String display() {
		return String.format("%s%s",rank,suit);
	}
	/**
	 * get a character and convert it into a integer to use as comparison
	 * @return the rank value of the card
	 */
	public int getValue()
	{
	ArrayList<Character> array1 = new ArrayList<Character>();//(Arrays.asList('A','2','3','4','5','6','7','8','9','T','J','Q','K'));
	array1.add('A');
	array1.add('2');
	array1.add('3');
	array1.add('4');
	array1.add('5');
	array1.add('6');
	array1.add('7');
	array1.add('8');
	array1.add('9');
	array1.add('T');
	array1.add('J');
	array1.add('Q');
	array1.add('K');
	ArrayList<Integer> array2 = new ArrayList<Integer>();//(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13));
	array2.add(1);
	array2.add(2);
	array2.add(3);
	array2.add(4);
	array2.add(5);
	array2.add(6);
	array2.add(7);
	array2.add(8);
	array2.add(9);
	array2.add(10);
	array2.add(11);
	array2.add(12);
	array2.add(13);
	
	for (int i = 0; i < array1.size(); i ++) 
	{
		if (rank == array1.get(i)) {
			return array2.get(i);
		}
	}
	return 0;
	}
}