package SolitairePrime;
public class Card {
	private char suit;
	private char rank;
	
	public Card(char r, char s) 
	{
		rank = r;
		suit = s;
	}
	
	public void display()
	{
		if (rank == 'T') {
			System.out.printf("10%s ", suit);
		}
		else {
			System.out.printf("%s%s ",rank,suit);
		}
	}
	
	public int getValue()
	{
		
	char[] array1 = {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};
	int[] array2 = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	for (int i = 0; i < array1.length; i ++) 
	{
		if (rank == array1[i]) {
			return array2[i];
		}
	}
	return 0;
	}
	
	public char getRank() {
		return rank;
	}
	public char getSuit() {
		return suit;
	}

	}

