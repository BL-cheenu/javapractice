package com.bl.advance.java.day21.exception;

public class MoodAnalysisException extends Exception {

    public enum ExceptionType{
        EMPTY,
        NULL
    }

    public ExceptionType type;
    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
