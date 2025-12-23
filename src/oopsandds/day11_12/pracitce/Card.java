package oopsandds.day11_12.pracitce;

public class Card {
    int rank;
    String suit;
    Card next;

    Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
        this.next = null;
    }

    public String toString() {
        return rank + " of " + suit;
    }
}
