package com.apple.shop;

public class userinfo {
    private String name;
    private int age;

    public void changeAge(int age) {
        if(age > 0 && age < 100) {
            this.age = age;
        }
    }

    public void addAge() {
        this.age++;
    }
}
