package com.bl.day34.jdbc;

import java.util.List;

public class JDBMain {
    public static void main(String[] args) throws EmployeePayrollException {
        EmployeePayrollServiceImpl employeePayrollService = new EmployeePayrollServiceImpl();
        List<EmployeePayroll> employeePayrolls = employeePayrollService.getEmployeePayrolls();
        employeePayrolls.forEach(System.out::println);
    }
}
