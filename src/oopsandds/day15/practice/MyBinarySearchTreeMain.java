package oopsandds.day15.practice;

public class MyBinarySearchTreeMain {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> searchTree = new MyBinarySearchTree<>();
        searchTree.add(56);
        searchTree.add(30);
        searchTree.add(70);

        System.out.println("Printing the elements of search Tree: ");
        searchTree.display();
    }
}
