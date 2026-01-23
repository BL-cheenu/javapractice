package com.bl.day35.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeePayrollServiceTest {
    EmployeePayrollServiceImpl employeePayrollService = new EmployeePayrollServiceImpl();

    @Test
    public void givenNewEmployee_WhenAdded_ShouldSyncWithDB() throws EmployeePayrollException {
        EmployeePayroll employeePayroll = employeePayrollService.addEmployeePayroll("cheenu", 30000.0, "M");
        Assertions.assertNotNull(employeePayroll);
        Assertions.assertTrue(employeePayroll.getId() > 0);

    }

    @Test
    public void givenNewEmployee_WhenAdded_ShouldInsertPayrollDetails() throws EmployeePayrollException {
        EmployeePayroll employee = employeePayrollService.addEmployeePayroll("Suresh", 6000000.00, "M");
        Assertions.assertNotNull(employee);
        Assertions.assertTrue(employee.getId() > 0);

    }
}
