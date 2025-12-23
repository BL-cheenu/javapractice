package oopsandds.day11_12.pracitce;

public class Player {
    String name;
    CardQueue cards;
    Player next;

    Player(String name) {
        this.name = name;
        cards = new CardQueue();
        next = null;
    }

    void addCard(Card card) {
        cards.enqueue(card);
    }

    void sortCards() {
        cards.sortByRank();
    }

    void showCards() {
        System.out.println("Player: " + name);
        cards.display();
    }
}
