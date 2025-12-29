package oopsandds.day15.practice;

public class MyBinarySearchTree<K extends Comparable<K>> {
    MyBinaryNode<K> root;

    public void add(K key) {
        root = this.addRecursively(root, key);
    }

    private MyBinaryNode<K> addRecursively(MyBinaryNode<K> current, K key) {
        if (current == null) {
            return new MyBinaryNode<>(key);
        }
        int compare = key.compareTo(current.key);
        if (compare < 0) {
            current.left = addRecursively(current.left, key);
        } else if (compare > 0) {
            current.right = addRecursively(current.right, key);
        }
        return current;
    }

    public void display() {
        print(root);
        System.out.println();
    }

    private void print(MyBinaryNode<K> node) {
        if (node == null) {
            return;
        }
        print(node.left);
        System.out.println(node.key + " ");
        print(node.right);
    }
}
