package com.bl.day35.jdbc;

public class EmployeePayrollServiceImpl {

    public EmployeePayroll addEmployeePayroll(String name, double salary, String gender) throws EmployeePayrollException {
        EmployeePayroll employeePayroll =EmployeePayrollDBService.addEmployeeToDB(name, salary, gender);
        return employeePayroll;
    }
}
