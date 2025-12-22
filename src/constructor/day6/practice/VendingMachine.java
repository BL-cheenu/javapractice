package constructor.day6.practice;

import java.util.Scanner;

public class VendingMachine {
    static int[] notes = {1000, 500, 100, 50, 10, 5, 2, 1};
    static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the change amount: ");
        int amount = sc.nextInt();

        System.out.println("Notes returned:");
        findNotes(amount, 0);

        System.out.println("Minimum number of notes: " + count);

    }

    static void findNotes(int amount, int index) {
        if (amount == 0) {
            return;
        }

        if (amount >= notes[index]) {
            System.out.println(notes[index] + " Rs");
            count++;
            findNotes(amount - notes[index], index);
        } else {
            findNotes(amount, index + 1);
        }
    }
}
