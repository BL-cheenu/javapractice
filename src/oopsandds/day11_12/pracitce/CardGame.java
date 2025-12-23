package oopsandds.day11_12.pracitce;

public class CardGame {
    public static void main(String[] args) {
        PlayerQueue playerQueue = new PlayerQueue();

        Player p1 = new Player("Alice");
        Player p2 = new Player("Bob");

        playerQueue.enqueue(p1);
        playerQueue.enqueue(p2);

        p1.addCard(new Card(5, "Hearts"));
        p1.addCard(new Card(2, "Clubs"));
        p1.addCard(new Card(10, "Spades"));

        p2.addCard(new Card(3, "Diamonds"));
        p2.addCard(new Card(7, "Hearts"));
        p2.addCard(new Card(1, "Clubs"));

        playerQueue.displayPlayers();
    }
}
