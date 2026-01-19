package com.bl.exception;

public class StateCensusException extends Exception{
    public enum ExceptionType {
        FILE_NOT_FOUND,
        INVALID_FILE
    }

    public ExceptionType type;

    public StateCensusException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
