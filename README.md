//full code
import java.util.*;

// Enum for Suit
enum Suit {
    SPADE, CLUB, HEART, DIAMOND
}

// Enum for Rank
enum Rank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}

// Card class
class Card {
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

// Comparator class to compare cards
class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        // 1. Compare by color
        int colorComparison = getColorValue(card1.getSuit()) - getColorValue(card2.getSuit());
        if (colorComparison != 0) return colorComparison;

        // 2. Compare by suit within each color
        int suitComparison = card1.getSuit().ordinal() - card2.getSuit().ordinal();
        if (suitComparison != 0) return suitComparison;

        // 3. Compare by card value (ascending)
        return card1.getRank().ordinal() - card2.getRank().ordinal();
    }

    private int getColorValue(Suit suit) {
        if (suit == Suit.HEART || suit == Suit.DIAMOND) {
            return 1; // Red
        } else {
            return 0; // Black
        }
    }
}

// Deck class
class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        // Initialize the deck with 52 cards
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawRandomCard() {
        if (cards.isEmpty()) {
            return null; // Deck is empty
        }
        Random random = new Random();
        int index = random.nextInt(cards.size());
        return cards.remove(index);
    }

    public List<Card> drawRandomCards(int numCards) {
        List<Card> drawnCards = new ArrayList<>();
        for (int i = 0; i < numCards; i++) {
            Card card = drawRandomCard();
            if (card != null) {
                drawnCards.add(card);
            } else {
                break; // Deck is empty
            }
        }
        return drawnCards;
    }

    public List<Card> getCards() {
        return cards;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a deck
        Deck deck = new Deck();

        // Shuffle the deck
        deck.shuffle();

        // Draw 20 random cards
        List<Card> drawnCards = deck.drawRandomCards(20);

        // Sort the drawn cards
        Collections.sort(drawnCards, new CardComparator());

        // Print the sorted cards
        for (Card card : drawnCards) {
            System.out.println(card);
        }
    }
}
