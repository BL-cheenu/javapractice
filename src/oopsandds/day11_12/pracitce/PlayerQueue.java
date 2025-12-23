package oopsandds.day11_12.pracitce;

public class PlayerQueue {
    Player front, rear;

    void enqueue(Player player) {
        if (rear == null) {
            front = rear = player;
            return;
        }
        rear.next = player;
        rear = player;
    }

    void displayPlayers() {
        Player temp = front;
        while (temp != null) {
            temp.sortCards();
            temp.showCards();
            temp = temp.next;
        }
    }
}
