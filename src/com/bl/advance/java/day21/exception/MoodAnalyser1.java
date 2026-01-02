package com.bl.advance.java.day21.exception;

public class MoodAnalyser1 {

    // UC1 && UC2
    public String analyseMood(String msg) {
        try {
            if (msg.contains("SAD")) {
                return "SAD";
            } else {
                return "HAPPY";
            }
        } catch (NullPointerException e) {
            return "HAPPY";
        }
    }
}
