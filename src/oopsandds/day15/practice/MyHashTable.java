package oopsandds.day15.practice;


public class MyHashTable<K, V> {
    MyMapNode<K, V> head;

    public V get(K key) {
        MyMapNode<K, V> temp = head;
        while (temp != null) {
            if (temp.getKey().equals(key)) {
                return temp.getValue();
            }
            temp = temp.next;
        }
        return null;
    }

    public void put(K key, V value) {
        if (head == null) {
            head = new MyMapNode<>(key, value);
            return;
        }

        MyMapNode<K, V> temp = head;

        while (temp != null) {
            if (temp.getKey().equals(key)) {
                temp.setValue(value);
                return;
            }
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = new MyMapNode<>(key, value);
    }

    public void display() {
        MyMapNode<K, V> temp = head;

        while (temp != null) {
            System.out.println(temp.getKey() + " -> " + temp.getValue());
            temp = temp.next;
        }
    }
}

