package br.com.gabriel.ifsp.exercises.deckofcards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();

        for (int i = 0; i < 13; i++) {
            Card card = deck.pickCards();
            System.out.println(card.getStateAsString());
        }
        System.out.println("---------------------------------------");
        Card[] cards = deck.pickCards(13);
        for (Card card : cards) {
            card.open();
        }
        for (Card card : cards) {
            System.out.println("Do you want to fold this card [Y/N]?");
            System.out.println(card.getStateAsString());
            String answer = scanner.nextLine();
            if (answer.toCharArray()[0] == 'Y') {
                card.fold();
            }
        }
        System.out.println("---------------------------------------");
        for (Card card : cards) {
            System.out.println(card.getStateAsString());
        }
    }
}
