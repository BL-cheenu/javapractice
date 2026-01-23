package com.bl.day35.jdbc;

public class EmployeePayrollException extends Exception {

    public EmployeePayrollException(String message) {
        super(message);
    }
    public EmployeePayrollException(String message, Exception e) {
        super(message, e);
    }
}
