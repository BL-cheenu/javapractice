package oopsandds.day14.practice;

public class MyLinkedList<T extends  Comparable<T>> {
    Node<T> head = null;

    // UC1 && UC3
    public void append(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node<T> currentNode = head;
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        currentNode.setNextNode(newNode);

    }

    public void display() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + "");
            currentNode = currentNode.getNextNode();
        }
        System.out.println("null");
    }

    public void displayStack() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNextNode();
        }
    }

    // UC2
    public void addFirst(T newData) {
        Node<T> newNode = new Node<>(newData);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNextNode(head);
            head = newNode;
        }

    }

    // UC4
    public void insertAfter(T position, T newData) {

        int pos = (Integer) position;
        Node<T> newNode = new Node<>(newData);

        if (pos == 0) {
            newNode.setNextNode(head);
            head = newNode;
            return;
        }

        Node<T> temp = head;
        for (int i = 1; i <= pos - 1 && temp != null; i++) {
            temp = temp.getNextNode();
        }

        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        newNode.setNextNode(temp.getNextNode());
        temp.setNextNode(newNode);
    }

    // UC5
    public T pop() {
        if (head == null) {
            System.out.println("List is empty, nothing to delete");
            return null;
        }
        T removedData = head.getData();
        head = head.getNextNode();
        return removedData;
    }

    // UC6
    public T popLast() {
        if (head == null) {
            System.out.println("List is empty, nothing to delete");
            return null;
        }
        if (head.getNextNode() == null) {
            T data = head.getData();
            head = null;
            return data;
        }
        Node<T> temp = head;
        while (temp.getNextNode().getNextNode() != null) {
            temp = temp.getNextNode();
        }

        T removedData = temp.getNextNode().getData();
        temp.setNextNode(null);
        return removedData;
    }

    // UC7
    public boolean search(T key) {
        Node<T> temp = head;

        while (temp != null) {
            if (temp.getData().equals(key)) {
                return true;
            }
            temp = temp.getNextNode();
        }
        return false;
    }

    // UC8
    public void insertAfterValue(T key, T data) {
        Node<T> temp = head;

        while (temp != null && !temp.getData().equals(key)) {
            temp = temp.getNextNode();
        }
        if (temp == null) {
            System.out.println("Value " + key + " not found!");
            return;
        }
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(temp.getNextNode());
        temp.setNextNode(newNode);
    }

    // UC9
    public boolean deleteValue(T key) {

        if (head == null)
            return false;

        if (head.getData().equals(key)) {
            head = head.getNextNode();
            return true;
        }

        Node<T> temp = head;

        while (temp.getNextNode() != null &&
                !temp.getNextNode().getData().equals(key)) {
            temp = temp.getNextNode();
        }

        if (temp.getNextNode() == null) {
            System.out.println("Value " + key + " not found!");
            return false;
        }

        temp.setNextNode(temp.getNextNode().getNextNode());
        return true;
    }


    public int size() {
        int count = 0;
        Node<T> temp = head;

        while (temp != null){
            count++;
            temp = temp.getNextNode();
        }
        return count;
    }
    // UC10
    public void sorted(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null || head.getData().compareTo(data) > 0) {
            newNode.setNextNode(head);
            head = newNode;
            return;
        }
        Node<T> temp = head;
        while (temp.getNextNode() != null &&  temp.getNextNode().getData().compareTo(data) < 0) {
            temp = temp.getNextNode();
        }
        newNode.setNextNode(temp.getNextNode());
        temp.setNextNode(newNode);
    }


}
