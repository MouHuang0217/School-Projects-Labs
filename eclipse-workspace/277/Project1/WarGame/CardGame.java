package WarGame;
import java.util.ArrayList;
import java.util.Scanner;

/** 
 * the creation of the card game war
 * @author Mou Huang
 * @since 2019-02-06
 */
public class CardGame 
{
	/**
	 * implementation of the how 'war' works
	 * @param cpu_deck is the deck of the cpu
	 * @param player_deck is the player deck
	 * @param cpu_card is cpu's card that caused the war
	 * @param player_card is the player's card that caused the war
	 */
	public static void war(ArrayList<Card> cpu_deck, ArrayList<Card> player_deck,Card cpu_card, Card player_card) 
	{
		ArrayList<Card> cpuWar = new ArrayList<Card>();
		cpuWar.add(cpu_card);
		ArrayList<Card> playerWar = new ArrayList<Card>();
		playerWar.add(player_card);
		//if the size is greater than four, then play 4 cards
		if (cpu_deck.size() > 4) { 
			for (int i = 0; i < 4; i ++) {
				cpuWar.add(deal(cpu_deck));
			}
		}
		//if the size is 4 or less, then just play the rest of the cards
		else {
			for(int i = 0; i < cpu_deck.size(); i++) {
				cpuWar.add(deal(cpu_deck));
			}
		}
		if (player_deck.size() > 4) {
			for (int i = 0; i < 4; i++ ) {
				playerWar.add(deal(player_deck));
			}
		}
		else {
			for(int i = 0; i < 4; i++ ) {
				playerWar.add(deal(player_deck));
			}
			
		}
		//get the first card to play war, index of 0 is the card that started the war
		int cpuSum = cpuWar.get(1).getValue();
		int playerSum = playerWar.get(1).getValue();
		
		System.out.printf("Cpu - hand:%d Card: %s X X X Total: %d\n",cpu_deck.size(),cpuWar.get(1).display(),cpuSum);
		System.out.printf("user- hand:%d Card: %s X X X Total: %d\n",player_deck.size(),playerWar.get(1).display(),playerSum);
		//if the war value is the same, play another game of war
		if (cpuSum == playerSum) {
			war(cpu_deck,player_deck,cpuWar.get(1),playerWar.get(1));
		}
		//cpu wins all 10 cards, takes in all the cards from him and player
		else if(cpuSum > playerSum) {
			System.out.println("cpu wins the war!");
			for (Card i: cpuWar) {
				cpu_deck.add(i);
			}
			for(Card i: playerWar) {
				cpu_deck.add(i);
			}
			System.out.printf("\nCpu - hand:%d \nuser - hand:%d\n\n",cpu_deck.size(),player_deck.size());
		}	
		//
		else {
			System.out.println("player wins the war!");
			for (Card i: cpuWar) {
				player_deck.add(i);
			}
			for(Card i: playerWar) {
				player_deck.add(i);
			}			System.out.printf("\nCpu - hand:%d \nuser - hand:%d\n\n",cpu_deck.size(),player_deck.size());
		}
		
	}
	/**
	 * deals the card from the top of the deck
	 * @param deck is either the cpu or the players deck
	 * @return the card removed from the top of the deck
	 */
	public static Card deal (ArrayList<Card> deck) {
		return deck.remove(deck.size()-1);
		
	}
	/**
	 * add the cards to the bottom to the winner
	 * @param deck is either cpu/players deck depending on who wins 
	 * @param x is the card that is added into the bottom of the deck
	 */
	public static void addToBottom(ArrayList<Card> deck, Card x) {
		deck.add(0,x);
		
	}
	/**
	 * when the game ends, whoever all the cards wins.
	 * @param cpu is the cpu deck's
	 * @param player is the player's deck 
	 */
	public static void winner(ArrayList<Card> cpu, ArrayList<Card> player) {
		if (cpu.isEmpty()){
			System.out.println("Player wins!, Congratz!");
		}
		else if (player.isEmpty()) {
			System.out.println("Cpu wins!");
		}
		
	}
	/**
	 * game logic
	 */
	public static void main(String[] args) 
	{
		Scanner userInput = new Scanner(System.in);
		
		Deck newDeck = new Deck();
		newDeck.shuffle();
		
		ArrayList<Card> cpu_deck = newDeck.dealDeck();
		ArrayList<Card> player_deck = newDeck.dealDeck();
		
		while (!cpu_deck.isEmpty() || !player_deck.isEmpty()) 
		{
			System.out.print("Press (P) to play your top card:");
			char choice = userInput.next().charAt(0);
			System.out.println("");
			if (choice == 'P' || choice == 'p') 
			{ 
				Card cpu_card = deal(cpu_deck);
				Card player_card = deal(player_deck);

				System.out.printf("Cpu - hand:%d Card: %s Total: %d\n",cpu_deck.size(),cpu_card.display(),cpu_card.getValue());
				System.out.printf("user- hand:%d Card: %s Total: %d\n",player_deck.size(),player_card.display(),player_card.getValue());

				if (cpu_card.getValue() == player_card.getValue()) 
				{
					System.out.println("Each player draws three cards!\n");
					war(cpu_deck,player_deck,cpu_card,player_card);
				} 
				else if (cpu_card.getValue() > player_card.getValue()) 
				{
					System.out.println("You have a lower total, Do you want to play one more card?: (Y)es or (N)o");
					choice = userInput.next().toLowerCase().charAt(0);

					if (choice == 'y' || choice == 'Y')
					{
						Card player_card_two = deal(player_deck);
						System.out.printf("Cpu - hand:%d Card: %s    Total:%d\n",cpu_deck.size(),cpu_card.display(),cpu_card.getValue());
						System.out.printf("user- hand:%d Card: %s %s Total:%d\n",player_deck.size(),player_card.display(),player_card_two.display(),player_card.getValue()+player_card_two.getValue());
						if (cpu_card.getValue() >= player_card.getValue() + player_card_two.getValue()) 
						{
							System.out.println("player takes the cards!");
							addToBottom(player_deck,cpu_card);
							addToBottom(player_deck,player_card);
							addToBottom(player_deck,player_card_two);
							System.out.printf("\nCpu - hand:%d \nuser - hand:%d\n",cpu_deck.size(),player_deck.size());
						}
						else 
						{
							System.out.println("cpu takes the cards :(");
							addToBottom(cpu_deck,cpu_card);
							addToBottom(cpu_deck,player_card);
							addToBottom(cpu_deck,player_card_two);
							System.out.printf("Cpu - hand:%d \nuser - hand:%d\n\n",cpu_deck.size(),player_deck.size());
						}
					}
					else 
					{
						System.out.println("cpu takes the card :(");
						addToBottom(cpu_deck,cpu_card);
						addToBottom(cpu_deck,player_card);
						System.out.printf("\nCpu - hand:%d \nuser - hand:%d\n\n",cpu_deck.size(),player_deck.size());
					}

				}
				else 
				{
					addToBottom(player_deck,cpu_card);
					addToBottom(player_deck,player_card);
					System.out.println("CPU has a lower card, he does not draw a card \nUser wins this round");
					System.out.printf("\nCpu - hand:%d \nuser - hand:%d\n\n",cpu_deck.size(),player_deck.size());
				}
			}
		}
		winner(cpu_deck,player_deck);
		}
				
			
	} 
		

