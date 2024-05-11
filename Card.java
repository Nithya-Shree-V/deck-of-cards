package cardsimulator;

import java.util.*;

public class Card {
	 private Suit suit;
	 private Rank rank;

	    public Card(Suit suit, Rank rank) {
	        this.suit = suit;
	        this.rank = rank;
	    }

	    public Suit getSuit() {
	        return suit;
	    }

	    public Rank getRank() {
	        return rank;
	    }

	    @Override
	    public String toString() {
	        return rank + " of " + suit;
	    }
}

//Comparator class for sorting cards
class CardComparator implements Comparator<Card> {
 @Override
 public int compare(Card card1, Card card2) {
     // Compare based on color first
     int colorComparison = getColorValue(card1.getSuit()) - getColorValue(card2.getSuit());
     if (colorComparison != 0) {
         return colorComparison;
     }

     // If colors are the same, compare based on suit
     int suitComparison = card1.getSuit().compareTo(card2.getSuit());
     if (suitComparison != 0) {
         return suitComparison;
     }

     // If suits are the same, compare based on rank
     return card1.getRank().ordinal() - card2.getRank().ordinal();
 }

 // Helper method to determine color value
 private int getColorValue(Suit suit) {
     return (suit == Suit.HEART || suit == Suit.DIAMOND) ? 1 : 0;
 }
}
