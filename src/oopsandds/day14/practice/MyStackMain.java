package oopsandds.day14.practice;

public class MyStackMain {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(20);
        stack.push(30);
        stack.push(40);

        stack.display();
        System.out.println();
        while (!stack.isEmpty()) {
            System.out.println("Peek: " + stack.peek());
            System.out.println("Popped: " + stack.pop());
            stack.display();
        }
    }
}
