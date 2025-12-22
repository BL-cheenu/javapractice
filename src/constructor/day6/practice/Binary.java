package constructor.day6.practice;

import java.util.Scanner;

public class Binary {
    public static String toBinary(int n) {
        String binary = "";
        for (int i = 7; i >= 0; i--) {
            int power = 1 << i;
            if (n >= power) {
                binary += "1";
                n -= power;
            } else {
                binary += "0";
            }
        }
        return binary;
    }

    public static int swapNibbles(int n) {
        return ((n & 0x0F) << 4) | ((n & 0xF0) >> 4);
    }

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number (0–255): ");
        int number = sc.nextInt();

        String binary = toBinary(number);
        System.out.println("Binary (8-bit): " + binary);

        int swapped = swapNibbles(number);
        System.out.println("After swapping nibbles: " + swapped);

        if (isPowerOfTwo(swapped)) {
            System.out.println(swapped + " is a power of 2");
        } else {
            System.out.println(swapped + " is NOT a power of 2");
        }
    }
}
