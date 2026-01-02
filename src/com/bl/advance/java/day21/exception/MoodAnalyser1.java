package com.bl.advance.java.day21.exception;

public class MoodAnalyser1 {
    String message;

    public MoodAnalyser1(String message) {
        this.message = message;
    }

    // UC1 && UC2
    public String analyseMood() {
        try {
            if (message.contains("SAD")) {
                return "SAD";
            } else {
                return "HAPPY";
            }
        } catch (NullPointerException e) {
            return "HAPPY";
        }
    }
}
