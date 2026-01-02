package com.bl.advance.java.regex;

import java.util.regex.Pattern;

public class UserRegistration {

    // UC1
    public static boolean uc1(String name) {
        String regex = "^[A-Z][a-zA-Z]{2,}$";
        boolean isValidName = Pattern.matches(regex, name);
        return isValidName;
    }

    // UC2
    public static void uc2() {
        String regex = "^(?:\\S+\\s)+[A-z][a-zA-Z]{2,}$";
        String input = "hello M";
        boolean isValidLastname = Pattern.matches(regex, input);
        System.out.println("Valid last name? " + isValidLastname);
    }

    // UC3
    public static void uc3() {
        String regex = "^[a-z][a-zA-Z0-9]*(\\.[a-zA-Z0-9]+)?@bl\\.co(\\.in)?$";
        String input = "hello23@bl.co.in";
        boolean isValidEmail = Pattern.matches(regex, input);
        System.out.println("Valid mail? " + isValidEmail);
    }

    // UC4
    public static void uc4() {
        String regex = "^91\\s[0-9]{10}$";
        String input = "91 1234567890";
        boolean isValidPhoneNumber = Pattern.matches(regex, input);
        System.out.println("Valid phone number? " + isValidPhoneNumber);
    }

    // UC5
    public static void uc5() {
        String regex = "^.{8,}$";
        String input = "hello1234";
        boolean isValidPassword = Pattern.matches(regex, input);
        System.out.println("Valid password? " + isValidPassword);
    }

    // UC6
    public static void uc6() {
        String regex = "^(?=.*[A-Z]).{8,}$";
        String input = "Hello@123";

        boolean isValidPassword = Pattern.matches(regex, input);
        System.out.println("Valid password? " + isValidPassword);
    }

    // UC7
    public static void uc7() {
        String regex = "^(?=.*[A-Z])(?=.*[0-9]).{8,}$";
        String input = "Hello123";

        boolean isValidPassword = Pattern.matches(regex, input);
        System.out.println("Valid password? " + isValidPassword);
    }

    // UC8
    public static void uc8() {
        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=[A-Za-z0-9]*[^A-Za-z0-9][A-Za-z0-9]*$).{8,}$";
        String input = "Hello@123";

        boolean isValidPassword = Pattern.matches(regex, input);
        System.out.println("Valid password? " + isValidPassword);
    }

    // UC9
    public static void uc9() {
        String regex = "^[a-zA-Z0-9]+([._+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,})(\\.[a-zA-Z]{2,})?$";
        String input = "abc@bl.co";

        boolean isValidPassword = Pattern.matches(regex, input);
        System.out.println("Valid email? " + isValidPassword);
    }

    public static void main(String[] args) {
       boolean resultOfUc1 =  uc1("hello");
        System.out.println("Valid name? " + resultOfUc1);

        uc2();
        uc3();
        uc4();
        uc5();
        uc6();
        uc7();
        uc8();
        uc9();
    }
}
