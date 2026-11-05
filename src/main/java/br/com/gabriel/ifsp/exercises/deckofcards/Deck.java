package br.com.gabriel.ifsp.exercises.deckofcards;

public class Deck {
    private int numberOfCards;
    private final Card[] cards = new Card[Card.Suit.values().length * Card.Rank.values().length];

    public Deck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards[numberOfCards++] = new Card(suit, rank, true);
            }
        }
    }

    public Card pickCards() {
        if (numberOfCards == 0) throw new IllegalStateException("Deck is empty");

        Card card = cards[--numberOfCards];
        cards[numberOfCards] = null;
        return card;
    }

    public Card[] pickCards(int n) {
        if (n < 0 || n > numberOfCards) throw new IllegalArgumentException("Invalid quantity of cards: " + n);
        Card[] pickedCards = new Card[n];
        for (int i = 0; i < n; i++) {
            pickedCards[i] = pickCards();
        }
        return pickedCards;
    }
}
