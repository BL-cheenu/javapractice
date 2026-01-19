package com.bl.day29.practice;

public class BuilderPatternMain {
    public static void main(String[] args) {
        User user = new UserBuilder("Demo", 25)
                .build();
        System.out.println(user);

        User user1 = new UserBuilder("Demo1", 26)
                .address("Chennai")
                .build();
        System.out.println(user1);
    }

}
