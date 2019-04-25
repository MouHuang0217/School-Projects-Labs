package SolitairePrime;
import java.util.Random;

public class Deck {
	private Card[] Data;
	private int top;
	
	public Deck()
	{
		char[] suits = {'H','D','S','C'};
		char[] ranks = {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};
		
		Data = new Card[52];
		top = 0;

		int count = 0;
		//construct the deck
		for (int s = 0; s < suits.length; s++) 
			for (int r = 0; r < ranks.length; r++)
			{
				Card C1 = new Card(ranks[r],suits[s]);
				Data[count++] = C1;
			}
	}
	public boolean notEmpty() {
		if (top == 51) {
			top = 0;
			return false;
		}
		return true;
	}

	
	public void display()
	{
		System.out.println("");
		int count = 0;
		//print a list of 4 by 13 cards display
		for (int i = 0; i < 52; i++ ) {
			if (count == 13) {
				count = 0;
				System.out.println("");
			}
			Card x = Data[i];
			x.display();
			count+=1;
		}
	}
	
	public void shuffle ()
	{		
		//shuffle the deck 100 times to get it randomized
		for (int i = 0; i < 100 ; i++) {
			Random ran = new Random();
			int x = ran.nextInt(52); //0-51 random
			int y = ran.nextInt(52); 
			Card temp = Data[x];
			Data[x] = Data[y];
			Data[y] = temp;
		}
	}
	public Card deal()
	{
		if (top == 52) {
			top = 0;
		}
		return Data[top++];
	}
}
