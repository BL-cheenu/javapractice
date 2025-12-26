package oopsandds.day14.practice;

public class MyQueueMain {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue<>();

        myQueue.enqueu(10);
        myQueue.enqueu(20);
        myQueue.enqueu(30);
        myQueue.enqueu(40);

        System.out.println("Printing queue elements: ");
        myQueue.displayQueue();

        System.out.println("Printing Dequeuing elements: ");
        while (!myQueue.isEmpty()) {
            System.out.println("Removed: " + myQueue.dequeue());
            myQueue.displayQueue();
        }

    }
}
