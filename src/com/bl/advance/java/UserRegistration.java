package com.bl.advance.java;

import java.util.regex.Pattern;

public class UserRegistration {

    // UC1
    private static void UC1() {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        String name = "Cheenu";
        boolean isValidName = Pattern.matches(regex, name);
        System.out.println("Is that valid name: " + isValidName);
    }

    // UC2
    private static void UC2() {
        String regex = "^(?:\\S+\\s)+[A-z][a-zA-Z]{2,}$";
        String input = "cheenu M";
        boolean isValidLastname = Pattern.matches(regex, input);
        System.out.println("Is that Last name is valid: " + isValidLastname);
    }

    public static void main(String[] args) {
        UC1();
        UC2();
    }


}
