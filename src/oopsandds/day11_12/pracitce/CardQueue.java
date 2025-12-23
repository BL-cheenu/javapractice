package oopsandds.day11_12.pracitce;

public class CardQueue {
    Card front, rear;

    void enqueue(Card card) {
        if (rear == null) {
            front = rear = card;
            return;
        }
        rear.next = card;
        rear = card;
    }

    Card dequeue() {
        if (front == null)
            return null;
        Card temp = front;
        front = front.next;
        if (front == null)
            rear = null;
        return temp;
    }

    boolean isEmpty() {
        return front == null;
    }

    void sortByRank() {
        if (front == null) return;

        for (Card i = front; i != null; i = i.next) {
            for (Card j = i.next; j != null; j = j.next) {
                if (i.rank > j.rank) {
                    int tempRank = i.rank;
                    String tempSuit = i.suit;

                    i.rank = j.rank;
                    i.suit = j.suit;

                    j.rank = tempRank;
                    j.suit = tempSuit;
                }
            }
        }
    }

    void display() {
        Card temp = front;
        while (temp != null) {
            System.out.println("   " + temp);
            temp = temp.next;
        }
    }
}
