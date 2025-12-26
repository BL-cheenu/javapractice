package oopsandds.day14.practice;

public class MyLinkedListMain {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.append(56);
        myLinkedList.append(30);
        myLinkedList.append(70);

        System.out.println("Printing the add() method element in the customized linked list");
        myLinkedList.display();

        MyLinkedList<Integer> myLinkedList1 = new MyLinkedList<>();
        myLinkedList1.addFirst(70);
        myLinkedList1.addFirst(30);
        myLinkedList1.addFirst(56);

        System.out.println("Printing the addFirst() method element in the customized linked list");
        myLinkedList.display();


        System.out.println("Printing the insertAfter() method element in the customized linked list");
        myLinkedList.insertAfter(5, 50);
        myLinkedList.display();

        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        System.out.println("Before pop:");
        list.display();
        list.pop();
        System.out.println("After UC5 pop:");
        list.display();

        list.popLast();
        System.out.println("After UC6 popLast:");
        list.display();

        System.out.println("Searching node: ");
        boolean found = list.search(30);
        System.out.println("After UC6 popLast:");

        if (found) {
            System.out.println("30 is present in the list");
        } else {
            System.out.println("30 is not present in the list");
        }

        myLinkedList.insertAfterValue(30, 40);
        System.out.println("After UC8:");
        myLinkedList.display();

        myLinkedList.deleteValue(40);
        System.out.println("After UC9 deletion:");
        list.display();

        System.out.println("Size of list = " + list.size());


        MyLinkedList<Integer> list1 = new MyLinkedList<>();

        list1.sorted(56);
        list1.sorted(30);
        list1.sorted(40);
        list1.sorted(70);
        System.out.println("Sorted elements: ");
        list1.display();
    }
}
