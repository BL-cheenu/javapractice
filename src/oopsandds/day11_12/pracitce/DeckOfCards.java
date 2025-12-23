package oopsandds.day11_12.pracitce;

import java.util.Random;

public class DeckOfCards {
    public static void main(String[] args) {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        String[] deck = new String[52];
        int a = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[a++] = rank + " of " + suit;
            }
        }

        Random random = new Random();
        for (int i = 0; i < deck.length; i++) {
            int randomNumber = random.nextInt(deck.length);
            String temp = deck[i];
            deck[i] = deck[randomNumber];
            deck[randomNumber] = temp;
        }

        String[][] players = new String[4][9];
        int j = 0;
        for (int k = 0; k < 4; k++) {
            for (int l = 0; l < 9; l++) {
                players[k][l] = deck[j++];
            }
        }

        for (int k = 0; k < 4; k++) {
            System.out.println("Player " + (k + 1) + " cards: ");
            for (int l = 0; l < 9; l++) {
                System.out.println(players[k][l]);
            }
        }
    }
}
