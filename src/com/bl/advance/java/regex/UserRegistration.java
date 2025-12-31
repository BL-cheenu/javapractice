package com.bl.advance.java.regex;

import java.util.regex.Pattern;

public class UserRegistration {

    // UC1
    private static void uc1() {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        String name = "Cheenu";
        boolean isValidName = Pattern.matches(regex, name);
        System.out.println("Valid name? " + isValidName);
    }

    // UC2
    private static void uc2() {
        String regex = "^(?:\\S+\\s)+[A-z][a-zA-Z]{2,}$";
        String input = "cheenu M";
        boolean isValidLastname = Pattern.matches(regex, input);
        System.out.println("Valid last name? " + isValidLastname);
    }

    // UC3
    private static void uc3() {
        String regex = "^[a-z][a-zA-Z0-9]*(\\.[a-zA-Z0-9]+)?@bl\\.co(\\.in)?$";
        String input = "cheenum23@bl.co.in";
        boolean isValidEmail = Pattern.matches(regex, input);
        System.out.println("Valid mail? " + isValidEmail);
    }

    // UC4
    private static void uc4() {
        String regex = "^91\\s[0-9]{10}$";
        String input = "91 1234567890";
        boolean isValidPhoneNumber = Pattern.matches(regex, input);
        System.out.println("Valid phone number? " + isValidPhoneNumber);
    }

    // UC5
    private static void uc5() {
        String regex = "^.{8,}$";
        String input = "hello1234";
        boolean isValidPassword = Pattern.matches(regex, input);
        System.out.println("Valid password? " + isValidPassword);
    }

    // UC6
    private static void uc6() {
        String regex = "^(?=.*[A-Z]).{8,}$";
        String pwd = "Hello@123";

        boolean isValidPassword = Pattern.matches(regex, pwd);
        System.out.println("Valid password? " + isValidPassword);
    }

    public static void main(String[] args) {
        uc1();
        uc2();
        uc3();
        uc4();
        uc5();
        uc6();
    }


}
