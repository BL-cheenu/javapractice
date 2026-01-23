package com.bl.day35.jdbc;

public class EmployeePayrollServiceImpl {
    EmployeePayrollDBService dbService = new EmployeePayrollDBService();

    public EmployeePayroll addEmployeePayroll(String name, double salary, String gender) throws EmployeePayrollException {
        EmployeePayroll employeePayroll = dbService.addEmployeeToDB(name, salary, gender);
        return employeePayroll;
    }
}
