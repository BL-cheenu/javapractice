package com.bl.advance.java;

import java.util.regex.Pattern;

public class UserRegistration {

    // UC1
    private static void uc1() {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        String name = "Cheenu";
        boolean isValidName = Pattern.matches(regex, name);
        System.out.println("Is that valid name: " + isValidName);
    }

    // UC2
    private static void uc2() {
        String regex = "^(?:\\S+\\s)+[A-z][a-zA-Z]{2,}$";
        String input = "cheenu M";
        boolean isValidLastname = Pattern.matches(regex, input);
        System.out.println("Is that Last name is valid: " + isValidLastname);
    }

    // UC3
    private static void uc3() {
        String regex = "^[a-z][a-zA-Z0-9]*(\\.[a-zA-Z0-9]+)?@bl\\.co(\\.in)?$";
        String input = "cheenum23@bl.co.in";
        boolean isValidEmail = Pattern.matches(regex, input);
        System.out.println("Is that valid mail: " + isValidEmail);
    }

    // UC4
    private static void uc4() {
        String regex = "^91\\s[0-9]{10}$";
        String input = "91 1234567890";
        boolean isValidPhoneNumber = Pattern.matches(regex, input);
        System.out.println("Is that valid phone number: " + isValidPhoneNumber);
    }

    public static void main(String[] args) {
        uc1();
        uc2();
        uc3();
        uc4();
    }


}
