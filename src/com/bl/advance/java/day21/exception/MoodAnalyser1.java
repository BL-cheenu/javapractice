package com.bl.advance.java.day21.exception;

public class MoodAnalyser1 {

    public String analyseMood(String msg) {
        if (msg.contains("SAD")) {
            return "SAD";
        } else {
            return "HAPPY";
        }
    }
}
