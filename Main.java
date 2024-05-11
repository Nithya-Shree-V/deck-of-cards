package cardsimulator;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 Deck deck = new Deck();

	        // Draw 20 random cards from the deck
	        List<Card> drawnCards = deck.drawRandomCards(20);

	        // Sort the drawn cards using custom comparator
	        
	        Collections.sort(drawnCards, new CardComparator());
	        

	        // Print the sorted cards
	        System.out.println("Sorted Cards:");
	        for (Card card : drawnCards) {
	            System.out.println(card);
	        }
	
	}

}
