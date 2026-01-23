package com.bl.day35.jdbc;

public class EmployeePayrollMain {
    public static void main(String[] args) throws EmployeePayrollException {
        EmployeePayrollServiceImpl employeePayrollService = new EmployeePayrollServiceImpl();
        employeePayrollService.addEmployeePayroll("cheenu", 30000.0, "M");

    }
}
