package oopsandds.day14.practice;

public class MyStack<T extends Comparable<T>> {
    MyLinkedList<T> list = new MyLinkedList<>();

    //UC1
    public void push(T data) {
        list.addFirst(data);
    }

    public void display() {
        list.displayStack();
    }

    public boolean isEmpty() {
        return list.head == null;
    }

    // UC2
    public T peek() {
        if (list.head == null) {
            System.out.println("Stack is empty");
            return null;
        }
        return list.head.getData();
    }

    // UC2
    public T pop() {
        return list.pop();
    }
}
