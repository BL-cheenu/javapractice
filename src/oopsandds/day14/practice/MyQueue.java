package oopsandds.day14.practice;

public class MyQueue<T extends Comparable<T>> {
    MyLinkedList<T> list = new MyLinkedList<>();

    // UC3
    public void enqueu(T data) {
        list.append(data);
    }

    public void displayQueue() {
        list.displayStack();
    }

    public boolean isEmpty() {
        return list.head == null;
    }

    public T dequeue() {
        return list.pop();
    }
}
