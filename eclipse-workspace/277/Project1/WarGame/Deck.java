package WarGame;
/** 
 * creates the Deck with the class of card, 
 * Deck is created by 52 cards
 * @author Moulue Huang
 * @since 2019-02-06
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class Deck {
	//instance variables
	private ArrayList<Card> deck;
	/**
	 * creating a deck that creates a deck full of Diamond, Clubs, Hearts and Spades numbered A-K
	 */
	public Deck()
	{
		ArrayList<Character> suit = new ArrayList<Character>();//(Arrays.asList('H','D', 'S','C');
		suit.add('D');
		suit.add('C');
		suit.add('H');
		suit.add('S');
		ArrayList<Character> rank = new ArrayList<Character>();//(Arrays.asList('A','2','3','4','5','6','7','8','9','T','J','Q','K'));
		rank.add('A');
		rank.add('2');
		rank.add('3');
		rank.add('4');
		rank.add('5');
		rank.add('6');
		rank.add('7');
		rank.add('8');
		rank.add('9');
		rank.add('T');
		rank.add('J');
		rank.add('Q');
		rank.add('K');
		
		deck = new ArrayList<Card>();
		for (char temp: suit) {
			for (char temp2: rank) {
				deck.add(new Card(temp2,temp));
			}
		}	
	}
	/**
	 * displays the deck of 52 in 4 lines, with lines sorted by the suits
	 */
	public void display() {
		System.out.println("");
		int count = 0;
		for (int i = 0; i < 52; i ++ ) {
			if (count == 13) {
				count = 0;
				System.out.println();
			}
			Card x = deck.get(i);
			x.display();
			count +=1;
		}
	}
	/**
	 * rearrange the ArrayList
	 */
	public void shuffle() {
		Collections.shuffle(deck);
	}
	/**
	 * divides half the deck 
	 * @return half of the deck leaving half remaining
	 */
	public ArrayList<Card> dealDeck() {
		ArrayList<Card> halfDeck = new ArrayList<Card>();
		for (int i = 0; i < 26 ; i ++ ) {
			halfDeck.add(deck.remove(0));
		}
		return halfDeck;
	}
	
}