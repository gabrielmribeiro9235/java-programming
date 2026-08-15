package br.com.gabriel.ifsp.exercises.deckofcards;

public class Card {
    public enum Suit {SPADES, HEARTS, DIAMONDS, CLUBS}
    public enum Rank {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}

    private final Suit suit;
    private final Rank rank;
    private boolean isFolded;

    public Card(Suit suit, Rank rank, boolean isFolded) {
        if (!validate(suit, rank)) throw new IllegalArgumentException("Suit and rank can not be null!");

        this.suit = suit;
        this.rank = rank;
        this.isFolded = isFolded;
    }

    private boolean validate(Suit suit, Rank rank) {
        return suit != null && rank != null;
    }

    public void open() {
        isFolded = false;
    }

    public void fold() {
        isFolded = true;
    }

    public String getStateAsString() {
        return "[Rank: " + rank + ", Suit: " + suit + ", Folded: " + (isFolded ? "yes" : "no") + "]";
    }
}
