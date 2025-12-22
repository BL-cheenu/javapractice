package constructor.day5.practice;

import java.util.Scanner;

public class VowelOrConsonant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a character: ");
        char ch = sc.next().charAt(0);
        char ch1 = Character.toLowerCase(ch);
        if (ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u') {
            System.out.println("It is a vowel");

        } else {
            System.out.println("It is a not vowel");
        }

    }
}
