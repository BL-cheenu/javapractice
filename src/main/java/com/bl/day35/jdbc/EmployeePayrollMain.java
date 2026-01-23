package com.bl.day35.jdbc;

public class EmployeePayrollMain {
    public static void main(String[] args) throws EmployeePayrollException {
        EmployeePayrollServiceImpl employeePayrollService = new EmployeePayrollServiceImpl();
        EmployeePayroll employee = employeePayrollService.addEmployeePayroll("Ramesh", 5500000.00, "M");
    }
}
