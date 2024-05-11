package cardsimulator;

import java.util.*;

public class Deck {
	 private List<Card> cards;

	    // Constructor to initialize deck with 52 cards
	    public Deck() {
	        cards = new ArrayList<>();
	        for (Suit suit : Suit.values()) {
	            for (Rank rank : Rank.values()) {
	                cards.add(new Card(suit, rank));
	            }
	        }
	    }

	    // Shuffle the deck
	    public void shuffle() {
	        Collections.shuffle(cards);
	    }

	    // Draw a random card from the deck
	    public Card drawRandomCard() {
	        Random rand = new Random();
	        int index = rand.nextInt(cards.size());
	        return cards.remove(index);
	    }

	    // Draw 20 random cards from the deck
	    public List<Card> drawRandomCards(int numCards) {
	        List<Card> drawnCards = new ArrayList<>();
	        for (int i = 0; i < numCards; i++) {
	            drawnCards.add(drawRandomCard());
	        }
	        return drawnCards;
	    }
}
