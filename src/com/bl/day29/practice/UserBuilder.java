package com.bl.day29.practice;

public class UserBuilder {
    private String name;
    private int age;

    private String email;
    private String phone;
    private String address;

    public UserBuilder(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserBuilder address(String address) {
        this.address = address;
        return this;
    }

    public User build() {
        return new User(name, age, email, phone, address);
    }
}
