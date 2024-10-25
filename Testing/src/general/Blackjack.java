package general;

import java.util.Scanner;
import java.util.ArrayList;

public class Blackjack {

	public static void main(String[] args) throws InterruptedException {
		DeckOfCards cards = new DeckOfCards();
		Scanner console = new Scanner(System.in);
		
		System.out.println("Welcome to Blackjack!");
		Thread.sleep(250);
		System.out.println("You have $500.");
		Thread.sleep(250);
		System.out.println("----------------------------");
		Thread.sleep(250);
		System.out.println("<Enter> to continue.");
		
		if (console.nextLine().equals("")) 
			Thread.sleep(250);
			System.out.println("How much do you want to bet?");
		
		int betAmount = console.nextInt();
		
		
		//spaceConsole();
		Thread.sleep(250);
		
		System.out.println("-------Round-1-------");
		Thread.sleep(250);
		
		ArrayList<String> hand = new ArrayList<>();
		
		hand.add(cards.drawCard());
		hand.add(cards.drawCard());
		
		System.out.println("Dealer gives you a " + hand.get(0) + " and a " + hand.get(1) + ".");
		Thread.sleep(250);
		System.out.println("Total: " + findTotalValue(hand));
		Thread.sleep(250);
		System.out.println("Type 'Hit' to draw a card, Type 'Stand' to move on.");
		
		while (findTotalValue(hand) <= 21) {
			if (console.nextLine().equalsIgnoreCase("hit")) {
				Thread.sleep(250);
				hand.add(cards.drawCard());
				System.out.println("Dealer gives you a " + hand.get(hand.size()-1));
				Thread.sleep(250);
				System.out.println("Total: " + findTotalValue(hand));
				System.out.println("Type 'Hit' to draw a card, Type 'Stand' to move on.");
			}
			//spaceConsole();
		}
		System.out.println("Bust! you Lose!");
		Thread.sleep(250);
		System.out.println("lost " + betAmount + " dollars.");
		 
		
	}
	
	static void spaceConsole() {
		int i = 0;
		while(i < 2) {
			System.out.println(" ");
			i++;
		}
	}
	
	static int findTotalValue(ArrayList<String> deck) {
		int totalValue = 0;
		
		for (int i = 0; i < deck.size(); i++) {	
			if (deck.get(i).toLowerCase().indexOf("jack") != -1 || deck.get(i).toLowerCase().indexOf("queen") != -1 || 
					deck.get(i).toLowerCase().indexOf("king") != -1)
				totalValue += 10;
			else if (deck.get(i).charAt(1) == '0')
				totalValue += 10;
			else
				totalValue += Character.getNumericValue(deck.get(i).charAt(0));
		}
		
		return totalValue;
	}
}
